package cx.pic.controller;

import cx.pic.service.CxPicService;
import cx.util.AjaxJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

@Controller
@RequestMapping("/pic")
public class CxPicController {

    @Resource
    private CxPicService cxPicService;

    @RequestMapping(value = "/list.do",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public AjaxJSON list(@RequestParam Map<String,Object> params){
        AjaxJSON result = new AjaxJSON();
        try{
            List<Map<String,Object> > list = cxPicService.findList();
            result.setObj(list);
            result.setSuccess(true);
        }catch(Exception e){
            result.setMsg("查询失败");
            result.setSuccess(false);
        }
        return result;
    }
}
