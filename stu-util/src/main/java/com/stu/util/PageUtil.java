package com.stu.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LARK on 2017/12/12.
 * 提供分页功能的工具类
 */

public class PageUtil implements Serializable {

    private int page = 1;   //当前页数
    private int limit = 10;   //一页显示的数
    private int code = 0;   //响应状态
    private String msg = "success"; //响应的消息
    private Integer count = 0;  //数据总条数
    private String keyword;
    private List<?> data;   //查出来的数据

    public PageUtil() {
        super();
    }

    public PageUtil(int page, int limit, int code, String msg, Integer count, String keyword, List<?> data) {
        this.page = page;
        this.limit = limit;
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.keyword = keyword;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getKeyword() {
        if(keyword != null){
            keyword = keyword.trim();
        }
        return keyword;
    }

    public void setKeyword(String keyword) {
        if(keyword != null){
            keyword = keyword.trim();
        }
        this.keyword = keyword;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        List d = new ArrayList();
        if(data.get(0).getClass().isArray()){
            for(int i = 0; i < data.size(); i++){
                Object o[] = (Object[]) data.get(i);
                Map m = new HashMap();
                Map m2 = new HashMap();
                m.put("stu", o[0]);
                m.put("cls", o[1]);
                m2.put("data",m);
                d.add(m2);
            }
        }else{
            d = data;
        }
        this.data = d;
    }
}
