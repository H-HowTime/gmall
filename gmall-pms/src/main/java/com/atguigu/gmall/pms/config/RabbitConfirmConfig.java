package com.atguigu.gmall.pms.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;

/**
 * @author hehao
 * @create 2021-02-02 21:49
 */
@Configuration
@Slf4j
public class RabbitConfirmConfig {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //设置交换机成功收到消息的回调，无论是否收到，都会执行
        rabbitTemplate.setConfirmCallback((@Nullable CorrelationData correlationData, boolean ack, @Nullable String cause) -> {
            if(!ack){
                log.error("消息没有成功到达交换机,原因：{}",cause);
            }
        });
        //设置队列成功收到消息的回调，当对流没有收到消息时才会执行
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
            log.error("消息没有到达队列！ 交换机：{}，消息：{}，routingKey：{}",exchange,new String(message.getBody()),routingKey);
        });
    }
}
