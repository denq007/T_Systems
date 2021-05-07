package com.t_systems.ecare.eCare.DAO;

import com.t_systems.ecare.eCare.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
public class UserDao extends GenericDAO<User>{


    public User getUserByUsername(String login) {
     try {
         User user=sessionFactory.getCurrentSession().createQuery("from User u where u.login =: login", User.class)
                 .setParameter("login", login)
                 .getSingleResult();
         return user;
     }catch (NoResultException e)
     {
         User user= null;
         return user;
     }

    }

  /*  public User getUserByName(String login)
    {
        int i=0;
        return (User) entityManager.
                createNamedQuery("User.findByUer", User.class)
                .setParameter("login", login)
                .getSingleResult();
    }*/

}
