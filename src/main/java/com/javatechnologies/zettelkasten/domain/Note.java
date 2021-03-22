package com.javatechnologies.zettelkasten.domain;

import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Where(clause = "deleted = 0")
public class Note {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer parentId;

    private String title;

    @Column(name = "text", length = 1024)
    private String text;
    private String tag;
    // mark note deleted (soft delete)
    private Integer deleted = 0;

    // empty constructor for spring model generation
    public Note(){
    }

    public Note(String title, String text, String tag, Integer parentId){
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted() {
        this.deleted = 1;
    }
}
