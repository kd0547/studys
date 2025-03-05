package com.example.boardexample.repository;

import com.example.boardexample.entity.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
