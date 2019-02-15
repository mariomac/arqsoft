package edu.upc.swarch.cats;

import org.junit.Assert;
import org.junit.Test;

public class CatFactsTest {
    @Test
    public void testCatFacts() throws Exception {
        // GIVEN a Cat Facts Application
        CatFacts cf = new CatFacts();

        // WHEN a random fact is retrieved
        String fact = cf.randomFact();

        // THEN the random fact is not null
        Assert.assertNotNull(fact);

        // AND fact length is larger than 0
        Assert.assertTrue(fact.length() > 0);

        /*
        OK, OK! THIS IS A REAL POOR TEST!
        - I'm just testing that randomFacts() returns "something"
        - If connection with the server is broken (server temporarily down, poor internet connection)
          tests will fail.
        */
    }
}
