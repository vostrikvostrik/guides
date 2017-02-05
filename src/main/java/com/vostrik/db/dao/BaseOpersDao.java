package com.vostrik.db.dao;


import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.Tags;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.entity.UserType;
import com.vostrik.db.beans.item.TagItem;
import com.vostrik.db.beans.item.TagItemLink;

import java.util.List;

/**
 * Created by EVostrikova on 09.07.15.
 */
public interface BaseOpersDao {


    List<TagItem> getTagsCloud();

    List<TagItemLink> getTagLink(Long tagId);

    Tags getTag(Long tagId);

    List<UserType> getUserTypeList();

    List<User> getUserList(int userType);

    List<Country> getCountries();

    Integer save(User user);
}
