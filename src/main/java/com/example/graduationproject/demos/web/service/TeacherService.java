package com.example.graduationproject.demos.web.service;

import com.example.graduationproject.demos.web.model.ao.TeacherAO;
import com.example.graduationproject.demos.web.model.vo.TeacherVO;

import java.util.List;

public interface TeacherService {
    List<TeacherVO> getTeachList(TeacherAO teacher) ;

    int addTeacher(TeacherAO teacher);

    int deleteTeacher(TeacherAO teacher);

    int updateTeacher(TeacherAO teacher);

    TeacherVO getTeach(TeacherAO teacher);
}
