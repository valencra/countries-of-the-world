package com.teamtreehouse.cotw.data;

import com.teamtreehouse.cotw.exception.NotFoundException;
import com.teamtreehouse.cotw.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CountryRepository {
    private static final List<Country> COUNTRIES = Arrays.asList(
            new Country("Ecuador", 16385068, "Quito", Arrays.asList("Spanish")),
            new Country("France", 67158000, "Paris", Arrays.asList("French")),
            new Country("India", 1324171354, "New Delhi", Arrays.asList("Hindi", "English")),
            new Country("Italy", 60589445, "Rome", Arrays.asList("Italian")),
            new Country("Kenya", 48655760, "Nairobi", Arrays.asList("Kiswahili", "English"))
    );

    public List<Country> getCountries() {
        return COUNTRIES;
    }

    public Country getCountry(String name) {
        Country selectedCountry = COUNTRIES.stream()
                .filter(country -> country.getName().equals(name))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        return selectedCountry;
    }
}
