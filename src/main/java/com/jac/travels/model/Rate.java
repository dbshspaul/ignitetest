package com.jac.travels.model;

import com.datastax.driver.core.LocalDate;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("rate")
public class Rate {
    @PrimaryKey
    private LocalDate stay_date;
    private Integer rate_plan_id;
    private Float adult02_charge;
    private Float adult03_charge;
    private Float adult04_charge;
    private Float adult05_charge;
    private Float adult06_charge;
    private Float adult07_charge;
    private Float adult08_charge;
    private Float adult09_charge;
    private Float adult10_charge;
    private Float adult11_charge;
    private Float adult12_charge;
    private Float adult13_charge;
    private Float adult14_charge;
    private Float adult15_charge;
    private Float adult16_charge;
    private Float adult17_charge;
    private Float adult18_charge;
    private Float adult19_charge;
    private Float adult20_charge;
    private Float adult21_charge;
    private Float adult22_charge;
    private Float adult23_charge;
    private Float adult24_charge;
    private Float adult25_charge;
    private Float adult26_charge;
    private Float adult27_charge;
    private Float adult28_charge;
    private Float adult29_charge;
    private Float adult30_charge;
    private Float adult_extra_charge;
    private Float base_rate;
    private Float child01_charge;
    private Float child01_split2_charge;
    private Float child02_charge;
    private Float child02_split2_charge;
    private Float child03_charge;
    private Float child03_split2_charge;
    private Float child04_charge;
    private Float child04_split2_charge;
    private Float child05_charge;
    private Float child06_charge;
    private Float child07_charge;
    private Float child08_charge;
    private Float child09_charge;
    private Float child10_charge;
    private Float child11_charge;
    private Float child12_charge;
    private Float child13_charge;
    private Float child14_charge;
    private Float child15_charge;
    private Float child16_charge;
    private Float child17_charge;
    private Float child18_charge;
    private Float child19_charge;
    private Float child20_charge;
    private Float child_charge;
    private Float child_extra_charge;
    private Float child_extra_split2_charge;
    private Float child_split2_charge;
    private Float double_occ_charge;
    private Float single_occ_charge;
    private Float triple_occ_charge;
    private Float unit_rate;
    private Float youth01_charge;
    private Float youth01_split2_charge;
    private Float youth02_charge;
    private Float youth02_split2_charge;
    private Float youth03_charge;
    private Float youth03_split2_charge;
    private Float youth04_charge;
    private Float youth04_split2_charge;
    private Float youth05_charge;
    private Float youth06_charge;
    private Float youth07_charge;
    private Float youth08_charge;
    private Float youth09_charge;
    private Float youth10_charge;
    private Float youth11_charge;
    private Float youth12_charge;
    private Float youth13_charge;
    private Float youth14_charge;
    private Float youth15_charge;
    private Float youth16_charge;
    private Float youth17_charge;
    private Float youth18_charge;
    private Float youth19_charge;
    private Float youth20_charge;
    private Float youth_charge;
    private Float youth_extra_charge;
    private Float youth_extra_split2_charge;
    private Float youth_split2_charge;

    public Integer getRate_plan_id() {
        return rate_plan_id;
    }

    public void setRate_plan_id(Integer rate_plan_id) {
        this.rate_plan_id = rate_plan_id;
    }

    public LocalDate getStay_date() {
        return stay_date;
    }

    public void setStay_date(LocalDate stay_date) {
        this.stay_date = stay_date;
    }

    public Float getAdult02_charge() {
        return adult02_charge;
    }

    public void setAdult02_charge(Float adult02_charge) {
        this.adult02_charge = adult02_charge;
    }

    public Float getAdult03_charge() {
        return adult03_charge;
    }

    public void setAdult03_charge(Float adult03_charge) {
        this.adult03_charge = adult03_charge;
    }

    public Float getAdult04_charge() {
        return adult04_charge;
    }

    public void setAdult04_charge(Float adult04_charge) {
        this.adult04_charge = adult04_charge;
    }

    public Float getAdult05_charge() {
        return adult05_charge;
    }

    public void setAdult05_charge(Float adult05_charge) {
        this.adult05_charge = adult05_charge;
    }

    public Float getAdult06_charge() {
        return adult06_charge;
    }

    public void setAdult06_charge(Float adult06_charge) {
        this.adult06_charge = adult06_charge;
    }

    public Float getAdult07_charge() {
        return adult07_charge;
    }

    public void setAdult07_charge(Float adult07_charge) {
        this.adult07_charge = adult07_charge;
    }

    public Float getAdult08_charge() {
        return adult08_charge;
    }

    public void setAdult08_charge(Float adult08_charge) {
        this.adult08_charge = adult08_charge;
    }

    public Float getAdult09_charge() {
        return adult09_charge;
    }

    public void setAdult09_charge(Float adult09_charge) {
        this.adult09_charge = adult09_charge;
    }

    public Float getAdult10_charge() {
        return adult10_charge;
    }

    public void setAdult10_charge(Float adult10_charge) {
        this.adult10_charge = adult10_charge;
    }

    public Float getAdult11_charge() {
        return adult11_charge;
    }

    public void setAdult11_charge(Float adult11_charge) {
        this.adult11_charge = adult11_charge;
    }

    public Float getAdult12_charge() {
        return adult12_charge;
    }

    public void setAdult12_charge(Float adult12_charge) {
        this.adult12_charge = adult12_charge;
    }

    public Float getAdult13_charge() {
        return adult13_charge;
    }

    public void setAdult13_charge(Float adult13_charge) {
        this.adult13_charge = adult13_charge;
    }

    public Float getAdult14_charge() {
        return adult14_charge;
    }

    public void setAdult14_charge(Float adult14_charge) {
        this.adult14_charge = adult14_charge;
    }

    public Float getAdult15_charge() {
        return adult15_charge;
    }

    public void setAdult15_charge(Float adult15_charge) {
        this.adult15_charge = adult15_charge;
    }

    public Float getAdult16_charge() {
        return adult16_charge;
    }

    public void setAdult16_charge(Float adult16_charge) {
        this.adult16_charge = adult16_charge;
    }

    public Float getAdult17_charge() {
        return adult17_charge;
    }

    public void setAdult17_charge(Float adult17_charge) {
        this.adult17_charge = adult17_charge;
    }

    public Float getAdult18_charge() {
        return adult18_charge;
    }

    public void setAdult18_charge(Float adult18_charge) {
        this.adult18_charge = adult18_charge;
    }

    public Float getAdult19_charge() {
        return adult19_charge;
    }

    public void setAdult19_charge(Float adult19_charge) {
        this.adult19_charge = adult19_charge;
    }

    public Float getAdult20_charge() {
        return adult20_charge;
    }

    public void setAdult20_charge(Float adult20_charge) {
        this.adult20_charge = adult20_charge;
    }

    public Float getAdult21_charge() {
        return adult21_charge;
    }

    public void setAdult21_charge(Float adult21_charge) {
        this.adult21_charge = adult21_charge;
    }

    public Float getAdult22_charge() {
        return adult22_charge;
    }

    public void setAdult22_charge(Float adult22_charge) {
        this.adult22_charge = adult22_charge;
    }

    public Float getAdult23_charge() {
        return adult23_charge;
    }

    public void setAdult23_charge(Float adult23_charge) {
        this.adult23_charge = adult23_charge;
    }

    public Float getAdult24_charge() {
        return adult24_charge;
    }

    public void setAdult24_charge(Float adult24_charge) {
        this.adult24_charge = adult24_charge;
    }

    public Float getAdult25_charge() {
        return adult25_charge;
    }

    public void setAdult25_charge(Float adult25_charge) {
        this.adult25_charge = adult25_charge;
    }

    public Float getAdult26_charge() {
        return adult26_charge;
    }

    public void setAdult26_charge(Float adult26_charge) {
        this.adult26_charge = adult26_charge;
    }

    public Float getAdult27_charge() {
        return adult27_charge;
    }

    public void setAdult27_charge(Float adult27_charge) {
        this.adult27_charge = adult27_charge;
    }

    public Float getAdult28_charge() {
        return adult28_charge;
    }

    public void setAdult28_charge(Float adult28_charge) {
        this.adult28_charge = adult28_charge;
    }

    public Float getAdult29_charge() {
        return adult29_charge;
    }

    public void setAdult29_charge(Float adult29_charge) {
        this.adult29_charge = adult29_charge;
    }

    public Float getAdult30_charge() {
        return adult30_charge;
    }

    public void setAdult30_charge(Float adult30_charge) {
        this.adult30_charge = adult30_charge;
    }

    public Float getAdult_extra_charge() {
        return adult_extra_charge;
    }

    public void setAdult_extra_charge(Float adult_extra_charge) {
        this.adult_extra_charge = adult_extra_charge;
    }

    public Float getBase_rate() {
        return base_rate;
    }

    public void setBase_rate(Float base_rate) {
        this.base_rate = base_rate;
    }

    public Float getChild01_charge() {
        return child01_charge;
    }

    public void setChild01_charge(Float child01_charge) {
        this.child01_charge = child01_charge;
    }

    public Float getChild01_split2_charge() {
        return child01_split2_charge;
    }

    public void setChild01_split2_charge(Float child01_split2_charge) {
        this.child01_split2_charge = child01_split2_charge;
    }

    public Float getChild02_charge() {
        return child02_charge;
    }

    public void setChild02_charge(Float child02_charge) {
        this.child02_charge = child02_charge;
    }

    public Float getChild02_split2_charge() {
        return child02_split2_charge;
    }

    public void setChild02_split2_charge(Float child02_split2_charge) {
        this.child02_split2_charge = child02_split2_charge;
    }

    public Float getChild03_charge() {
        return child03_charge;
    }

    public void setChild03_charge(Float child03_charge) {
        this.child03_charge = child03_charge;
    }

    public Float getChild03_split2_charge() {
        return child03_split2_charge;
    }

    public void setChild03_split2_charge(Float child03_split2_charge) {
        this.child03_split2_charge = child03_split2_charge;
    }

    public Float getChild04_charge() {
        return child04_charge;
    }

    public void setChild04_charge(Float child04_charge) {
        this.child04_charge = child04_charge;
    }

    public Float getChild04_split2_charge() {
        return child04_split2_charge;
    }

    public void setChild04_split2_charge(Float child04_split2_charge) {
        this.child04_split2_charge = child04_split2_charge;
    }

    public Float getChild05_charge() {
        return child05_charge;
    }

    public void setChild05_charge(Float child05_charge) {
        this.child05_charge = child05_charge;
    }

    public Float getChild06_charge() {
        return child06_charge;
    }

    public void setChild06_charge(Float child06_charge) {
        this.child06_charge = child06_charge;
    }

    public Float getChild07_charge() {
        return child07_charge;
    }

    public void setChild07_charge(Float child07_charge) {
        this.child07_charge = child07_charge;
    }

    public Float getChild08_charge() {
        return child08_charge;
    }

    public void setChild08_charge(Float child08_charge) {
        this.child08_charge = child08_charge;
    }

    public Float getChild09_charge() {
        return child09_charge;
    }

    public void setChild09_charge(Float child09_charge) {
        this.child09_charge = child09_charge;
    }

    public Float getChild10_charge() {
        return child10_charge;
    }

    public void setChild10_charge(Float child10_charge) {
        this.child10_charge = child10_charge;
    }

    public Float getChild11_charge() {
        return child11_charge;
    }

    public void setChild11_charge(Float child11_charge) {
        this.child11_charge = child11_charge;
    }

    public Float getChild12_charge() {
        return child12_charge;
    }

    public void setChild12_charge(Float child12_charge) {
        this.child12_charge = child12_charge;
    }

    public Float getChild13_charge() {
        return child13_charge;
    }

    public void setChild13_charge(Float child13_charge) {
        this.child13_charge = child13_charge;
    }

    public Float getChild14_charge() {
        return child14_charge;
    }

    public void setChild14_charge(Float child14_charge) {
        this.child14_charge = child14_charge;
    }

    public Float getChild15_charge() {
        return child15_charge;
    }

    public void setChild15_charge(Float child15_charge) {
        this.child15_charge = child15_charge;
    }

    public Float getChild16_charge() {
        return child16_charge;
    }

    public void setChild16_charge(Float child16_charge) {
        this.child16_charge = child16_charge;
    }

    public Float getChild17_charge() {
        return child17_charge;
    }

    public void setChild17_charge(Float child17_charge) {
        this.child17_charge = child17_charge;
    }

    public Float getChild18_charge() {
        return child18_charge;
    }

    public void setChild18_charge(Float child18_charge) {
        this.child18_charge = child18_charge;
    }

    public Float getChild19_charge() {
        return child19_charge;
    }

    public void setChild19_charge(Float child19_charge) {
        this.child19_charge = child19_charge;
    }

    public Float getChild20_charge() {
        return child20_charge;
    }

    public void setChild20_charge(Float child20_charge) {
        this.child20_charge = child20_charge;
    }

    public Float getChild_charge() {
        return child_charge;
    }

    public void setChild_charge(Float child_charge) {
        this.child_charge = child_charge;
    }

    public Float getChild_extra_charge() {
        return child_extra_charge;
    }

    public void setChild_extra_charge(Float child_extra_charge) {
        this.child_extra_charge = child_extra_charge;
    }

    public Float getChild_extra_split2_charge() {
        return child_extra_split2_charge;
    }

    public void setChild_extra_split2_charge(Float child_extra_split2_charge) {
        this.child_extra_split2_charge = child_extra_split2_charge;
    }

    public Float getChild_split2_charge() {
        return child_split2_charge;
    }

    public void setChild_split2_charge(Float child_split2_charge) {
        this.child_split2_charge = child_split2_charge;
    }

    public Float getDouble_occ_charge() {
        return double_occ_charge;
    }

    public void setDouble_occ_charge(Float double_occ_charge) {
        this.double_occ_charge = double_occ_charge;
    }

    public Float getSingle_occ_charge() {
        return single_occ_charge;
    }

    public void setSingle_occ_charge(Float single_occ_charge) {
        this.single_occ_charge = single_occ_charge;
    }

    public Float getTriple_occ_charge() {
        return triple_occ_charge;
    }

    public void setTriple_occ_charge(Float triple_occ_charge) {
        this.triple_occ_charge = triple_occ_charge;
    }

    public Float getUnit_rate() {
        return unit_rate;
    }

    public void setUnit_rate(Float unit_rate) {
        this.unit_rate = unit_rate;
    }

    public Float getYouth01_charge() {
        return youth01_charge;
    }

    public void setYouth01_charge(Float youth01_charge) {
        this.youth01_charge = youth01_charge;
    }

    public Float getYouth01_split2_charge() {
        return youth01_split2_charge;
    }

    public void setYouth01_split2_charge(Float youth01_split2_charge) {
        this.youth01_split2_charge = youth01_split2_charge;
    }

    public Float getYouth02_charge() {
        return youth02_charge;
    }

    public void setYouth02_charge(Float youth02_charge) {
        this.youth02_charge = youth02_charge;
    }

    public Float getYouth02_split2_charge() {
        return youth02_split2_charge;
    }

    public void setYouth02_split2_charge(Float youth02_split2_charge) {
        this.youth02_split2_charge = youth02_split2_charge;
    }

    public Float getYouth03_charge() {
        return youth03_charge;
    }

    public void setYouth03_charge(Float youth03_charge) {
        this.youth03_charge = youth03_charge;
    }

    public Float getYouth03_split2_charge() {
        return youth03_split2_charge;
    }

    public void setYouth03_split2_charge(Float youth03_split2_charge) {
        this.youth03_split2_charge = youth03_split2_charge;
    }

    public Float getYouth04_charge() {
        return youth04_charge;
    }

    public void setYouth04_charge(Float youth04_charge) {
        this.youth04_charge = youth04_charge;
    }

    public Float getYouth04_split2_charge() {
        return youth04_split2_charge;
    }

    public void setYouth04_split2_charge(Float youth04_split2_charge) {
        this.youth04_split2_charge = youth04_split2_charge;
    }

    public Float getYouth05_charge() {
        return youth05_charge;
    }

    public void setYouth05_charge(Float youth05_charge) {
        this.youth05_charge = youth05_charge;
    }

    public Float getYouth06_charge() {
        return youth06_charge;
    }

    public void setYouth06_charge(Float youth06_charge) {
        this.youth06_charge = youth06_charge;
    }

    public Float getYouth07_charge() {
        return youth07_charge;
    }

    public void setYouth07_charge(Float youth07_charge) {
        this.youth07_charge = youth07_charge;
    }

    public Float getYouth08_charge() {
        return youth08_charge;
    }

    public void setYouth08_charge(Float youth08_charge) {
        this.youth08_charge = youth08_charge;
    }

    public Float getYouth09_charge() {
        return youth09_charge;
    }

    public void setYouth09_charge(Float youth09_charge) {
        this.youth09_charge = youth09_charge;
    }

    public Float getYouth10_charge() {
        return youth10_charge;
    }

    public void setYouth10_charge(Float youth10_charge) {
        this.youth10_charge = youth10_charge;
    }

    public Float getYouth11_charge() {
        return youth11_charge;
    }

    public void setYouth11_charge(Float youth11_charge) {
        this.youth11_charge = youth11_charge;
    }

    public Float getYouth12_charge() {
        return youth12_charge;
    }

    public void setYouth12_charge(Float youth12_charge) {
        this.youth12_charge = youth12_charge;
    }

    public Float getYouth13_charge() {
        return youth13_charge;
    }

    public void setYouth13_charge(Float youth13_charge) {
        this.youth13_charge = youth13_charge;
    }

    public Float getYouth14_charge() {
        return youth14_charge;
    }

    public void setYouth14_charge(Float youth14_charge) {
        this.youth14_charge = youth14_charge;
    }

    public Float getYouth15_charge() {
        return youth15_charge;
    }

    public void setYouth15_charge(Float youth15_charge) {
        this.youth15_charge = youth15_charge;
    }

    public Float getYouth16_charge() {
        return youth16_charge;
    }

    public void setYouth16_charge(Float youth16_charge) {
        this.youth16_charge = youth16_charge;
    }

    public Float getYouth17_charge() {
        return youth17_charge;
    }

    public void setYouth17_charge(Float youth17_charge) {
        this.youth17_charge = youth17_charge;
    }

    public Float getYouth18_charge() {
        return youth18_charge;
    }

    public void setYouth18_charge(Float youth18_charge) {
        this.youth18_charge = youth18_charge;
    }

    public Float getYouth19_charge() {
        return youth19_charge;
    }

    public void setYouth19_charge(Float youth19_charge) {
        this.youth19_charge = youth19_charge;
    }

    public Float getYouth20_charge() {
        return youth20_charge;
    }

    public void setYouth20_charge(Float youth20_charge) {
        this.youth20_charge = youth20_charge;
    }

    public Float getYouth_charge() {
        return youth_charge;
    }

    public void setYouth_charge(Float youth_charge) {
        this.youth_charge = youth_charge;
    }

    public Float getYouth_extra_charge() {
        return youth_extra_charge;
    }

    public void setYouth_extra_charge(Float youth_extra_charge) {
        this.youth_extra_charge = youth_extra_charge;
    }

    public Float getYouth_extra_split2_charge() {
        return youth_extra_split2_charge;
    }

    public void setYouth_extra_split2_charge(Float youth_extra_split2_charge) {
        this.youth_extra_split2_charge = youth_extra_split2_charge;
    }

    public Float getYouth_split2_charge() {
        return youth_split2_charge;
    }

    public void setYouth_split2_charge(Float youth_split2_charge) {
        this.youth_split2_charge = youth_split2_charge;
    }

    @Override
    public String toString() {
        return "Rate:{" +
                "rate_plan_id=" + rate_plan_id +
                ", stay_date='" + stay_date + '\'' +
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
