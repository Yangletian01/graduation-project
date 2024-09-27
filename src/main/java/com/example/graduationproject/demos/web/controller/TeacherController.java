package com.example.graduationproject.demos.web.controller;

import com.example.graduationproject.demos.web.model.ao.TeacherAO;
import com.example.graduationproject.demos.web.model.vo.TeacherVO;
import com.example.graduationproject.demos.web.service.impl.TeacherServiceImpl;
import com.example.graduationproject.demos.web.utils.ApiResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.controller
 * @className: TeachController
 * @author: yangletian
 * @date: 2024/9/18 9:40
 * @version: 1.0
 */
@RestController
@RequestMapping("/teach")
public class TeacherController {

    @Autowired
    private TeacherServiceImpl teachService;

    @RequestMapping(value = "/V1/addTeacher", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ApiResponse<?> addTeacher(@RequestBody TeacherAO teacher) {
        int i = teachService.addTeacher(teacher);
        if(i>0){
         return  ApiResponse.success(200, "添加成功");
        }
        return ApiResponse.error("添加失败");
    }

    @RequestMapping(value = "/V1/deleteTeacher", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ApiResponse<?> deleteTeacher(@RequestBody TeacherAO teacher) {
        int i = teachService.deleteTeacher(teacher);
        if(i>0){
            return  ApiResponse.success(200, "删除成功");
        }
        return ApiResponse.error("删除失败");
    }

    @RequestMapping(value = "/V1/updateTeacher", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ApiResponse<?> updateTeacher(@RequestBody TeacherAO teacher) {
        int i = teachService.updateTeacher(teacher);
        if(i>0){
            return  ApiResponse.success(200, "修改成功");
        }
        return ApiResponse.error("修改失败");
    }

    @RequestMapping(value = "/V1/getTeachList", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ApiResponse<List<TeacherVO>> getTeachList(@RequestBody TeacherAO teacher){
        //开启分页
        PageHelper.startPage(teacher.getPageNo(), teacher.getPageSize());
        List<TeacherVO> teachList = teachService.getTeachList(teacher);
        PageInfo pageInfo = new PageInfo(teachList);
        return ApiResponse.success(pageInfo.getList(), pageInfo.getTotal());
    }


    @RequestMapping(value = "/V1/getTeach", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ApiResponse<TeacherVO> getTeach(@RequestBody TeacherAO teacher){
        TeacherVO teach = teachService.getTeach(teacher);
        return ApiResponse.success(teach);
    }

}
