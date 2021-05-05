package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


@Repository
public class UserDao extends AbstractHibernateDAO{

    public UserDao() {
        setClazz(User.class);
    }

    public User getUserByUsername(String login) {
     try {
         User user=getCurrentSession().createQuery("from User u where u.login =: login", User.class)
                 .setParameter("login", login)
                 .getSingleResult();
         return user;
     }catch (NoResultException e)
     {
         User user= null;
         return user;
     }

    }

}
