package de.htwberlin.webtech.web.api;

public class Shipment {
    private String shipmentId;
    private String senderName;
    private String recipientName;
    private String senderAdress;
    private String recipientAdress;

    public Shipment(String shipmentId, String senderName, String senderAdress, String recipientName, String recipientAdress) {
        this.shipmentId = shipmentId;
        this.senderName = senderName;
        this.senderAdress = senderAdress;
        this.recipientName = recipientName;
        this.recipientAdress = recipientAdress;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
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

    public String getSenderAdress() {
        return senderAdress;
    }

    public void setSenderAdress(String senderAdress) {
        this.senderAdress = senderAdress;
    }

    public String getRecipientAdress() {
        return recipientAdress;
    }

    public void setRecipientAdress(String recipientAdress) {
        this.recipientAdress = recipientAdress;
    }
}
