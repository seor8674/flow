package com.example.flowhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

@Setter
@Getter
@AllArgsConstructor
public class ExtendsDto {

    @Max(value = 20, message = "확장자 길이는 20 이하입니다.")
    private String name;
}
