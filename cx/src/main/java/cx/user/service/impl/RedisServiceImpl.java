package cx.user.service.impl;

import cx.user.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("redisService")
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate redisTemplate;


    public String getOpenid(String trd_session) {
        return (String) redisTemplate.opsForHash().get("wechat:" + trd_session, "openid");
    }

    public String checkWeChatLogin(String trd_session) {
        return redisTemplate.opsForHash().entries("wechat:" + trd_session).isEmpty() ? "noLogin" : "Logined";
    }


}