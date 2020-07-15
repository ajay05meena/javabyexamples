package com.akm.dao;

import com.akm.entity.UserEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


public class UserDao extends AbstractDAO<UserEntity> {
    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public UserEntity getById(long id){
        return get(id);
    }

    public UserEntity save(UserEntity userEntity){
        return persist(userEntity);
    }
}

