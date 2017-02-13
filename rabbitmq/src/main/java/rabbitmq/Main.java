package rabbitmq;

import java.util.HashMap;

/**
 * Created by renming.cheng on 2017/1/13.
 */
public class Main {
    public Main() throws Exception{

        QueueConsumer consumer = new QueueConsumer("queueTest");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue");

        for (int i = 0; i < 10; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }

    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
        new Main();
    }
}
