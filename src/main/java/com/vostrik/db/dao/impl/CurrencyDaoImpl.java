package com.vostrik.db.dao.impl;

import com.vostrik.db.beans.entity.Currency;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.db.dao.CurrencyDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * User: User
 * Date: 27.02.17
 * Time: 6:30
 */
@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private BaseDao baseDao;

    @Override
    public Currency createCurrency(Currency currency) {
        return baseDao.save(currency);
    }

    @Override
    public Currency readCurrency(long currencyId) {
        return baseDao.loadById(Currency.class, currencyId);
    }

    @Override
    public Currency updateCurrency(long currencyId, Currency currency) {
        return baseDao.save(currency);
    }

    @Override
    public Long deleteCurrency(Long currencyId) {
        baseDao.delete(Currency.class, currencyId);
        return currencyId;
    }

    @Override
    public List<Currency> getCurrencyList() {
        return baseDao.getList(Currency.class);
    }
}
