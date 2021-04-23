package com.wy.music.ManyExamination;

import com.wy.music.MusicApplication;
import com.wy.music.domain.Judge;
import com.wy.music.domain.ManyExamination;
import com.wy.music.service.JudgeService;
import com.wy.music.service.ManyExaminationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = {MusicApplication.class})
@RunWith(SpringRunner.class)
public class ManyExaminationTest {

    @Autowired
    private ManyExaminationService service;

    @Autowired
    private JudgeService judgeService;

    @Test
    public void testManyExamination() {
        /*  List<ManyExamination> manyExaminations = service.selectAll();*/
        /*  System.out.println(manyExaminations);*/
    }



    /* public  void testJudge(){
        List<Judge> judges = judgeService.selectAll();
        System.out.println(judges);
    }*/

    @Test
    public void split() {
        String test = "B,C";
        String[] split = test.split(",");

    }
}
