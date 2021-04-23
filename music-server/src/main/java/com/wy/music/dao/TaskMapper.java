package com.wy.music.dao;

import com.wy.music.domain.Task;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*指定任务的mapper*/
@Mapper
public interface TaskMapper {

    /*制定任务*/
    public void addTask(Task task);

    /*查询任务*/
    public List<Task> selectAll(@Param("username") String username,@Param("start") Integer start,@Param("size") Integer size);

    /*查询总记录数*/
    public Long findTotal(String username);

    /*修改完成状态*/
    void updateFlag(Integer taskStatus,Integer id );

    /*删除任务*/
    void deleteTask(Integer id);
}
