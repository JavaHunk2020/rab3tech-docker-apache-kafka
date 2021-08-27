package com.technohunk.kafka;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
	
	
	@Value(value = "${general.topic.name}")
    private String topicName;
	
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	int count=0;

	@PostConstruct
	public void produceMessage() {
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		 
		ses.scheduleAtFixedRate(()-> {
			   count++; 
			   String message="TechnoHunk00"+count+" : "+new Date();
			   System.out.println("Sending message is = "+message);
			   kafkaTemplate.send(topicName, message);
			 }
		, 1, 3, TimeUnit.SECONDS);
		
	}
	
}
