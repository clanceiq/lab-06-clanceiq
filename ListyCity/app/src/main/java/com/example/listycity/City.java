package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City
 */
public class City implements Comparable {
    private String city;
    private String province;

    /**
     * Constructor for the City class
     * @param city String for the city name
     * @param province String for the province name
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Getter for the city name
     * @return
     *      City name
     */
    String getCityName() {
        return city;
    }

    /**
     * Getter for the province name
     * @return
     *      Province name
     */
    String getProvinceName() {
        return province;
    }

    /**
     * Compares two cities to determine their order in the list
     * @param o the object to be compared.
     * @return
     *      An int - determines which object will come first
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Checks to see if two cities are equal
     * @param o The object to check if equal
     * @return
     *      A boolean for if the cities are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, province);
    }
}
