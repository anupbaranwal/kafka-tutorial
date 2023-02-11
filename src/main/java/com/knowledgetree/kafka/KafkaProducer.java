package com.knowledgetree.kafka;

import static com.knowledgetree.KafkaConstant.KAFKA_TOPIC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
  private final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
  private final KafkaTemplate<String, String> kafkaTemplate;

  public KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    kafkaTemplate.send(KAFKA_TOPIC, message);
    log.info("Message sent: {}", message);

  }
}
