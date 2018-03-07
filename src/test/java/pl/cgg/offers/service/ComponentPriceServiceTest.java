package pl.cgg.offers.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComponentPriceServiceTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getComponentPriceToMap() {
        //Given
        ComponentPriceService componentPriceService = new ComponentPriceService();
        componentPriceService.getOneComponentPrice(1L);
    }
}