package com.example.test.controller;

import java.util.*;
import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 设置保存string类型到redis
     */
    @RequestMapping(value = "/setAndGetString")
    public void setAndGetString(){

        redisTemplate.opsForValue().set("key1","1");
        redisTemplate.opsForValue().set("key2","2");
        redisTemplate.opsForValue().set("key3","3");

        System.out.println(redisTemplate.opsForValue().get("key1"));
    }

    /**
     * 设置保存map类型到redis
     */
    @RequestMapping(value = "setAndGetMap")
    public void setAndGetMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age","18");
        map.put("gender","男");

        redisTemplate.opsForHash().putAll("userInfo",map);
        redisTemplate.opsForHash().put("userInfo","sel","111");

        System.out.println(redisTemplate.opsForHash().entries("userInfo"));
        System.out.println(redisTemplate.opsForHash().keys("userInfo"));
        System.out.println(redisTemplate.opsForHash().values("userInfo"));
        System.out.println(redisTemplate.opsForHash().get("userInfo","name"));
    }

    /**
     * 设置保存list类型到redis
     */
    @RequestMapping(value = "setAndGetList")
    public void setAndGetList(){

        List<String > list1 = new ArrayList<>();
        list1.add("hello1");
        list1.add("world1");

        List<String > list2 = new ArrayList<>();
        list2.add("hello2");
        list2.add("world2");

        redisTemplate.opsForList().leftPush("leftList",list1);
        redisTemplate.opsForList().rightPush("rightList",list2);
        System.out.println(redisTemplate.opsForList().leftPop("leftList"));
        System.out.println(redisTemplate.opsForList().rightPop("rightList"));
    }
    /**
     * 设置保存set类型到redis
     */
    @RequestMapping(value = "setAndGetSet")
    public void setAndGetSet(){

        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        set.add("numberSet","1");
        set.add("numberSet","2");
        set.add("numberSet","3");
        Set<Object> resultSet =redisTemplate.opsForSet().members("numberSet");
        System.out.println("resultSet:"+resultSet);

    }


    /**
     * 设置保存set类型到redis
     */
    @RequestMapping(value = "setAndGetZSet")
    public void setAndGetZSet(){

        ZSetOperations<Object,Object> zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zSet","one",1);
        zSetOperations.add("zSet","two",2);
        zSetOperations.add("zSet","three",3);

        System.out.println(redisTemplate.opsForZSet().range("zSet",1,3));
        System.out.println(redisTemplate.opsForZSet().range("zSet",0,zSetOperations.size("zSet")));


    }
}
