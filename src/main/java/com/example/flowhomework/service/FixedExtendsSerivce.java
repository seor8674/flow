package com.example.flowhomework.service;

import com.example.flowhomework.entity.*;
import com.example.flowhomework.exception.Myexception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FixedExtendsSerivce {

    @Autowired
    private FixedExtendsRepository fixedExtendsRepository;

    @Transactional(readOnly = true)
    public List<FixedExtendsDto> getList(){
        return fixedExtendsRepository.findAll().stream().map(s->s.toDto()).collect(Collectors.toList());
    }

    @Transactional
    public void addFixedExtends(String name) throws Exception
    {

        if(fixedExtendsRepository.findByName(name).isPresent())
        {
            throw new Myexception("이미 존재하는 확장자입니다.");
        }
        fixedExtendsRepository.save(FixedExtends.builder()
                .name(name)
                .checked(false)
                .build());
    }

    @Transactional
    public void updateFixedExtends(String name) throws Exception
    {
        fixedExtendsRepository.findByName(name).orElseThrow(()->new Myexception("존재하지 않는 확장자입니다."));
        FixedExtends fixedExtends = fixedExtendsRepository.findByName(name).get();
        fixedExtends.changeCheck();
    }

    @Transactional
    public void deleteFixedExtends(String name) throws Exception
    {
        fixedExtendsRepository.findByName(name).orElseThrow(()->new Myexception("존재하지 않는 확장자입니다."));
        fixedExtendsRepository.deleteByName(name);
    }

}
