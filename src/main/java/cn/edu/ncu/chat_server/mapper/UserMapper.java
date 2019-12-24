package cn.edu.ncu.chat_server.mapper;


import cn.edu.ncu.chat_server.dto.UserRegisterAndLoginDTO;
import cn.edu.ncu.chat_server.entity.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Mapper;



@Mapper
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(UserRegisterAndLoginDTO userRegisterAndLoginDTO);

    int register(UserRegisterAndLoginDTO userRegisterDTO);

    User selectByAccount(String account);
}