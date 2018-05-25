package cx.consumable.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cx.consumable.dao.CxConsumableDao;
import cx.consumable.entity.CxConsumable;
import cx.consumable.service.CxConsumableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CxConsumable")
public class CxConsumableServiceImpl implements CxConsumableService {

    @Resource
    private CxConsumableDao cxConsumableDao;

    public List<CxConsumable> findList(CxConsumable cxConsumable) {
           return cxConsumableDao.findList(cxConsumable);
    }

    public CxConsumable getDetails(Integer conId) {
        if(null == conId){
            return null;
        }
        return cxConsumableDao.getDetails(conId);
    }

    public PageInfo<CxConsumable> findDistinctList(CxConsumable cxConsumable, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CxConsumable> pageList = new PageInfo<CxConsumable>(cxConsumableDao.findDistinctList(cxConsumable));
        return pageList;
    }

}
