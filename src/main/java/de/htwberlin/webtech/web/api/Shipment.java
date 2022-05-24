package de.htwberlin.webtech.web.api;

public class Shipment {
    private long shipmentId;
    private String recipientName;
    private String recipientAddress;
    private String senderName;
    private String senderAddress;

    public Shipment(long shipmentId, String recipientName, String recipientAddress, String senderName, String senderAddress) {
        this.shipmentId = shipmentId;
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
    }

    public long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }
}
