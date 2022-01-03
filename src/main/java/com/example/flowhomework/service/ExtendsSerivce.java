package com.example.flowhomework.service;

import com.example.flowhomework.entity.Extends;
import com.example.flowhomework.entity.ExtendsDto;
import com.example.flowhomework.entity.ExtendsRepository;
import com.example.flowhomework.exception.Myexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExtendsSerivce {

    @Autowired
    private ExtendsRepository extendsRepository;

    @Transactional(readOnly = true)
    public List<ExtendsDto> getList(){
        return extendsRepository.findAll().stream().map(s->s.toDto()).collect(Collectors.toList());
    }


    @Transactional
    public void addExtends(String name) throws Exception
    {
        if(name.length()>20){
            throw new Myexception("확장자 길이는 20 이하입니다.");
        }
        if(extendsRepository.findByName(name).isPresent())
        {
            throw new Myexception("이미 존재하는 확장자입니다.");
        }
        if(extendsRepository.findAll().size()>200){
            throw new Myexception("확장자가 200개 입니다.");
        }
        extendsRepository.save(Extends.builder()
                .name(name)
                .build());
    }
    @Transactional
    public void deleteFixedExtends(String name) throws Exception
    {
        extendsRepository.findByName(name).orElseThrow(()->new Myexception("존재하지 않는 확장자입니다."));
        extendsRepository.deleteByName(name);
    }
}
