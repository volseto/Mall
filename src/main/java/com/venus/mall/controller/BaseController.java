package com.venus.mall.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpSession;

public class BaseController {
    //log4j2
    protected Logger logger = LogManager.getLogger(BaseController.class);

    //检查用户是否登录
    protected Object checkUser(HttpSession session){
        Object o = session.getAttribute("userId");
        if(o==null){
            logger.info("用户未登录");
            return null;
        }
        logger.info("用户已登录，用户ID：{}", o);
        return o;
    }
}
