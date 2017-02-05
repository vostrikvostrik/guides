package com.vostrik.controllers.rest;

/**
 * User: User
 * Date: 11.01.16
 * Time: 16:24
 */

import com.vostrik.db.beans.entity.Tour;
import com.vostrik.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class TourRestController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TourService tourService;


    @RequestMapping(value="/tours", method = RequestMethod.GET)
    public List getTours( Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return tourService.getTourList();
    }

    @RequestMapping(value="/tours/{id}", method = RequestMethod.GET)
    public ResponseEntity<Tour> getTour(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return new ResponseEntity<Tour>( tourService.readTour(id), HttpStatus.OK);
    }

    @RequestMapping(value="/tours", method = RequestMethod.POST)
    public Tour createTour(@PathVariable("tour") Tour tour, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return tourService.createTour(tour);
    }

    @RequestMapping(value="/tours/{id}", method = RequestMethod.DELETE)
    public Long deleteTour(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return tourService.deleteTour(id);
    }

    @RequestMapping(value="/tours/{id}", method = RequestMethod.PUT)
    public Tour updateTour(@RequestParam(value="id", required=true) Long id, @RequestParam(value="tour", required=true) Tour tour, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return tourService.updateTour(id, tour);
    }

}
