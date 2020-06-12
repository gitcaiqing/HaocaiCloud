package com.haocai.mybatisGenerator.mapper;

import com.haocai.mybatisGenerator.entity.TransLearningCourse;

public interface TransLearningCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TransLearningCourse record);

    int insertSelective(TransLearningCourse record);

    TransLearningCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransLearningCourse record);

    int updateByPrimaryKey(TransLearningCourse record);
}