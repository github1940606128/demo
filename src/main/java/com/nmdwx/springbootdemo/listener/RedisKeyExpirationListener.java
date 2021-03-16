package com.nmdwx.springbootdemo.listener;

import io.lettuce.core.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author: wangxiao
 * @date: 2021-03-12 13:45
 **/
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    private final static Logger logger = LoggerFactory.getLogger(RedisKeyExpirationListener.class);

    private final static String prefix = "TEST:KEY";

//    @Autowired
//    private RedisClient redisClient;

    public RedisKeyExpirationListener(RedisMessageListenerContainer redisMessageListenerContainer) {
        super(redisMessageListenerContainer);
        logger.info("RedisKeyExpirationListener---------------------初始化");
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        if(expiredKey.startsWith(prefix)){
            //TODO
            logger.info("log，【"+expiredKey+"】过期了");
            System.out.println("sout，【"+expiredKey+"】过期了");
            // 建议使用: valueSerializer
            byte[] body = message.getBody();
            byte[] channel = message.getChannel();
            System.out.print("onMessage >> " );
            System.out.println(String.format("channel: %s, body: %s, bytes: %s"
                    ,new String(channel), new String(body), new String(pattern)));
        }
    }
}