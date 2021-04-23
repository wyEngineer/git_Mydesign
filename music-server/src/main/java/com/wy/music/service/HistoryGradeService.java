package com.wy.music.service;

import com.wy.music.domain.HistoryGrade;
import com.wy.music.domain.Vo.HistoryGradeVo;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

public interface HistoryGradeService {
    //保存用户成绩
    void addGrade(HistoryGrade historyGrade);
    /*查询历史成绩*/
    List<HistoryGrade> selectGrade(HistoryGradeVo historyGradeVo);
    /*查询总记录数*/
    Long findByTotal(String username, String model, String selectCondition);
    /*删除历史成绩*/
    void deleteHistory(Integer id);
}
