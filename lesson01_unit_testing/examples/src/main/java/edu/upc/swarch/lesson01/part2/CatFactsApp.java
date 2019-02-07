package edu.upc.swarch.lesson01.part2;


public class CatFactsApp {
    public static void main(String[] args) throws Exception {
        HardlyTestableCatFacts facts = new HardlyTestableCatFacts();

        System.out.println(facts.randomFact());

    }
}
