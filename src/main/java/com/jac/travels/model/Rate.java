package com.jac.travels.model;

import com.jac.travels.idclass.RatePK;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.math.BigDecimal;

@Table("rate")
public class Rate {
    @PrimaryKey
    private RatePK ratePK;
    private BigDecimal adult02_charge;
    private BigDecimal adult03_charge;
    private BigDecimal adult04_charge;
    private BigDecimal adult05_charge;
    private BigDecimal adult06_charge;
    private BigDecimal adult07_charge;
    private BigDecimal adult08_charge;
    private BigDecimal adult09_charge;
    private BigDecimal adult10_charge;
    private BigDecimal adult11_charge;
    private BigDecimal adult12_charge;
    private BigDecimal adult13_charge;
    private BigDecimal adult14_charge;
    private BigDecimal adult15_charge;
    private BigDecimal adult16_charge;
    private BigDecimal adult17_charge;
    private BigDecimal adult18_charge;
    private BigDecimal adult19_charge;
    private BigDecimal adult20_charge;
    private BigDecimal adult21_charge;
    private BigDecimal adult22_charge;
    private BigDecimal adult23_charge;
    private BigDecimal adult24_charge;
    private BigDecimal adult25_charge;
    private BigDecimal adult26_charge;
    private BigDecimal adult27_charge;
    private BigDecimal adult28_charge;
    private BigDecimal adult29_charge;
    private BigDecimal adult30_charge;
    private BigDecimal adult_extra_charge;
    private BigDecimal base_rate;
    private BigDecimal child01_charge;
    private BigDecimal child01_split2_charge;
    private BigDecimal child02_charge;
    private BigDecimal child02_split2_charge;
    private BigDecimal child03_charge;
    private BigDecimal child03_split2_charge;
    private BigDecimal child04_charge;
    private BigDecimal child04_split2_charge;
    private BigDecimal child05_charge;
    private BigDecimal child06_charge;
    private BigDecimal child07_charge;
    private BigDecimal child08_charge;
    private BigDecimal child09_charge;
    private BigDecimal child10_charge;
    private BigDecimal child11_charge;
    private BigDecimal child12_charge;
    private BigDecimal child13_charge;
    private BigDecimal child14_charge;
    private BigDecimal child15_charge;
    private BigDecimal child16_charge;
    private BigDecimal child17_charge;
    private BigDecimal child18_charge;
    private BigDecimal child19_charge;
    private BigDecimal child20_charge;
    private BigDecimal child_charge;
    private BigDecimal child_extra_charge;
    private BigDecimal child_extra_split2_charge;
    private BigDecimal child_split2_charge;
    private BigDecimal double_occ_charge;
    private BigDecimal single_occ_charge;
    private BigDecimal triple_occ_charge;
    private BigDecimal unit_rate;
    private BigDecimal youth01_charge;
    private BigDecimal youth01_split2_charge;
    private BigDecimal youth02_charge;
    private BigDecimal youth02_split2_charge;
    private BigDecimal youth03_charge;
    private BigDecimal youth03_split2_charge;
    private BigDecimal youth04_charge;
    private BigDecimal youth04_split2_charge;
    private BigDecimal youth05_charge;
    private BigDecimal youth06_charge;
    private BigDecimal youth07_charge;
    private BigDecimal youth08_charge;
    private BigDecimal youth09_charge;
    private BigDecimal youth10_charge;
    private BigDecimal youth11_charge;
    private BigDecimal youth12_charge;
    private BigDecimal youth13_charge;
    private BigDecimal youth14_charge;
    private BigDecimal youth15_charge;
    private BigDecimal youth16_charge;
    private BigDecimal youth17_charge;
    private BigDecimal youth18_charge;
    private BigDecimal youth19_charge;
    private BigDecimal youth20_charge;
    private BigDecimal youth_charge;
    private BigDecimal youth_extra_charge;
    private BigDecimal youth_extra_split2_charge;
    private BigDecimal youth_split2_charge;

    public RatePK getRatePK() {
        return ratePK;
    }

    public void setRatePK(RatePK ratePK) {
        this.ratePK = ratePK;
    }

    public BigDecimal getAdult02_charge() {
        return adult02_charge;
    }

    public void setAdult02_charge(BigDecimal adult02_charge) {
        this.adult02_charge = adult02_charge;
    }

    public BigDecimal getAdult03_charge() {
        return adult03_charge;
    }

    public void setAdult03_charge(BigDecimal adult03_charge) {
        this.adult03_charge = adult03_charge;
    }

    public BigDecimal getAdult04_charge() {
        return adult04_charge;
    }

    public void setAdult04_charge(BigDecimal adult04_charge) {
        this.adult04_charge = adult04_charge;
    }

    public BigDecimal getAdult05_charge() {
        return adult05_charge;
    }

    public void setAdult05_charge(BigDecimal adult05_charge) {
        this.adult05_charge = adult05_charge;
    }

    public BigDecimal getAdult06_charge() {
        return adult06_charge;
    }

    public void setAdult06_charge(BigDecimal adult06_charge) {
        this.adult06_charge = adult06_charge;
    }

    public BigDecimal getAdult07_charge() {
        return adult07_charge;
    }

    public void setAdult07_charge(BigDecimal adult07_charge) {
        this.adult07_charge = adult07_charge;
    }

    public BigDecimal getAdult08_charge() {
        return adult08_charge;
    }

    public void setAdult08_charge(BigDecimal adult08_charge) {
        this.adult08_charge = adult08_charge;
    }

    public BigDecimal getAdult09_charge() {
        return adult09_charge;
    }

    public void setAdult09_charge(BigDecimal adult09_charge) {
        this.adult09_charge = adult09_charge;
    }

    public BigDecimal getAdult10_charge() {
        return adult10_charge;
    }

    public void setAdult10_charge(BigDecimal adult10_charge) {
        this.adult10_charge = adult10_charge;
    }

    public BigDecimal getAdult11_charge() {
        return adult11_charge;
    }

    public void setAdult11_charge(BigDecimal adult11_charge) {
        this.adult11_charge = adult11_charge;
    }

    public BigDecimal getAdult12_charge() {
        return adult12_charge;
    }

    public void setAdult12_charge(BigDecimal adult12_charge) {
        this.adult12_charge = adult12_charge;
    }

    public BigDecimal getAdult13_charge() {
        return adult13_charge;
    }

    public void setAdult13_charge(BigDecimal adult13_charge) {
        this.adult13_charge = adult13_charge;
    }

    public BigDecimal getAdult14_charge() {
        return adult14_charge;
    }

    public void setAdult14_charge(BigDecimal adult14_charge) {
        this.adult14_charge = adult14_charge;
    }

    public BigDecimal getAdult15_charge() {
        return adult15_charge;
    }

    public void setAdult15_charge(BigDecimal adult15_charge) {
        this.adult15_charge = adult15_charge;
    }

    public BigDecimal getAdult16_charge() {
        return adult16_charge;
    }

    public void setAdult16_charge(BigDecimal adult16_charge) {
        this.adult16_charge = adult16_charge;
    }

    public BigDecimal getAdult17_charge() {
        return adult17_charge;
    }

    public void setAdult17_charge(BigDecimal adult17_charge) {
        this.adult17_charge = adult17_charge;
    }

    public BigDecimal getAdult18_charge() {
        return adult18_charge;
    }

    public void setAdult18_charge(BigDecimal adult18_charge) {
        this.adult18_charge = adult18_charge;
    }

    public BigDecimal getAdult19_charge() {
        return adult19_charge;
    }

    public void setAdult19_charge(BigDecimal adult19_charge) {
        this.adult19_charge = adult19_charge;
    }

    public BigDecimal getAdult20_charge() {
        return adult20_charge;
    }

    public void setAdult20_charge(BigDecimal adult20_charge) {
        this.adult20_charge = adult20_charge;
    }

    public BigDecimal getAdult21_charge() {
        return adult21_charge;
    }

    public void setAdult21_charge(BigDecimal adult21_charge) {
        this.adult21_charge = adult21_charge;
    }

    public BigDecimal getAdult22_charge() {
        return adult22_charge;
    }

    public void setAdult22_charge(BigDecimal adult22_charge) {
        this.adult22_charge = adult22_charge;
    }

    public BigDecimal getAdult23_charge() {
        return adult23_charge;
    }

    public void setAdult23_charge(BigDecimal adult23_charge) {
        this.adult23_charge = adult23_charge;
    }

    public BigDecimal getAdult24_charge() {
        return adult24_charge;
    }

    public void setAdult24_charge(BigDecimal adult24_charge) {
        this.adult24_charge = adult24_charge;
    }

    public BigDecimal getAdult25_charge() {
        return adult25_charge;
    }

    public void setAdult25_charge(BigDecimal adult25_charge) {
        this.adult25_charge = adult25_charge;
    }

    public BigDecimal getAdult26_charge() {
        return adult26_charge;
    }

    public void setAdult26_charge(BigDecimal adult26_charge) {
        this.adult26_charge = adult26_charge;
    }

    public BigDecimal getAdult27_charge() {
        return adult27_charge;
    }

    public void setAdult27_charge(BigDecimal adult27_charge) {
        this.adult27_charge = adult27_charge;
    }

    public BigDecimal getAdult28_charge() {
        return adult28_charge;
    }

    public void setAdult28_charge(BigDecimal adult28_charge) {
        this.adult28_charge = adult28_charge;
    }

    public BigDecimal getAdult29_charge() {
        return adult29_charge;
    }

    public void setAdult29_charge(BigDecimal adult29_charge) {
        this.adult29_charge = adult29_charge;
    }

    public BigDecimal getAdult30_charge() {
        return adult30_charge;
    }

    public void setAdult30_charge(BigDecimal adult30_charge) {
        this.adult30_charge = adult30_charge;
    }

    public BigDecimal getAdult_extra_charge() {
        return adult_extra_charge;
    }

    public void setAdult_extra_charge(BigDecimal adult_extra_charge) {
        this.adult_extra_charge = adult_extra_charge;
    }

    public BigDecimal getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(BigDecimal base_rate) {
        this.base_rate = base_rate;
    }

    public BigDecimal getChild01_charge() {
        return child01_charge;
    }

    public void setChild01_charge(BigDecimal child01_charge) {
        this.child01_charge = child01_charge;
    }

    public BigDecimal getChild01_split2_charge() {
        return child01_split2_charge;
    }

    public void setChild01_split2_charge(BigDecimal child01_split2_charge) {
        this.child01_split2_charge = child01_split2_charge;
    }

    public BigDecimal getChild02_charge() {
        return child02_charge;
    }

    public void setChild02_charge(BigDecimal child02_charge) {
        this.child02_charge = child02_charge;
    }

    public BigDecimal getChild02_split2_charge() {
        return child02_split2_charge;
    }

    public void setChild02_split2_charge(BigDecimal child02_split2_charge) {
        this.child02_split2_charge = child02_split2_charge;
    }

    public BigDecimal getChild03_charge() {
        return child03_charge;
    }

    public void setChild03_charge(BigDecimal child03_charge) {
        this.child03_charge = child03_charge;
    }

    public BigDecimal getChild03_split2_charge() {
        return child03_split2_charge;
    }

    public void setChild03_split2_charge(BigDecimal child03_split2_charge) {
        this.child03_split2_charge = child03_split2_charge;
    }

    public BigDecimal getChild04_charge() {
        return child04_charge;
    }

    public void setChild04_charge(BigDecimal child04_charge) {
        this.child04_charge = child04_charge;
    }

    public BigDecimal getChild04_split2_charge() {
        return child04_split2_charge;
    }

    public void setChild04_split2_charge(BigDecimal child04_split2_charge) {
        this.child04_split2_charge = child04_split2_charge;
    }

    public BigDecimal getChild05_charge() {
        return child05_charge;
    }

    public void setChild05_charge(BigDecimal child05_charge) {
        this.child05_charge = child05_charge;
    }

    public BigDecimal getChild06_charge() {
        return child06_charge;
    }

    public void setChild06_charge(BigDecimal child06_charge) {
        this.child06_charge = child06_charge;
    }

    public BigDecimal getChild07_charge() {
        return child07_charge;
    }

    public void setChild07_charge(BigDecimal child07_charge) {
        this.child07_charge = child07_charge;
    }

    public BigDecimal getChild08_charge() {
        return child08_charge;
    }

    public void setChild08_charge(BigDecimal child08_charge) {
        this.child08_charge = child08_charge;
    }

    public BigDecimal getChild09_charge() {
        return child09_charge;
    }

    public void setChild09_charge(BigDecimal child09_charge) {
        this.child09_charge = child09_charge;
    }

    public BigDecimal getChild10_charge() {
        return child10_charge;
    }

    public void setChild10_charge(BigDecimal child10_charge) {
        this.child10_charge = child10_charge;
    }

    public BigDecimal getChild11_charge() {
        return child11_charge;
    }

    public void setChild11_charge(BigDecimal child11_charge) {
        this.child11_charge = child11_charge;
    }

    public BigDecimal getChild12_charge() {
        return child12_charge;
    }

    public void setChild12_charge(BigDecimal child12_charge) {
        this.child12_charge = child12_charge;
    }

    public BigDecimal getChild13_charge() {
        return child13_charge;
    }

    public void setChild13_charge(BigDecimal child13_charge) {
        this.child13_charge = child13_charge;
    }

    public BigDecimal getChild14_charge() {
        return child14_charge;
    }

    public void setChild14_charge(BigDecimal child14_charge) {
        this.child14_charge = child14_charge;
    }

    public BigDecimal getChild15_charge() {
        return child15_charge;
    }

    public void setChild15_charge(BigDecimal child15_charge) {
        this.child15_charge = child15_charge;
    }

    public BigDecimal getChild16_charge() {
        return child16_charge;
    }

    public void setChild16_charge(BigDecimal child16_charge) {
        this.child16_charge = child16_charge;
    }

    public BigDecimal getChild17_charge() {
        return child17_charge;
    }

    public void setChild17_charge(BigDecimal child17_charge) {
        this.child17_charge = child17_charge;
    }

    public BigDecimal getChild18_charge() {
        return child18_charge;
    }

    public void setChild18_charge(BigDecimal child18_charge) {
        this.child18_charge = child18_charge;
    }

    public BigDecimal getChild19_charge() {
        return child19_charge;
    }

    public void setChild19_charge(BigDecimal child19_charge) {
        this.child19_charge = child19_charge;
    }

    public BigDecimal getChild20_charge() {
        return child20_charge;
    }

    public void setChild20_charge(BigDecimal child20_charge) {
        this.child20_charge = child20_charge;
    }

    public BigDecimal getChild_charge() {
        return child_charge;
    }

    public void setChild_charge(BigDecimal child_charge) {
        this.child_charge = child_charge;
    }

    public BigDecimal getChild_extra_charge() {
        return child_extra_charge;
    }

    public void setChild_extra_charge(BigDecimal child_extra_charge) {
        this.child_extra_charge = child_extra_charge;
    }

    public BigDecimal getChild_extra_split2_charge() {
        return child_extra_split2_charge;
    }

    public void setChild_extra_split2_charge(BigDecimal child_extra_split2_charge) {
        this.child_extra_split2_charge = child_extra_split2_charge;
    }

    public BigDecimal getChild_split2_charge() {
        return child_split2_charge;
    }

    public void setChild_split2_charge(BigDecimal child_split2_charge) {
        this.child_split2_charge = child_split2_charge;
    }

    public BigDecimal getDouble_occ_charge() {
        return double_occ_charge;
    }

    public void setDouble_occ_charge(BigDecimal double_occ_charge) {
        this.double_occ_charge = double_occ_charge;
    }

    public BigDecimal getSingle_occ_charge() {
        return single_occ_charge;
    }

    public void setSingle_occ_charge(BigDecimal single_occ_charge) {
        this.single_occ_charge = single_occ_charge;
    }

    public BigDecimal getTriple_occ_charge() {
        return triple_occ_charge;
    }

    public void setTriple_occ_charge(BigDecimal triple_occ_charge) {
        this.triple_occ_charge = triple_occ_charge;
    }

    public BigDecimal getUnit_rate() {
        return unit_rate;
    }

    public void setUnit_rate(BigDecimal unit_rate) {
        this.unit_rate = unit_rate;
    }

    public BigDecimal getYouth01_charge() {
        return youth01_charge;
    }

    public void setYouth01_charge(BigDecimal youth01_charge) {
        this.youth01_charge = youth01_charge;
    }

    public BigDecimal getYouth01_split2_charge() {
        return youth01_split2_charge;
    }

    public void setYouth01_split2_charge(BigDecimal youth01_split2_charge) {
        this.youth01_split2_charge = youth01_split2_charge;
    }

    public BigDecimal getYouth02_charge() {
        return youth02_charge;
    }

    public void setYouth02_charge(BigDecimal youth02_charge) {
        this.youth02_charge = youth02_charge;
    }

    public BigDecimal getYouth02_split2_charge() {
        return youth02_split2_charge;
    }

    public void setYouth02_split2_charge(BigDecimal youth02_split2_charge) {
        this.youth02_split2_charge = youth02_split2_charge;
    }

    public BigDecimal getYouth03_charge() {
        return youth03_charge;
    }

    public void setYouth03_charge(BigDecimal youth03_charge) {
        this.youth03_charge = youth03_charge;
    }

    public BigDecimal getYouth03_split2_charge() {
        return youth03_split2_charge;
    }

    public void setYouth03_split2_charge(BigDecimal youth03_split2_charge) {
        this.youth03_split2_charge = youth03_split2_charge;
    }

    public BigDecimal getYouth04_charge() {
        return youth04_charge;
    }

    public void setYouth04_charge(BigDecimal youth04_charge) {
        this.youth04_charge = youth04_charge;
    }

    public BigDecimal getYouth04_split2_charge() {
        return youth04_split2_charge;
    }

    public void setYouth04_split2_charge(BigDecimal youth04_split2_charge) {
        this.youth04_split2_charge = youth04_split2_charge;
    }

    public BigDecimal getYouth05_charge() {
        return youth05_charge;
    }

    public void setYouth05_charge(BigDecimal youth05_charge) {
        this.youth05_charge = youth05_charge;
    }

    public BigDecimal getYouth06_charge() {
        return youth06_charge;
    }

    public void setYouth06_charge(BigDecimal youth06_charge) {
        this.youth06_charge = youth06_charge;
    }

    public BigDecimal getYouth07_charge() {
        return youth07_charge;
    }

    public void setYouth07_charge(BigDecimal youth07_charge) {
        this.youth07_charge = youth07_charge;
    }

    public BigDecimal getYouth08_charge() {
        return youth08_charge;
    }

    public void setYouth08_charge(BigDecimal youth08_charge) {
        this.youth08_charge = youth08_charge;
    }

    public BigDecimal getYouth09_charge() {
        return youth09_charge;
    }

    public void setYouth09_charge(BigDecimal youth09_charge) {
        this.youth09_charge = youth09_charge;
    }

    public BigDecimal getYouth10_charge() {
        return youth10_charge;
    }

    public void setYouth10_charge(BigDecimal youth10_charge) {
        this.youth10_charge = youth10_charge;
    }

    public BigDecimal getYouth11_charge() {
        return youth11_charge;
    }

    public void setYouth11_charge(BigDecimal youth11_charge) {
        this.youth11_charge = youth11_charge;
    }

    public BigDecimal getYouth12_charge() {
        return youth12_charge;
    }

    public void setYouth12_charge(BigDecimal youth12_charge) {
        this.youth12_charge = youth12_charge;
    }

    public BigDecimal getYouth13_charge() {
        return youth13_charge;
    }

    public void setYouth13_charge(BigDecimal youth13_charge) {
        this.youth13_charge = youth13_charge;
    }

    public BigDecimal getYouth14_charge() {
        return youth14_charge;
    }

    public void setYouth14_charge(BigDecimal youth14_charge) {
        this.youth14_charge = youth14_charge;
    }

    public BigDecimal getYouth15_charge() {
        return youth15_charge;
    }

    public void setYouth15_charge(BigDecimal youth15_charge) {
        this.youth15_charge = youth15_charge;
    }

    public BigDecimal getYouth16_charge() {
        return youth16_charge;
    }

    public void setYouth16_charge(BigDecimal youth16_charge) {
        this.youth16_charge = youth16_charge;
    }

    public BigDecimal getYouth17_charge() {
        return youth17_charge;
    }

    public void setYouth17_charge(BigDecimal youth17_charge) {
        this.youth17_charge = youth17_charge;
    }

    public BigDecimal getYouth18_charge() {
        return youth18_charge;
    }

    public void setYouth18_charge(BigDecimal youth18_charge) {
        this.youth18_charge = youth18_charge;
    }

    public BigDecimal getYouth19_charge() {
        return youth19_charge;
    }

    public void setYouth19_charge(BigDecimal youth19_charge) {
        this.youth19_charge = youth19_charge;
    }

    public BigDecimal getYouth20_charge() {
        return youth20_charge;
    }

    public void setYouth20_charge(BigDecimal youth20_charge) {
        this.youth20_charge = youth20_charge;
    }

    public BigDecimal getYouth_charge() {
        return youth_charge;
    }

    public void setYouth_charge(BigDecimal youth_charge) {
        this.youth_charge = youth_charge;
    }

    public BigDecimal getYouth_extra_charge() {
        return youth_extra_charge;
    }

    public void setYouth_extra_charge(BigDecimal youth_extra_charge) {
        this.youth_extra_charge = youth_extra_charge;
    }

    public BigDecimal getYouth_extra_split2_charge() {
        return youth_extra_split2_charge;
    }

    public void setYouth_extra_split2_charge(BigDecimal youth_extra_split2_charge) {
        this.youth_extra_split2_charge = youth_extra_split2_charge;
    }

    public BigDecimal getYouth_split2_charge() {
        return youth_split2_charge;
    }

    public void setYouth_split2_charge(BigDecimal youth_split2_charge) {
        this.youth_split2_charge = youth_split2_charge;
    }

    @Override
    public String toString() {
        return "Rate:{" +
                "ratePK=" + ratePK +
                ", adult02_charge=" + adult02_charge +
                ", adult03_charge=" + adult03_charge +
                ", adult04_charge=" + adult04_charge +
                ", adult05_charge=" + adult05_charge +
                ", adult06_charge=" + adult06_charge +
                ", adult07_charge=" + adult07_charge +
                ", adult08_charge=" + adult08_charge +
                ", adult09_charge=" + adult09_charge +
                ", adult10_charge=" + adult10_charge +
                ", adult11_charge=" + adult11_charge +
                ", adult12_charge=" + adult12_charge +
                ", adult13_charge=" + adult13_charge +
                ", adult14_charge=" + adult14_charge +
                ", adult15_charge=" + adult15_charge +
                ", adult16_charge=" + adult16_charge +
                ", adult17_charge=" + adult17_charge +
                ", adult18_charge=" + adult18_charge +
                ", adult19_charge=" + adult19_charge +
                ", adult20_charge=" + adult20_charge +
                ", adult21_charge=" + adult21_charge +
                ", adult22_charge=" + adult22_charge +
                ", adult23_charge=" + adult23_charge +
                ", adult24_charge=" + adult24_charge +
                ", adult25_charge=" + adult25_charge +
                ", adult26_charge=" + adult26_charge +
                ", adult27_charge=" + adult27_charge +
                ", adult28_charge=" + adult28_charge +
                ", adult29_charge=" + adult29_charge +
                ", adult30_charge=" + adult30_charge +
                ", adult_extra_charge=" + adult_extra_charge +
                ", base_rate=" + base_rate +
                ", child01_charge=" + child01_charge +
                ", child01_split2_charge=" + child01_split2_charge +
                ", child02_charge=" + child02_charge +
                ", child02_split2_charge=" + child02_split2_charge +
                ", child03_charge=" + child03_charge +
                ", child03_split2_charge=" + child03_split2_charge +
                ", child04_charge=" + child04_charge +
                ", child04_split2_charge=" + child04_split2_charge +
                ", child05_charge=" + child05_charge +
                ", child06_charge=" + child06_charge +
                ", child07_charge=" + child07_charge +
                ", child08_charge=" + child08_charge +
                ", child09_charge=" + child09_charge +
                ", child10_charge=" + child10_charge +
                ", child11_charge=" + child11_charge +
                ", child12_charge=" + child12_charge +
                ", child13_charge=" + child13_charge +
                ", child14_charge=" + child14_charge +
                ", child15_charge=" + child15_charge +
                ", child16_charge=" + child16_charge +
                ", child17_charge=" + child17_charge +
                ", child18_charge=" + child18_charge +
                ", child19_charge=" + child19_charge +
                ", child20_charge=" + child20_charge +
                ", child_charge=" + child_charge +
                ", child_extra_charge=" + child_extra_charge +
                ", child_extra_split2_charge=" + child_extra_split2_charge +
                ", child_split2_charge=" + child_split2_charge +
                ", double_occ_charge=" + double_occ_charge +
                ", single_occ_charge=" + single_occ_charge +
                ", triple_occ_charge=" + triple_occ_charge +
                ", unit_rate=" + unit_rate +
                ", youth01_charge=" + youth01_charge +
                ", youth01_split2_charge=" + youth01_split2_charge +
                ", youth02_charge=" + youth02_charge +
                ", youth02_split2_charge=" + youth02_split2_charge +
                ", youth03_charge=" + youth03_charge +
                ", youth03_split2_charge=" + youth03_split2_charge +
                ", youth04_charge=" + youth04_charge +
                ", youth04_split2_charge=" + youth04_split2_charge +
                ", youth05_charge=" + youth05_charge +
                ", youth06_charge=" + youth06_charge +
                ", youth07_charge=" + youth07_charge +
                ", youth08_charge=" + youth08_charge +
                ", youth09_charge=" + youth09_charge +
                ", youth10_charge=" + youth10_charge +
                ", youth11_charge=" + youth11_charge +
                ", youth12_charge=" + youth12_charge +
                ", youth13_charge=" + youth13_charge +
                ", youth14_charge=" + youth14_charge +
                ", youth15_charge=" + youth15_charge +
                ", youth16_charge=" + youth16_charge +
                ", youth17_charge=" + youth17_charge +
                ", youth18_charge=" + youth18_charge +
                ", youth19_charge=" + youth19_charge +
                ", youth20_charge=" + youth20_charge +
                ", youth_charge=" + youth_charge +
                ", youth_extra_charge=" + youth_extra_charge +
                ", youth_extra_split2_charge=" + youth_extra_split2_charge +
                ", youth_split2_charge=" + youth_split2_charge +
                '}';
    }
}
