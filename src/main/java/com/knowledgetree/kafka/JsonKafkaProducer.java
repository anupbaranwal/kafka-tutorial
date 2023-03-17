package com.knowledgetree.kafka;

import static com.knowledgetree.KafkaConstant.KAFKA_TOPIC;

import com.knowledgetree.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

  private static final Logger log = LoggerFactory.getLogger(JsonKafkaProducer.class);

  private final KafkaTemplate<String, User> kafkaTemplate;

  public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(User user) {
    Message<User> message = MessageBuilder
        .withPayload(user)
        .setHeader(KafkaHeaders.TOPIC, KAFKA_TOPIC)
        .build();
    kafkaTemplate.send(message);
    log.info("user data sent: {}", user);
  }
}
