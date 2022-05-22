package com.stewart.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Stewart
 * @create 2022/5/21
 * @Description
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userid,String productid,int num){
        //根据商品id查看库存是否充足

        //保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功"+orderId);

        //通过mq来完成消息的分发
        String exchangeName = "fanout_order_exchange";
        String routingkey = "";

        rabbitTemplate.convertAndSend(exchangeName,routingkey,orderId);

    }
    public void makeOrderDirect(String userid,String productid,int num){
        //根据商品id查看库存是否充足

        //保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生产成功"+orderId);

        //通过mq来完成消息的分发
        String exchangeName = "direct_order_exchange";

        rabbitTemplate.convertAndSend(exchangeName,"email",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"duanxin",orderId);
        rabbitTemplate.convertAndSend(exchangeName,"sms",orderId);

    }
}
