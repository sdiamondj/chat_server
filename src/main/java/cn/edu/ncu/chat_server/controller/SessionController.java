package cn.edu.ncu.chat_server.controller;

import cn.edu.ncu.chat_server.service.SessionService;
import cn.edu.ncu.chat_server.vo.SessionVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/session")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @ResponseBody
    @RequestMapping(value = "/select")
    public String selectByAccount(@RequestParam("account")String account){
        List<SessionVO> list = sessionService.selectByAccount(account);
        return JSONObject.toJSONString(list);
    }
}
