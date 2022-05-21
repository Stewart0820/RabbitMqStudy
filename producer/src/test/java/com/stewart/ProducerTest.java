package com.stewart;

/**
 * @author Stewart
 * @create 2022/5/21
 * @Description
 */

import com.stewart.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerTest {
    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads(){
        orderService.makeOrder("1","1",12);
    }
}
