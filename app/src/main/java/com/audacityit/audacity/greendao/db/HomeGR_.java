package com.audacityit.audacity.greendao.db;

import com.audacityit.audacity.greendao.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "HOME_GR_".
 */
public class HomeGR_ {

    private Long id;
    private String title;
    private String background;
    private long home_id;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient HomeGR_Dao myDao;

    private HomeGR homeGR;
    private Long homeGR__resolvedKey;


    public HomeGR_() {
    }

    public HomeGR_(Long id) {
        this.id = id;
    }

    public HomeGR_(Long id, String title, String background, long home_id) {
        this.id = id;
        this.title = title;
        this.background = background;
        this.home_id = home_id;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHomeGR_Dao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public long getHome_id() {
        return home_id;
    }

    public void setHome_id(long home_id) {
        this.home_id = home_id;
    }

    /** To-one relationship, resolved on first access. */
    public HomeGR getHomeGR() {
        long __key = this.home_id;
        if (homeGR__resolvedKey == null || !homeGR__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HomeGRDao targetDao = daoSession.getHomeGRDao();
            HomeGR homeGRNew = targetDao.load(__key);
            synchronized (this) {
                homeGR = homeGRNew;
            	homeGR__resolvedKey = __key;
            }
        }
        return homeGR;
    }

    public void setHomeGR(HomeGR homeGR) {
        if (homeGR == null) {
            throw new DaoException("To-one property 'home_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.homeGR = homeGR;
            home_id = homeGR.getId();
            homeGR__resolvedKey = home_id;
        }
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