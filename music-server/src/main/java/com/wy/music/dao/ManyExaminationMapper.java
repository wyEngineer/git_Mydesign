package com.wy.music.dao;

import com.wy.music.domain.ManyExamination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*多选的dao层*/
@Mapper
public interface ManyExaminationMapper {
    //查询所有单选
    List<ManyExamination> selectAll(@Param("start") Integer start,@Param("size") Integer size,@Param("subjectText") String subjectText);

    //查询总记录条数
    Long findPageTotal(String subjectText);


    //查询所有多选，测试模式
    List<ManyExamination> selectAllTest();
}
