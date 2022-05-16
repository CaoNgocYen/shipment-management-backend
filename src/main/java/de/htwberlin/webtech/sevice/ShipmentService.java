package de.htwberlin.webtech.sevice;

import de.htwberlin.webtech.persistence.ShipmentEntity;
import de.htwberlin.webtech.persistence.ShipmentRepository;
import de.htwberlin.webtech.web.api.Shipment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipmentService {
    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> findAll(){
        List<ShipmentEntity> shipments = shipmentRepository.findAll();
        return shipments.stream()
                .map(shipmentEntity -> new Shipment(
                        shipmentEntity.getShipmentId(),
                        shipmentEntity.getSenderName(),
                        shipmentEntity.getSenderAddress(),
                        shipmentEntity.getRecipientName(),
                        shipmentEntity.getRecipientAddress()
                ))
                .collect(Collectors.toList());
    }
}

