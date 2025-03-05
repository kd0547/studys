package com.example.boardexample.repository;

import com.example.boardexample.dto.BoardDto;
import com.example.boardexample.entity.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class BoardRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Board> findPage(int page) {
        return em.createQuery("select b from Board b order by createAt desc")
                .setMaxResults(10)
                .setFirstResult((page - 1) * 10)
                .getResultList();
    }

    public Long save(BoardDto boardDto) {
        Board board = Board.createBoard(boardDto);
        em.persist(board);
        return board.getId();
    }

    public Optional<Board> findById(Long id) {
        Board board = em.find(Board.class,id);
        Optional<Board> optionalBoard = Optional.ofNullable(board);
        return optionalBoard;
    }

    public int updateLike(long id) {
        Query query = em.createNativeQuery(
                "UPDATE board SET likes = likes + 1 WHERE id = :id")
                .setParameter("id",id);
        return query.executeUpdate();
    }
}
