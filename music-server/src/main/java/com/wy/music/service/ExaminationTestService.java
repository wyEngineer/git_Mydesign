package com.wy.music.service;

import com.wy.music.domain.AloneAnswer;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.domain.Examination;

import java.util.List;

public interface ExaminationTestService {
    /*查询所有单选题Integer page,Integer limit*/
    List<Examination> selectAloneProblemTest(Integer currentPage, Integer pageSize );
    /*查询记录条数*/
    Long findPageTotal();

    /*单选练习添加意见*/
    void addAloneDescribe(AloneDescribe aloneDescribe);
    //查询单选测验
    List<Examination> selectAloneProblem();
}
