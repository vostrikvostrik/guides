package com.vostrik.controllers.settings;

import com.vostrik.db.beans.entity.User;
import com.vostrik.model.ManageClient;
import com.vostrik.service.TourService;
import com.vostrik.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
 * Date: 24.10.15
 * Time: 11:04
 */
@RequestMapping("/settings/manage/")
@Controller
public class ManageController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    TourService tourService;

    @Autowired
    UserService userService;



    @RequestMapping(value = "clients", method = RequestMethod.GET)
    public String clients(Map<String, Object> map) throws IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("clientList", userService.getClientList());
        ManageClient manageClient = new ManageClient();
        manageClient.setClientName("clientName");
        map.put("manageClient", manageClient);
        map.put("client",new User());
        logger.debug("clients method");
        return "manage.clients";
    }

    /*
    @RequestMapping(value = "clients", method = RequestMethod.POST)
   // @SuppressWarnings("serial")
    public String createClient(@Valid User client
    //, Map<String, Object> map
    , BindingResult errors) {
        if (!errors.hasErrors()) {
            Authentication authentication =
                    SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null) {

              //  map.put("currentUser", authentication.getPrincipal());
            }
            logger.info("create user = " + client);

            User user = userService.createUser(client);
           // map.put("client",user);
          //  return user;
            return "manage.clients";

        } else
        {
            logger.info("create result.getAllErrors() = " + errors.getAllErrors());
            for (Object object : errors.getAllErrors()) {
                if(object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                   // String message = messageSource.getMessage(fieldError, null);
                    logger.info("create error = " + fieldError.getDefaultMessage());
                }
            }

          //  map.put("client", new User());
         //   return errors;
            return "manage.clients";
        }

    }  */



    @RequestMapping(value = "/guides", method = RequestMethod.GET)
    public String guides(Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        map.put("guideList", userService.getGuideList());

        return "manage.guides";
    }

    @RequestMapping(value = "/tours", method = RequestMethod.GET)
    public String tours(@RequestParam(value = "tour_active", required = false) Integer tour_active,
                        @RequestParam(value = "tourtype", required = false) Integer tourtype, Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        if (tour_active != null && tourtype != null)
            map.put("tourList", tourService.getTourItemList(tourtype, tour_active));
        else if (tour_active != null && tourtype == null)
            map.put("tourList", tourService.getTourItemListByLifeCircleType(tour_active));
        else if (tour_active == null && tourtype != null)
            map.put("tourList", tourService.getTourItemActiveList(tourtype));
        else
            map.put("tourList", tourService.getTourItemList());


        return "manage.tours";
    }

    @RequestMapping(value = "manage", method = RequestMethod.GET)
    public String manage(Map<String, Object> map) throws IOException {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }

        return "manage.manage";
    }
}
