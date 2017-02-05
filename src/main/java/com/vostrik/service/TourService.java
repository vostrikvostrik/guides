package com.vostrik.service;

import com.vostrik.db.beans.entity.Tour;
import com.vostrik.db.beans.entity.TourType;
import com.vostrik.db.beans.item.TourItem;

import java.util.Date;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 10:04
 */
public interface TourService {
    //-------------CRUD
    Tour createTour(Tour tour);//create
    Tour readTour(long tourId);//read
    Tour updateTour(long tourId, Tour tour); //update
    Long deleteTour(Long tourId); //delete
    List<Tour> getTourList(); //get list

    List<TourType> getTourTypeList();
    List<TourItem> getTourItemList();
    List<Tour> getTourList(long guideId);
    List<Tour> getTourActiveList(long activeType);
    List<TourItem> getTourItemActiveList(long activeType);
    List<Tour> getTourListByLifeCircleType(long tourLifeCircleType);
    List<TourItem> getTourItemListByLifeCircleType(long tourLifeCircleType);
    List<Tour> getTourList(long activeType, long tourLifeCircleType);
    List<TourItem> getTourItemList(long activeType, long tourLifeCircleType);
    List<TourItem> searchTourItem(Long country, Long city, Long tourType, Date dateStart, Date dateEnd, Long guide, Float priceMin, Float priceMax);
    List<TourItem> searchTourItem(String country, String city, String tourType, Date dateStart, Date dateEnd, String guide, Float priceMin, Float priceMax);

    TourItem getTourItem(long tourId);

}
