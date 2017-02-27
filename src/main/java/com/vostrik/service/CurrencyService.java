package com.vostrik.service;

import com.vostrik.db.beans.entity.Currency;

import java.util.List;

/**
 * User: User
 * Date: 26.02.17
 * Time: 21:54
 */
public interface CurrencyService {
    //-------------CRUD
    Currency createCurrency(Currency currency);//create
    Currency readCurrency(long currencyId);//read
    Currency updateCurrency(long currencyId, Currency currency); //update
    Long deleteCurrency(Long currencyId); //delete
    List<Currency> getCurrencyList(); //get list
}
