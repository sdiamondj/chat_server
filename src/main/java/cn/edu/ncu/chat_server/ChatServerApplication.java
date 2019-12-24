package cn.edu.ncu.chat_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

//@MapperScan(value = "cn.edu.ncu.chat_server.mapper")
@SpringBootApplication
public class ChatServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatServerApplication.class, args);
    }

}
