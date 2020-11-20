package com.example.challenge.tenpo.persistence.repository;

import com.example.challenge.tenpo.persistence.entities.History;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    Slice<History> findByUsername(String username, Pageable pageable);
}
