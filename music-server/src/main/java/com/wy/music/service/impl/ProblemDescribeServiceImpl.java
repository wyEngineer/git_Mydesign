package com.wy.music.service.impl;

import com.wy.music.dao.ProblemDescribeMapper;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.service.ProblemDescribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class ProblemDescribeServiceImpl implements ProblemDescribeService {

    @Autowired
    private ProblemDescribeMapper problemDescribeMapper;

    @Override
    public List<AloneDescribe> selectAll(Integer page,Integer size,String search) {
        int start = (page - 1) * size;
        List<AloneDescribe> aloneDescribes = problemDescribeMapper.selectAll(start,size,search);
        for (AloneDescribe aloneDescribe : aloneDescribes) {
            if (aloneDescribe.getIsFinish() == 0) {
                aloneDescribe.setIsFinishText("未处理");
            } else {
                aloneDescribe.setIsFinishText("已处理");
            }
        }
        return aloneDescribes;
    }

    @Override
    public Long findTotal(String search) {
        return problemDescribeMapper.findTotal(search);
    }

    @Override
    public void addAnswer(Integer id, String handler, String answer) {
        /*获取当前系统时间*/
        Timestamp finishTime=new Timestamp(System.currentTimeMillis());
        problemDescribeMapper.addAnswer(id,handler,answer,finishTime);
    }

    @Override
    public void deleteProblem(Integer id) {
        problemDescribeMapper.deleteProblem(id);
    }
}
