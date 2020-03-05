package com.library.bean;

/**
 * @Author: 周黎
 * @Date: 2019/11/11
 * @Description: com.library.bean
 * @version: 1.0
 */
public class User {
    private String id;
    private String account;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
}

