package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 02.12.15
 * Time: 0:17
 */
@Entity
@Table(name="VOSTRIK_REGIONS")
public class Region {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country_id")
    private Long country_Id;

    @Column(name = "code")
    private String code;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "Ing")
    private Float Ing;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(Long country_Id) {
        this.country_Id = country_Id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getIng() {
        return Ing;
    }

    public void setIng(Float ing) {
        Ing = ing;
    }
}
