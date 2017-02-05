package com.vostrik.controllers.settings;

import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.dao.BaseDao;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * User: User
 * Date: 01.11.16
 * Time: 19:09
 */
@RequestMapping("/settings/catalog")
@RestController
public class CountryController {

    @Resource
    private BaseDao baseDao;

    @RequestMapping(value = "/countries", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Country> getCountries() {
        List<Country> listOfCountries = baseDao.getList(Country.class);
        return listOfCountries;
    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Country getCountryById(@PathVariable Long id) {
        return baseDao.loadById(Country.class, id);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.POST, headers = "Accept=application/json")
    public Country addCountry(@RequestBody Country country) {
        return baseDao.save(country);
    }

    @RequestMapping(value = "/countries", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Country updateCountry(@RequestBody Country country) {
        return baseDao.save(country);

    }

    @RequestMapping(value = "/country/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteCountry(@PathVariable("id") Long id) {
        baseDao.delete(Country.class, id);
    }
}
