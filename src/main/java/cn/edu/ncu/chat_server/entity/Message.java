package cn.edu.ncu.chat_server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private Integer messageId;

    private Integer senderId;

    private Integer receiverId;

    private String content;

    private String time;

    private Integer state;


}