package com.wy.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.domain.Examination;
import com.wy.music.service.ExaminationTestService;
import com.wy.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/examination")
public class ExaminationTestController {
    @Autowired
    private ExaminationTestService aloneTestService;


    //查询所有单选题 Integer page,Integer limit
    @GetMapping("/selectAloneProblemTest")
    public Object selectAloneProblemTest(Integer currentPage, Integer pageSize) {
        //解释:如果currentPage==null的时候，就让它=1，否则=currentPage
        currentPage = currentPage == null ? 1 : currentPage;
        pageSize = pageSize == null ? 10 : pageSize;
        List<Examination> aloneProblemTest = aloneTestService.selectAloneProblemTest(currentPage, pageSize);
        Long pageTotal = aloneTestService.findPageTotal();
        JSONObject jsonObject = new JSONObject();
        if (aloneProblemTest != null) {
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("aloneData", aloneProblemTest);
            jsonObject.put("pageTotal", pageTotal);
            String choose = "";
            jsonObject.put("choose", choose);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到单选题库");
        return jsonObject;
    }

    //查询单选测试
    @GetMapping("/selectAloneProblem")
    public Object selectAloneProblem() {
        List<Examination> aloneProblem = aloneTestService.selectAloneProblem();
        JSONObject jsonObject = new JSONObject();
        if (aloneProblem != null) {
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("aloneData", aloneProblem);
            String choose = "";
            jsonObject.put("choose", choose);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到单选题库");
        return jsonObject;
    }

    //对刷题练习内的提出问题描述(单选，多选，判断)
    @PostMapping("/addDescribeProblem")
    public Object addAloneDescribe(@RequestBody AloneDescribe aloneDescribe) {
        JSONObject jsonObject = new JSONObject();
        try {
            aloneTestService.addAloneDescribe(aloneDescribe);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "感谢您的提交，我们会尽快联系你");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "啊偶,系统异常，无法上传您的问题");
        }
        return jsonObject;
    }

}
