package net.javaguides.springboot.kafka;

import net.javaguides.springboot.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyJsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyJsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public MyJsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user) {

        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "javaguides-json")
                .build();

        LOGGER.info(String.format("Message sent %s", user.toString()));
        kafkaTemplate.send(message);
    }
}
