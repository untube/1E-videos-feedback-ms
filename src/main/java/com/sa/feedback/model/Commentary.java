package com.sa.feedback.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name="commentary")
@EntityListeners(AuditingEntityListener.class)
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name="create_at", nullable = false)
    private Date created_at;

    @Column(name="updated_at", nullable = false)
    private Date updated_at;

    @Column(name="id_video", nullable=false) 
    private Long id_video;
    
    @Column(name="likes", nullable = true) 
    private Integer likes;

    @Column(name="description", nullable=false)
    private String description;


    public Commentary() {

    }

    public Commentary(Long id, String subject, Date created_at, Date updated_at, Long id_video, Integer likes) {
        this.id = id;
        this.subject = subject;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.id_video = id_video;
        this.likes = likes;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Long getId_video() {
        return this.id_video;
    }

    public void setId_video(Long id_video) {
        this.id_video = id_video;
    }

    public Integer getLikes() {
        return this.likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
        this.description = description;
    }



}