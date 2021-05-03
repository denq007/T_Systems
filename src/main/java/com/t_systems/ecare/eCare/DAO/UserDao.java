package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Repository
public class UserDao extends AbstractHibernateDAO{
    @PersistenceContext
    EntityManager entityManager;
    public UserDao() {
        setClazz(User.class);
    }

    public User getUserByUsername(String login) {
       try {
           return entityManager.createQuery("from User where login=:login",User.class).setParameter("login", login)
                   .getSingleResult();
       }catch (NoResultException e)
       {
           return new User();
       }
    }
}
