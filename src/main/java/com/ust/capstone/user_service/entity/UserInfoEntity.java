package com.ust.capstone.user_service.entity;

// import com.fasterxml.jackson.annotation.JsonManagedReference;
// import com.ust.capstone.user_service.pojo.RoleInfoPojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;
    
    @Column(name="username")
    private String username;

    @Column(name="pword")
    private String password;

    @Column(name = "role_id")
    private int roleId; 
}
