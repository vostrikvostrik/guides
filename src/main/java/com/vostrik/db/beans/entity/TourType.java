package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 25.10.15
 * Time: 22:16
 */
@Entity
@Table(name="vostrik_tourtype")
public class TourType {

    @Id
    @Column(name = "type_id")
    @GeneratedValue
    private Long typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "type_descr")
    private String typeDescr;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescr() {
        return typeDescr;
    }

    public void setTypeDescr(String typeDescr) {
        this.typeDescr = typeDescr;
    }
}
