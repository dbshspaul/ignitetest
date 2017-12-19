package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.ContractPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("contract")
public class Contract {
    @PrimaryKey
    private ContractPK contractPK;
    private LocalDate booking_from;
    private LocalDate booking_to;
    private String buying_currency;
    private Integer channel_manager_id;
    private Byte channel_type_id;
    private Short contract_status_id;
    private Byte contract_type_id;
    private Integer follow_on_contract_id;
    private Boolean no_end_dates;
    private LocalDate stay_from;
    private LocalDate stay_to;

    public ContractPK getContractPK() {
        return contractPK;
    }

    public void setContractPK(ContractPK contractPK) {
        this.contractPK = contractPK;
    }

    public LocalDate getBooking_from() {
        return booking_from;
    }

    public void setBooking_from(LocalDate booking_from) {
        this.booking_from = booking_from;
    }

    public LocalDate getBooking_to() {
        return booking_to;
    }

    public void setBooking_to(LocalDate booking_to) {
        this.booking_to = booking_to;
    }

    public String getBuying_currency() {
        return buying_currency;
    }

    public void setBuying_currency(String buying_currency) {
        this.buying_currency = buying_currency;
    }

    public Integer getChannel_manager_id() {
        return channel_manager_id;
    }

    public void setChannel_manager_id(Integer channel_manager_id) {
        this.channel_manager_id = channel_manager_id;
    }

    public Short getContract_status_id() {
        return contract_status_id;
    }

    public void setContract_status_id(Short contract_status_id) {
        this.contract_status_id = contract_status_id;
    }

    public Byte getContract_type_id() {
        return contract_type_id;
    }

    public void setContract_type_id(Byte contract_type_id) {
        this.contract_type_id = contract_type_id;
    }

    public Integer getFollow_on_contract_id() {
        return follow_on_contract_id;
    }

    public void setFollow_on_contract_id(Integer follow_on_contract_id) {
        this.follow_on_contract_id = follow_on_contract_id;
    }

    public Boolean getNo_end_dates() {
        return no_end_dates;
    }

    public void setNo_end_dates(Boolean no_end_dates) {
        this.no_end_dates = no_end_dates;
    }

    public LocalDate getStay_from() {
        return stay_from;
    }

    public void setStay_from(LocalDate stay_from) {
        this.stay_from = stay_from;
    }

    public LocalDate getStay_to() {
        return stay_to;
    }

    public void setStay_to(LocalDate stay_to) {
        this.stay_to = stay_to;
    }

    public Byte getChannel_type_id() {
        return channel_type_id;
    }

    public void setChannel_type_id(Byte channel_type_id) {
        this.channel_type_id = channel_type_id;
    }

    @Override
    public String toString() {
        return "Contract:{" +
                "contractPK=" + contractPK +
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
