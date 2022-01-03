package com.example.flowhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Extends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Extends_Id")
    private Long id;

    private String name;


    public ExtendsDto toDto(){
        return new ExtendsDto(name);
    }



}
