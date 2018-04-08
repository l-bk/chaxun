package cx.pic.service.Impl;

import cx.pic.dao.CxPicDao;
import cx.pic.service.CxPicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("CxPicService")
public class CxPicServiceImpl implements CxPicService {

    @Resource
    private CxPicDao cxPicDao;

    public List<Map<String, Object>> findList() {
        return cxPicDao.findList();
    }
}
