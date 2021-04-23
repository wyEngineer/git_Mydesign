package com.wy.music.controller;

import com.alibaba.fastjson.JSONObject;
import com.wy.music.domain.HistoryGrade;
import com.wy.music.domain.Vo.HistoryGradeVo;
import com.wy.music.service.HistoryGradeService;
import com.wy.music.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("/grade")
@RestController
public class HistoryGradeController {

    @Autowired
    private HistoryGradeService historyGradeService;

    @PostMapping("/addScore")
    public JSONObject addScore(@RequestBody HistoryGrade historyGrade) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        historyGrade.setExaimTime(timestamp);
        JSONObject jsonObject = new JSONObject();
        try {
            historyGradeService.addGrade(historyGrade);
            jsonObject.put(Const.CODE, 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
        }
        return jsonObject;
    }

    /*查询历史成绩*/
    @PostMapping("/selectGrade")
    public JSONObject selectGrade(HistoryGradeVo historyGradeVo) {
        if (historyGradeVo.getPage() == null) {
            historyGradeVo.setPage(1);
        }
        if (historyGradeVo.getSize() == null) {
            historyGradeVo.setSize(10);
        }
        JSONObject jsonObject = new JSONObject();
        List<HistoryGrade> historyGrades = historyGradeService.selectGrade(historyGradeVo);
        Long totalCount = historyGradeService.findByTotal(historyGradeVo.getUsername(), historyGradeVo.getModel(), historyGradeVo.getSelectCondition());
        if (historyGrades != null) {
            jsonObject.put(Const.CODE, 1);
            jsonObject.put("historyGrades", historyGrades);
            jsonObject.put("totalCount", totalCount);
            return jsonObject;
        }
        jsonObject.put(Const.CODE, 0);
        jsonObject.put(Const.MSG, "系统异常，未查询到你的历史成绩");
        return jsonObject;
    }

    /*修改历史成成绩*/
    @GetMapping("/deleteHistory")
    public JSONObject deleteHistory(Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            historyGradeService.deleteHistory(id);
            jsonObject.put(Const.CODE, 1);
            jsonObject.put(Const.MSG, "删除成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put(Const.CODE, 0);
            jsonObject.put(Const.MSG, "系统失败,删除历史成绩失败!");
        }
        return jsonObject;
    }
}
