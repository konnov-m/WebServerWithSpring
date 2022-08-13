package org.example.repository;

import org.example.models.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserRepositoryDB implements UserRepository{

    private SessionFactory sessionFactory;

    public UserRepositoryDB(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from " + User.class.getName()).getResultList();
    }

    @Override
    public long create(String name) {
        System.out.println("------------------------");
        System.out.println("Creating User with name: " + name);
        User user = new User(name);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
        return user.getId();
    }
}
