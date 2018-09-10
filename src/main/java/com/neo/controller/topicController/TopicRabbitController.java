package com.neo.controller.topicController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/topic")
public class TopicRabbitController {

    @Autowired
    AmqpTemplate topicAmq;
    @RequestMapping("msg")
    protected String send(){
        this.topicAmq.convertAndSend("Lsr_TopicExchange","Lsr_Topic1.message1","这是来自【Lsr_Topic1】的消息！");
        this.topicAmq.convertAndSend("Lsr_TopicExchange","Lsr_Topic.message1","这是来自【message1】的消息！");
        this.topicAmq.convertAndSend("Lsr_TopicExchange","Lsr_Topic.message2","这是来自【message2】的消息！");
        this.topicAmq.convertAndSend("Lsr_TopicExchange","Lsr_Topic.message1222","这是来自【message1222】的消息！");
        this.topicAmq.convertAndSend("Lsr_TopicExchange","Lsr_Topic.message1.111111","这是来自【Lsr_Topic.message1.111111】的消息！");
        return "myJsp";
    }

    @RequestMapping("msg2")
    public String send2(Model model){
        this.topicAmq.convertAndSend("Lsr_Topic.message2","这是来自【Lsr_Topic.message2】的消息！");
//        this.topicAmq.convertAndSend("Lsr_Topic.message2.*","这是来自【Lsr_Topic.message2.*】的消息！");
        model.addAttribute("flag" , "【Lsr_Topic.message2】");
        return "myJsp";
    }

    private class Mode {
    }
}
