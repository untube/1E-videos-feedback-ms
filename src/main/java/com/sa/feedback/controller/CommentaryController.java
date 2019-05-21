package com.sa.feedback.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.sa.feedback.exception.ResourceNotFoundException;
import com.sa.feedback.model.Commentary;
import com.sa.feedback.repository.CommentaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/feedback/resources")
public class CommentaryController {
    @Autowired
    private CommentaryRepository commentaryRepository;

    @GetMapping("/commentaries")
    public List<Commentary> getAllCommentaries() {
        return this.commentaryRepository.findAll();
    }

    @GetMapping("/commentaries/{id}")
    public ResponseEntity<Commentary> getCommentaryById(@PathVariable(value= "id") Long commentaryId) throws ResourceNotFoundException{
        Commentary commentary = commentaryRepository.findById(commentaryId).orElseThrow(() -> new ResourceNotFoundException("Commentary not found on ::" + commentaryId));
        return ResponseEntity.ok().body(commentary);
    }
    
    @PostMapping("/commentaries")
    public Commentary createCommentary(@Valid @RequestBody Commentary commentary) {
        commentary.setCreated_at(new Date());
        commentary.setUpdated_at(new Date()); 
        commentary.setLikes(0);
        return commentaryRepository.save(commentary);
    } 

    @PutMapping("/commentaries/{id}")
    public ResponseEntity<Commentary> updateCommentary(@PathVariable(value="id") Long commentaryId, @Valid @RequestBody Commentary toUpdateCommentary) throws ResourceNotFoundException {
        Commentary commentary = commentaryRepository.findById(commentaryId).orElseThrow(() -> new ResourceNotFoundException("Commentary not found at :: " + commentaryId));
        commentary.setUpdated_at(new Date());
        commentary.setSubject(toUpdateCommentary.getSubject());
        commentary.setDescription(toUpdateCommentary.getDescription());
        commentary.setLikes(toUpdateCommentary.getLikes());
        final Commentary updatedCommentary = commentaryRepository.save(commentary);
        return ResponseEntity.ok(updatedCommentary);
    }

    @DeleteMapping("/commentaries/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value="id") Long commentaryId) throws Exception {
        Commentary commentary = commentaryRepository.findById(commentaryId).orElseThrow(() -> new ResourceNotFoundException("User not found on ::" + commentaryId));

        commentaryRepository.delete(commentary);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response; 
    }

}