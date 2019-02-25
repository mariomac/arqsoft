package edu.upc.swarch.cats;

import java.util.ArrayList;
import java.util.List;

/**
 * Fake implementation of the CatFactsClient interface. It just provides some dummy data
 * to allow testing CatFacts class without requiring an external service to work and a connection
 * to be established.
 */
public class CatFactsFakeClient
        implements CatFactsClient {

    @Override
    public List<String> retrieveFacts() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("Cats are beautiful");
        list.add("Cats have 4 feet");
        list.add("Cats eat cats food");
        return list;
    }
}
