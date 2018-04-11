package cx.announcement.controller;

import com.sun.javafx.collections.MappingChange;
import cx.announcement.entity.CxAnnouncement;
import cx.announcement.service.CxAnnouncementService;
import cx.util.AjaxJSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/an")
public class CxAnnouncementController {

    @Resource
    private CxAnnouncementService cxAnnouncementService;


    @RequestMapping(value = "/findList.do",produces = "application/json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxJSON findList(@RequestParam Map<String,Object> param){
        AjaxJSON result =new AjaxJSON();
        try{
            List<CxAnnouncement> list=cxAnnouncementService.findList();
            result.setSuccess(true);
            result.setObj(list);
        }catch (Exception e){
            result.setMsg("查询失败");
            result.setSuccess(false);
        }
        return  result;
    }
}
