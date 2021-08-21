package pl.kamil.springbootrabbitmqconsumer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RabbitMQConsumer {

    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME = "orders";

    @Autowired
    RabbitMQConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    String getSingleMessageFormTheQueue(){
        return (String)rabbitTemplate.receiveAndConvert(QUEUE_NAME);
    }

//    @RabbitListener(queues = "orders") // fetch all messages from the Queue in FIFO order
    public void rabbitListener(String order){
        System.out.println(order);
    }
}
