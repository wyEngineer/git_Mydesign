package com.wy.music.domain;

/*单选答案的实体类*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class AloneAnswer implements Serializable {

    private Integer id;
    private Integer subjectId;
    private String textA;
    private String textB;
    private String textC;
    private String textD;
}
