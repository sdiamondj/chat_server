package cn.edu.ncu.chat_server.service;

import cn.edu.ncu.chat_server.dto.UserRegisterAndLoginDTO;
import cn.edu.ncu.chat_server.entity.User;
import cn.edu.ncu.chat_server.mapper.UserMapper;

import cn.edu.ncu.chat_server.vo.BaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public BaseVO userRegister(UserRegisterAndLoginDTO userRegisterAndLoginDTO){
        User user = userMapper.selectByAccount(userRegisterAndLoginDTO.getAccount());
        BaseVO baseVO;
        if(user == null){
            int res = userMapper.register(userRegisterAndLoginDTO);
            if(res == 0){
                baseVO = new BaseVO(0,"注册失败,未知错误,请重试!");
            }else{
                baseVO = new BaseVO(1,"注册成功!");
            }
        }else{
            baseVO = new BaseVO(0,"注册失败,账号已被使用!");
        }
        return baseVO;
    }

    public BaseVO userLogin(UserRegisterAndLoginDTO userRegisterAndLoginDTO){
        User user = userMapper.login(userRegisterAndLoginDTO);
        BaseVO baseVO;
        if(user == null){
            baseVO = new BaseVO(0,"登录失败!");
        }else{
            baseVO = new BaseVO(1,"登录成功!");
        }
        return baseVO;
    }
}
