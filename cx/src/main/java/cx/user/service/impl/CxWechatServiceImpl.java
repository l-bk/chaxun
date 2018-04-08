package cx.user.service.impl;

import cx.user.dao.CxWechatDao;
import cx.user.entity.XcWechat;
import cx.user.service.CxWechatService;
import cx.util.RequestUtils;
import cx.util.UUIDTool;
import net.sf.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service("XcWechatService")
public class CxWechatServiceImpl implements CxWechatService {


    @Resource
    private CxWechatDao cxWechatDao;

    @Resource
    private RedisTemplate redisTemplate;

    //初始化redis用户存储时间
    private static final int SESSION_TIME = 20;

    private static final String appid = "wx12f3ae63f42f18f6";
    private static final String secret= "62ef9f026c623f3b7f79e29f8b971231";
    private static final String url="https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";




    public String WeChatLogin(String code) {
        String app_url = url.replace("APPID",appid).replace("SECRET",secret).replace("JSCODE",code);
        JSONObject resultJSON = JSONObject.fromObject(RequestUtils.httpRequest(app_url));
        if(resultJSON.containsKey("errcode")){
            return "error";
        }
        else {
            String openid = resultJSON.getString("openid");
            String session_key = resultJSON.getString("session_key");
            String trd_sessionid = UUIDTool.getUUID(openid+session_key);
            Map<String,String> map = new HashMap<String, String>();
            map.put("openid",openid);
            map.put("session_key",session_key);
            XcWechat wechat =new XcWechat();
            wechat.setOpenId(openid);
            if(cxWechatDao.ifExist(wechat) == null){
                //新增用户
                XcWechat newXcWechat =new XcWechat();
                newXcWechat.setOpenId(openid);
                newXcWechat.setUserSex("0");
                cxWechatDao.insert(newXcWechat);
            }
            redisTemplate.opsForHash().putAll("wechat:"+trd_sessionid,map);
            redisTemplate.expire(trd_sessionid,SESSION_TIME, TimeUnit.DAYS);
            return trd_sessionid;
        }
    }

    public XcWechat ifExist(XcWechat xcWechat) {
        if(xcWechat == null){
            return null;
        }
        return cxWechatDao.ifExist(xcWechat);
    }

    public int update(XcWechat xcWechat) {
        if(xcWechat == null ){
            return 0;
        }
        return cxWechatDao.update(xcWechat);
    }

}
