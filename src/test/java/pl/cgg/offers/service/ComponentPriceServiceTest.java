package pl.cgg.offers.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentPriceServiceTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getComponentPriceToMap() {
        //Given
        ComponentPriceService componentPriceService = new ComponentPriceService();
        componentPriceService.getOneComponentPrice(1L);
    }
}