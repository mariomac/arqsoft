package edu.upc.swarch.cats;

import java.util.List;

/**
 * Implementors of this interface must return a list of cat facts.
 */
public interface CatFactsClient {
    /**
     * Retrieve a list of cat facts.
     *
     * @return
     * @throws Exception if the implementor can't retrieve the list of cat facts, by any reason.
     */
    List<String> retrieveFacts() throws Exception;
}
