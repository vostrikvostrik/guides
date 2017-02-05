package com.vostrik.controllers.settings;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.Currency;
import com.vostrik.db.beans.entity.TourType;
import com.vostrik.db.dao.BaseDao;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * User: User
 * Date: 25.10.15
 * Time: 11:18
 */
@RequestMapping("/settings/catalog")
@Controller
public class CatalogController {

    @Resource
    private BaseDao baseDao;

    @RequestMapping(value = "/countries", method = { RequestMethod.GET, RequestMethod.POST})
    public String manageCountries(@ModelAttribute(value = "manageCountries") Country manageCountry,
                                  Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("countryList", baseDao.getList(Country.class));


        return "catalog.countries";
    }

    @RequestMapping(value = "/cities", method = { RequestMethod.GET, RequestMethod.POST})
    public String manageCities(@ModelAttribute(value = "manageCities") City manageCity, Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("cityList", baseDao.getList(City.class));

        return "catalog.cities";
    }

    @RequestMapping(value = "/tourtypes", method = { RequestMethod.GET, RequestMethod.POST})
    public String manageTourTypes(@ModelAttribute(value = "manageTourTypes") TourType manageTourType, Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("tourtypeList", baseDao.getList(TourType.class));

        return "catalog.tourtypes";
    }

    @RequestMapping(value = "/currencies", method = { RequestMethod.GET, RequestMethod.POST})
    public String manageCurrencies(@ModelAttribute(value = "manageCurrencies") Currency manageCurrency, Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("currencyList", baseDao.getList(Currency.class));
        return "catalog.currencies";
    }
}
