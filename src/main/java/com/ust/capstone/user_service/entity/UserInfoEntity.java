package com.ust.capstone.user_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoEntity {
    
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;
}
