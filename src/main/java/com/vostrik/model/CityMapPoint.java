package com.vostrik.model;

import com.vostrik.db.beans.entity.City;

import java.io.Serializable;
import java.util.List;

/**
 * User: User
 * Date: 11.01.16
 * Time: 13:33
 */
public class CityMapPoint implements Serializable {

    private City city;
    private List<TourPoint> tourPointList;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<TourPoint> getTourPointList() {
        return tourPointList;
    }

    public void setTourPointList(List<TourPoint> tourPointList) {
        this.tourPointList = tourPointList;
    }
}
