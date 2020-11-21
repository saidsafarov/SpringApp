package com.company.dao.inter;

import com.company.entity.Country;

import java.util.List;

public interface CountryDaoInter {

    public List<Country> getAll();

    public Country getById(int id);

    public boolean update(Country u);

    public boolean add(Country country);

    public boolean delete(Country country);

    public boolean deleteById(int id);
}
