package cn.edu.ncu.chat_server.vo;

import cn.edu.ncu.chat_server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class SessionVO {

    private int sessionId;//会话id
    private int talkerId; //会话对象的ID
    private User user;
    private String sessionContent;//最近的一条会话内容
    private String time;//最近一次会话的时间（可以不用显示时间）
    private int userId;//会话的本人;

}
