package com.example.flowhomework.controller;

import com.example.flowhomework.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@Controller
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/file")
    public String insertBoard(MultipartHttpServletRequest multipartHttpServletRequest, HttpServletResponse response) throws Exception {
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        String name;
        try{
            while(iterator.hasNext()) {
                name = iterator.next();
                List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
                for (MultipartFile multipartFile : list) {
                    fileService.addFile(multipartFile);
                }
            }
        }catch (Exception e){
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('"+e.getMessage()+ "'); history.go(-1);</script>");
            out.flush();
        }

        return "redirect:/";
    }
}
