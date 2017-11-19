package com.catlife.model;

/**
 * Created by Wholanz on 2017/11/19.
 */
public class PersonalUserInfo {
    private long id;
    private String openId;
    private String nickName;
    private int gender;
    private int city;
    private int province;
    private int country;
    private String avatarUrl;
    private String personalStatement;
    private int age;
    private int emotionState;
    private int job;
    private int constellation;
    private int hobby;
    private long updateTime;
    private long createTime;

    public long getId() {
        return id;
    }

    public PersonalUserInfo setId(long id) {
        this.id = id;
        return this;
    }

    public String getOpenId() {
        return openId;
    }

    public PersonalUserInfo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public PersonalUserInfo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public PersonalUserInfo setGender(int gender) {
        this.gender = gender;
        return this;
    }

    public int getCity() {
        return city;
    }

    public PersonalUserInfo setCity(int city) {
        this.city = city;
        return this;
    }

    public int getProvince() {
        return province;
    }

    public PersonalUserInfo setProvince(int province) {
        this.province = province;
        return this;
    }

    public int getCountry() {
        return country;
    }

    public PersonalUserInfo setCountry(int country) {
        this.country = country;
        return this;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public PersonalUserInfo setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public String getPersonalStatement() {
        return personalStatement;
    }

    public PersonalUserInfo setPersonalStatement(String personalStatement) {
        this.personalStatement = personalStatement;
        return this;
    }

    public int getAge() {
        return age;
    }

    public PersonalUserInfo setAge(int age) {
        this.age = age;
        return this;
    }

    public int getEmotionState() {
        return emotionState;
    }

    public PersonalUserInfo setEmotionState(int emotionState) {
        this.emotionState = emotionState;
        return this;
    }

    public int getJob() {
        return job;
    }

    public PersonalUserInfo setJob(int job) {
        this.job = job;
        return this;
    }

    public int getConstellation() {
        return constellation;
    }

    public PersonalUserInfo setConstellation(int constellation) {
        this.constellation = constellation;
        return this;
    }

    public int getHobby() {
        return hobby;
    }

    public PersonalUserInfo setHobby(int hobby) {
        this.hobby = hobby;
        return this;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public PersonalUserInfo setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public PersonalUserInfo setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "PersonalUserInfo{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", city=" + city +
                ", province=" + province +
                ", country=" + country +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", personalStatement='" + personalStatement + '\'' +
                ", age=" + age +
                ", emotionState=" + emotionState +
                ", job=" + job +
                ", constellation=" + constellation +
                ", hobby=" + hobby +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}
