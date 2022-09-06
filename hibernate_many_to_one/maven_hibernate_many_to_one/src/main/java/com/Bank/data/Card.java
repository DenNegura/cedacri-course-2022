package com.Bank.data;

import java.util.Date;

public class Card {
    private int idCard;

    private String type;

    private Date dateIssue;

    private Client client;

    @Override
    public String toString() {
        return "Card{" +
                "id_card=" + idCard +
                ", type='" + type + '\'' +
                ", date_issue=" + dateIssue +
                ", \nclient=" + client +
                '}';
    }

    public int getIdCard() {
        return idCard;
    }

    public String getType() {
        return type;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public Client getClient() {
        return client;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
