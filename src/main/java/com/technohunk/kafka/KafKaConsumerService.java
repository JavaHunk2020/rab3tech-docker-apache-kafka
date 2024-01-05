package com.technohunk.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.technohunk.kafka.service.model.User;

@Service
public class KafKaConsumerService 
{
	private final Logger logger 
		= LoggerFactory.getLogger(KafKaConsumerService.class);
	
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "${general.topic.group.id}")
	public void consume1(String message) {
		logger.info(String.format("#####MESSAGE RECIEVED FROM CONSUMER##-1 -> %s", message));
	}
	
	
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "${general.topic.group.id}")
	public void consume2(String message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#-2 -> %s", message));
	}
	
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "${general.topic.group.id}")
	public void consume3(String message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#-3 -> %s", message));
	}
	
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "${general.topic.group.id}")
	public void consume4(String message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#-4 -> %s", message));
	}
	
	
	//${general.topic.name} =>>>3 partitions
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "ram500gn",containerFactory = "npkafkaListenerContainerFactory")
	public void consume5(String message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#-5 -> %s", message));
	}
	
	@KafkaListener(topics = "${general.topic.name}", 
			groupId = "ram600gn",containerFactory = "ram600gnFactoryListener")
	public void consume6(String message) {
		logger.info(String.format("###MESSAGE RECIEVED FROM CONSUMER#-6 -> %s", message));
	}
	
	
	@KafkaListener(topics = "${user.topic.name}", 
			groupId = "${user.topic.group.id}",
			containerFactory = "userKafkaListenerContainerFactory")
	public void consume(User user) {
		logger.info(String.format("User created -> %s", user));
	}
}
