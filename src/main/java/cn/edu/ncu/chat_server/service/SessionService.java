package cn.edu.ncu.chat_server.service;

import cn.edu.ncu.chat_server.entity.Message;
import cn.edu.ncu.chat_server.entity.Session;
import cn.edu.ncu.chat_server.entity.User;
import cn.edu.ncu.chat_server.mapper.MessageMapper;
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
    @Autowired
    private MessageMapper messageMapper;

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

    public String addFriends(String me_account,String him_account){
        User me = userMapper.selectByAccount(me_account);
        User him = userMapper.selectByAccount(him_account);
        if(him == null){
            return "0";
        }else{

            //是否已经是好友
            if(sessionMapper.selectByBothId(me.getId(),him.getId())!=null){
                return "2";
            }

            Session session1 = new Session();
            Session session2 = new Session();
            session1.setUserId(me.getId());
            session1.setTalkerId(him.getId());
            session1.setSessionContent("我们已成功加为好友,可以开始聊天啦!");
            session1.setTime(new Timestamp(System.currentTimeMillis())+"");
            session2.setUserId(him.getId());
            session2.setTalkerId(me.getId());
            session2.setTime(new Timestamp(System.currentTimeMillis())+"");
            session2.setSessionContent("我们已成功加为好友,可以开始聊天啦!");
            sessionMapper.insertSelective(session1);
            sessionMapper.insertSelective(session2);

            //insert into table message
            Message message = new Message();
            message.setSenderId(me.getId());
            message.setReceiverId(him.getId());
            message.setState(1);
            message.setTime(new Timestamp(System.currentTimeMillis())+"");
            message.setContent("我们已成功加为好友,可以开始聊天啦!");
            messageMapper.insertSelective(message);
            return "1";
        }
    }
}
