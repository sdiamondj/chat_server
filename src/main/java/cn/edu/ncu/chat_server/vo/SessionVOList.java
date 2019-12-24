package cn.edu.ncu.chat_server.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SessionVOList {
    private List<SessionVO> sessions = new ArrayList<>();

}
