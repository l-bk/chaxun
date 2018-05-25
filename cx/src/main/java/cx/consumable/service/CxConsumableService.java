package cx.consumable.service;

import com.github.pagehelper.PageInfo;
import cx.consumable.entity.CxConsumable;

import java.util.List;

public interface CxConsumableService {

    public List<CxConsumable> findList(CxConsumable cxConsumable);

    public CxConsumable getDetails(Integer conId);

    public PageInfo<CxConsumable> findDistinctList(CxConsumable cxConsumable, int pageNum, int pageSize);
}
