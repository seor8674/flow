package com.example.flowhomework.controller;


import com.example.flowhomework.entity.ExtendsDto;
import com.example.flowhomework.entity.ExtendsRequestDto;
import com.example.flowhomework.entity.FixedExtendsDto;
import com.example.flowhomework.service.ExtendsSerivce;
import com.example.flowhomework.service.FixedExtendsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    FixedExtendsSerivce fixedExtendsSerivce;

    @Autowired
    ExtendsSerivce extendsSerivce;

    @RequestMapping("/")
    public String Home(Model model)
    {
        List<ExtendsDto> ExtendsDtoList = extendsSerivce.getList();
        List<FixedExtendsDto> FixedExtendsDtoList = fixedExtendsSerivce.getList();
        model.addAttribute("ExList",ExtendsDtoList);
        model.addAttribute("FixedExList",FixedExtendsDtoList);
        return "index";
    }





}
