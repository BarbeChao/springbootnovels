package com.luochao.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
//        传入的redisFactory工厂包含了配置文件中redis的配置信息
        RedisTemplate<String,Object> template = new RedisTemplate<>();

//        把配置信息作为参数传入了RedisTemplate中
        template.setConnectionFactory(redisConnectionFactory);

//        通过lettuce进行redis的数据传输的数据序列化

//        设置一个String序列化格式
        StringRedisSerializer keySerializer = new StringRedisSerializer();
//        把String序列化格式设置为redis  Key的序列化格式
        template.setKeySerializer(keySerializer);

//        通过fastJson设置一个Object序列化格式
        GenericFastJsonRedisSerializer valueSerializer = new GenericFastJsonRedisSerializer();
//        把Object序列化格式设置为redis value的序列化格式
        template.setValueSerializer(valueSerializer);

//       设置Hash类型Key的序列化格式
        template.setHashKeySerializer(keySerializer);
//        设置Hash类型Value的序列化格式
        template.setValueSerializer(valueSerializer);

   return template;
    }
}
