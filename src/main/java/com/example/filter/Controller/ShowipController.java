package com.example.filter.Controller;

import com.example.filter.Service.impl.Showipimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShowipController {

    @Autowired
    Showipimpl showipimpl;

    @RequestMapping("/showip")
    @ResponseBody
    public String selectip(String ip){
        return showipimpl.selectIp(ip);
    }

    @RequestMapping("/message")
    @ResponseBody
    public String hello(){
        return "hello word";
    }

    @RequestMapping("/notfind")
    public String notfind(){
        return "404";
    }
}
