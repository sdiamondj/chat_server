package cn.edu.ncu.chat_server;

import cn.edu.ncu.chat_server.entity.User;
import cn.edu.ncu.chat_server.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends ChatServerApplicationTests {

    @Autowired
    private UserService userService;

//    @Test
//    void userRegister(){
//        User user = new User();
//        user.setAccount("baba");
//        user.setPassword("1234");
//        user.setDescription("babababa");
//        userService.userRegister(user);
//    }

//    @Test
//    void userLogin(){
//        UserLoginDTO test = new UserLoginDTO();
//        test.setAccount("baba");
//        test.setPassword("1234");
//        User user = userService.userLogin(test);
//        if(user == null){
//            System.out.println("失败");
//        }else{
//            System.out.println("成功");
//        }
//    }
}
