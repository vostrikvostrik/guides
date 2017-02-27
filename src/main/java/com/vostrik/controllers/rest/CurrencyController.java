package com.vostrik.controllers.rest;

import com.vostrik.db.beans.entity.Currency;
import com.vostrik.service.CurrencyService;
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

/**
 * User: User
 * Date: 26.02.17
 * Time: 21:52
 */
@RestController
public class CurrencyController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CurrencyService currencyService;


    @RequestMapping(value="/currencies", method = RequestMethod.GET)
    public List getCurrencies( Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return currencyService.getCurrencyList();
    }

    @RequestMapping(value="/currencies/{id}", method = RequestMethod.GET)
    public ResponseEntity<Currency> getCurrency(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return new ResponseEntity<Currency>( currencyService.readCurrency(id), HttpStatus.OK);
    }

    @RequestMapping(value="/currencies", method = RequestMethod.POST)
    public Currency createCurrency(@PathVariable("currency") Currency currency, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return currencyService.createCurrency(currency);
    }

    @RequestMapping(value="/currencies/{id}", method = RequestMethod.DELETE)
    public Long deleteCurrency(@PathVariable Long id, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return currencyService.deleteCurrency(id);
    }

    @RequestMapping(value="/currencies/{id}", method = RequestMethod.PUT)
    public Currency updateCurrency(@RequestParam(value="id", required=true) Long id, @RequestParam(value="currency", required=true) Currency currency, Map<String, Object> map) {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {

            map.put("currentUser", authentication.getPrincipal());
        }
        return currencyService.updateCurrency(id, currency);
    }

}
