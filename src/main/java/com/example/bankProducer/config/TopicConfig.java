package com.example.bankProducer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(org.apache.kafka.common.config.TopicConfig.CLEANUP_POLICY_CONFIG, org.apache.kafka.common.config.TopicConfig.CLEANUP_POLICY_COMPACT);
        configurations.put(org.apache.kafka.common.config.TopicConfig.RETENTION_MS_CONFIG, "86400000");
        configurations.put(org.apache.kafka.common.config.TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");
        configurations.put(org.apache.kafka.common.config.TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");

        return TopicBuilder.name("EVT_BANK_ACCOUNT_TRANSACTION")
                .configs(configurations)
                .build();
    }
}
