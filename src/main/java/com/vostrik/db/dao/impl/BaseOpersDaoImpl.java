package com.vostrik.db.dao.impl;

import com.vostrik.db.beans.entity.Country;
import com.vostrik.db.beans.entity.Tags;
import com.vostrik.db.beans.entity.User;
import com.vostrik.db.beans.entity.UserType;
import com.vostrik.db.beans.item.TagItem;
import com.vostrik.db.beans.item.TagItemLink;
import com.vostrik.db.dao.BaseDao;
import com.vostrik.db.dao.BaseOpersDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by EVostrikova on 09.07.15.
 */
@Repository
public class BaseOpersDaoImpl implements BaseOpersDao {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private BaseDao baseDao;

    @Override
    public List<UserType> getUserTypeList() {
        return baseDao.getList(UserType.class);
    }

    @Override
    public List<User> getUserList(int userType) {
        DetachedCriteria detchCriteria = DetachedCriteria.forClass(User.class);
        switch (userType) {
            case 1: {//guide
                detchCriteria.add(Restrictions.eq("userIsGuide", new Integer(1)));
                break;
            }
            case 2: {//client
                detchCriteria.add(Restrictions.eq("userIsClient", new Integer(1)));
                break;
            }
            default: {
                break;
            }
        }

        return  baseDao.findByCriteria(detchCriteria);
    }

    @Override
    public List<Country> getCountries() {
        return baseDao.getList(Country.class);
    }

    @Override
    public Integer save(User user){
       baseDao.save(user);
       return 1;
    }

    @Override
    public List<TagItem> getTagsCloud(){
        return em.createQuery("SELECT  new com.vostrik.db.beans.item.TagItem(" +
                " t.tagName,COUNT(tr.tagId)," +
                "   '/search.htm?id=' || CONVERT(tr.tagId,char))" +
                " FROM " +
                " TagRef tr," +
                " Tags  t," +
                " TagContentType  tct" +
                " WHERE tr.tagId = t.id" +
                " AND tct.id = tr.tagContentType" +
                " GROUP BY t.tagName", TagItem.class)
                .getResultList();
    }

    @Override
    public List<TagItemLink> getTagLink(Long tagId){
        return em.createQuery("SELECT  new com.vostrik.db.beans.item.TagItemLink(" +
                "  t.tagName," +
                " CONCAT(tct.typeLink,CONCAT('?id=', CONVERT(tr.tagRef, CHAR))), "+
                "tr.contentShort,tct.typeDescr ) " +
                " FROM " +
                " TagRef tr," +
                " Tags  t," +
                " TagContentType  tct" +
                " WHERE tr.tagId = t.id" +
                " AND tct.id = tr.tagContentType" +
                " AND tr.tagId = :tagId", TagItemLink.class).setParameter("tagId",tagId)
                .getResultList();

        //
    }

    @Override
    public Tags getTag(Long tagId){
        return baseDao.loadById(Tags.class , tagId);
    }

}
