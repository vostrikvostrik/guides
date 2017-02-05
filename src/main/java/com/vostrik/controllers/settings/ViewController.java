package com.vostrik.controllers.settings;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

/**
 * User: User
 * Date: 24.10.15
 * Time: 11:04
 */
@RequestMapping("/settings/view/")
@Controller
public class ViewController {

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET)
    public String mainPage(Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return "view.mainPage";
    }

    @RequestMapping(value = "/clientPage", method = RequestMethod.GET)
    public String clientPage(Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return "view.clientPage";
    }
}
