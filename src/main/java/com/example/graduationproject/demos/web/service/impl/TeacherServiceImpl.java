package com.example.graduationproject.demos.web.service.impl;


import com.example.graduationproject.demos.web.dao.TeacherDao;
import com.example.graduationproject.demos.web.model.ao.TeacherAO;
import com.example.graduationproject.demos.web.model.dto.TeacherDTO;
import com.example.graduationproject.demos.web.model.vo.TeacherVO;
import com.example.graduationproject.demos.web.service.TeacherService;
import com.example.graduationproject.demos.web.utils.BaseException;
import com.example.graduationproject.demos.web.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
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
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<TeacherVO> getTeachList(TeacherAO teacher){
        log.info("getTeachList入参:{}", teacher);
          //先在redis中查询
//        List value =redisUtil.lGet("teachListKey",0,-1);
//        log.info("getTeachList出参redis:{}", value);
//        if(value.size()>0){
//            log.info("缓存中有数据!");
//            return value;
//        }
        //从库中查
        TeacherDTO teacherDTO = new TeacherDTO();
        //对象属性复制
        BeanUtils.copyProperties(teacher, teacherDTO);
        List teacherList = teacherDao.getTeacherList(teacherDTO);
        //redis缓存
        redisUtil.lSetList("teachListKey", teacherList);
        return teacherList;
    }

    @Override
    public int addTeacher(TeacherAO teacher) {
        log.info("addTeacher入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        int i = teacherDao.addTeacher(teacherDTO);
        if(i>0){
            // 删除缓存，保证下次读取时重新加载
            redisUtil.del("teachListKey");
        }
        return i;
    }

    @Override
    public int deleteTeacher(TeacherAO teacher) {
        log.info("deleteTeacher入参:{}", teacher);
        if(teacher.getId()==null){
            throw new BaseException("删除时id不能为空");
        }
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        int i = teacherDao.deleteTeacher(teacherDTO);
        if(i>0){
            // 删除缓存，保证下次读取时重新加载
            redisUtil.del("teachListKey");
        }
        return i;
    }

    @Override
    public int updateTeacher(TeacherAO teacher) {
        if(teacher.getId()==null){
            throw new BaseException("修改时id不能为空");
        }
        log.info("updateTeacher入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        int i = teacherDao.updateTeacher(teacherDTO);
        if(i>0){
            // 删除缓存，保证下次读取时重新加载
            redisUtil.del("teachListKey");
        }
        return i;
    }

    @Override
    public TeacherVO getTeach(TeacherAO teacher) {
        log.info("getTeach入参:{}", teacher);
        TeacherDTO teacherDTO = new TeacherDTO();
        BeanUtils.copyProperties(teacher, teacherDTO);
        return teacherDao.getTeach(teacherDTO);
    }
}
