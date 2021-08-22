package pl.kamil.springbootrabbitmqconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kamil.model.Order;

@RestController
public class OrderController {

    private final RabbitMQConsumer rabbitMQConsumer;

    @Autowired
    OrderController(RabbitMQConsumer rabbitMQConsumer) {
        this.rabbitMQConsumer = rabbitMQConsumer;
    }

    @GetMapping("receiveOrder")
    public ResponseEntity<Order> getOrderFromQueue(){
        return new ResponseEntity<>(rabbitMQConsumer.getSingleMessageFormTheQueue(), HttpStatus.OK);
    }
}
