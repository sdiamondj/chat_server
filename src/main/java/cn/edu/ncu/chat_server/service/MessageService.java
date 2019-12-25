package cn.edu.ncu.chat_server.service;

import cn.edu.ncu.chat_server.dto.ReceiveMessageDTO;
import cn.edu.ncu.chat_server.entity.Message;
import cn.edu.ncu.chat_server.mapper.MessageMapper;
import cn.edu.ncu.chat_server.vo.MessageOneVO;
import cn.edu.ncu.chat_server.vo.MessageVO;
import cn.edu.ncu.chat_server.vo.SimpleMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public void saveMessage(int senderId,int receiverId,String content){
        Message message = new Message();
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setContent(content);
        message.setTime(new Timestamp(System.currentTimeMillis())+"");
        messageMapper.insertSelective(message);
    }

    public List<MessageVO> getChatRecord(int idA,int idB){
        List<MessageVO> res = new ArrayList<>();
        List<Message> list = messageMapper.selectByBothId(idA,idB);
        for(Message message : list){
            MessageVO messageVO = new MessageVO();
            messageVO.setContent(message.getContent());
            String[] times = message.getTime().split("\\.");
            messageVO.setTime(times[0]);
            if(message.getSenderId() == idA){
                messageVO.setState(0);
            }else{
                messageVO.setState(1);
            }
            res.add(messageVO);
        }
        return res;
    }

    public MessageOneVO getNoReadMessage(int me_id, int him_id){
        List<Message> list = messageMapper.selectByBothIdAndState(new ReceiveMessageDTO(me_id,him_id,0));
        MessageOneVO messageOneVO = new MessageOneVO();
        ArrayList<SimpleMsg> messages = new ArrayList<>();
        for(Message message : list){
            SimpleMsg simpleMsg = new SimpleMsg();
            simpleMsg.setContent(message.getContent());
            String[] times = message.getTime().split("\\.");
            simpleMsg.setTime(times[0]);
            messages.add(simpleMsg);
            message.setState(1);
            messageMapper.updateByPrimaryKeySelective(message);
        }
        if(messages.size() == 0){
            messageOneVO.setCode(0);
        }else{
            messageOneVO.setCode(1);
        }
        messageOneVO.setMessages(messages);
        return messageOneVO;
    }
}
