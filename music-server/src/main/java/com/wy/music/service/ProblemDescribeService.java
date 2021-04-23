package com.wy.music.service;

import com.wy.music.domain.AloneDescribe;

import java.util.List;

public interface ProblemDescribeService {
    /*查询所有疑问*/
    List<AloneDescribe> selectAll(Integer start, Integer size,String search);

    /*查询总记录数*/
    Long findTotal(String search);

    /*对提出的问题进行答疑*/
    void addAnswer(Integer id,String handler,String answer);
    /*删除答疑*/
    void deleteProblem(Integer id);
}
