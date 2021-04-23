package com.wy.music.service;

import com.wy.music.domain.ManyExamination;

import java.util.List;

public interface ManyExaminationService {
    //查询所有单选
    List<ManyExamination> selectAll(Integer page,Integer size,String subjectText);
    //查询总记录条数
    Long findPageTotal(String subjectText);

    //查询所有多选，测试模式
    List<ManyExamination> selectAllTest();
}
