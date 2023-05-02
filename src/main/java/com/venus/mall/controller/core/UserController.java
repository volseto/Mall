package com.venus.mall.controller.core;

import com.venus.mall.controller.BaseController;
import com.venus.mall.service.UserService;
import com.venus.mall.entity.Address;
import com.venus.mall.entity.User;
import com.venus.mall.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

//用户信息

@Controller
public class UserController extends BaseController {
    @Resource(name = "addressService")
    private AddressService addressService;
    @Resource(name="userService")
    private UserService userService;

    //转到前台天猫-用户详情页
    @RequestMapping(value = "userDetails", method = RequestMethod.GET)
    public String goToUserDetail(HttpSession session, Map<String,Object> map){
        logger.info("检查用户是否登录");
        Object userId = checkUser(session);
        if (userId != null) {
            logger.info("获取用户信息");
            User user = userService.get(Integer.parseInt(userId.toString()));
            map.put("user", user);

            logger.info("获取用户所在地区级地址");
            String districtAddressId = user.getUser_address().getAddress_areaId();
            Address districtAddress = addressService.get(districtAddressId);
            logger.info("获取市级地址信息");
            Address cityAddress = addressService.get(districtAddress.getAddress_regionId().getAddress_areaId());
            logger.info("获取其他地址信息");
            List<Address> addressList = addressService.getRoot();
            List<Address> cityList = addressService.getList(
                    null,cityAddress.getAddress_regionId().getAddress_areaId()
            );
            List<Address> districtList = addressService.getList(null,cityAddress.getAddress_areaId());

            map.put("addressList", addressList);
            map.put("cityList", cityList);
            map.put("districtList", districtList);
            map.put("addressId", cityAddress.getAddress_regionId().getAddress_areaId());
            map.put("cityAddressId", cityAddress.getAddress_areaId());
            map.put("districtAddressId", districtAddressId);
            return  "/userDetails";
        } else {
            return "redirect:/login";
        }
    }
    //用户详情更新
    @RequestMapping(value="user/update",method=RequestMethod.POST,produces ="application/json;charset=utf-8")
    public String userUpdate(HttpSession session, Map<String,Object> map,
                             @RequestParam(value = "user_nickname") String user_nickname,
                             @RequestParam(value = "user_gender") String user_gender,
                             @RequestParam(value = "user_birthday") String user_birthday,
                             @RequestParam(value = "user_address") String user_address,
                             @RequestParam(value = "user_password") String user_password
    ) throws ParseException{
        logger.info("检查用户是否登录");
        Object userId = checkUser(session);
        if (userId != null) {
            logger.info("获取用户信息");
            User user = userService.get(Integer.parseInt(userId.toString()));
            map.put("user", user);
        } else {
            return "redirect:/login";
        }
        logger.info("创建用户对象");
        User userUpdate = new User()
                .setUser_id(Integer.parseInt(userId.toString()))
                .setUser_nickname(user_nickname)
                .setUser_gender(Byte.valueOf(user_gender))
                .setUser_birthday(new SimpleDateFormat("yyyy-MM-dd").parse(user_birthday))
                .setUser_address(new Address().setAddress_areaId(user_address))
                .setUser_password(user_password);
        logger.info("执行修改");
        if (userService.update(userUpdate)){
             logger.info("修改成功!跳转到用户详情页面");
             return "redirect:/userDetails";
         }
         throw new RuntimeException();
    }
}
