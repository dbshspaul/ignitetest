package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class BoardBasisAllocationPK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer rate_plan_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer board_basis_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public Integer getBoard_basis_id() {
        return board_basis_id;
    }

    public void setBoard_basis_id(Integer board_basis_id) {
        this.board_basis_id = board_basis_id;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BoardBasisAllocationPK)) return false;
        BoardBasisAllocationPK that = (BoardBasisAllocationPK) o;
        return Objects.equals(getRate_plan_id(), that.getRate_plan_id()) &&
                Objects.equals(getBoard_basis_id(), that.getBoard_basis_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRate_plan_id(), getBoard_basis_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "BoardBasisAllocationPK: {" +
                "rate_plan_id=" + rate_plan_id +
                ", board_basis_id=" + board_basis_id +
                ", stay_date=" + stay_date +
                '}';
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }
}
