package cn.edu.ncu.chat_server.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReceiveMessageDTO {
    private Integer me_id;
    private Integer him_id;
    private Integer state;
}
