package cx.consumable.controller;

import com.github.pagehelper.PageInfo;
import cx.consumable.entity.CxConsumable;
import cx.consumable.service.CxConsumableService;
import cx.util.AjaxJSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import javax.annotation.Resource;

@Controller
@RequestMapping("/con")
public class CxConsumableController {
    @Resource
    private CxConsumableService cxConsumableService;

    @RequestMapping(value = "/findList.do",method = RequestMethod.POST,produces = "application/json")
    @ResponseBody
    public AjaxJSON findList(@RequestParam Map<String,Object> map, @RequestBody AjaxJSON json){
        AjaxJSON result =new AjaxJSON();
        try{
            String pageNum = (String) map.get("pageNum");
            String pageSize = (String) map.get("pageSize");
            pageNum = pageNum == null?"0":pageNum;
            pageSize= pageSize == null?"0":pageSize;
            CxConsumable cxConsumable =(CxConsumable) JSONObject.toBean(JSONObject.fromObject(json.getObj()),CxConsumable.class);
            PageInfo<CxConsumable> list=cxConsumableService.findList(cxConsumable,Integer.valueOf(pageNum),Integer.valueOf(pageSize));
            result.setObj(list.getList());
            result.setTotal(list.getTotal());
            result.setSuccess(true);

        }catch(Exception e){
            result.setSuccess(false);
            result.setMsg("查询失败");
        }
        return result;
    }
}
