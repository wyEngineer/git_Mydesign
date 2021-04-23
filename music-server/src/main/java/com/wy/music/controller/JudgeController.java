package com.wy.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.Judge;
import com.wy.music.service.JudgeService;
import com.wy.music.utils.Const;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//判断题web层
@RestController
@RequestMapping("/judge")
public class JudgeController {

    @Autowired
    private JudgeService judgeService;

    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true, defaultValue = "10") Integer size,
                                String text) {
        JSONObject jsonObject = new JSONObject();
        List<Judge> judges = judgeService.selectAll(page, size, text);
        Long pageTotal = judgeService.findTotal(text);
        if (judges != null) {
            for (Judge judge : judges) {
                if (judge.getAnswer() == 1) {
                    judge.setAnswerText("正确");
                } else {
                    judge.setAnswerText("错误");
                }
            }
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("judges", judges);
            jsonObject.put("pageTotal", pageTotal);
            String choose = "";
            jsonObject.put("choose", choose);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常，未查询到判断题库");
        return jsonObject;
    }

    @GetMapping("/selectAllTest")
    public JSONObject selectAllTest() {
        JSONObject jsonObject = new JSONObject();
        List<Judge> judgesTest = judgeService.selectAllTest();
        if (judgesTest != null) {
            for (Judge judge : judgesTest) {
                if (judge.getAnswer() == 1) {
                    judge.setAnswerText("正确");
                } else {
                    judge.setAnswerText("错误");
                }
            }
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("judgesTest", judgesTest);
            String choose = "";
            jsonObject.put("choose", choose);
            return jsonObject;

        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到判断题库");
        return jsonObject;
    }
}
