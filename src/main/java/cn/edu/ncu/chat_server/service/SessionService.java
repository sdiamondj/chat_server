package cn.edu.ncu.chat_server.service;

import cn.edu.ncu.chat_server.entity.Session;
import cn.edu.ncu.chat_server.entity.User;
import cn.edu.ncu.chat_server.mapper.SessionMapper;
import cn.edu.ncu.chat_server.mapper.UserMapper;
import cn.edu.ncu.chat_server.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionMapper sessionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<SessionVO> selectByAccount(String account){
        User user = userMapper.selectByAccount(account);
        List<Session> list = sessionMapper.selectByUserId(user.getId());
        List<SessionVO> res = new ArrayList<>();
        for(Session session : list){
            User talker = userMapper.selectByPrimaryKey(session.getTalkerId());
            SessionVO sessionVO = new SessionVO(session.getSessionId(),session.getTalkerId(),talker,session.getSessionContent(),session.getTime(),user.getId());
            res.add(sessionVO);
        }
        return res;
    }
}
