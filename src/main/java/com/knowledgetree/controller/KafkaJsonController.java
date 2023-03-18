package com.knowledgetree.controller;

import com.knowledgetree.kafka.JsonKafkaProducer;
import com.knowledgetree.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/kafka-json")
@RestController
public class KafkaJsonController {

  private final JsonKafkaProducer kafkaProducer;

  public KafkaJsonController(JsonKafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @PostMapping("/publish")
  public ResponseEntity<String> publish(@RequestBody User user) {
    kafkaProducer.sendMessage(user);
    return ResponseEntity.ok("User record sent successfully");
  }
}
