package de.htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "shipments")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id", length = 10)
    private String shipmentId;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "recipient_name", nullable = false)
    private String recipientName;

    @Column(name = "sender_address", nullable = false)
    private String senderAddress;

    @Column(name = "recipient_address", nullable = false)
    private String recipientAddress;

    public ShipmentEntity(String shipmentId, String senderName, String recipientName, String senderAddress, String recipientAddress) {
        this.shipmentId = shipmentId;
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
    }

    protected ShipmentEntity() {}

    public String getShipmentId() {
        return shipmentId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }
}
