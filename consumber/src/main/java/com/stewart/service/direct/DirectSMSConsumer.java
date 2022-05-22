package com.stewart.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Stewart
 * @create 2022/5/21
 * @Description
 */
@RabbitListener(queues = {"sms.direct.queue"})
@Service
public class DirectSMSConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("sms direct--接收到了消息"+message);
    }
}
