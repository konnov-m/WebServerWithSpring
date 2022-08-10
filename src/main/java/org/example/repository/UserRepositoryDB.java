package org.example.repository;

import org.example.core.HibernateUtils;
import org.example.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryDB implements UserRepository{

    private SessionFactory sessionFactory = HibernateUtils.buildSessionFactory(HIBERNATE_CFG_FILE, User.class);
    public static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            return session.createQuery("SELECT a FROM Users a", User.class).getResultList();
        }

    }

    @Override
    public long create(String name) {
        User user = new User(name);
        try (Session session = sessionFactory.openSession()){
            session.getTransaction().begin();
            session.persist(user);
            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user.getId();
    }
}
