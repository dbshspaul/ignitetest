package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import com.jac.travels.idclass.BoardBasisAllocationPK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("board_basis_allocation")
public class BoardBasisAllocation {
    @PrimaryKey
    private BoardBasisAllocationPK boardBasisAllocationPK;
    private LocalDate stay_date;
    private Integer allocation;
    private Boolean close_out;
    private Integer sold;

    public BoardBasisAllocationPK getBoardBasisAllocationPK() {
        return boardBasisAllocationPK;
    }

    public void setBoardBasisAllocationPK(BoardBasisAllocationPK boardBasisAllocationPK) {
        this.boardBasisAllocationPK = boardBasisAllocationPK;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Integer getAllocation() {
        return allocation;
    }

    public void setAllocation(Integer allocation) {
        this.allocation = allocation;
    }

    public Boolean getClose_out() {
        return close_out;
    }

    public void setClose_out(Boolean close_out) {
        this.close_out = close_out;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "BoardBasisAllocation:{" +
                "boardBasisAllocationPK=" + boardBasisAllocationPK +
                ", stay_date=" + stay_date +
                ", allocation=" + allocation +
                ", close_out=" + close_out +
                ", sold=" + sold +
                '}';
    }
}
