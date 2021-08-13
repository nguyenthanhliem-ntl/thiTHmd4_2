package com.example.thi_thmd4_2.controller;

import com.example.thi_thmd4_2.model.City;
import com.example.thi_thmd4_2.model.Country;
import com.example.thi_thmd4_2.service.city.ICityService;
import com.example.thi_thmd4_2.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries(){
        return countryService.findAll();
    }

    @GetMapping("/city")
    public ModelAndView showListCity(){
        Iterable<City> cities= cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateCity(){
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "thêm thành công!");
        return modelAndView;
    }


    @GetMapping("delete-city/{id}")
    public ModelAndView deleteCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        if(city.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("city",city.get());
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCity(@ModelAttribute ("city") City city){
        cityService.remove((city.getId()));
        return "redirect:city";
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditCity(@PathVariable Long id){
        Optional<City> cityOptional = cityService.findById(id);
        if(cityOptional.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("city",cityOptional.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("city") City city){
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("city",city);
        modelAndView.addObject("message","Cập nhật thành công!");
        return modelAndView;
    }

    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Validated @ModelAttribute("city") City city, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("/create-city");
        }
        return new ModelAndView("/create-city");
    }
}