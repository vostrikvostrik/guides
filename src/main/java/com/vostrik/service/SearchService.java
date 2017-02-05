package com.vostrik.service;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.User;

import java.util.List;

/**
 * User: User
 * Date: 02.01.17
 * Time: 11:01
 */
public interface SearchService {
    List<Country> getCountries(String country);
    List<City> getCities(String city);
    List<City> getCities(Long countryId);
    List<User> getGuides(String guide);

}
