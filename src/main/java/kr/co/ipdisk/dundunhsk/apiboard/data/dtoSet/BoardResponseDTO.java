package kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet;

import java.time.LocalDateTime;

import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;
import lombok.Getter;

@Getter
public class BoardResponseDTO {
    private long id;
    private String boardTableName;
    private String boardName;
    private String boardDescription;
    private int boardPostCount;
    private LocalDateTime boardCreateDateTime;

    private BoardResponseDTO(BoardEntity boardEntity){
        this.id = boardEntity.getId();
        this.boardTableName = boardEntity.getBoardTableName();
        this.boardName = boardEntity.getBoardName();
        this.boardDescription = boardEntity.getBoardDescription();
        this.boardPostCount = boardEntity.getBoardPostCount();
        this.boardCreateDateTime = boardEntity.getBoardCreateDate();
    }

    public static BoardResponseDTO of(BoardEntity boardEntity){
        return new BoardResponseDTO(boardEntity);
    }
}
