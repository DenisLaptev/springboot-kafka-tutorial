package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.MyJsonKafkaProducer;
import net.javaguides.springboot.kafka.MyKafkaProducer;
import net.javaguides.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonMessageRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMessageRestController.class);

    private MyJsonKafkaProducer producer;

    @Autowired
    public JsonMessageRestController(MyJsonKafkaProducer producer) {
        this.producer = producer;
    }

    //http://localhost:8080/api/v1/kafka/json/publish
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        producer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent to the topic");

    }
}
