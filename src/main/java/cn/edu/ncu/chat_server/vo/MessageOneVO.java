package cn.edu.ncu.chat_server.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MessageOneVO {
    private int code;
    private ArrayList<SimpleMsg> messages;
}
