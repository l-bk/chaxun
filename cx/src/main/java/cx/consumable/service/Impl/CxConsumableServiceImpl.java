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

    public PageInfo<CxConsumable> findList(CxConsumable cxConsumable, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<CxConsumable> pageList = new PageInfo<CxConsumable>(cxConsumableDao.findList(cxConsumable));
        return pageList;
    }

}
