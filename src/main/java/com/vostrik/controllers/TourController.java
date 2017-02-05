package com.vostrik.controllers;

import com.vostrik.service.TourService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Map;

/**
 * User: User
 * Date: 06.01.17
 * Time: 18:40
 */
@Controller
public class TourController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TourService tourService;

    @RequestMapping(value="/tours/tourview", method = RequestMethod.GET)
    public String tourView(@RequestParam(value = "tourId") Long tourId, Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        map.put("tourItem",tourService.getTourItem(tourId));
        return "tourview";
    }

}
