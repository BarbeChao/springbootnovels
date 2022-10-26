package com.luochao.util;

import redis.clients.jedis.Jedis;

public class JedisUtil {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.56.101",6379);
        System.out.println(jedis.get("luochao"));
        jedis.close();
    }
}
