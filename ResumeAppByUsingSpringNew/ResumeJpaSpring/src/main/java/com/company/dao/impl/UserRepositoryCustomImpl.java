package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Component("userDao1")
@Transactional
public class UserRepositoryCustomImpl implements UserRepositoryCustom {
    public UserRepositoryCustomImpl() {
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        String jpql = "select u from User u where 1 = 1 ";

        if (name != null && !name.trim().isEmpty()) {
            jpql += "and u.name= :name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += "and u.surname= :surname ";
        }
        if (nationalityId != null) {
            jpql += "and u.nationalityId.id= :nid";
        }
        jpql = jpql + " ORDER BY 'id' ASC";

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null && nationalityId != 0) {
            query.setParameter("nid", nationalityId);
        }
        return query.getResultList();
    }

    @Override
    public User getById(int userId) {
        User user = em.find(User.class, userId);
        return user;
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean add(User user) {
        Query query = em.createNativeQuery("INSERT INTO"
                + "user(name, surname, email, phone, password, profile_description, address,"
                + "birthdate, birthplace_id, nationality_id, authority_id)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        query.setParameter(1, user.getName());
        query.setParameter(2, user.getSurname());
        query.setParameter(3, user.getEmail());
        query.setParameter(4, user.getPhone());
        query.setParameter(6, user.getProfileDescription());
        query.setParameter(8, user.getBirthdate());
        query.setParameter(9, user.getBirthplaceId().getId());
        query.setParameter(10, user.getNationalityId().getId());
        query.executeUpdate();
        return true;
    }

    @Override
    public boolean remove(User user) {
        em.remove(em.find(User.class, user.getId()));
        return true;
    }

    @Override
    public boolean deleteById(int userId) {
        em.remove(em.find(User.class, userId));
        return true;
    }

    @Override
    public boolean update(User u) {
        em.merge(u);
        return true;
    }

}
