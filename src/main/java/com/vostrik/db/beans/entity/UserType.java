package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 22.10.15
 * Time: 12:47
 */
@Entity
@Table(name="VOSTRIK_USERTYPE")
public class UserType {

    @Id
    @Column(name = "type_id")
    @GeneratedValue
    private Long typeId;

    @Column(name = "type_name")
    private String typeName;

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


}
