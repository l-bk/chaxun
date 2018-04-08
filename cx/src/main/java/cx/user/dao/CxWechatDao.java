package cx.user.dao;


import cx.user.entity.XcWechat;

import java.util.List;

public interface CxWechatDao {

    public XcWechat ifExist(XcWechat xcWechat);

    public void insert(XcWechat xcWechat);

    public int update(XcWechat xcWechat);
}
