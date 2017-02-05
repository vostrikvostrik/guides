package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.service.SearchService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: User
 * Date: 02.01.17
 * Time: 11:01
 */
@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    BaseDao baseDao;

    @Override
    public List<Country> getCountries(String country) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(Country.class);
//        detchCriteria.add(Restrictions.ilike("countryName", country.toLowerCase()+"%"));//case-insensitive
     /*   if(country.equals("") || country.equals(null)){
            detchCriteria.add(
                    Restrictions.or(Restrictions.ilike("countryName", country.toLowerCase()+"%"),
                            Restrictions.eqOrIsNull("countryName","")));
        }
        else    */
            detchCriteria.add(Restrictions.ilike("countryName",country.toLowerCase()+"%"));

        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<City> getCities(String city) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(City.class);
//        detchCriteria.add(Restrictions.ilike("cityName",city.toLowerCase()+"%"));//case-insensitive
       /* if(city.equals("") || city.equals(null)){
            detchCriteria.add(Restrictions.or(Restrictions.ilike("cityName", city.toLowerCase()+"%"),
                            Restrictions.eqOrIsNull("cityName","")));
        }
        else    */
            detchCriteria.add(Restrictions.ilike("cityName",city.toLowerCase()+"%"));

        return baseDao.findByCriteria(detchCriteria);

    }

    @Override
    public List<City> getCities(Long countryId) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(City.class);
        detchCriteria.add(Restrictions.eq("country",countryId));//case-insensitive
        return baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<User> getGuides(String guide) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(User.class);
        detchCriteria.add(Restrictions.eq("userIsGuide", new Integer(1)));
     /*   if(guide.equals("") || guide.equals(null)){
            detchCriteria.add(
            Restrictions.or(Restrictions.ilike("userPublicName",guide.toLowerCase()+"%"),
                    Restrictions.eqOrIsNull("userPublicName",null)));
        }
        else */
         detchCriteria.add(Restrictions.ilike("userPublicName",guide.toLowerCase()+"%"));
        return  baseDao.findByCriteria(detchCriteria);
    }
}
