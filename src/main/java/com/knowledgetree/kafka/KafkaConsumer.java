package com.knowledgetree.kafka;

import static com.knowledgetree.KafkaConstant.KAFKA_TOPIC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
  private final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

  @KafkaListener(topics = KAFKA_TOPIC, groupId = "kafka-consumer-group")
  public String consume(String message) {
    LOG.info("Message Received: {}",message);
    return message;
  }
}
