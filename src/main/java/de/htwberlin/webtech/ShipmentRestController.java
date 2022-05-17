package de.htwberlin.webtech;

import de.htwberlin.webtech.sevice.ShipmentService;
import de.htwberlin.webtech.web.api.Shipment;
import de.htwberlin.webtech.web.api.ShipmentManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ShipmentRestController {

    //private List<Shipment> shipments;

    private final ShipmentService shipmentService;

    public ShipmentRestController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }


    //public ShipmentRestController(){
    //    shipments = new ArrayList<>();
    //    shipments.add(new Shipment("1", "Frondo Beutlin", "Eisenacher Str.28, 10781 Berlin", "Gustav Gimli", "Lorenzstr.8, 81737 München"));
    //    shipments.add(new Shipment("2", "Sepp Sauron", "Richard-Wagner-Straße, 2830177 Hannover", "Serap Durin", "Sewanstr. 111, 10319 Berlin"));
    //}

    @GetMapping(path = "/api/v1/shipments")
    public ResponseEntity<List<Shipment>> fetchShipments(){
        return ResponseEntity.ok(shipmentService.findAll());
    }

    @GetMapping(path = "/api/v1/shipments/{id}")
    public ResponseEntity<Shipment> fetchShipmentById(@PathVariable Long id) {
        var shipment = shipmentService.findById(id);
        return shipment != null? ResponseEntity.ok(shipment) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/shipments")
    public ResponseEntity<Void> createShipment(@RequestBody ShipmentManipulationRequest request) throws URISyntaxException {
        var shipment = shipmentService.create(request);
        URI uri = new URI("/api/v1/shipments" + shipment.getShipmentId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/shipments/{id}")
    public ResponseEntity<Shipment> updateShipment(@PathVariable Long id, @RequestBody ShipmentManipulationRequest request){
        var shipment = shipmentService.update(id, request);
        return shipment != null? ResponseEntity.ok(shipment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/shipments/{id}")
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id){
        boolean successful = shipmentService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

}
