package com.vostrik.controllers.rest;

import com.vostrik.db.beans.entity.User;
import com.vostrik.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: User
 * Date: 07.01.17
 * Time: 14:05
 */
@RestController
public class UserRestController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List getClients(Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        map.put("client",new User());
        return userService.getClientList();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getClient(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return new ResponseEntity<User>(userService.readUser(id), HttpStatus.OK);
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Expected!")
    @SuppressWarnings("serial")
    private static class ExpectedException extends RuntimeException {

    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public User createClient(@Valid @RequestBody User client, BindingResult errors) {
        if (!errors.hasErrors()) {
            User user = userService.createUser(client);
            return user;
        } else
        {
            logger.info("create result.getAllErrors() = " + errors.getAllErrors());
            Map<String,String> userErrors=new HashMap<String,String>();
            for (Object object : errors.getAllErrors()) {
                logger.info(" error  class = " + object.getClass());
                if(object instanceof FieldError ) {
                    FieldError fieldError = (FieldError) object;
                    String message = messageSource.getMessage(fieldError, null);
                    logger.debug("create error = " + message);
                    userErrors.put(fieldError.getField(),message);
                }
                else if(object instanceof ObjectError) {
                    ObjectError fieldError = (ObjectError) object;
                    String message = messageSource.getMessage(fieldError, null);
                    logger.debug("create error = " + message);
                    userErrors.put(fieldError.getObjectName(),message);
                }
            }
            User user = new User();
            user.setErrors(userErrors);
            return user;
        }

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public Long deleteClient(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        logger.warn("delete userid = " + id);
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public User updateClient(@PathVariable(value = "id") Long id, @Valid @RequestBody User client, BindingResult errors) {
        if (!errors.hasErrors()) {
            return userService.updateUser(id, client);
        }
        else
        {
            logger.info("create result.getAllErrors() = " + errors.getAllErrors());
            Map<String,String> userErrors=new HashMap<String,String>();
            for (Object object : errors.getAllErrors()) {
                logger.info(" error  class = " + object.getClass());
                if(object instanceof FieldError ) {
                    FieldError fieldError = (FieldError) object;
                    String message = messageSource.getMessage(fieldError, null);
                    logger.debug("create error = " + message);
                    userErrors.put(fieldError.getField(),message);
                }
                else if(object instanceof ObjectError) {
                    ObjectError fieldError = (ObjectError) object;
                    String message = messageSource.getMessage(fieldError, null);
                    logger.debug("create error = " + message);
                    userErrors.put(fieldError.getObjectName(),message);
                }
            }
            User user = new User();
            user.setErrors(userErrors);
            return user;
        }
    }

    // guides

    @RequestMapping(value = "/guides", method = RequestMethod.GET)
    public List getGuides(Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return userService.getGuideList();
    }

    @RequestMapping(value = "/guides/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getGuide(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return new ResponseEntity<User>(userService.readUser(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/guides", method = RequestMethod.POST)
    public User createGuides(@Valid @RequestBody User guide, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return userService.createUser(guide);
    }

    @RequestMapping(value = "/guides/{id}", method = RequestMethod.DELETE)
    public Long deleteGuide(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return userService.deleteUser(id);
    }

    @RequestMapping(value = "/guides/{id}", method = RequestMethod.PUT)
    public User updateGuide(@RequestParam(value = "id", required = true) Long id, @Valid @RequestParam(value = "guide", required = true) User guide, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return userService.updateUser(id, guide);
    }

}
