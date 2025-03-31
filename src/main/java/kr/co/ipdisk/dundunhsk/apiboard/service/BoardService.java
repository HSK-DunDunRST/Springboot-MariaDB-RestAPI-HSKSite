package kr.co.ipdisk.dundunhsk.apiboard.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ipdisk.dundunhsk.apiboard.common.ErrorResponse;
import kr.co.ipdisk.dundunhsk.apiboard.common.ResponseUtil;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.ApiResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.BoardRequestDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.BoardResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;
import kr.co.ipdisk.dundunhsk.apiboard.data.enumSet.ErrorType;
import kr.co.ipdisk.dundunhsk.apiboard.data.repository.BoardEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardEntityRepository boardEntityRepository;

    //^ 모든 게시판 조회
    @Transactional(readOnly = true)
    public ApiResponseDTO<List<BoardResponseDTO>> getBoardList(){
        List<BoardEntity> boardEntities = boardEntityRepository.findAll();
        List<BoardResponseDTO> boardResponseList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntities){
            boardResponseList.add(BoardResponseDTO.of(boardEntity));
        }
        return ResponseUtil.ok(boardResponseList);
    }

    //^ 게시판 생성
    @Transactional
    public ApiResponseDTO<BoardResponseDTO> createBoard(BoardRequestDTO boardRequestDTO){
        if(boardEntityRepository.findByBoardTableName(boardRequestDTO.getBoardTableName()).isEmpty()){
            BoardEntity saveBoard = boardEntityRepository.save(BoardEntity.of(boardRequestDTO));
            return ResponseUtil.ok(BoardResponseDTO.of(saveBoard));
        } else{
            return ResponseUtil.error(ErrorResponse.of(ErrorType.DUPLICATED_BOARD));
        }
    }

    //^ 특정 게시판 조회
    @Transactional
    public ApiResponseDTO<Optional<BoardEntity>> getByIdBoard(Long id){
        if(boardEntityRepository.findById(id).isPresent()){
            return ResponseUtil.ok(boardEntityRepository.findById(id));
        } else{
            return ResponseUtil.error(ErrorResponse.of(ErrorType.NOT_FOUND_BOARD));
        }
    }
}
