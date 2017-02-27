package com.vostrik.service.impl;

import com.vostrik.db.beans.entity.Currency;
import com.vostrik.db.dao.CurrencyDao;
import com.vostrik.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: User
 * Date: 26.02.17
 * Time: 21:55
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDao currencyDao;

    @Override
    @Transactional(readOnly = false)
    public Currency createCurrency(Currency currency) {
        return currencyDao.createCurrency(currency);
    }

    @Override
    @Transactional
    public Currency readCurrency(long currencyId) {
        return currencyDao.readCurrency(currencyId);
    }

    @Override
    @Transactional(readOnly = false)
    public Currency updateCurrency(long currencyId, Currency currency) {
        return currencyDao.updateCurrency(currencyId,currency);
    }

    @Override
    @Transactional(readOnly = false)
    public Long deleteCurrency(Long currencyId) {
        return currencyDao.deleteCurrency(currencyId);
    }

    @Override
    @Transactional
    public List<Currency> getCurrencyList() {
        return currencyDao.getCurrencyList();
    }
}
