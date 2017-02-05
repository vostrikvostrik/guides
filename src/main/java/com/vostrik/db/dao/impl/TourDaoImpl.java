package com.vostrik.db.dao.impl;

import com.vostrik.db.beans.entity.*;
import com.vostrik.db.beans.item.TourItem;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.db.dao.TourDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * User: User
 * Date: 25.10.15
 * Time: 9:55
 */
@Repository
public class TourDaoImpl implements TourDao{

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private BaseDao baseDao;

    @Override
    public List<Tour> getTourList() {
        return baseDao.getList(Tour.class);
    }

    @Override
    public List<TourType> getTourTypes() {
        return baseDao.getList(TourType.class);
    }

    @Override
    public List<Tour> getTourActiveList(long cityId, long activeType) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourActive", activeType));
        detchCriteria.add(Restrictions.eq("tourCity", cityId));
        return baseDao.findByCriteria(detchCriteria);
    }


    @Override
    public List<Tour> getTourList(int cityId) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourCity", cityId));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<TourItem> getTourItemList() {
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "\tFROM \n" +
                "\tTour vt,\n" +
                "\tCity vcity,\n" +
                "\tCountry vcountry,\n" +
                "\tUser vguide,\n" +
                "\tTourType vtype,\n" +
                "\tCurrency vcurrency\n" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency", TourItem.class)
                    .getResultList();
    }

    @Override
    public List<Tour> getTourList(long guideId) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourGuide", guideId));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<Tour> getTourActiveList(long activeType) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourActive", activeType));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<TourItem> getTourItemActiveList(long activeType) {
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "\tFROM \n" +
                "\tTour vt,\n" +
                "\tCity vcity,\n" +
                "\tCountry vcountry,\n" +
                "\tUser vguide,\n" +
                "\tTourType vtype,\n" +
                "\tCurrency vcurrency\n" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency and  vt.tourActive = :activeType", TourItem.class)
                .setParameter("activeType", activeType)
                .getResultList();
    }

    @Override
    public List<Tour> getTourListByLifeCircleType(long tourLifeCircleType) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourLifeCircle", tourLifeCircleType));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<TourItem> getTourItemListByLifeCircleType(long tourLifeCircleType) {
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "\tFROM \n" +
                "\tTour vt,\n" +
                "\tCity vcity,\n" +
                "\tCountry vcountry,\n" +
                "\tUser vguide,\n" +
                "\tTourType vtype,\n" +
                "\tCurrency vcurrency\n" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency and  vt.tourLifeCircle = :tourLifeCircleType", TourItem.class)
                .setParameter("tourLifeCircleType", tourLifeCircleType)
                .getResultList();
    }

    @Override
    public List<TourItem> searchTourItem(Long country, Long city, Long tourType, Date dateStart, Date dateEnd, Long guide, Float priceMin, Float priceMax) {

        logger.debug("countryId =" + country);
        logger.debug("dateStart =" + dateStart);
        logger.debug("dateEnd =" + dateEnd);
        logger.debug("priceMin =" + priceMin);
        logger.debug("priceMax =" + priceMax);
        logger.debug("tourType =" + tourType);
        logger.debug("guideId =" + guide);
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                " FROM \n" +
                " Tour vt,\n" +
                " City vcity,\n" +
                " Country vcountry,\n" +
                " User vguide,\n" +
                " TourType vtype,\n" +
                " Currency vcurrency\n" +
                " WHERE \n" +
                " vcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                " AND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                " AND vcurrency.currencyId = vt.tourCurrency and "+
                " vcountry.id = :countryId "+
            //    " and vcity.id = :cityId  " +
                " and vt.tourStartDate between :dateStart and :dateEnd " +
                " and vt.tourPrice between :priceMin and :priceMax " +
                " and vt.tourType = :tourType"+
                " and vt.tourGuide = :guideId", TourItem.class)
                .setParameter("countryId", country)
            //    .setParameter("cityId", city)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .setParameter("priceMin", priceMin)
                .setParameter("priceMax", priceMax)
                .setParameter("tourType", tourType)
                .setParameter("guideId", guide)
                .getResultList();

    }

    @Override
    public List<TourItem> searchTourItem(String country, String city, String tourType, Date dateStart, Date dateEnd, String guide, Float priceMin, Float priceMax) {
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "\tFROM \n" +
                "\tTour vt,\n" +
                "\tCity vcity,\n" +
                "\tCountry vcountry,\n" +
                "\tUser vguide,\n" +
                "\tTourType vtype,\n" +
                "\tCurrency vcurrency\n" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency and  vcountry.countryName = :countryName and vcity.cityName = :cityName  " +
                " and vt.tourStartDate between :dateStart and :dateEnd " +
                " and vt.tourPrice between :priceMin and :priceMax " +
                " and vguide.userPublicName = :userPublicName", TourItem.class)
                .setParameter("countryName", country)
                .setParameter("cityName", city)
                .setParameter("dateStart", dateStart)
                .setParameter("dateEnd", dateEnd)
                .setParameter("priceMin", priceMin)
                .setParameter("priceMax", priceMax)
                .setParameter("userPublicName", guide)
                .getResultList();
    }


    @Override
    public List<Tour> getTourList(long activeType, long tourLifeCircleType) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Tour.class);
        detchCriteria.add(Restrictions.eq("tourLifeCircle", tourLifeCircleType));
        detchCriteria.add(Restrictions.eq("tourActive", activeType));
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<TourItem> getTourItemList(long activeType, long tourLifeCircleType) {
        return em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "FROM \n" +
                "Tour vt,\n" +
                "City vcity,\n" +
                "Country vcountry,\n" +
                "User vguide,\n" +
                "TourType vtype," +
                "Currency vcurrency" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency and  vt.tourLifeCircle = :tourLifeCircleType and vt.tourActive = :activeType",TourItem.class)
                .setParameter("tourLifeCircleType", tourLifeCircleType)
                .setParameter("activeType", activeType).getResultList();

    }

    @Override
    ///Getting all cities names where the active tours presents
    public List<City> getTourCities(){
        return em.createQuery("select DISTINCT new com.vostrik.db.beans.entity.City(c.id, c.cityName, c.country, c.region, c.latitude, c.longitude) from com.vostrik.db.beans.entity.City c, com.vostrik.db.beans.entity.Tour t where t.tourCity = c.id and t.tourActive = 1", City.class)
        .getResultList();
    }

    @Override
    public User getTourUser(long tourId){
         List<User> userList= em.createQuery("select new com.vostrik.db.beans.entity.User(u.userId, u.userName , u.userDescribe) from User u, Tour t where t.tourGuide = u.userId and t.tourId = :tourId", User.class)
                .setParameter("tourId", tourId).getResultList();
        return userList.size() > 0 ? userList.get(0) : null;
    }

    @Override
    public TourItem getTour(long tourId) {
        List<TourItem> tourItemList = em.createQuery("" +
                "SELECT new com.vostrik.db.beans.item.TourItem(vt.tourId," +
                "vt.tourName , " +
                "vt.tourDescribe , " +
                "vt.tourStartDate , " +
                "vt.tourEndDate , " +
                "vt.tourPrice , " +
                "vt.tourCurrency ," +
                "vcurrency.currencyName," +
                "vt.tourActive, " +
                "vt.tourGuide ," +
                "vguide.userDescribe , " +
                "vguide.userEmail , " +
                "vcountry.countryName , " +
                "vcity.cityName , " +
                "vtype.typeName ," +
                "vt.tourPlacesCount, vguide.userPublicName)" +
                "\tFROM \n" +
                "\tTour vt,\n" +
                "\tCity vcity,\n" +
                "\tCountry vcountry,\n" +
                "\tUser vguide,\n" +
                "\tTourType vtype,\n" +
                "\tCurrency vcurrency\n" +
                "\tWHERE \n" +
                "\tvcity.id = vt.tourCity AND vcountry.id = vt.tourCountry\n" +
                "\tAND vt.tourType = vtype.typeId AND vt.tourGuide = vguide.userId\n" +
                "\tAND vcurrency.currencyId = vt.tourCurrency and  vt.tourId = :tourId", TourItem.class)
                .setParameter("tourId", tourId)
                .getResultList();
        return tourItemList.size() > 0 ? tourItemList.get(0) : null;
    }

    @Override
    public Tour createTour(Tour tour) {
        return baseDao.save(tour);
    }

    @Override
    public Tour readTour(long tourId) {
        return baseDao.loadById(Tour.class, tourId);
    }

    @Override
    public Tour updateTour(long tourId, Tour tour) {
        return baseDao.save(tour);
    }

    @Override
    public Long deleteTour(Long tourId) {
        baseDao.delete(Tour.class, tourId);
        return tourId;
    }


}
