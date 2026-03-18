package za.ac.cput.repository.impl;

import za.ac.cput.domain.Driver;
import za.ac.cput.repository.IDriverRepository;
import java.util.HashMap;

public class DriverRepositoryImpl implements IDriverRepository {
    private final HashMap<String, Driver> store = new HashMap<>();
    private static DriverRepositoryImpl instance;

    private DriverRepositoryImpl() {}

    public static DriverRepositoryImpl getInstance() {
        if (instance == null)
            instance = new DriverRepositoryImpl();
        return instance;
    }

    @Override
    public Driver create(Driver driver) {
        store.put(driver.getId(), driver);
        return driver;
    }

    @Override
    public Driver read(String id) {
        return store.get(id);
    }

    @Override
    public Driver update(Driver driver) {
        if (store.containsKey(driver.getId())) {
            store.put(driver.getId(), driver);
            return driver;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return store.remove(id) != null;
    }
}