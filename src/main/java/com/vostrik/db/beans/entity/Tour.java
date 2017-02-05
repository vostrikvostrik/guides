package com.vostrik.db.beans.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: User
 * Date: 25.10.15
 * Time: 9:33
 */
@Entity
@Table(name="VOSTRIK_TOURS")
public class Tour  implements Serializable {

    @Id
    @Column(name = "tour_id")
    @GeneratedValue
    private Long tourId;

    @Column(name = "tour_name")
    private String tourName;

    @Column(name = "tour_describe")
    private String tourDescribe;

    @Column(name = "tour_startdate")
    private Date tourStartDate;

    @Column(name = "tour_enddate")
    private Date tourEndDate;

    @Column(name = "tour_price")
    private Float tourPrice;

    @Column(name = "tour_currency")
    private Long tourCurrency;

    @Column(name = "tour_active")
    private Long tourActive;

    @Column(name = "tour_guide")
    private Long tourGuide;

    @Column(name = "tour_country")
    private Long tourCountry;

    @Column(name = "tour_city")
    private Long tourCity;

    @Column(name = "tour_type")
    private Long tourType;

    @Column(name = "tour_placesCount")
    private Long tourPlacesCount;

    @Column(name = "tour_lifecircle")
    private Long tourLifeCircle;

    @Column(name = "tour_url")
    private String tourUrl;

    public Long getTourId() {
        return tourId;
    }

    public void setTourId(Long tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourDescribe() {
        return tourDescribe;
    }

    public void setTourDescribe(String tourDescribe) {
        this.tourDescribe = tourDescribe;
    }

    public Date getTourStartDate() {
        return tourStartDate;
    }

    public void setTourStartDate(Date tourStartDate) {
        this.tourStartDate = tourStartDate;
    }

    public Date getTourEndDate() {
        return tourEndDate;
    }

    public void setTourEndDate(Date tourEndDate) {
        this.tourEndDate = tourEndDate;
    }

    public Float getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(Float tourPrice) {
        this.tourPrice = tourPrice;
    }

    public Long getTourCurrency() {
        return tourCurrency;
    }

    public void setTourCurrency(Long tourCurrency) {
        this.tourCurrency = tourCurrency;
    }

    public Long getTourActive() {
        return tourActive;
    }

    public void setTourActive(Long tourActive) {
        this.tourActive = tourActive;
    }

    public Long getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(Long tourGuide) {
        this.tourGuide = tourGuide;
    }

    public Long getTourCountry() {
        return tourCountry;
    }

    public void setTourCountry(Long tourCountry) {
        this.tourCountry = tourCountry;
    }

    public Long getTourCity() {
        return tourCity;
    }

    public void setTourCity(Long tourCity) {
        this.tourCity = tourCity;
    }

    public Long getTourType() {
        return tourType;
    }

    public void setTourType(Long tourType) {
        this.tourType = tourType;
    }

    public Long getTourPlacesCount() {
        return tourPlacesCount;
    }

    public void setTourPlacesCount(Long tourPlacesCount) {
        this.tourPlacesCount = tourPlacesCount;
    }

    public Long getTourLifeCircle() {
        return tourLifeCircle;
    }

    public void setTourLifeCircle(Long tourLifeCircle) {
        this.tourLifeCircle = tourLifeCircle;
    }

    public String getTourUrl() {
        return tourUrl;
    }

    public void setTourUrl(String tourUrl) {
        this.tourUrl = tourUrl;
    }
}
