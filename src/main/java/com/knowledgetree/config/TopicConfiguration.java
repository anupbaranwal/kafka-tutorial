package com.knowledgetree.config;

import static com.knowledgetree.KafkaConstant.KAFKA_JSON_TOPIC;
import static com.knowledgetree.KafkaConstant.KAFKA_TOPIC;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfiguration {

  @Bean
  public NewTopic kafkaTopic() {
    return TopicBuilder.name(KAFKA_TOPIC).build();
  }

  @Bean
  public NewTopic kafkaJsonTopic() {
    return TopicBuilder.name(KAFKA_JSON_TOPIC).build();
  }
}
