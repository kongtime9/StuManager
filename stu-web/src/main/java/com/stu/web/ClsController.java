package com.stu.web;

import com.stu.entity.Cls;
import com.stu.service.IClsService;
import com.stu.util.PageUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by qixuan on 2017/12/12.
 * 处理班级相关请求的Controller类
 */
@RestController
@RequestMapping("/clsController")
@Scope("prototype")
public class ClsController {

    @Resource(name = "clsService")
    private IClsService clsService;

    @RequestMapping("/addCls")
    public String addCls(Cls cls){
        if(clsService.addCls(cls)){
            return "addClsSuccess";
        }
        return "addClsFail";
    }

    @RequestMapping("/updateCls")
    public String updateCls(Cls cls){
        if(clsService.updateCls(cls)){
            return "updateSuccess";
        }
        return "updateFail";
    }

    @RequestMapping("/findClsList")
    public PageUtil findClsList(PageUtil pageUtil){
        return clsService.findClsList(pageUtil);
    }

    @RequestMapping("/getClsById")
    public Cls getClsById(Cls cls){
        return clsService.getClsById(cls.getCno());
    }

    public void setClsService(IClsService clsService) {
        this.clsService = clsService;
    }
}
