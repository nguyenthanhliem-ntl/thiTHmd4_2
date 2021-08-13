package com.example.thi_thmd4_2.repository;

import com.example.thi_thmd4_2.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepository extends PagingAndSortingRepository<Country, Long> {
}
