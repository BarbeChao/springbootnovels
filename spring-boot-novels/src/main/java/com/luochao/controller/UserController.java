package com.luochao.controller;

import com.luochao.domain.User;
import com.luochao.service.UserService;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes({"newUser"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringEncryptor stringEncryptor;
    //跳转登录界面
    @GetMapping("/book/login")
    public String loginMian(){
        return "login";
    }

    //跳转注册界面
    @GetMapping("/book/register")
    public String register(){
        return "register";
    }

    //登录
    @PostMapping("/login")
    public String login(Model model, String userId,String userPassword){
        System.out.println(userId);
        System.out.println(userPassword);
        Map<String,String > map = this.jasypr(userId,userPassword);
        User user = new User();
        user.setUserId(map.get("JasyptUserId"));
        user.setUserPassword(map.get("JasyptUserPassword"));
        System.out.println("iiii"+user);
        User newUser= userService.selectByUserId(user);
        if(newUser!=null){
            model.addAttribute("newUser",newUser);
            return "redirect:index";
        }
            model.addAttribute("results","账号或者密码错误");
        return "login";
    }

    //删除用户session
    @RequestMapping("/remove/sessionUser")
    public String removeSession(HttpSession session, SessionStatus sessionStatus){
        session.removeAttribute("newUser");
        sessionStatus.setComplete();
        return "redirect:/index";
    }

    //注册
    @RequestMapping("/register")
    public String register(Model model,User user){
        String results = userService.insert(user);
        model.addAttribute("resutlts",results);
        System.out.println(results);
        return "login";
    }

    //修改名称
    @GetMapping("/nameSet")
    public String nameSet(HttpSession session, String name){
           User user =(User) session.getAttribute("newUser");
           userService.updataName(user,name);
        return "userSet";
    }

    //修改性别
    @GetMapping("/sexSet")
    public String sexSet(HttpSession session, String sex){
       User user = (User) session.getAttribute("newUser");
        userService.updataSex(user,sex);
        return "userSet";
    }


    //修改年龄
    @GetMapping("/ageSet")
    public String ageSet(HttpSession session, String age){
        User user = (User) session.getAttribute("newUser");
        userService.updataAge(user,age);
        return "userSet";
    }

    //修改密码
    @GetMapping("/passwordSet")
    public String passwordSet(HttpSession session, String oldpassword, String newpassword, Model model){
        User user =(User) session.getAttribute("newUser");
        System.out.println(oldpassword);
        System.out.println(newpassword);
        String result = userService.updataPassword(user,oldpassword,newpassword);
        model.addAttribute("result",result);
        return "userSet";
    }

    //跳转信息总页
    @RequestMapping("/userInfo")
    public String info(){
        return "userinfo";
    }

    //跳转信息设置
    @RequestMapping("/userSet")
    public String test(){
        return "userSet";
    }
    //跳转个人信息界面
    @RequestMapping("/userIndex")
    public String userIndex(){
        return "userIndex";
    }
    //跳转名字修改页
    @GetMapping("/namePage")
    public String namePage(){
        return "nameSet";
    }
    //跳转性别修改页
    @GetMapping("/sexPage")
    public String sexPage(){
        return "sexSet";
    }
    //跳转年龄修改页
    @GetMapping("/agePage")
    public String agePage(){
        return "ageSet";
    }

    //跳转修改密码页面
    @GetMapping("/passwordPage")
    public String passwordPage(){
        return "passwordSet";
    }

    //加密接口
    @RequestMapping("/user/jasypt")
    @ResponseBody
    public Map<String,String> jasypr(String userId, String userPassword){
        Map<String,String> JasyptMap = new HashMap<>();
        //获取加密器
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //设置加密语
        encryptor.setPassword("luochaoyyds");
        String JasyptUserId  = encryptor.encrypt(userId);
        String JasyptUserPassword = encryptor.encrypt(userPassword);
        JasyptMap.put("JasyptUserId",JasyptUserId);
        JasyptMap.put("JasyptUserPassword",JasyptUserPassword);
        return JasyptMap;
    }
}
