package com.teamtreehouse.cotw.data;

import com.rits.cloning.Cloner;
import com.teamtreehouse.cotw.exception.NotFoundException;
import com.teamtreehouse.cotw.model.Country;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class CountryRepository {
    private static final List<Country> COUNTRIES = Arrays.asList(
            new Country("Ecuador", "16,385,068", "Quito", Arrays.asList("Spanish")),
            new Country("France", "67,158,000", "Paris", Arrays.asList("French")),
            new Country("India", "1,324,171,354", "New Delhi", Arrays.asList("Hindi", "English")),
            new Country("Italy", "60,589,445", "Rome", Arrays.asList("Italian")),
            new Country("Kenya", "48,655,760", "Nairobi", Arrays.asList("Kiswahili", "English"))
    );

    public List<Country> getCountries() {
        return COUNTRIES;
    }

    public List<Country> getCountriesSortByName() {
        Cloner cloner = new Cloner();
        List<Country> countries = cloner.deepClone(COUNTRIES);
        countries.sort((c1, c2) -> (c1.getName()).compareTo(c2.getName()));
        return countries;
    }

    public List<Country> getCountriesSortByPopulation() {
        Cloner cloner = new Cloner();
        List<Country> countries = cloner.deepClone(COUNTRIES);
        countries.sort((c1, c2) -> {
            int c1Pop = 0;
            int c2Pop = 0;
            try {
                NumberFormat usFormat = NumberFormat.getNumberInstance(Locale.US);
                c1Pop = usFormat.parse(c1.getPopulation()).intValue();
                c2Pop = usFormat.parse(c2.getPopulation()).intValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return c1Pop - c2Pop;
        });
        return countries;
    }

    public Country getCountry(String name) {
        Country selectedCountry = COUNTRIES.stream()
                .filter(country -> country.getName().equals(name))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        return selectedCountry;
    }
}
