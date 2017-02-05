package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Tags;
import com.vostrik.db.beans.entity.Tour;
import com.vostrik.db.beans.item.TagItem;
import com.vostrik.db.beans.item.TagItemLink;
import com.vostrik.db.dao.BaseOpersDao;
import com.vostrik.db.dao.TourDao;
import com.vostrik.model.CityMapPoint;
import com.vostrik.model.TourPoint;
import com.vostrik.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * User: User
 * Date: 06.01.16
 * Time: 9:49
 */
@Service
public class MapServiceImpl implements MapService {

    @Autowired
    private BaseOpersDao baseOpersDao;

    @Autowired
    private TourDao tourDao;

    @Override
    @Transactional(readOnly = true)
    public List<City> getTourCities(){
        List<CityMapPoint> cityMapPoints = getCityPoints();
       return tourDao.getTourCities();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CityMapPoint> getCityPoints(){
        List<CityMapPoint> result= new ArrayList<CityMapPoint>();
        List<City> cityList = tourDao.getTourCities();
        for(City city : cityList){
            CityMapPoint cityMapPoint = new CityMapPoint();
            cityMapPoint.setCity(city);

            List<TourPoint> tourPointList = new ArrayList<TourPoint>();
            //для этого города получить список всех туров с гидами
            for(Tour tour : tourDao.getTourActiveList(city.getId(), 1L)){
                TourPoint tourPoint = new TourPoint();
                tourPoint.setTour(tour);
                tourPoint.setUser(tourDao.getTourUser(tour.getTourId()));
                tourPointList.add(tourPoint);
            }

            cityMapPoint.setTourPointList(tourPointList);
            result.add(cityMapPoint);
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagItem> getTagsCloud(){
        return  baseOpersDao.getTagsCloud();
    }

    @Override
    @Transactional(readOnly = true)
    public Tags getTag(Long tagId){
        return  baseOpersDao.getTag(tagId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagItemLink> getTagLink(Long tagId){
        return  baseOpersDao.getTagLink(tagId);
    }
}
