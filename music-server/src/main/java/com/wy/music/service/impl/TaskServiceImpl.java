package com.wy.music.service.impl;

import com.wy.music.dao.TaskMapper;
import com.wy.music.domain.Task;
import com.wy.music.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public void addTask(Task task) {
        //获取当前系统时间
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        task.setTaskCreate(timestamp);
        taskMapper.addTask(task);
    }

    @Override
    public List<Task> selectAll(String username,Integer page,Integer size) {
        Integer start = (page - 1 ) * size;

        List<Task> tasks = taskMapper.selectAll(username,start,size);
        for (Task task : tasks) {
            if (task.getTaskStatus() == 0) {
                task.setTaskStatusFlag(false);
            } else {
                task.setTaskStatusFlag(true);
            }
        }
        return tasks;
    }

    @Override
    public Long findTotal(String username) {
        return taskMapper.findTotal(username);
    }

    @Override
    public void updateFlag(Integer taskStatus, Integer id) {
        taskMapper.updateFlag(taskStatus,id);
    }

    @Override
    public void deleteTask(Integer id) {
        taskMapper.deleteTask(id);
    }
}
