package com.wy.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.ManyExamination;
import com.wy.music.service.ManyExaminationService;
import com.wy.music.utils.Const;
import lombok.experimental.PackagePrivate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manyExamination")
public class ManyExaminationController {

    @Autowired
    private ManyExaminationService manyExaminationService;


    /*查询所有多选*/
    @GetMapping("/selectAll")
    public JSONObject selectAll(@RequestParam(name = "page", defaultValue = "1", required = true) Integer page,
                                @RequestParam(name = "size", defaultValue = "5", required = true) Integer size,
                                @RequestParam(name = "subject_text") String subjectText) {

        JSONObject jsonObject = new JSONObject();
        //查询多选题库
        List<ManyExamination> manyExaminations = manyExaminationService.selectAll(page, size, subjectText);
        //查询总记录条数
        Long pageTotal = manyExaminationService.findPageTotal(subjectText);
        if (manyExaminations != null) {
            //将拿到的答案选项，根据逗号进行分割
            for (ManyExamination manyExamination : manyExaminations) {
                String manyAnswerChoose = manyExamination.getManyAnswerChoose();
                String[] splitData = manyAnswerChoose.split(",");
                manyExamination.setManyAnswers(splitData);
            }
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("manyExaminations", manyExaminations);
            jsonObject.put("pageTotal", pageTotal);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到多选题库");
        return jsonObject;
    }


    @GetMapping("/selectAllTest")
    public JSONObject selectAllTest() {
        JSONObject jsonObject = new JSONObject();
        List<ManyExamination> manyExaminations = manyExaminationService.selectAllTest();
        if (manyExaminations != null) {
            //将拿到的答案选项，根据逗号进行分割
            for (ManyExamination manyExamination : manyExaminations) {
                String manyAnswerChoose = manyExamination.getManyAnswerChoose();
                String[] splitData = manyAnswerChoose.split(",");
                manyExamination.setManyAnswers(splitData);
            }
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("manyExaminations", manyExaminations);
            return jsonObject;
        }

        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常,未查询到多选题库");
        return jsonObject;
    }
}
