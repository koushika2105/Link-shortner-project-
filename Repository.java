package com.example.demo.repository;

import com.example.demo.entity.LinkShortenerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LinkShortenerRepository extends JpaRepository<LinkShortenerEntity, Long> {

    Optional<LinkShortenerEntity> findByShortCode(String shortCode);
}