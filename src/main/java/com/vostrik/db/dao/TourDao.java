package com.vostrik.db.dao;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Tour;
import com.vostrik.db.beans.entity.TourType;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.item.TourItem;

import java.util.Date;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 9:55
 */
public interface TourDao {

    List<TourType> getTourTypes();
    List<TourItem> getTourItemList();
    List<Tour> getTourList(long guideId);
    List<Tour> getTourActiveList(long activeType);
    List<TourItem> getTourItemActiveList(long activeType);
    List<Tour> getTourListByLifeCircleType(long tourLifeCircleType);
    List<Tour> getTourList(long activeType, long tourLifeCircleType);
    List<TourItem> getTourItemList(long activeType, long tourLifeCircleType);
    List<TourItem> getTourItemListByLifeCircleType(long tourLifeCircleType);
    List<TourItem> searchTourItem(Long country, Long city, Long tourType, Date dateStart, Date dateEnd, Long guide, Float priceMin, Float priceMax);
    List<TourItem> searchTourItem(String country, String city, String tourType, Date dateStart, Date dateEnd, String guide, Float priceMin, Float priceMax);

    List<Tour> getTourList(int cityId);

    List<Tour> getTourActiveList(long cityId, long activeType);

    ///Getting all cities names where the active tours presents
    List<City> getTourCities();

    User getTourUser(long tourId);

    TourItem getTour(long tourId);

    //-------------CRUD
    Tour createTour(Tour tour);//create
    Tour readTour(long tourId);//read
    Tour updateTour(long tourId, Tour tour); //update
    Long deleteTour(Long tourId); //delete
    List<Tour> getTourList(); //get list

}
