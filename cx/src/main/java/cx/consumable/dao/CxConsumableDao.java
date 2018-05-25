package cx.consumable.dao;

import cx.consumable.entity.CxConsumable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;
public interface CxConsumableDao {

    public List<CxConsumable> findList(CxConsumable cxConsumable);

    public CxConsumable getDetails(Integer conId);

    public List<CxConsumable> findDistinctList(CxConsumable cxConsumable);
}
