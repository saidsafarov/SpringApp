package com.company.sevice.inter;

import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {
    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int userId);

    public boolean update(User u);

    public boolean add(User u);

    public boolean delete(User user);

    public boolean deleteById(int id);
}
