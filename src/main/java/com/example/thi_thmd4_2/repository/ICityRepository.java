package com.example.thi_thmd4_2.repository;

import com.example.thi_thmd4_2.model.City;
import com.example.thi_thmd4_2.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
    Iterable<City> findAllByCountry(Country country);}
