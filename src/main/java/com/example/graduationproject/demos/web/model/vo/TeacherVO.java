package com.example.graduationproject.demos.web.model.vo;

import com.example.graduationproject.demos.web.utils.Page;
import lombok.Data;


/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.model
 * @className: TeacherModel
 * @author: yangletian
 * @date: 2024/9/18 9:47
 * @version: 1.0
 */
//给前端展示实体
@Data
public class TeacherVO  {

    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String teachLevel;
    private String remark;
    private String creationTime;
    private String updateTime;


}
