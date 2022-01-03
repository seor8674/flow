package com.example.flowhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Getter
@Setter
@AllArgsConstructor
public class FixedExtendsDto {


    private String name;

    private Boolean check;
}
