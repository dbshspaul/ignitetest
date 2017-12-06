package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;

@Table("supplement")
public class Supplement {
    @PrimaryKey
    private Integer supplement_id;
    private Boolean apply_special_offer;
    private Set<Integer> board_basis_ids;
    private Byte child_age_max;
    private Byte child_age_min;
    private Boolean child_age_override;
    private Boolean child_youth_infant_only;
    private String description;
    private Byte length_of_stay_max;
    private Byte length_of_stay_min;
    private Boolean length_of_stay_restriction;
    private Boolean manadatory;
    private String name;
    private Boolean pay_local;
    private Boolean per_peron;
    private LocalDate stay_from;
    private LocalDate stay_to;
    private Byte supplement_calculation_type_id;

    public Integer getSupplement_id() {
        return supplement_id;
    }

    public void setSupplement_id(Integer supplement_id) {
        this.supplement_id = supplement_id;
    }

    public Boolean getApply_special_offer() {
        return apply_special_offer;
    }

    public void setApply_special_offer(Boolean apply_special_offer) {
        this.apply_special_offer = apply_special_offer;
    }

    public Set<Integer> getBoard_basis_ids() {
        return board_basis_ids;
    }

    public void setBoard_basis_ids(Set<Integer> board_basis_ids) {
        this.board_basis_ids = board_basis_ids;
    }

    public Byte getChild_age_max() {
        return child_age_max;
    }

    public void setChild_age_max(Byte child_age_max) {
        this.child_age_max = child_age_max;
    }

    public Byte getChild_age_min() {
        return child_age_min;
    }

    public void setChild_age_min(Byte child_age_min) {
        this.child_age_min = child_age_min;
    }

    public Boolean getChild_age_override() {
        return child_age_override;
    }

    public void setChild_age_override(Boolean child_age_override) {
        this.child_age_override = child_age_override;
    }

    public Boolean getChild_youth_infant_only() {
        return child_youth_infant_only;
    }

    public void setChild_youth_infant_only(Boolean child_youth_infant_only) {
        this.child_youth_infant_only = child_youth_infant_only;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getLength_of_stay_max() {
        return length_of_stay_max;
    }

    public void setLength_of_stay_max(Byte length_of_stay_max) {
        this.length_of_stay_max = length_of_stay_max;
    }

    public Byte getLength_of_stay_min() {
        return length_of_stay_min;
    }

    public void setLength_of_stay_min(Byte length_of_stay_min) {
        this.length_of_stay_min = length_of_stay_min;
    }

    public Boolean getLength_of_stay_restriction() {
        return length_of_stay_restriction;
    }

    public void setLength_of_stay_restriction(Boolean length_of_stay_restriction) {
        this.length_of_stay_restriction = length_of_stay_restriction;
    }

    public Boolean getManadatory() {
        return manadatory;
    }

    public void setManadatory(Boolean manadatory) {
        this.manadatory = manadatory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPay_local() {
        return pay_local;
    }

    public void setPay_local(Boolean pay_local) {
        this.pay_local = pay_local;
    }

    public Boolean getPer_peron() {
        return per_peron;
    }

    public void setPer_peron(Boolean per_peron) {
        this.per_peron = per_peron;
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

    public Byte getSupplement_calculation_type_id() {
        return supplement_calculation_type_id;
    }

    public void setSupplement_calculation_type_id(Byte supplement_calculation_type_id) {
        this.supplement_calculation_type_id = supplement_calculation_type_id;
    }
}
