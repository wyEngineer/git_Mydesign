package com.wy.music.service.impl;

import com.wy.music.dao.JudgeMapper;
import com.wy.music.domain.Judge;
import com.wy.music.service.JudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//判断题业务层
@Service
@Transactional
public class JudgeServiceImpl implements JudgeService {


    @Autowired
    private JudgeMapper judgeMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Judge> selectAll(Integer page,Integer size,String text) {
        int start = (page - 1 ) * size;
        return judgeMapper.selectAll(start,size,text);
    }

    @Override
    public Long findTotal(String text) {
        return judgeMapper.findTotal(text);
    }

    @Override
    public List<Judge> selectAllTest() {
        return judgeMapper.selectAllTest();
    }
}
