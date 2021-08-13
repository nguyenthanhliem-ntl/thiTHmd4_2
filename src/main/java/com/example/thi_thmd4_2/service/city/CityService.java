package com.example.thi_thmd4_2.service.city;

import com.example.thi_thmd4_2.model.City;
import com.example.thi_thmd4_2.model.Country;
import com.example.thi_thmd4_2.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CityService implements ICityService{
    @Autowired
    private ICityRepository cityRepository;

    @Override
    public Iterable<City> findAllByCountry(Country country) {
        return cityRepository.findAllByCountry(country);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
