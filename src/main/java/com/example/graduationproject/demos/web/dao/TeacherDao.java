package com.example.graduationproject.demos.web.dao;

import com.example.graduationproject.demos.web.model.dto.TeacherDTO;
import com.example.graduationproject.demos.web.model.vo.TeacherVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherDao {
    List<TeacherVO> getTeacherList(TeacherDTO teacher);

    int addTeacher(TeacherDTO teacherDTO);

    int deleteTeacher(TeacherDTO teacherDTO);

    int updateTeacher(TeacherDTO teacherDTO);

    TeacherVO getTeach(TeacherDTO teacherDTO);
}
