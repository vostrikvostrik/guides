package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 25.10.15
 * Time: 10:43
 */
@Entity
@Table(name="VOSTRIK_COUNTRIES")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String countryName;

    @Column(name = "code")
    private String code;

    @Column(name = "alias")
    private String alias;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "lng")
    private Float lng;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }
}
