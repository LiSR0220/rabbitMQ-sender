package com.neo.controller.directController;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("directSenderController")
public class DirectSenderController {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String dateString = sdf.format(new Date());
    String context = "这个是direct模式,Direct Exchange是RabbitMQ默认的交换机模式，也是最简单的模式，根据key(binding key)全文匹配去寻找队列。"
            + dateString ;

    @RequestMapping("send")
    public String send(){

        System.out.println("【发送消息】：" + context);
        // 第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息
        rabbitAmqpTemplate.convertAndSend("Lsr_DirectHello", context);
        return "myJsp";
    }

    @RequestMapping("sendAndReceivers")
    public void sendAndReceivers(){
        for (int i = 0; i<10; i++){
            System.out.println("【发送消息】一对多["+(i+1)+"]：" + context);
            // 第一个参数表示交换机，第二个参数表示routing key，第三个参数即消息
            this.rabbitAmqpTemplate.convertAndSend("Lsr_DirectHelloMany", context);
        }
    }
}
