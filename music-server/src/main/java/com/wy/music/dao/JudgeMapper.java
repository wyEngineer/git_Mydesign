package com.wy.music.dao;

import com.wy.music.domain.Judge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JudgeMapper {
    //查询所有判断
    List<Judge> selectAll(@Param("start") Integer start,  @Param("size") Integer size,@Param("text") String text);
    //查询总记录数
    Long findTotal(String text);
    //查询所有判断，测试
    List<Judge> selectAllTest();
}
