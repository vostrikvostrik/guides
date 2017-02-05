package com.vostrik.controllers;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.TourType;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.item.TagItem;
import com.vostrik.db.beans.item.TourItem;
import com.vostrik.model.CityMapPoint;
import com.vostrik.model.ManageClient;
import com.vostrik.service.MapService;
import com.vostrik.service.MemberNoteService;
import com.vostrik.service.SearchService;
import com.vostrik.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by EVostrikova on 10.07.15.
 */

@RequestMapping("/")
@Controller
public class IndexController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MapService mapService;

    @Autowired
    SearchService searchService;

    @Autowired
    TourService tourService;

    @Autowired
    MemberNoteService memberNoteService;

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String printWelcome(Map<String, Object>  map) throws IOException {
       /* Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        } */
        map.put("manageClient", new ManageClient());
        return "index";
    }

    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    @ResponseBody
    public String generateShort(@RequestParam(value = "noteText") String noteText, HttpServletRequest request, ModelMap model) throws IOException {


        return "noteText = " + noteText;
    }

    @RequestMapping("/")
    public String redirectEmpty() {
        return "redirect:/index";
    }


    @RequestMapping(value = "/getCityPoints", method = RequestMethod.POST)
    @ResponseBody
    public  List<City> getCityPoints(HttpServletRequest request, ModelMap model) throws IOException {
        return mapService.getTourCities();
    }

    @RequestMapping(value = "/getCityMapPoints", method = RequestMethod.POST)
    @ResponseBody
    public  List<CityMapPoint> getCityMapPoints(HttpServletRequest request, ModelMap model) throws IOException {
        return mapService.getCityPoints();
    }

    @RequestMapping(value = "/getCityPoints", method = RequestMethod.GET)
    public @ResponseBody List<City> getCityPointsGet(HttpServletRequest request, ModelMap model) throws IOException {
        return mapService.getTourCities();
    }

    @RequestMapping(value = "/getTagsCloud", method = RequestMethod.POST)
    public @ResponseBody List<TagItem> getTagsCloud(HttpServletRequest request, ModelMap model) throws IOException {
        return mapService.getTagsCloud();
    }

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public String tourView(@RequestParam(value = "id") Long tagId, Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("tagItem",mapService.getTag(tagId));
        map.put("resultList",mapService.getTagLink(tagId));
        return "search";
    }


    @RequestMapping(value = "/search/country", method = RequestMethod.POST)
    public @ResponseBody List<Country> getCountriesForSearch(@RequestParam(value="name", required=true)  String name) throws IOException {
        return  searchService.getCountries(name);
    }

    @RequestMapping(value = "/search/city", method = RequestMethod.POST)
    public @ResponseBody List<City> getCitiesForSearch(@RequestParam(value="name", required=true)  String name) throws IOException {
        return  searchService.getCities(name);
       // return null;
    }

    @RequestMapping(value = "/search/city/country", method = RequestMethod.POST)
    public @ResponseBody List<City> getCitiesForSearch(@RequestParam(value="countryId", required=true)  Long countryId) throws IOException {
        return  searchService.getCities(countryId);
    }

    @RequestMapping(value = "/search/quide", method = RequestMethod.POST)
    public @ResponseBody List<User> getGuidesForSearch(@RequestParam(value="name", required=true)  String name) throws IOException {
        return  searchService.getGuides(name);
    }

    @RequestMapping(value = "/search/tourType", method = RequestMethod.POST)
    public @ResponseBody List<TourType> getTourTypesForSearch() throws IOException {
        return  tourService.getTourTypeList();
    }


    @RequestMapping(value = "/search/tours", method = RequestMethod.POST)
    public @ResponseBody List<TourItem> getToursSearch(@RequestParam(value="countrySelect", required=true)  Long countrySelect,
                                                       @RequestParam(value="tourTypeSelect", required=true)  Long tourTypeSelect,
                                                       @RequestParam(value="dateFrom", required=true)  Date dateFrom,
                                                       @RequestParam(value="dateTo", required=true) Date dateTo,
                                                       @RequestParam(value="guideSelect", required=true)  Long guideSelect
                                                       ) throws IOException {
        List<TourItem> tourItemList =  tourService.searchTourItem(countrySelect,0L, tourTypeSelect, dateFrom, dateTo, guideSelect, 0F , 1000000F);

        return tourItemList;
    }
}

