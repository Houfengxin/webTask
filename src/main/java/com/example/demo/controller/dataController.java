package com.example.demo.controller;

import com.example.demo.mapper.DataMapper;

import com.example.demo.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class dataController {

    @Autowired
    private DataMapper dataMapper;

    @GetMapping("/adddata")
    public String ada(){
        return "manage";
    }
    @RequestMapping("/adddata")
    public String adddata(HttpServletRequest request, Map<String,Object> map){
        String dataname = request.getParameter("dataname");
        String define = request.getParameter("define");
        String content = request.getParameter("content");
        Data data = new Data();
        data.setDataname(dataname);
        data.setDefine(define);
        data.setContent(content);
        dataMapper.adddata(data);
        map.put("msg3","添加成功");
        return "manage";
    }

    @GetMapping("/getdata")
    public String gdata(){
        return "manage";
    }

    @RequestMapping("/getdata")
    public String getdata(HttpServletRequest request,Map<String,Object> map){
        String dataname = request.getParameter("dataname");
        Data data  = dataMapper.getdata(dataname);
        if(data !=null){
            map.put("msg4",data.getContent());
            return "manage";
        }else{
            map.put("msg4","此知识点暂无，请添加！");
            return "manage";
        }
    }
    @GetMapping("/deletedata")
    public String dta(){
        return "manage";
    }

    @RequestMapping("/deletedata")
    public String deletedata(HttpServletRequest request,Map<String,Object> map){
        String dataname = request.getParameter("dataname");
        Data data  = dataMapper.getdata(dataname);
        if(data !=null){
            dataMapper.deletedata(dataname);
            map.put("msg5","删除成功");
            return "manage";
        }else{
            map.put("msg5","此知识点不存在，请重试！");
            return "manage";
        }
    }

    @GetMapping("/updatedata")
    public String updata(){
        return "manage";
    }
    @RequestMapping("/updatedata")
    public String updatedata(HttpServletRequest request,Map<String,Object> map){
        String dataname = request.getParameter("dataname");
        String define = request.getParameter("define");
        String content = request.getParameter("content");
        Data data = dataMapper.getdata(dataname);
        if(data != null){
            dataMapper.updatedata(dataname,define,content);
            map.put("msg6","该知识点详情已更新！");
            return "manage";
        }else{
            map.put("msg6","该知识点不存在！");
            return "manage";
        }
    }
    @GetMapping("/manage")
    @RequestMapping("/manage")
    public String manage(){
        return "manage";
    }

}
