package kr.co.ipdisk.dundunhsk.apiboard.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long>{
    List<BoardEntity> findByBoardTableName(String boardTableName);
}
