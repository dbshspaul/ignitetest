package com.jac.travels.idclass;

import com.datastax.driver.core.LocalDate;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import java.util.Objects;

public class RateBoardBasisUpgradePK {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private Integer board_basis_upgrade_id;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private LocalDate stay_date;
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private String tenant_id;

    public Integer getBoard_basis_upgrade_id() {
        return board_basis_upgrade_id;
    }

    public void setBoard_basis_upgrade_id(Integer board_basis_upgrade_id) {
        this.board_basis_upgrade_id = board_basis_upgrade_id;
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
        if (!(o instanceof RateBoardBasisUpgradePK)) return false;
        RateBoardBasisUpgradePK that = (RateBoardBasisUpgradePK) o;
        return Objects.equals(getBoard_basis_upgrade_id(), that.getBoard_basis_upgrade_id()) &&
                Objects.equals(getStay_date(), that.getStay_date());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getBoard_basis_upgrade_id(), getStay_date());
    }

    @Override
    public String toString() {
        return "RateBoardBasisUpgradePK:{" +
                "board_basis_upgrade_id=" + board_basis_upgrade_id +
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
