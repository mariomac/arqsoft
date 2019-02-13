package edu.upc.swarch.cats;


public class CatFactsApp {
    public static void main(String[] args) throws Exception {
        HardlyTestableCatFacts facts = new HardlyTestableCatFacts();

        System.out.println(facts.randomFact());

    }
}
