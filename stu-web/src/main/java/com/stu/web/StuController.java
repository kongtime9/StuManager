package com.stu.web;

import com.stu.entity.Stu;
import com.stu.service.IClsService;
import com.stu.service.IStuService;
import com.stu.util.PageUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by qixuan on 2017/12/6.
 * 处理学生相关请求的Controller类
 */

@RestController
@RequestMapping("/stuController")
@Scope("prototype")
public class StuController {

    @Resource(name = "stuService")
    private IStuService stuService;

    @Resource(name = "clsService")
    private IClsService clsService;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    /**
     * 查询班级信息
     *
     * @return
     */
    @RequestMapping("/findClsList")
    public List findClsList() {
        return clsService.findClsList();
    }

    /**
     * 添加学生
     *
     * @param stu     学生对象
     */
    @RequestMapping("/addStu")
    public String addStu(Stu stu) {
        System.out.println(stu.getSimage());
        if (stuService.addStu(stu)) {
            return "addStuSuccess";
        }
        return "addStuFail";
    }

    /**
     * 修改學生
     * @param stu
     * @return
     */
    @RequestMapping("/updateStu")
    public Object updateStu(Stu stu){
        System.out.println(stu.getSname() +"，" + stu.getSno());
        if (stuService.updateStu(stu)) {
            return stuService.findStuList();
        }
        return "updateStuFail";
    }

    @RequestMapping("/deleteStu")
    public Object deleteStu(Stu stu){
        if(stuService.deleteStu(stu)){
            return stuService.findStuList();
        }
        return "deleteStuFail";
    }


    @RequestMapping("/findStuList")
    public PageUtil findStuList(PageUtil pageUtil){
        return stuService.findStuList(pageUtil);
    }



    /**
     * 处理文件上传
     *
     * @param file
     * @param session
     */
    @RequestMapping("/upLoadFile")
    private Map upLoadFile(MultipartFile file, HttpSession session) {
        if(!file.isEmpty()){
            //获取服务器路径
            String basePath = session.getServletContext().getRealPath("/images");
            String realName = file.getOriginalFilename();//真实上传的文件名
            //执行上传操作
            try {
                String fileName = sdf.format(new Date()) + "_" + realName;
                file.transferTo(new File(basePath + "/" + fileName));
                Map res = new HashMap();
                res.put("fileName", fileName);
                return res;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void setStuService(IStuService stuService) {
        this.stuService = stuService;
    }

    public void setClsService(IClsService clsService) {
        this.clsService = clsService;
    }
}
