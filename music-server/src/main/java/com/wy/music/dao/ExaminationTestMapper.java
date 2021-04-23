package com.wy.music.dao;

import com.wy.music.domain.AloneAnswer;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.domain.Examination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExaminationTestMapper {
    //查询所有单选题@Param("start") Integer start,@Param("limit") Integer limit
    List<Examination> selectAloneProblemTest(@Param("start") Integer start,@Param("pageSize") Integer pageSize);

    /*查询记录条数*/
    Long findPageTotal();

    /*单选练习添加意见*/
    void addAloneDescribe(AloneDescribe aloneDescribe);

    //查询单选测验
    List<Examination> selectAloneProblem();
}
