package de.htwberlin.webtech;

import de.htwberlin.webtech.web.api.Shipment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ShipmentRestController {

    private List<Shipment> shipments;

    public ShipmentRestController() {
        shipments = new ArrayList<>();
        shipments.add(new Shipment(1, "Frondo Beutlin", "Eisenacher Str.28, 10781 Berlin", "Gustav Gimli", "Lorenzstr.8, 81737 München"));
        shipments.add(new Shipment(2, "Sepp Sauron", "Richard-Wagner-Straße, 2830177 Hannover", "Serap Durin", "Sewanstr. 111, 10319 Berlin"));
    }

    @GetMapping(path = "/api/v1/shipments")
    public ResponseEntity<List<Shipment>> fetchShipments() {
        return ResponseEntity.ok(shipments);
    }
}
