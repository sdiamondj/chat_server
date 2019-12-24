package cn.edu.ncu.chat_server.mapper;

import cn.edu.ncu.chat_server.entity.Session;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SessionMapper {
    int deleteByPrimaryKey(Integer sessionId);

    int insert(Session record);

    int insertSelective(Session record);

    Session selectByPrimaryKey(Integer sessionId);

    int updateByPrimaryKeySelective(Session record);

    int updateByPrimaryKey(Session record);

    List<Session> selectByUserId(Integer userId);
}