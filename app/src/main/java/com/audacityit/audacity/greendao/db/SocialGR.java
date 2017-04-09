package com.audacityit.audacity.greendao.db;

import java.util.List;
import com.audacityit.audacity.greendao.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SOCIAL_GR".
 */
public class SocialGR {

    private Long id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient SocialGRDao myDao;

    private List<SocialGR_> socialGR_List;

    public SocialGR() {
    }

    public SocialGR(Long id) {
        this.id = id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getSocialGRDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<SocialGR_> getSocialGR_List() {
        if (socialGR_List == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SocialGR_Dao targetDao = daoSession.getSocialGR_Dao();
            List<SocialGR_> socialGR_ListNew = targetDao._querySocialGR_SocialGR_List(id);
            synchronized (this) {
                if(socialGR_List == null) {
                    socialGR_List = socialGR_ListNew;
                }
            }
        }
        return socialGR_List;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetSocialGR_List() {
        socialGR_List = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

}