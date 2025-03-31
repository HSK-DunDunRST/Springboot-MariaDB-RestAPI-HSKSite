package kr.co.ipdisk.dundunhsk.apiboard.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.ipdisk.dundunhsk.apiboard.data.entitySet.BoardEntity;

@Repository
public interface BoardEntityRepository extends JpaRepository<BoardEntity, Long>{

}
