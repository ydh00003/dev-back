package com.springboot.backspringbootrestapi.model;

import lombok.Data;

@Data
public class UserVO {

	private String name;
    private String phone;

    public UserVO() {
        
    }

    public UserVO(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }
    
}