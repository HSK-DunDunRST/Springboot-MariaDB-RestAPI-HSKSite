package kr.co.ipdisk.dundunhsk.apiboard.data.entitySet;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.BoardRequestDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board_data")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_table_name")
    private String boardTableName;

    @Column(name = "board_name")
    private String boardName;

    @Column(name = "board_description")
    private String boardDescription;

    @Column(name = "board_post_count")
    private int boardPostCount;

    @Column(name = "board_create_date")
    private LocalDateTime boardCreateDate;

    @Builder
    public BoardEntity(BoardRequestDTO boardRequestDTO){
        this.boardTableName = boardRequestDTO.getBoardTableName();
        this.boardName = boardRequestDTO.getBoardName();
        this.boardDescription = boardRequestDTO.getBoardDescription();
        this.boardPostCount = boardRequestDTO.getBoardPostCount();
        this.boardCreateDate = LocalDateTime.now();
    }
    
    public static BoardEntity of(BoardRequestDTO boardRequestDTO){
        return BoardEntity.builder()
            .boardRequestDTO(boardRequestDTO)
            .build();
    }
}
