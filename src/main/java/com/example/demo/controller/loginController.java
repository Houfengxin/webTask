package com.example.demo.controller;


import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class loginController {
    @Autowired
    private UserMapper userMapper;

    /*@GetMapping("/login")
    @RequestMapping("/login")
    public String login(){
        return "login";
    }*/


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request,Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        if(loginuser!=null){
            map.put("msg2","the user "+loginuser+" login");
            return "index";
        }
        else{
            map.put("msg2","仅供学习使用！");
            return "login";
        }
    }


}
