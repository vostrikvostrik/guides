package com.vostrik.db.dao;

import com.vostrik.db.beans.entity.Currency;

import java.util.List;

/**
 * User: User
 * Date: 27.02.17
 * Time: 6:28
 */
public interface CurrencyDao {

    //-------------CRUD
    Currency createCurrency(Currency currency);//create
    Currency readCurrency(long currencyId);//read
    Currency updateCurrency(long currencyId, Currency currency); //update
    Long deleteCurrency(Long currencyId); //delete
    List<Currency> getCurrencyList(); //get list
}
