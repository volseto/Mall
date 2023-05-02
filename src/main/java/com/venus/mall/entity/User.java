package com.venus.mall.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//用户实体类

public class User {
    private Integer user_id; //用户ID
    private String user_name; //用户登录名
    private String user_nickname; //用户昵称
    private String user_password; //用户密码
    private Byte user_gender; //用户性别
    private Date user_birthday; //用户生日
    private Address user_address; //用户现居地
    private Address user_homeplace; //用户家乡地址
    private List<ProductOrderItem> productOrderItemList; //购物车
    private List<ProductOrder> productOrderList; //订单集合

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_gender=" + user_gender +
                ", user_birthday=" + user_birthday +
                ", user_address=" + user_address +
                ", user_homeplace=" + user_homeplace +
                '}';
    }

    public User() {
    }

    public User(Integer user_id, String user_name, String user_nickname, String user_password, Byte user_gender) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.user_password = user_password;
        this.user_gender = user_gender;
    }

    public User(Integer user_id, String user_name, String user_nickname, String user_password, String user_realname, Byte user_gender, Date user_birthday, Address user_address, Address user_homeplace, String user_profile_picture_src) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_nickname = user_nickname;
        this.user_password = user_password;
        this.user_gender = user_gender;
        this.user_birthday = user_birthday;
        this.user_address = user_address;
        this.user_homeplace = user_homeplace;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public User setUser_id(Integer user_id) {
        this.user_id = user_id;
        return this;
    }

    public String getUser_name() {
        return user_name;
    }

    public User setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public User setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
        return this;
    }

    public String getUser_password() {
        return user_password;
    }

    public User setUser_password(String user_password) {
        this.user_password = user_password;
        return this;
    }

    public Byte getUser_gender() {
        return user_gender;
    }

    public User setUser_gender(Byte user_gender) {
        this.user_gender = user_gender;
        return this;
    }

    public String getUser_birthday() {
        if(user_birthday != null){
            SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
            return time.format(user_birthday);
        }
        return null;
    }

    public User setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
        return this;
    }

    public Address getUser_address() {
        return user_address;
    }

    public User setUser_address(Address user_address) {
        this.user_address = user_address;
        return this;
    }

    public Address getUser_homeplace() {
        return user_homeplace;
    }

    public User setUser_homeplace(Address user_homeplace) {
        this.user_homeplace = user_homeplace;
        return this;
    }

    public List<ProductOrderItem> getProductOrderItemList() {
        return productOrderItemList;
    }

    public void setProductOrderItemList(List<ProductOrderItem> productOrderItemList) {
        this.productOrderItemList = productOrderItemList;
    }

    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }
}
