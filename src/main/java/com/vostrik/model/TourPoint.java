package com.vostrik.model;

import com.vostrik.db.beans.entity.Tour;
import com.vostrik.db.beans.entity.User;

import java.io.Serializable;

/**
 * User: User
 * Date: 11.01.16
 * Time: 13:34
 */
public class TourPoint implements Serializable {

    Tour tour;
    User user; //тип пользователя - гид

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
