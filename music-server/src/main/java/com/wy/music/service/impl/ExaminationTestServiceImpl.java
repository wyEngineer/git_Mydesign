package com.wy.music.service.impl;

import com.wy.music.dao.ExaminationTestMapper;
import com.wy.music.domain.AloneAnswer;
import com.wy.music.domain.AloneDescribe;
import com.wy.music.domain.Examination;
import com.wy.music.service.ExaminationTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ExaminationTestServiceImpl implements ExaminationTestService {

    @Autowired
    private ExaminationTestMapper aloneTestMapper;


    //如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override/*Integer page,Integer limit*/
    public List<Examination> selectAloneProblemTest(Integer currentPage, Integer pageSize) {
        int start = (currentPage-1) * pageSize;
        return aloneTestMapper.selectAloneProblemTest(start,pageSize);
    }

    //如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Long findPageTotal() {
      return   aloneTestMapper.findPageTotal();
    }

    @Override
    public void addAloneDescribe(AloneDescribe aloneDescribe) {
        aloneTestMapper.addAloneDescribe(aloneDescribe);
    }

    @Override
    public List<Examination> selectAloneProblem() {
        return aloneTestMapper.selectAloneProblem();
    }
}
