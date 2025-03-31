package kr.co.ipdisk.dundunhsk.apiboard.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.ApiResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.BoardResponseDTO;
import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;
// import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;
import kr.co.ipdisk.dundunhsk.apiboard.service.BoardService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    @GetMapping
    public ApiResponseDTO<Optional<BoardEntity>> getByIdBoard(@RequestParam(name = "id") Long id){
        return boardService.getByIdBoard(id);
    }

    @GetMapping("/list")
    public ApiResponseDTO<List<BoardResponseDTO>> getBoardList(){
        return boardService.getBoardList();
    }
}
