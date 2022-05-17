package de.htwberlin.webtech.web.api;

public class ShipmentManipulationRequest {
    private String senderName;
    private String recipientName;
    private String senderAddress;
    private String recipientAddress;

    public ShipmentManipulationRequest(String senderName, String recipientName, String senderAddress, String recipientAddress) {
        this.senderName = senderName;
        this.recipientName = recipientName;
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
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
