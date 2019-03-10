package upc.arqsoft.dbs.dao;

import upc.arqsoft.dbs.model.Fine;

import java.util.List;

/**
 * Data Access Object (DAO) interface for the Fines.
 */
public interface FineDAO {
    /**
     * Adds an unpaid fine to the database
     * @param model model of the car
     * @param plate plate of the car
     * @param amount amount of euros
     * @throws Exception
     */
    void addFine(String model, String plate, int amount) throws Exception;

    /**
     * Updates an existing fine into the database
     * @param fine the fine to update. It has to have the `id` field set.
     * @throws Exception
     */
    void updateFine(Fine fine) throws Exception;

    /**
     * Gets all the fines for the car with a given plate
     * @param plate plate of the car whose fines we want to list
     * @return
     * @throws Exception
     */
    List<Fine> getAllFines(String plate) throws Exception;
}
