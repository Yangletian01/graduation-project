package com.example.graduationproject.demos.web.service.impl;


import com.example.graduationproject.demos.web.dao.TeacherDao;
import com.example.graduationproject.demos.web.model.ao.TeacherAO;
import com.example.graduationproject.demos.web.model.dto.TeacherDTO;
import com.example.graduationproject.demos.web.model.vo.TeacherVO;
import com.example.graduationproject.demos.web.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @projectName: graduation-project
 * @package: com.example.graduationproject.demos.web.service.impl
 * @className: TeachServiceImpl
 * @author: yangletian
 * @date: 2024/9/18 9:41
 * @version: 1.0
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    //日志类
    private static final Logger log = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherVO> getTeachList(TeacherAO teacher){
        log.info("getTeachList入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        //对象属性复制
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.getTeacherList(teacherDTO);
    }

    @Override
    public int addTeacher(TeacherAO teacher) {
        log.info("addTeacher入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.addTeacher(teacherDTO);
    }

    @Override
    public int deleteTeacher(TeacherAO teacher) {
        log.info("deleteTeacher入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.deleteTeacher(teacherDTO);
    }

    @Override
    public int updateTeacher(TeacherAO teacher) {
        log.info("updateTeacher入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.updateTeacher(teacherDTO);
    }

    @Override
    public TeacherVO getTeach(TeacherAO teacher) {
        log.info("getTeach入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.getTeach(teacherDTO);
    }
}
