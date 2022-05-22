package com.stewart.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stewart
 * @create 2022/5/21
 * @Description
 *
 * Direct多了routingkey，routingkey就类似于分类
 * 如果routingkey都定义为一样的，就是fanout模式了
 */
@Configuration
public class DirectRabbitMqConfig {
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }

    // 声明队列，sms ，email ，duanxin

    @Bean
    public Queue smsQueue(){
        return new Queue("sms.direct.queue",true);
    }

    @Bean
    public Queue duanxinQueue(){
        return new Queue("duanxin.direct.queue",true);
    }

    @Bean
    public Queue emailQueue(){
        return new Queue("email.direct.queue",true);
    }

    // 完成绑定关系


    @Bean
    public Binding smsBinding(){
        return BindingBuilder.bind(smsQueue()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding duanxinBinding(){
        return BindingBuilder.bind(duanxinQueue()).to(directExchange()).with("duanxin");
    }

    @Bean
    public Binding emailBinding(){
        return BindingBuilder.bind(emailQueue()).to(directExchange()).with("email");
    }
}
