package net.javaguides.springboot.kafka;

import net.javaguides.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyJsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyJsonKafkaConsumer.class);

    @KafkaListener(topics = "javaguides-json", groupId = "my-consumer-group")
    public void consume(User user) {
        LOGGER.info(String.format("JSON Message received --> %s", user.toString()));
    }
}
