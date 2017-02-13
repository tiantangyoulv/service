package spring.rabbit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.rabbitmq.MessageProducer;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by renming.cheng on 2017/1/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:rabbitmq.xml"})
public class SpringRabbitTest extends AbstractJUnit4SpringContextTests {
    private Logger logger = LoggerFactory.getLogger(SpringRabbitTest.class);

    @Resource
    private MessageProducer messageProducer;

    @Test
    public void testAddMsg(){
        HashMap message = new HashMap();
        message.put("userName", "cheng");
        message.put("userAge",15);
        messageProducer.sendMessage(message);
    }
}
