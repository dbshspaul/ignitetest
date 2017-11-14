package com.jac.travels.model;

import java.util.Date;

public class Contract {
    private int property_id;
    private int contract_id;
    private Date booking_from;
    private Date booking_to;
    private String buying_currency;
    private int channel_manager_id;
    private int channel_type_id;
    private int contract_status_id;
    private int contract_type_id;
    private int follow_on_contract_id;
    private boolean no_end_dates;
    private Date stay_from;
    private Date stay_to;

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public Date getBooking_from() {
        return booking_from;
    }

    public void setBooking_from(Date booking_from) {
        this.booking_from = booking_from;
    }

    public Date getBooking_to() {
        return booking_to;
    }

    public void setBooking_to(Date booking_to) {
        this.booking_to = booking_to;
    }

    public String getBuying_currency() {
        return buying_currency;
    }

    public void setBuying_currency(String buying_currency) {
        this.buying_currency = buying_currency;
    }

    public int getChannel_manager_id() {
        return channel_manager_id;
    }

    public void setChannel_manager_id(int channel_manager_id) {
        this.channel_manager_id = channel_manager_id;
    }

    public int getChannel_type_id() {
        return channel_type_id;
    }

    public void setChannel_type_id(int channel_type_id) {
        this.channel_type_id = channel_type_id;
    }

    public int getContract_status_id() {
        return contract_status_id;
    }

    public void setContract_status_id(int contract_status_id) {
        this.contract_status_id = contract_status_id;
    }

    public int getContract_type_id() {
        return contract_type_id;
    }

    public void setContract_type_id(int contract_type_id) {
        this.contract_type_id = contract_type_id;
    }

    public int getFollow_on_contract_id() {
        return follow_on_contract_id;
    }

    public void setFollow_on_contract_id(int follow_on_contract_id) {
        this.follow_on_contract_id = follow_on_contract_id;
    }

    public boolean isNo_end_dates() {
        return no_end_dates;
    }

    public void setNo_end_dates(boolean no_end_dates) {
        this.no_end_dates = no_end_dates;
    }

    public Date getStay_from() {
        return stay_from;
    }

    public void setStay_from(Date stay_from) {
        this.stay_from = stay_from;
    }

    public Date getStay_to() {
        return stay_to;
    }

    public void setStay_to(Date stay_to) {
        this.stay_to = stay_to;
    }

    @Override
    public String toString() {
        return "Contract:{" +
                "property_id=" + property_id +
                ", contract_id=" + contract_id +
                ", booking_from=" + booking_from +
                ", booking_to=" + booking_to +
                ", buying_currency='" + buying_currency + '\'' +
                ", channel_manager_id=" + channel_manager_id +
                ", channel_type_id=" + channel_type_id +
                ", contract_status_id=" + contract_status_id +
                ", contract_type_id=" + contract_type_id +
                ", follow_on_contract_id=" + follow_on_contract_id +
                ", no_end_dates=" + no_end_dates +
                ", stay_from=" + stay_from +
                ", stay_to=" + stay_to +
                '}';
    }
}
