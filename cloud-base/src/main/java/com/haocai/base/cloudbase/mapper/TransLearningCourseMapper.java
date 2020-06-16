package com.haocai.base.cloudbase.mapper;


import com.haocai.base.cloudbase.entity.TransLearningCourse;
import org.springframework.stereotype.Repository;

@Repository
public interface TransLearningCourseMapper extends BaseMapper<TransLearningCourse> {
    int deleteByPrimaryKey(Long id);

    Integer insert(TransLearningCourse record);

    int insertSelective(TransLearningCourse record);

    TransLearningCourse selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TransLearningCourse record);

    int updateByPrimaryKey(TransLearningCourse record);
}