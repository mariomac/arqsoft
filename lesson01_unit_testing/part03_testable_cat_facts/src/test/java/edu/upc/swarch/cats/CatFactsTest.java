package edu.upc.swarch.cats;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CatFactsTest {

  // Tests cat facts with a Fake Client implementation
  @Test
  public void testCatFacts() throws Exception {
    // GIVEN a Cat Facts Application
    CatFacts cf = new CatFacts(
            new CatFactsFakeClient()
    );

    // WHEN a random fact is retrieved
    String fact = cf.randomFact();

    List<String> expectedReturnedData = new ArrayList<>();
    expectedReturnedData.add("Cats are beautiful");
    expectedReturnedData.add("Cats have 4 feet");
    expectedReturnedData.add("Cats eat cats food");
    
    // THEN the returned fact is contained
    // in the set of facts returned from the
    // Cat Facts service
    Assert.assertTrue( expectedReturnedData.contains(fact));

  }

  // Same test as before, but using a Mockito's mock of the service
  @Test
  public void testWithMock() throws Exception {
    List<String> factsSet = new ArrayList<>();
    factsSet.add("Cats are beautiful");
    factsSet.add("Cats have 4 feet");
    factsSet.add("Cats eat cats food");

    CatFactsClient service = Mockito.mock(CatFactsClient.class);
    Mockito.when(service.retrieveFacts()).thenReturn(factsSet);

    CatFacts cf = new CatFacts( service );

    String fact = cf.randomFact();

    Assert.assertTrue(factsSet.contains(fact));



  }

  // Same test as before, but using a Mockito's spy implementation that allows us to
  // verify the interactions between the objects
  @Test
  public void testWithMockSpy() throws Exception {
    List<String> factsSet = new ArrayList<>();
    factsSet.add("Hoello");

    CatFactsClient service =
            Mockito.spy(CatFactsClient.class);
    Mockito.when(service.retrieveFacts())
            .thenReturn(factsSet);
    
    CatFacts cf = new CatFacts( service );
    
    String fact = cf.randomFact();
    
    Assert.assertTrue(factsSet.contains(fact));

    // We can use "verify" to chec, in this case, that retrieveFacts method has been invoked once
    // and only once
    Mockito.verify(service, Mockito.only()).retrieveFacts();
  }

}
