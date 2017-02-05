package com.vostrik.db.beans.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: User
 * Date: 25.10.15
 * Time: 10:43
 */

@Entity
@Table(name="VOSTRIK_CITIES")
public class City implements Serializable {

    public Long getId() {
        return id;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String cityName;

    @Column(name = "country")
    private Long country;

    @Column(name = "region")
    private Long region;

    @Column(name = "latitude")
    private Float latitude;

    @Column(name = "longitude")
    private Float longitude;

    public City(){
        super();
    }

    public City(Long id, String cityName, Long country, Long region, Float latitude, Float longitude) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
