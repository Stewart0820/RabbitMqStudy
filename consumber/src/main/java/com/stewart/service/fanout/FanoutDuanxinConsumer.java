package com.stewart.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author Stewart
 * @create 2022/5/21
 * @Description
 */
@RabbitListener(queues = {"duanxin.fanout.queue"})
@Service
public class FanoutDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("短信 fanout--接收到了消息"+message);
    }
}
