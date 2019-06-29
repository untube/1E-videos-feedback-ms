package com.sa.feedback.repository;

import java.util.List;

import com.sa.feedback.model.Commentary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
    List<Commentary> findByIdVideo(String idVideo);
}