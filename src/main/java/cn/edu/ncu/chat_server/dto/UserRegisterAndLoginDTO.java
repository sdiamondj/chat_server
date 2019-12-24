package cn.edu.ncu.chat_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegisterAndLoginDTO {
    private String account;
    private String password;

}
