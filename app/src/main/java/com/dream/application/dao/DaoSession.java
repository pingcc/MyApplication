package com.dream.application.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.dream.application.dao.LawHead;
import com.dream.application.dao.LawHeadSecond;
import com.dream.application.dao.LawHeadThird;

import com.dream.application.dao.LawHeadDao;
import com.dream.application.dao.LawHeadSecondDao;
import com.dream.application.dao.LawHeadThirdDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig lawHeadDaoConfig;
    private final DaoConfig lawHeadSecondDaoConfig;
    private final DaoConfig lawHeadThirdDaoConfig;

    private final LawHeadDao lawHeadDao;
    private final LawHeadSecondDao lawHeadSecondDao;
    private final LawHeadThirdDao lawHeadThirdDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        lawHeadDaoConfig = daoConfigMap.get(LawHeadDao.class).clone();
        lawHeadDaoConfig.initIdentityScope(type);

        lawHeadSecondDaoConfig = daoConfigMap.get(LawHeadSecondDao.class).clone();
        lawHeadSecondDaoConfig.initIdentityScope(type);

        lawHeadThirdDaoConfig = daoConfigMap.get(LawHeadThirdDao.class).clone();
        lawHeadThirdDaoConfig.initIdentityScope(type);

        lawHeadDao = new LawHeadDao(lawHeadDaoConfig, this);
        lawHeadSecondDao = new LawHeadSecondDao(lawHeadSecondDaoConfig, this);
        lawHeadThirdDao = new LawHeadThirdDao(lawHeadThirdDaoConfig, this);

        registerDao(LawHead.class, lawHeadDao);
        registerDao(LawHeadSecond.class, lawHeadSecondDao);
        registerDao(LawHeadThird.class, lawHeadThirdDao);
    }
    
    public void clear() {
        lawHeadDaoConfig.clearIdentityScope();
        lawHeadSecondDaoConfig.clearIdentityScope();
        lawHeadThirdDaoConfig.clearIdentityScope();
    }

    public LawHeadDao getLawHeadDao() {
        return lawHeadDao;
    }

    public LawHeadSecondDao getLawHeadSecondDao() {
        return lawHeadSecondDao;
    }

    public LawHeadThirdDao getLawHeadThirdDao() {
        return lawHeadThirdDao;
    }

}
