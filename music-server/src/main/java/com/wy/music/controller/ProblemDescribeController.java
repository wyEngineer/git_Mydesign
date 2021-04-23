package com.wy.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.service.ProblemDescribeService;
import com.wy.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problem")
public class ProblemDescribeController {

    @Autowired
    private ProblemDescribeService problemDescribeService;

    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page,
                                @RequestParam(name = "size", defaultValue = "10", required = true) Integer size,
                                String search) {
        JSONObject jsonObject = new JSONObject();
        List<AloneDescribe> describes = problemDescribeService.selectAll(page, size, search);
        Long totalCount = problemDescribeService.findTotal(search);
        if (describes != null) {
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("describes", describes);
            jsonObject.put("totalCount", totalCount);
            return jsonObject;
        }

        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到答疑！");
        return jsonObject;
    }

    /*添加答疑*/
    @PostMapping("/addAnswer")
    public JSONObject addAnswer(Integer id, String handler, String answer) {
        JSONObject jsonObject = new JSONObject();
        try {
            problemDescribeService.addAnswer(id, handler, answer);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "谢谢您的答疑!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统异常，无法答疑");
        }
        return jsonObject;
    }

    /*删除答疑*/
    @GetMapping("/deleteProblem")
    public JSONObject deleteProblem(Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            problemDescribeService.deleteProblem(id);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE,0);
            jsonObject.put(Const.MSG,"系统异常,删除失败!");
        }
        return jsonObject;
    }
}

