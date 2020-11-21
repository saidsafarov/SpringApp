package com.company.sevice.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.sevice.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
    public UserServiceImpl() {
        System.out.println("Constructor of UserDaoImpl");
    }

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao;


    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        return userDao.getAll(null, null, null);
    }

    @Override
    public User getById(int userId) {
        return userDao.getById(userId);
    }

    private static BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public boolean add(User user) {

        return userDao.add(user);
    }

    @Override
    public boolean delete(User user) {
        return userDao.remove(user);
    }

    @Override
    public boolean deleteById(int userId) {
        return userDao.deleteById(userId);

    }

    @Override
    public boolean update(User u) {
        return userDao.update(u);
    }

}
