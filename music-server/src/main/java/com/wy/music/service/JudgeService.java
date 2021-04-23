package com.wy.music.service;

import com.wy.music.domain.Judge;

import java.util.List;

public interface JudgeService {
    //查询所有判断
    List<Judge> selectAll(Integer page,Integer size,String text);
    //查询总记录数
    Long findTotal(String text);

    List<Judge> selectAllTest();
}
