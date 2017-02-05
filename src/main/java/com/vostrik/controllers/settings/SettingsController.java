package com.vostrik.controllers.settings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

/**
 * User: User
 * Date: 24.10.15
 * Time: 11:01
 */
@RequestMapping("/settings/")
@Controller
public class SettingsController {


    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String manage(Map<String, Object> map) throws IOException {

        return "manage.clients";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(Map<String, Object> map) throws IOException {

        return "view.mainPage";
    }



}
