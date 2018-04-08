package cx.consumable.service;

import com.github.pagehelper.PageInfo;
import cx.consumable.entity.CxConsumable;

import java.util.List;

public interface CxConsumableService {

    public PageInfo<CxConsumable> findList(CxConsumable cxConsumable, int pageNum, int pageSize);
}
