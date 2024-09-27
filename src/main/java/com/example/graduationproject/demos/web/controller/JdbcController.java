package com.example.graduationproject.demos.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //写一个list请求，查询数据库信息
    @GetMapping("/list")
    public List<Map<String,Object>> list(){

        String sql="select * from graduation_teach";
        List<Map<String,Object>> list_map=jdbcTemplate.queryForList(sql);
        return list_map;

    }

}
