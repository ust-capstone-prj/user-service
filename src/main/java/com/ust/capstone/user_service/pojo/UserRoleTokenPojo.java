package com.ust.capstone.user_service.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleTokenPojo {
   // private int userId;
    private String username;
    //private int roleId;
    private String roleName;
    private String token;

}
