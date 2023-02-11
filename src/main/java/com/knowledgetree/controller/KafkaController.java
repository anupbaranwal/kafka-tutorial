package com.knowledgetree.controller;

import com.knowledgetree.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

  private final KafkaProducer kafkaProducer;

  public KafkaController(KafkaProducer kafkaProducer) {
    this.kafkaProducer = kafkaProducer;
  }

  @GetMapping("/produce")
  public ResponseEntity<String> sendMessage(@RequestParam String message) {
    kafkaProducer.sendMessage(message);
    return ResponseEntity.ok("Message has been sent to kafka topic");
  }
}
