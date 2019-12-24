package cn.edu.ncu.chat_server.controller;

import cn.edu.ncu.chat_server.dto.UserRegisterAndLoginDTO;
import cn.edu.ncu.chat_server.service.UserService;
import cn.edu.ncu.chat_server.vo.BaseVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(@RequestParam(value = "account")String account,
                           @RequestParam(value = "password")String password){
        UserRegisterAndLoginDTO userRegisterAndLoginDTO = new UserRegisterAndLoginDTO(account, password);
        BaseVO baseVO =  userService.userRegister(userRegisterAndLoginDTO);
        return JSONObject.toJSONString(baseVO);
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestParam(value = "account")String account,
                        @RequestParam(value = "password")String password){
        UserRegisterAndLoginDTO userRegisterAndLoginDTO = new UserRegisterAndLoginDTO(account,password);
        BaseVO baseVO = userService.userLogin(userRegisterAndLoginDTO);
        return JSONObject.toJSONString(baseVO);
    }
}
