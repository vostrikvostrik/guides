package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 30.12.16
 * Time: 12:26
 */
@Entity
@Table(name="vostrik_tag_ref")
public class TagRef {
    @Id
    @Column(name = "tag_id")
    @GeneratedValue
    private Long tagId;

    @Column(name = "tag_ref")
    private Long tagRef;

    @Column(name = "tag_content_type")
    private Long tagContentType;

    @Column(name = "tag_content_short")
    private String contentShort;

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Long getTagRef() {
        return tagRef;
    }

    public void setTagRef(Long tagRef) {
        this.tagRef = tagRef;
    }

    public Long getTagContentType() {
        return tagContentType;
    }

    public void setTagContentType(Long tagContentType) {
        this.tagContentType = tagContentType;
    }
}
