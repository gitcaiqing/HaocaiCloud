package com.haocai.ticketserver.cloudticketserver.service;

import com.haocai.base.cloudbase.entity.TransLearningCourse;
import com.haocai.base.cloudbase.entity.TransTask;
import com.haocai.base.cloudbase.vo.ResponseMessage;

public interface TransLearningCourseService {

    ResponseMessage addLearningCourse(TransTask transTask);
}
