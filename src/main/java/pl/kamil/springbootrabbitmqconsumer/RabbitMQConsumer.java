package pl.kamil.springbootrabbitmqconsumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kamil.model.Order;

@Service
class RabbitMQConsumer {

    private final RabbitTemplate rabbitTemplate;
    private static final String QUEUE_NAME_A = "queue.A";
    private static final String QUEUE_NAME_B = "queue.B";

    @Autowired
    RabbitMQConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    Order getSingleMessageFormTheQueue() {
        return (Order) rabbitTemplate.receiveAndConvert(QUEUE_NAME_A);
    }

    @RabbitListener(queues = QUEUE_NAME_A) // fetch all messages from the Queue in FIFO order
    public void rabbitListenerA(Order order) {
        System.out.println("From Queue A:" + order);
    }

    @RabbitListener(queues = QUEUE_NAME_B) // fetch all messages from the Queue in FIFO order
    public void rabbitListenerB(Order order) {
        System.out.println("From Queue B:" + order);
    }
}
