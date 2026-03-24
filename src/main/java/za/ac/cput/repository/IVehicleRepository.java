package za.ac.cput.repository;

import za.ac.cput.domain.Vehicle;
import java.util.List;


/*
VehicleFactoryTest.java
Vehicle model class
Author: Litha Owethu Mazibuko (240143485)
Date:March 2026
 */

public interface IVehicleRepository extends IRepository<Vehicle, String> {
List<Vehicle> getAll();
}
