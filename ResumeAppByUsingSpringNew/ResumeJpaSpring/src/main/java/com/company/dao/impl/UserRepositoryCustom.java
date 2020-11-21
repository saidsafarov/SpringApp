
package com.company.dao.impl;

import com.company.entity.User;

import java.util.List;

public interface UserRepositoryCustom {

    public List<User> getAll(String name, String surname, Integer nationalityId);

    public User getById(int userId);

    public boolean update(User u);

    public boolean add(User u);

    public boolean remove(User user);

    public boolean deleteById(int id);
}
