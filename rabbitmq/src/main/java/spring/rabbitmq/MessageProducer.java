package spring.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by renming.cheng on 2017/1/16.
 */
public class MessageProducer {
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Resource
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message){
        logger.info("to send message:{}",message);
        amqpTemplate.convertAndSend("queueTestKey",message);
    }
}
