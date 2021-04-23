package com.wy.music.service;

import com.wy.music.domain.Task;

import java.util.List;

public interface TaskService {
    /*制定任务*/
    public void addTask(Task task);

    /*查询任务*/
    public List<Task> selectAll(String username,Integer page,Integer size);

    /*查询总记录数*/
    public Long findTotal(String username);

    /*修改完成状态*/
    void updateFlag(Integer taskStatus,Integer id );

    /*删除任务*/
    void deleteTask(Integer id);
}
