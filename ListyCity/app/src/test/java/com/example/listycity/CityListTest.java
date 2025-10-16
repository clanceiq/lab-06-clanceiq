package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import androidx.annotation.OpenForTesting;

import org.junit.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddExeption() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        City cityClone = new City("Vancouver", "British Columbia");
        City city2 = new City("Calgary", "Alberta");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));
        assertTrue(cityList.hasCity(cityClone));
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();
        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);

        assertTrue(cityList.hasCity(city));

        cityList.delete(city);

        assertFalse(cityList.hasCity(city));
    }

    @Test
    public void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City ("Vancouver", "British Columbia");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());

        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
    }
}
