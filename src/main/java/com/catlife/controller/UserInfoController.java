package com.catlife.controller;

import com.catlife.dao.PersonalUserInfoDAO;
import com.catlife.model.PersonalUserInfo;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;
import net.paoding.rose.web.annotation.rest.Put;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Wholanz on 2017/11/19.
 */
@Path("/user")
public class UserInfoController {

    @Autowired
    PersonalUserInfoDAO personalUserInfoDAO;

    @Get("register")
    @Post("register")
    @Put("register")
    public String register(@RequestParam("openId") String openId,
                @RequestParam("nickName") String nickName) {
        long userId;
        long curTime = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        String errorMsg = null;

        PersonalUserInfo personalUserInfo = new PersonalUserInfo()
                .setOpenId(openId).setNickName(nickName).setCreateTime(curTime).setUpdateTime(curTime);
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
        return "@" +jsonObject.toString();
    }


    @Get("query")
    public String query( @RequestParam(value = "userId")  long userId){
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
        return "@" +jsonObject.toString();
    }
}
