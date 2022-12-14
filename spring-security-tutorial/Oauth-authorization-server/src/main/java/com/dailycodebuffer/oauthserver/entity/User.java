package com.dailycodebuffer.oauthserver.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
