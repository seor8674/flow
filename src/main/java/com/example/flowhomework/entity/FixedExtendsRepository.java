package com.example.flowhomework.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface FixedExtendsRepository extends JpaRepository<FixedExtends,Long> {

    public Optional<FixedExtends> findByName(String name);

    public Integer deleteByName(String name);
}
