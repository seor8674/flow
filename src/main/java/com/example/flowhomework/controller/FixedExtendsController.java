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
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/fixedextends")
public class FixedExtendsController {


    @Autowired
    FixedExtendsSerivce fixedExtendsSerivce;



    @PostMapping()
    public String addFixedExtends(FixedExtendsDto name) throws Exception
    {
        fixedExtendsSerivce.addFixedExtends(name.getName());
        return "redirect:/";
    }
    @GetMapping("/delete")
    public String RemoveFixedExtends(String name) throws Exception
    {
        fixedExtendsSerivce.deleteFixedExtends(name);
        return "redirect:/";
    }
    @GetMapping("/update")
    public String PutFixedExtends(String name) throws Exception
    {
        System.out.println("eqeq");
        fixedExtendsSerivce.updateFixedExtends(name);
        return "redirect:/";
    }




}
