package com.example.graduationproject.demos.web.utils;

import lombok.Data;

//分页类  需要时继承

@Data
public class Page<T> {
    private int pageNo; // 当前页
    private int pageSize;    // 每页大小


    public Page() {
    }
}