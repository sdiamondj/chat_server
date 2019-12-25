package cn.edu.ncu.chat_server.mapper;

import cn.edu.ncu.chat_server.dto.ReceiveMessageDTO;
import cn.edu.ncu.chat_server.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MessageMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectByBothId(Integer idA,Integer idB);

    List<Message> selectByBothIdAndState(ReceiveMessageDTO receiveMessageDTO);
}