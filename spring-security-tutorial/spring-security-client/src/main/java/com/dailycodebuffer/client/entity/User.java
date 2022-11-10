package com.dailycodebuffer.client.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long Id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(
            length = 60
    )
    private String password;
    private String role;
    private boolean enabled = false;
}
