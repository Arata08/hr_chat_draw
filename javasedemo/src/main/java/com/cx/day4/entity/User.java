package com.cx.day4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private  Integer id;
    private  String username;
    private String userpwd;
    private Integer userage;
    private  String usersex;
    private  Integer isdel;
}
