package com.technohunk.kafka.service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig 
{

	@Value(value = "${general.topic.name}")
	private String topicName;

	@Value(value = "${user.topic.name}")
	private String userTopicName;

	@Bean
	public NewTopic generalTopic() {
		return TopicBuilder.name(topicName)
			      .partitions(3)
			      .replicas(1)
			      .build();
	}

	@Bean
	public NewTopic userTopic() {
		return TopicBuilder.name(userTopicName)
			      .partitions(1)
			      .replicas(1)
			      .build();
	}
	
	//If not using spring boot
	
	/*
	 * @Bean public KafkaAdmin kafkaAdmin() { Map<String, Object> configs = new
	 * HashMap<>(); configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
	 * bootstrapAddress); return new KafkaAdmin(configs); }
	 */
}
