package kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class BoardRequestDTO {

    private long id;
    private String boardTableName;
    private String boardName;
    private String boardDescription;
    private int boardPostCount;
    private LocalDateTime boardCreateDateTime;
}
