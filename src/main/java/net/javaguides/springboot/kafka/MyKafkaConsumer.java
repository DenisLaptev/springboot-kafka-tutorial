package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyKafkaConsumer.class);

    @KafkaListener(topics = "javaguides", groupId = "my-consumer-group")
    public void consume(String message) {
        LOGGER.info(String.format("Message received --> %s", message));
    }
}
