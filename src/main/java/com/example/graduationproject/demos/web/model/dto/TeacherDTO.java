package com.example.graduationproject.demos.web.model.dto;

import lombok.Data;

/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.model.dto
 * @className: TeacherDTO
 * @author: yangletian
 * @date: 2024/9/18 11:59
 * @version: 1.0
 */

//主要跟数据库交互的实体类
@Data
public class TeacherDTO {

    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String teachLevel;
    private String remark;
    private String creationTime;
    private String updateTime;

}
