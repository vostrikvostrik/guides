package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 30.12.16
 * Time: 12:26
 */
@Entity
@Table(name="vostrik_tag_content_type")
public class TagContentType {

    @Id
    @Column(name = "content_type_id")
    @GeneratedValue
    private Long id;

    @Column(name = "content_type_link")
    private String typeLink;

    @Column(name = "content_type_descr")
    private String typeDescr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeLink() {
        return typeLink;
    }

    public void setTypeLink(String typeLink) {
        this.typeLink = typeLink;
    }

    public String getTypeDescr() {
        return typeDescr;
    }

    public void setTypeDescr(String typeDescr) {
        this.typeDescr = typeDescr;
    }

}
