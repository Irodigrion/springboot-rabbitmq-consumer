package pl.kamil.springbootrabbitmqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    RabbitMQConsumer rabbitMQConsumer;

    @Autowired
    OrderController(RabbitMQConsumer rabbitMQConsumer) {
        this.rabbitMQConsumer = rabbitMQConsumer;
    }

    @GetMapping("receiveOrder")
    public String getOrderFromQueue(){
        return rabbitMQConsumer.getSingleMessageFormTheQueue();
    }
}
