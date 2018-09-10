package com.neo.controller.topicController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class test {

    @Autowired
    AmqpTemplate topicAmq;

    @RequestMapping("msg")
    protected String send(Model model){
        this.topicAmq.convertAndSend("Lsr_Topic.message1","这是来自【Lsr_Topic1】的【test1】消息！");
        model.addAttribute("flag","发送者：【Lsr_Topic.message1】");
        return "myJsp";
    }

    @RequestMapping("msg2")
    protected String msg2(Model model){
        this.topicAmq.convertAndSend("Lsr_Topic.message2","这是来自【Lsr_Topic1】的【test2】消息！");
        model.addAttribute("flag","发送者：【Lsr_Topic.message2】");
        return "myJsp";
    }
}
