package com.wy.music.service.impl;

import com.wy.music.dao.ManyExaminationMapper;
import com.wy.music.domain.ManyExamination;
import com.wy.music.service.ManyExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*多选的service层*/
@Service
@Transactional
public class ManyExaminationServiceImpl implements ManyExaminationService {

    @Autowired
    private ManyExaminationMapper manyExaminationMapper;

    @Override
    //支持事务
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ManyExamination> selectAll(Integer page,Integer size,String subjectText) {
        int start=(page-1)*size;
        return manyExaminationMapper.selectAll(start,size,subjectText);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Long findPageTotal(String subjectText) {
        return manyExaminationMapper.findPageTotal(subjectText);
    }

    @Override
    public List<ManyExamination> selectAllTest() {
        return manyExaminationMapper.selectAllTest();
    }
}
