package com.quotemanager.form;

import com.quotemanager.model.User;
import com.quotemanager.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {
    private String name;
    private String email;
    private String login;
    private String password;

    public User toUser(){
        return User.builder()
                .name(this.name)
                .email(this.email)
                .login(this.login)
                .password(this.password)
                .status(UserStatus.ATIVO)
                .createdDate(new Date())
                .build();

    }
}
