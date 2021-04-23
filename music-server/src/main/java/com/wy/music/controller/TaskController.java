package com.wy.music.controller;

/*任务的控制层*/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.Task;
import com.wy.music.service.TaskService;
import com.wy.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public JSONObject addTask(Task task) {
        JSONObject jsonObject = new JSONObject();
        try {
            taskService.addTask(task);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "制定任务成功，尽快完成!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统异常，制定任务失败");
        }
        return jsonObject;
    }

    @GetMapping("/selectAll")
    public JSONObject jsonObject(String username,
                                 @RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                 @RequestParam(name = "size",required = true,defaultValue = "6") Integer size) {

        JSONObject jsonObject = new JSONObject();
        List<Task> tasks = taskService.selectAll(username,page,size);
        //查询总记录数
        Long totalCount = taskService.findTotal(username);
        if (tasks != null) {
            String disabled = "";
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("tasks", tasks);
            /*给前端返回空值，以便于,点击完成任务，禁止点击css。防止点击一行全局变化*/
            jsonObject.put("disabled", disabled);
            jsonObject.put("totalCount",totalCount);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常，未查询到任务数据");
        return jsonObject;
    }

    /*修改任务完成状态*/
    @GetMapping("/updateFlag")
    public JSONObject updateFlag(Integer taskStatus, Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            taskService.updateFlag(taskStatus, id);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "任务完成啦，恭喜你，休息会吧！");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统异常，修改用户进度失败!");
        }
        return jsonObject;
    }

    /*删除任务*/
    @GetMapping("/deleteTask")
    public JSONObject deleteTask(Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            taskService.deleteTask(id);
            jsonObject.put(Const.CODE,1);
            jsonObject.put(Const.MSG,"删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE,0);
            jsonObject.put(Const.MSG,"系统异常，删除任务失败!");
        }
        return jsonObject;
    }
}
