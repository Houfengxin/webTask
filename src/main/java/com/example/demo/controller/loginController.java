package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

@Controller
public class loginController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
    @RequestMapping("/linear")
    public String linear(){
        return "linear.html";
    }
    @RequestMapping("/array")
    public String array(){
        return "array.html";
    }
    @RequestMapping("/hash")
    public String hash(){
        return "hash.html";
    }
    @RequestMapping("/tree")
    public String tree(){
        return "tree.html";
    }
    @RequestMapping("/graph")
    public String graph(){
        return "graph.html";
    }
    @RequestMapping("/algorithm")
    public String algorithm(){
        return "algorithm.html";
    }
    @RequestMapping("/checkuser")
    public String checkuser(HttpServletRequest request,
                            HttpServletResponse response,
                            Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();

        User user = userMapper.checkuser(username,password);

        if(user!=null){
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userMapper.updateUser(user);
            response.addCookie(new Cookie("token",token));
            session.setAttribute("loginUser",user);
            map.put("msg0","欢迎"+username);
            map.put("user",user);
            //model.addAttribute("user",username);

            return "/index";
        }else {
            map.put("msg","login fail");
            return "/login";
        }
    }
}
