package com.catlife.controllers;

import com.catlife.dao.PersonalUserInfoDAO;
import com.catlife.model.PersonalUserInfo;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.annotation.rest.Put;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Wholanz on 2017/11/19.
 */
@Path("/user")
public class UserInfoController {

    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    PersonalUserInfoDAO personalUserInfoDAO;

    @Get("register")
    @Post("register")
    @Put("register")
    public String register(@Param("openId") String openId,
                @Param("nickName") String nickName) {
        logger.debug("openId:{},nickName:{}",openId,nickName);
        long userId;
        long curTime = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        String errorMsg = null;

        PersonalUserInfo personalUserInfo = new PersonalUserInfo()
                .setOpenId(openId).setNickName(nickName).setCreateTime(curTime).setUpdateTime(curTime);

        logger.debug("personalUserInfo:{}",personalUserInfo);
        try{
            userId = personalUserInfoDAO.insert(personalUserInfo);
            personalUserInfo.setId(userId);
        } catch (Exception e){
            errorMsg = e.getMessage();
        }
        if(errorMsg == null){
            JSONObject data = JSONObject.fromObject(personalUserInfo);
            jsonObject.put("data",data);
            jsonObject.put("ret",1);
            jsonObject.put("msg","insert success");
        } else{
            jsonObject.put("errorCode",1001);
            jsonObject.put("ret",0);
            jsonObject.put("msg",errorMsg);
        }
        logger.debug("insert personalUserInfo return:{}",jsonObject.toString());
        return "@" +jsonObject.toString();
    }


    @Get("query")
    public String query( @Param(value = "userId")  long userId){
        logger.debug("userId:{}",userId);
        PersonalUserInfo personalUserInfo =  personalUserInfoDAO.getByUserId(userId);
        JSONObject jsonObject = new JSONObject();
        if(personalUserInfo == null){
            jsonObject.put("erroCode",1001);
            jsonObject.put("ret",0);
            jsonObject.put("msg","invalid UserId");
        } else{
            JSONObject data = JSONObject.fromObject(personalUserInfo);
            jsonObject.put("data",data);
            jsonObject.put("ret",1);
            jsonObject.put("msg","query success");
        }
        logger.debug("query personalUserInfo return:{}",jsonObject.toString());
        return "@" +jsonObject.toString();
    }
}
