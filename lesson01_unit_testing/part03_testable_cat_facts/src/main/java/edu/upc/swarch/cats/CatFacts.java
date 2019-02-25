package edu.upc.swarch.cats;


import java.util.List;
import java.util.Random;

/**
 * CatFacts picks up one random fact from a list of cat facts, as retrieved by the CatFactsClient.
 */
public class CatFacts {

    private CatFactsClient client;

    private Random rnd = new Random(System.nanoTime());

    public CatFacts(CatFactsClient client) {
        this.client = client;
    }

    /**
     * Returns a random cat fact
     *
     * @return
     * @throws Exception if the facts can't be retrieved
     */
    public String randomFact() throws Exception {
        List<String> facts = client.retrieveFacts();
        return facts.get(rnd.nextInt(facts.size()));
    }

}
