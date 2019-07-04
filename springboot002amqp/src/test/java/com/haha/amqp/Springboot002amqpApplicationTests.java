package com.haha.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot002amqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1.单播(点对点)
     */
    @Test
    public void contextLoads() {
        HashMap<String, String> map = new HashMap<>();
        map.put("msg,","我是你爸爸");
        map.put("data","是的呢");
        rabbitTemplate.convertAndSend("yang.haha","#.haha",map);
    }

    @Test
    public void recieve(){
        Object o = rabbitTemplate.receiveAndConvert("yang.haha");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
