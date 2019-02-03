package edu.upc.swarch.lesson01.misc.cats;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CatFactsWebClient {

    private static final String SERVICE_URL = "https://cat-fact.herokuapp.com/facts";

    public List<String> retrieveFacts() throws Exception {

        HttpsURLConnection conn = (HttpsURLConnection) new URL(SERVICE_URL).openConnection();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(new InputStreamReader(conn.getInputStream()));

        List<String> facts = new ArrayList<>();

        for (Iterator<JsonNode> it = response.get("all").elements() ; it.hasNext() ; ) {
            JsonNode factJson = it.next();
            JsonNode text = factJson.get("text");
            if (text != null) {
                facts.add(text.asText());
            }
        }
        return facts;
    }
}
