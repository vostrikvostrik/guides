package com.vostrik.db.beans.item;

import java.util.Date;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 10:43
 */
public class TourItem {
    private Long tourId;
    private String tourName;
    private String tourDescribe;
    private Date tourStartDate;
    private Date tourEndDate;
    private Float tourPrice;
    private Long tourCurrency;
    private String tourCurrName;
    private Long tourActive;
    private Long tourGuide;
    private String tourGuideName;
    private String tourGuideEmail;
    private String tourCountry;
    private String tourCity;
    private String tourType;
    private List<ClientItem> clientItems;
    private Integer clientCount;
    private Long placesCount;
    private String userPublicName;

    public TourItem(Long tourId, String tourName, String tourDescribe, Date tourStartDate, Date tourEndDate, Float tourPrice, Long tourCurrency, String tourCurrName, Long tourActive, Long tourGuide, String tourGuideName, String tourGuideEmail, String tourCountry, String tourCity, String tourType, Long placesCount, String userPublicName) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourDescribe = tourDescribe;
        this.tourStartDate = tourStartDate;
        this.tourEndDate = tourEndDate;
        this.tourPrice = tourPrice;
        this.tourCurrency = tourCurrency;
        this.tourCurrName = tourCurrName;
        this.tourActive = tourActive;
        this.tourGuide = tourGuide;
        this.tourGuideName = tourGuideName;
        this.tourGuideEmail = tourGuideEmail;
        this.tourCountry = tourCountry;
        this.tourCity = tourCity;
        this.tourType = tourType;
        this.placesCount = placesCount;
        this.userPublicName = userPublicName;
    }



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

    public String getTourCurrName() {
        return tourCurrName;
    }

    public void setTourCurrName(String tourCurrName) {
        this.tourCurrName = tourCurrName;
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

    public String getTourGuideName() {
        return tourGuideName;
    }

    public void setTourGuideName(String tourGuideName) {
        this.tourGuideName = tourGuideName;
    }

    public String getTourGuideEmail() {
        return tourGuideEmail;
    }

    public void setTourGuideEmail(String tourGuideEmail) {
        this.tourGuideEmail = tourGuideEmail;
    }

    public String getTourCountry() {
        return tourCountry;
    }

    public void setTourCountry(String tourCountry) {
        this.tourCountry = tourCountry;
    }

    public String getTourCity() {
        return tourCity;
    }

    public void setTourCity(String tourCity) {
        this.tourCity = tourCity;
    }

    public String getTourType() {
        return tourType;
    }

    public void setTourType(String tourType) {
        this.tourType = tourType;
    }

    public List<ClientItem> getClientItems() {
        return clientItems;
    }

    public void setClientItems(List<ClientItem> clientItems) {
        this.clientItems = clientItems;
    }

    public Integer getClientCount() {
        return clientCount;
    }

    public void setClientCount(Integer clientCount) {
        this.clientCount = clientCount;
    }

    public Long getPlacesCount() {
        return placesCount;
    }

    public void setPlacesCount(Long placesCount) {
        this.placesCount = placesCount;
    }

    public String getUserPublicName() {
        return userPublicName;
    }

    public void setUserPublicName(String userPublicName) {
        this.userPublicName = userPublicName;
    }
}