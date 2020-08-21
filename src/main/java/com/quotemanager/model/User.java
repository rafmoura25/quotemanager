package com.quotemanager.model;

import com.quotemanager.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String code;
    private String name;
    private String email;
    private String login;
    private String password;
    private Date createdDate;
    private UserStatus status;
}
