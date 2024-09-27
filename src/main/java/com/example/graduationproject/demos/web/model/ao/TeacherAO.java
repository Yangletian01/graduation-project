package com.example.graduationproject.demos.web.model.ao;

import com.example.graduationproject.demos.web.utils.Page;
import lombok.Data;

/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.model.ao
 * @className: TeacherAO
 * @author: yangletian
 * @date: 2024/9/18 11:59
 * @version: 1.0
 */

//前端传递过来的数据 实体
@Data
public class TeacherAO extends Page {

    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String teachLevel;
    private String remark;
    private String creationTime;
    private String updateTime;

}
