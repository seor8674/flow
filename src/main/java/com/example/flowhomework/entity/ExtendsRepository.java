package com.example.flowhomework.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ExtendsRepository extends JpaRepository<Extends,Long> {

    public Optional<Extends> findByName(String name);

    public Integer deleteByName(String name);

}
