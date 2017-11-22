package com.teamtreehouse.cotw.controller;

import com.teamtreehouse.cotw.data.CountryRepository;
import com.teamtreehouse.cotw.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String getCountries(ModelMap modelMap) {
        List<Country> countries = countryRepository.getCountries();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/sort-by-name")
    public String getCountriesSortByName(ModelMap modelMap) {
        List<Country> countries = countryRepository.getCountriesSortByName();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/sort-by-population")
    public String getCountriesSortByPopulation(ModelMap modelMap) {
        List<Country> countries = countryRepository.getCountriesSortByPopulation();
        modelMap.put("countries", countries);
        return "index";
    }

    @RequestMapping("/countries/{name}")
    public String getCountry(@PathVariable String name, ModelMap modelMap) {
        Country country = countryRepository.getCountry(name);
        modelMap.put("country", country);
        return "detail";
    }
}
