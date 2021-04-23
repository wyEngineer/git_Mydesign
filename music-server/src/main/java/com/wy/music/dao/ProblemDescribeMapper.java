package com.wy.music.dao;

import com.wy.music.domain.AloneDescribe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.Timestamp;
import java.util.List;

/*疑问表的mapper层*/
@Mapper
public interface ProblemDescribeMapper {

    /*查询所有疑问*/
    List<AloneDescribe> selectAll(@Param("start") Integer start,@Param("size") Integer size,@Param("search") String search);

    /*查询总记录数*/
    Long findTotal(String search);

    /*对提出的问题答疑*/
    void addAnswer(@Param("id") Integer id, @Param("handler") String handler, @Param("answer") String  answer, @Param("finishTime")Timestamp finishTime);

    /*删除答疑*/
    void deleteProblem(Integer id);
}
