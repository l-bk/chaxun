package cx.user.service;

import cx.user.entity.XcWechat;
import org.springframework.stereotype.Service;


public interface CxWechatService {

    public String WeChatLogin(String code);

    public XcWechat ifExist(XcWechat xcWechat);

    public int update(XcWechat xcWechat);
}
