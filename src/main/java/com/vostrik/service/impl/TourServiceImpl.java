package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.Tour;
import com.vostrik.db.beans.entity.TourType;
import com.vostrik.db.beans.item.TourItem;
import com.vostrik.db.dao.TourDao;
import com.vostrik.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 10:04
 */
@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourDao tourDao;

    @Override
    @Transactional(readOnly = false)
    public Tour createTour(Tour tour) {
        return tourDao.createTour(tour);
    }

    @Override
    @Transactional
    public Tour readTour(long tourId) {
        return tourDao.readTour(tourId);
    }

    @Override
    @Transactional(readOnly = false)
    public Tour updateTour(long tourId, Tour tour) {
        return tourDao.updateTour(tourId, tour);
    }

    @Override
    @Transactional(readOnly = false)
    public Long deleteTour(Long tourId) {
        return tourDao.deleteTour(tourId);
    }

    @Override
    @Transactional
    public List<Tour> getTourList() {
        return tourDao.getTourList();
    }

    @Override
    @Transactional
    public List<TourItem> getTourItemList() {
        return tourDao.getTourItemList();
    }

    @Override
    @Transactional
    public List<Tour> getTourList(long guideId) {
        return tourDao.getTourList(guideId);
    }

    @Override
    @Transactional
    public List<TourType> getTourTypeList() {
        return tourDao.getTourTypes();
    }

    @Override
    @Transactional
    public List<Tour> getTourListByLifeCircleType(long tourLifeCircleType) {
        return tourDao.getTourListByLifeCircleType(tourLifeCircleType);
    }

    @Override
    @Transactional
    public List<TourItem> getTourItemListByLifeCircleType(long tourLifeCircleType) {
        return tourDao.getTourItemListByLifeCircleType(tourLifeCircleType);
    }

    @Override
    @Transactional
    public List<Tour> getTourActiveList(long activeType) {
        return  tourDao.getTourActiveList(activeType);
    }

    @Override
    @Transactional
    public List<TourItem> getTourItemActiveList(long activeType) {
        return tourDao.getTourItemActiveList(activeType);
    }

    @Override
    @Transactional
    public List<Tour> getTourList(long activeType, long tourLifeCircleType) {
        return  tourDao.getTourList(activeType,tourLifeCircleType);
    }

    @Override
    @Transactional
    public List<TourItem> getTourItemList(long activeType, long tourLifeCircleType) {
        return tourDao.getTourItemList(activeType,tourLifeCircleType);
    }

    @Override
    public List<TourItem> searchTourItem(Long country, Long city, Long tourType, Date dateStart, Date dateEnd, Long guide, Float priceMin, Float priceMax) {
        return tourDao.searchTourItem( country,  city,  tourType,  dateStart,  dateEnd,  guide,  priceMin,  priceMax);

    }

    @Override
    @Transactional
    public List<TourItem> searchTourItem(String country, String city, String tourType, Date dateStart, Date dateEnd, String guide, Float priceMin, Float priceMax) {
        return tourDao.searchTourItem( country,  city,  tourType,  dateStart,  dateEnd,  guide,  priceMin,  priceMax);
    }

    @Override
    @Transactional
    public TourItem getTourItem(long tourId) {
        return tourDao.getTour(tourId);
    }


}
