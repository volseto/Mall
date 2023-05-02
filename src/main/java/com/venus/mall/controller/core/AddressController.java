package com.venus.mall.controller.core;

import com.alibaba.fastjson.JSONObject;
import com.venus.mall.controller.BaseController;
import com.venus.mall.entity.Address;
import com.venus.mall.service.AddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//地址信息管理

@RestController
public class AddressController extends BaseController {
    @Resource(name = "addressService")
    private AddressService addressService;

    //获取地址信息
    @RequestMapping(value = "address/{areaId}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    protected String getAddressByAreaId(@PathVariable String areaId) {
        JSONObject object = new JSONObject();
        logger.info("获取AreaId为{}的地址信息");
        List<Address> addressList = addressService.getList(null, areaId);
        if (addressList == null || addressList.size() <= 0) {
            object.put("success", false);
            return object.toJSONString();
        }
        logger.info("获取该地址可能的子地址信息");
        List<Address> childAddressList = addressService.getList(null, addressList.get(0).getAddress_areaId());
        object.put("success", true);
        object.put("addressList", addressList);
        object.put("childAddressList", childAddressList);
        return object.toJSONString();
    }
}
