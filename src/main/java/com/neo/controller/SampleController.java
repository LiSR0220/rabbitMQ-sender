package com.neo.controller;


import com.neo.model.Params;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class SampleController {

    @RequestMapping("/adminController")
    public String adminController(){
        return "helloAdmin";
    }

    @RequestMapping(value="/jspController", method=RequestMethod.POST)
    @ResponseBody
    public Object jspController(@RequestBody Params params){
        System.out.println("++++++++++++++++++++++++++++++++++");

        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isEmpty(params)){
            map.put("success",true);
            map.put("message","更新成功了！");
        } else {
            map.put("success",false);
            map.put("message","数据为空！");
        }
        return map;
    }

    @RequestMapping("/ceshi")
    public String getListaUtentiView(ModelMap map){
        return "scanfJsp";
    }

    @RequestMapping("/scanfJsp")
    @ResponseBody
    public String scanfJsp(ModelMap map){
        map.put("name", "测试中");
        return map.toString();
    }
    @RequestMapping("/hello")
    public String getHello(ModelMap map){
        return "jsp/hello";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("lsr".equals(username)&&"123456".equals(password)){
            return "jsp/success";
        }
        return "jsp/fail";
    }

    @RequestMapping("/login1")
    public String loginIndex(Model model){
        model.addAttribute("username", "李先生");
        return "jsp/login";
    }

    @RequestMapping("/admin")
    public String admin(Model model){
        model.addAttribute("admin", "【admin】李先生");
        return "jsp/admin/index";
    }
}
