package com.example.flowhomework.service;

import com.example.flowhomework.entity.*;
import com.example.flowhomework.exception.Myexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    ExtendsRepository extendsRepository;

    @Autowired
    FixedExtendsRepository fixedExtendsRepository;


    @Transactional
    public void addFile(MultipartFile multipartFile) throws Exception{
        String filename = multipartFile.getOriginalFilename();
        String[] f = filename.split("\\.");
        String name = f[0];
        String extend = f[1];

        List<Extends> ex = extendsRepository.findAll();
        List<FixedExtends> fex = fixedExtendsRepository.findAll();
        for (Extends anExtends : ex) {
            if(extend.equals(anExtends.getName())){
                throw new Myexception("금지된 확장자 입니다.");
            }
        }
        for (FixedExtends fixedExtends : fex) {
            if(fixedExtends.getChecked()&&extend.equals(fixedExtends.getName())){
                throw new Myexception("금지된 확장자 입니다.");
            }
        }
        fileRepository.save(File.builder()
                .name(name)
                .extend(extend)
                .createTime(LocalDateTime.now())
                .build());

    }





}
