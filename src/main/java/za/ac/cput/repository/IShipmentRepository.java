package za.ac.cput.repository;

import za.ac.cput.domain.Shipment;

import java.util.List;

public interface IShipmentRepository extends IRepository<Shipment, String> {
    List<Shipment> getAllShipments();
}
