package com.vostrik.db.beans.entity;

import javax.persistence.*;

/**
 * User: User
 * Date: 25.10.15
 * Time: 22:04
 */
@Entity
@Table(name="VOSTRIK_CURRENCY")
public class Currency {
    @Id
    @Column(name = "currency_id")
    @GeneratedValue
    private Long currencyId;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "currency_name")
    private String currencyName;

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}
