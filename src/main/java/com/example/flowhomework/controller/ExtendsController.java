package com.example.flowhomework.controller;




import com.example.flowhomework.entity.ExtendsDto;
import com.example.flowhomework.entity.ExtendsRequestDto;
import com.example.flowhomework.entity.FixedExtendsDto;
import com.example.flowhomework.service.ExtendsSerivce;
import com.example.flowhomework.service.FixedExtendsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/extends")
public class ExtendsController {


    @Autowired
    FixedExtendsSerivce fixedExtendsSerivce;

    @Autowired
    ExtendsSerivce extendsSerivce;


    @PostMapping()
    public String addExtends( ExtendsRequestDto name, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        try{
            extendsSerivce.addExtends(name.getName());
        }catch (Exception e){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('"+e.getMessage()+ "'); history.go(-1);</script>");
            out.flush();
        }

        return "redirect:/";
    }
    @GetMapping("/delete")
    public String RemoveExtends(String name) throws Exception
    {
        extendsSerivce.deleteFixedExtends(name);
        return "redirect:/";
    }





}
