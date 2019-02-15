package edu.upc.swarch.cats;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * CatFacts class does all the logic of the Cat Facts application, and that's why it's so difficult
 * to test:
 *
 * - This single class does too many things
 * - It relies on a given external service to work
 */
public class CatFacts {

    /**
     * Constant containing the Web Address of the cat facts service. Try to open it from
     * your web browser and see what happens!
     */
    private static final String SERVICE_URL = "https://cat-fact.herokuapp.com/facts";

    private Random rnd = new Random(System.nanoTime());

    /**
     * Returns a random cat fact
     * @return
     * @throws Exception if the facts can't be retrieved
     */
    public String randomFact() throws Exception {
        List<String> facts = retrieveFacts();
        return facts.get(rnd.nextInt(facts.size()));
    }

    /**
     * Retrieve from the web service a list of cat facts. DON'T WORRY IF YOU DON'T UNDERSTAND IT.
     * It's just an example of a highly coupled, hardly testable code.
     *
     * @return
     * @throws Exception if the connection can't be established or the response from the server does
     *                   not have a valid format.
     */
    private List<String> retrieveFacts() throws Exception {

        // Open a connection between our application and the server
        URLConnection conn = new URL(SERVICE_URL).openConnection();

        // List of retrieved cat facts
        List<String> facts = new ArrayList<>();

        // This two lines read the JSON response from the cats server
        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(new InputStreamReader(conn.getInputStream()));

        // The response for the server has a field called "all", that contains a list of cat facts
        // We iterate it.
        Iterator<JsonNode> it = response.get("all").elements();
        while (it.hasNext()) {
            JsonNode factJson = it.next();
            JsonNode text = factJson.get("text"); // Each cat fact has a field named "text" with the actual fact
            if (text != null) {
                facts.add(text.asText());
            }
        }
        return facts;
    }


}
