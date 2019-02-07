package edu.upc.swarch.lesson01.part2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

// It is hardly testable because
// 1 - it does so many things
// 2 - relies on a given external service to work
public class HardlyTestableCatFacts {
    private static final String SERVICE_URL = "https://cat-fact.herokuapp.com/facts";
    private Random rnd = new Random(System.nanoTime());

    public String randomFact() throws Exception {
        List<String> facts = retrieveFacts();
        return facts.get(rnd.nextInt(facts.size()));
    }

    private List<String> retrieveFacts() throws Exception {
        HttpsURLConnection conn = (HttpsURLConnection) new URL(SERVICE_URL).openConnection();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(new InputStreamReader(conn.getInputStream()));

        List<String> facts = new ArrayList<>();

        for (Iterator<JsonNode> it = response.get("all").elements(); it.hasNext() ; ) {
            JsonNode factJson = it.next();
            JsonNode text = factJson.get("text");
            if (text != null) {
                facts.add(text.asText());
            }
        }
        return facts;
    }
}
