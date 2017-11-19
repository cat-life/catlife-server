package com.catlife.dao;

import com.catlife.model.PersonalUserInfo;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * Created by Wholanz on 2017/11/19.
 */
@DAO
public interface PersonalUserInfoDAO {
    public static String TABLE_NAME = " personal_user_info ";
    public static String COLS = " id, open_id, nick_name, gender, city, province, country, avatar_url, personal_statement, age, " +
            " emotion_state, job, constellation, hobby, update_time, create_time ";
    public static String INSERT_VALUES = " NULL, :1.openId, :1.nickName, :1.gender, :1.city, :1.province, :1.country, :1.avatarUrl, " +
            " :1.personalStatement, :1.age, :1.emotionState, :1.job, :1.constellation, :1.hobby, :1.updateTime, :1.createTime ";

    @ReturnGeneratedKeys
    @SQL(" insert into " + TABLE_NAME + " ( " + COLS + " ) values ( " + INSERT_VALUES + " )")
    long insert(PersonalUserInfo personalUserInfo);

    @SQL(" select " + COLS + " from " + TABLE_NAME + " where id = :userId")
    PersonalUserInfo getByUserId(@SQLParam("userId") long userId);
}


