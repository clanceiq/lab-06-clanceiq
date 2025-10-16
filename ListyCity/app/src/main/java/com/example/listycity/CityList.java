package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * Checks whether a city exists in the CityArray
     * @param city
     *      The city you want to check in the array
     * @return
     *     A boolean of whether the city exiss in the list
     */
    public boolean hasCity(City city) {
        if (cities.contains(city)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the given city exists in a list and deletes it if it does.
     * If the city does not exist, an exception is thrown
     * @param city
     *      The city to delete from the list
     */
    public void delete(City city) {
        if (hasCity(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of cities in the list
     * @return
     *      The number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
