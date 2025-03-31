package kr.co.ipdisk.dundunhsk.apiboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ipdisk.dundunhsk.apiboard.common.ResponseUtil;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.ApiResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.BoardResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;
import kr.co.ipdisk.dundunhsk.apiboard.data.repository.BoardEntityRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

    @Autowired
    private final BoardEntityRepository boardEntityRepository;

    @Transactional(readOnly = true)
    public ApiResponseDTO<List<BoardResponseDTO>> getBoardList(){
        List<BoardEntity> boardEntities = boardEntityRepository.findAll();
        List<BoardResponseDTO> boardResponseList = new ArrayList<>();

        for(BoardEntity boardEntity : boardEntities){
            boardResponseList.add(BoardResponseDTO.of(boardEntity));
        }
        return ResponseUtil.ok(boardResponseList);
    }
}
