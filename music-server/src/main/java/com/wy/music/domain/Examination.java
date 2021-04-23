package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Examination {
    private Integer id;
    private String subjectText;
    private String subjectAnswerText;
    private String subjectAnswerChoose;

    /*存储单选的四个答案*/
    private AloneAnswer aloneAnswer;
}
