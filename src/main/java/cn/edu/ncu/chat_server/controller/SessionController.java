package cn.edu.ncu.chat_server.controller;

import cn.edu.ncu.chat_server.service.MessageService;
import cn.edu.ncu.chat_server.service.SessionService;
import cn.edu.ncu.chat_server.vo.MessageOneVO;
import cn.edu.ncu.chat_server.vo.MessageVO;
import cn.edu.ncu.chat_server.vo.SessionVO;
import com.alibaba.fastjson.JSON;
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
    @Autowired
    private MessageService messageService;

    @ResponseBody
    @RequestMapping(value = "/select")
    public String selectByAccount(@RequestParam("account")String account){
        List<SessionVO> list = sessionService.selectByAccount(account);
        return JSONObject.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/send")
    public String sendMessage(@RequestParam("senderId")Integer senderId,
                              @RequestParam("receiverId")Integer receiverId,
                              @RequestParam("content")String content){
        sessionService.updateSession(senderId,receiverId,content);
        sessionService.updateSession(receiverId,senderId,content);
        messageService.saveMessage(senderId,receiverId,content);
        return "OK";
    }

    @ResponseBody
    @RequestMapping(value = "/record")
    public String getAllRecord(@RequestParam("me_id")Integer me_id,
                               @RequestParam("him_id")Integer him_id){
        List<MessageVO> list = messageService.getChatRecord(me_id,him_id);
        return JSON.toJSONString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/receiveOne")
    public String receiveMessage(@RequestParam("me_id")Integer me_id,
                                 @RequestParam("him_id")Integer him_id){
        MessageOneVO messageOneVO = messageService.getNoReadMessage(him_id,me_id);
        return JSON.toJSONString(messageOneVO);
    }
}
