package de.htwberlin.webtech.sevice;

import de.htwberlin.webtech.persistence.ShipmentEntity;
import de.htwberlin.webtech.persistence.ShipmentRepository;
import de.htwberlin.webtech.web.api.Shipment;
import de.htwberlin.webtech.web.api.ShipmentManipulationRequest;
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
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Shipment findById(Long id){
        var shipmentEntity = shipmentRepository.findById(id);
        return shipmentEntity.map(this::transformEntity).orElse(null);
    }

    public Shipment create(ShipmentManipulationRequest request){
        var shipmentEntity = new ShipmentEntity(request.getRecipientName(), request.getRecipientAddress(), request.getSenderName(), request.getSenderAddress());
        shipmentRepository.save(shipmentEntity);
        return transformEntity(shipmentEntity);
    }

    public Shipment update(Long id, ShipmentManipulationRequest request){
        var shipmentEntityOptional = shipmentRepository.findById(id);
        if(shipmentEntityOptional.isEmpty()){
            return null;
        }
        var shipmentEntity = shipmentEntityOptional.get();
        shipmentEntity.setRecipientName(request.getRecipientName());
        shipmentEntity.setRecipientAddress(request.getRecipientAddress());
        shipmentEntity.setSenderName(request.getSenderName());
        shipmentEntity.setSenderAddress(request.getSenderAddress());
        shipmentRepository.save(shipmentEntity);
        return transformEntity(shipmentEntity);
    }

    public boolean deleteById(Long id) {
        if (!shipmentRepository.existsById(id)){
            return false;
        }
        shipmentRepository.deleteById(id);
        return true;
    }

    private Shipment transformEntity(ShipmentEntity shipmentEntity){
        return new Shipment(
                shipmentEntity.getShipmentId(),
                shipmentEntity.getSenderName(),
                shipmentEntity.getSenderAddress(),
                shipmentEntity.getRecipientName(),
                shipmentEntity.getRecipientAddress()
        );
    }
}

