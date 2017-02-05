package com.vostrik.service;

import com.vostrik.db.beans.entity.City;
import com.vostrik.db.beans.entity.Tags;
import com.vostrik.db.beans.item.TagItem;
import com.vostrik.db.beans.item.TagItemLink;
import com.vostrik.model.CityMapPoint;

import java.util.List;

/**
 * User: User
 * Date: 06.01.16
 * Time: 9:48
 */

public interface MapService {

    List<City> getTourCities();

    Tags getTag(Long tagId);

    List<CityMapPoint> getCityPoints();

    List<TagItem> getTagsCloud();

    List<TagItemLink> getTagLink(Long tagId);
}
