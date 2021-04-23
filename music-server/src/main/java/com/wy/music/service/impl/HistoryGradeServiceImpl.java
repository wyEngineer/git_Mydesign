package com.wy.music.service.impl;

import com.wy.music.dao.HistoryGradeMapper;
import com.wy.music.domain.HistoryGrade;
import com.wy.music.domain.Vo.HistoryGradeVo;
import com.wy.music.service.HistoryGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

//历史成绩的业务层
@Service
@Transactional
public class HistoryGradeServiceImpl implements HistoryGradeService {

    @Autowired
    private HistoryGradeMapper historyGradeMapper;

    @Override
    public void addGrade(HistoryGrade historyGrade) {
        historyGradeMapper.addGrade(historyGrade);
    }

    @Override
    public List<HistoryGrade> selectGrade(HistoryGradeVo historyGradeVo) {
        historyGradeVo.setPage((historyGradeVo.getPage() - 1) * historyGradeVo.getSize());
        return historyGradeMapper.selectGrade(historyGradeVo);
    }

    @Override
    public Long findByTotal(String username, String model, String selectCondition) {
        return historyGradeMapper.findByTotal(username, model, selectCondition);
    }

    @Override
    public void deleteHistory(Integer id) {
        historyGradeMapper.deleteHistory(id);
    }
}
