package cn.edu.ncu.chat_server.service;

import cn.edu.ncu.chat_server.entity.Session;
import cn.edu.ncu.chat_server.entity.User;
import cn.edu.ncu.chat_server.mapper.SessionMapper;
import cn.edu.ncu.chat_server.mapper.UserMapper;
import cn.edu.ncu.chat_server.vo.SessionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
            String[] times = session.getTime().split("\\.");
            SessionVO sessionVO = new SessionVO(session.getSessionId(),session.getTalkerId(),talker,session.getSessionContent(),times[0],user.getId());
            res.add(sessionVO);
        }
        return res;
    }

    public void updateSession(Integer idA,Integer idB,String content){
        User userA = userMapper.selectByPrimaryKey(idA);
        List<Session> listA = sessionMapper.selectByUserId(userA.getId());
        boolean flag = false;
        for(Session sessionA : listA){
            User userB = userMapper.selectByPrimaryKey(sessionA.getTalkerId());
            if(userB.getId().equals(idB)){
                //todo update
                sessionA.setSessionContent(content);
                sessionA.setTime(new Timestamp(System.currentTimeMillis())+"");
                sessionMapper.updateByPrimaryKeySelective(sessionA);
                flag = true;
            }
        }
        if(!flag){
            //todo insert
            Session session = new Session();
            session.setSessionContent(content);
            session.setTime(new Timestamp(System.currentTimeMillis())+"");
            session.setUserId(userA.getId());
            session.setTalkerId(idB);
            sessionMapper.insertSelective(session);
        }
    }
}
