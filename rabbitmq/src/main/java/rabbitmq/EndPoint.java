package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by renming.cheng on 2017/1/13.
 */
public class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endpointName) throws IOException, TimeoutException {
        this.endPointName = endpointName;

        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();

        //hostname of your rabbitmq server
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("cheng");
        factory.setPassword("123456");
        //getting a connection
        connection = factory.newConnection();

        //creating a channel
        channel = connection.createChannel();
        //channel.exchangeDeclare("exchangeTest", "direct",true);
        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(endpointName, true, false, false, null);
    }


    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws java.io.IOException
     */
    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}
