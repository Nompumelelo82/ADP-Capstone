package za.ac.cput.repository;

/*
VehicleFactoryTest.java
Vehicle model class
Author: Litha Owethu Mazibuko (240143485)
Date:2026
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.factory.VehicleFactory;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleRepositoryTest {

    private VehicleRepository repository;
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        repository = (VehicleRepository) VehicleRepository.getRepository();

        vehicle = VehicleFactory.createVehicle(
                "V001",
                "CAA24680",
                Vehicle.VehicleType.TRUCK,
                16000.0f,
                Vehicle.VehicleStatus.AVAILABLE,
                18000.0f,
                LocalDate.of(2025,12,10)
                );
    }

    @Test
    void testCreate() {
        Vehicle created = repository.create(vehicle);
        assertNotNull(created);
        assertEquals(vehicle.getVehicleId(), created.getVehicleId());
    }

    @Test
    void testRead() {
        repository.create(vehicle);
        Vehicle read = repository.read(vehicle.getVehicleId());
        assertNotNull(read);
        assertEquals(vehicle.getVehicleId(), read.getVehicleId());
    }

    @Test
    void testUpdate() {
        repository.create(vehicle);

        Vehicle updated = new Vehicle.Builder()
                .setVehicleId(vehicle.getVehicleId())
                .setNumberPlate("CAA13690")
                .setType(Vehicle.VehicleType.TRUCK)
                .setCapacity(15000.00f)
                .setCurrentStatus(Vehicle.VehicleStatus.IN_SERVICE)
                .setMileage(6000.0f)
                .setLastService(LocalDate.now())
                .build();

        Vehicle result = repository.update(updated);

        assertNotNull(result);
        assertEquals("CAA13690", result.getNumberPlate());
    }

    @Test
    void testDelete() {
        repository.create(vehicle);
        boolean deleted = repository.delete(vehicle.getVehicleId());

        assertTrue(deleted);
        assertNull(repository.read(vehicle.getVehicleId()));
    }
}






















