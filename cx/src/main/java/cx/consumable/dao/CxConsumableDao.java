package cx.consumable.dao;

import cx.consumable.entity.CxConsumable;

import java.util.List;
import java.util.Map;
public interface CxConsumableDao {

    public List<CxConsumable> findList(CxConsumable cxConsumable);
}
