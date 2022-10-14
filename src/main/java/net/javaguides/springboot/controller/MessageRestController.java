package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.MyKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageRestController.class);
    private MyKafkaProducer producer;

    @Autowired
    public MessageRestController(MyKafkaProducer producer) {
        this.producer = producer;
    }

    //http://localhost:8080/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        LOGGER.info(String.format("MessageRestController publish method. message= %s", message));
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
