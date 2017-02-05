package com.vostrik.db.beans.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: User
 * Date: 05.07.16
 * Time: 9:09
 */
@Entity
@Table(name="vostrik_tags")
public class Tags implements Serializable{

    @Id
    @Column(name = "tag_id")
    @GeneratedValue
    private Long id;

    @Column(name = "tag_name")
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
