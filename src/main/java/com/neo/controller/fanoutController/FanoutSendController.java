package com.neo.controller.fanoutController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.AbstractQueue;

@Controller
@RequestMapping("/fanoutSendController")
public class FanoutSendController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @RequestMapping("allSend")
    public String fanoutSend(){
        this.amqpTemplate.convertAndSend("Lsr_fanoutExchange","","【广播消息】");
        return "";
    }
}
