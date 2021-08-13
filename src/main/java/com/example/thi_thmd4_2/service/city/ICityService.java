package com.example.thi_thmd4_2.service.city;

import com.example.thi_thmd4_2.model.Country;
import com.example.thi_thmd4_2.service.IGeneralService;
import com.example.thi_thmd4_2.model.City;

public interface ICityService extends IGeneralService<City> {
    Iterable<City> findAllByCountry(Country country);
}
