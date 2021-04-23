package com.wy.music.dao;
//历史成绩的mapper接口
import com.wy.music.domain.HistoryGrade;
import com.wy.music.domain.Vo.HistoryGradeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface HistoryGradeMapper {
    //保存用户成绩
    void addGrade(HistoryGrade historyGrade);


    /*查询历史成绩*/
    List<HistoryGrade> selectGrade(HistoryGradeVo historyGradeVo);

    /*查询总记录数*/
    Long findByTotal(@Param("username") String username,@Param("model")  String model,@Param("selectCondition") String selectCondition);

    /*删除历史成绩*/
    void deleteHistory(Integer id);
}
