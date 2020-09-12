package com.zionk.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        //String字符串
        //redisTemplate.opsForValue().set("str","heima");
        redisTemplate.boundValueOps("str").set("heima");
        System.out.println("str="+redisTemplate.opsForValue().get("str"));
        //Hash散表
        redisTemplate.boundHashOps("h_key").put("name","heima");
        redisTemplate.boundHashOps("h_key").put("name","zionk");
        redisTemplate.boundHashOps("h_key").put("name","zzk");
        //获取所有域
        Set keys = redisTemplate.boundHashOps("h_key").keys();
        System.out.println("Hash所有散列的获取所有域："+keys);
        //获取所有值
        List values = redisTemplate.boundHashOps("h_key").values();
        System.out.println("Hash散列所有的值："+values);
        //list列表
        redisTemplate.boundListOps("l_key").leftPush("c");
        redisTemplate.boundListOps("l_key").leftPush("b");
        redisTemplate.boundListOps("l_key").leftPush("a");
        //获取全部元素
        List list = redisTemplate.boundListOps("l_key").range(0, -1);
        System.out.println("list列表中所有元素："+list);
        //Set集合
        redisTemplate.boundSetOps("s_key").add("a","b","c");
        Set members = redisTemplate.boundSetOps("s_key").members();
        System.out.println("set集合中所有元素："+members);
        //Sorted Set有序集合
        redisTemplate.boundZSetOps("z_key").add("a",30);
        redisTemplate.boundZSetOps("z_key").add("b",20);
        redisTemplate.boundZSetOps("z_key").add("c",10);
        Set z_key = redisTemplate.boundZSetOps("z_key").range(0, -1);
        System.out.println("zset有序集合中的所有元素："+z_key);
    }
}
