/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author VINAY
 */
public class Voter {
    
    private StringProperty gothram;
    private StringProperty name;
    private StringProperty surname;
    private StringProperty fatherName;
    private StringProperty motherName;
    private StringProperty childMale1;
    private StringProperty childMale2;
    private StringProperty childFemale1;
    private StringProperty childFemale2;
    private StringProperty profession;
    private StringProperty newspaper;
    private StringProperty mobile;
    private StringProperty landline;
    private StringProperty receipt;
    private StringProperty receipt_per;
    private StringProperty municipalward;
    private StringProperty Add_name;
    private StringProperty door_no;
    private StringProperty street;
    private StringProperty landmark;
    
    private BooleanProperty house;
    private BooleanProperty ration;
    private BooleanProperty aadhar;
    private BooleanProperty voter;
    private BooleanProperty gas;
    private BooleanProperty tap;
    private BooleanProperty bank_acc;

    public Voter() {
        this.gothram = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.surname = new SimpleStringProperty();
        this.fatherName = new SimpleStringProperty();
        this.motherName = new SimpleStringProperty();
        this.childMale1 = new SimpleStringProperty();
        this.childMale2 = new SimpleStringProperty();
        this.childFemale1 = new SimpleStringProperty();
        this.childFemale2 = new SimpleStringProperty();
        this.profession = new SimpleStringProperty();
        this.newspaper = new SimpleStringProperty();
        this.mobile = new SimpleStringProperty();
        this.landline = new SimpleStringProperty();
        this.receipt = new SimpleStringProperty();
        this.receipt_per = new SimpleStringProperty();
        this.municipalward = new SimpleStringProperty();
        this.Add_name = new SimpleStringProperty();
        this.door_no = new SimpleStringProperty();
        this.street = new SimpleStringProperty();
        this.landmark = new SimpleStringProperty();
        this.house = new SimpleBooleanProperty();
        this.ration = new SimpleBooleanProperty();
        this.aadhar = new SimpleBooleanProperty();
        this.voter = new SimpleBooleanProperty();
        this.gas = new SimpleBooleanProperty();
        this.tap = new SimpleBooleanProperty();
        this.bank_acc = new SimpleBooleanProperty();
    }

    public String getGothram() {
        return gothram.get();
    }

    public void setGothram(String gothram) {
        this.gothram.set(gothram);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getFatherName() {
        return fatherName.get();
    }

    public void setFatherName(String fatherName) {
        this.fatherName.set(fatherName);
    }

    public String getMotherName() {
        return motherName.get();
    }

    public void setMotherName(String motherName) {
        this.motherName.set(motherName);
    }

    public String getChildMale1() {
        return childMale1.get();
    }

    public void setChildMale1(String childMale1) {
        this.childMale1.set(childMale1);
    }

    public String getChildMale2() {
        return childMale2.get();
    }

    public void setChildMale2(String childMale2) {
        this.childMale2.set(childMale2);
    }

    public String getChildFemale1() {
        return childFemale1.get();
    }

    public void setChildFemale1(String childFemale1) {
        this.childFemale1.set(childFemale1);
    }

    public String getChildFemale2() {
        return childFemale2.get();
    }

    public void setChildFemale2(String childFemale2) {
        this.childFemale2.set(childFemale2);
    }

    public String getProfession() {
        return profession.get();
    }

    public void setProfession(String profession) {
        this.profession.set(profession);
    }

    public String getNewspaper() {
        return newspaper.get();
    }

    public void setNewspaper(String newspaper) {
        this.newspaper.set(newspaper);
    }

    public String getMobile() {
        return mobile.get();
    }

    public void setMobile(String mobile) {
        this.mobile.set(mobile);
    }

    public String getLandline() {
        return landline.get();
    }

    public void setLandline(String landline) {
        this.landline.set(landline);
    }

    public String getReceipt() {
        return receipt.get();
    }

    public void setReceipt(String receipt) {
        this.receipt.set(receipt);
    }

    public String getReceipt_per() {
        return receipt_per.get();
    }

    public void setReceipt_per(String receipt_per) {
        this.receipt_per.set(receipt_per);
    }

    public String getMunicipalward() {
        return municipalward.get();
    }

    public void setMunicipalward(String municipalward) {
        this.municipalward.set(municipalward);
    }

    public String getAdd_name() {
        return Add_name.get();
    }

    public void setAdd_name(String Add_name) {
        this.Add_name.set(Add_name);
    }

    public String getDoor_no() {
        return door_no.get();
    }

    public void setDoor_no(String door_no) {
        this.door_no.set(door_no);
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public String getLandmark() {
        return landmark.get();
    }

    public void setLandmark(String landmark) {
        this.landmark.set(landmark);
    }

    public Boolean getHouse() {
        return house.get();
    }

    public void setHouse(Boolean house) {
        this.house.set(house);
    }

    public Boolean getRation() {
        return ration.get();
    }

    public void setRation(Boolean ration) {
        this.ration.set(ration);
    }

    public Boolean getAadhar() {
        return aadhar.get();
    }

    public void setAadhar(Boolean aadhar) {
        this.aadhar.set(aadhar);
    }

    public Boolean getVoter() {
        return voter.get();
    }

    public void setVoter(Boolean voter) {
        this.voter.set(voter);
    }

    public Boolean getGas() {
        return gas.get();
    }

    public void setGas(Boolean gas) {
        this.gas.set(gas);
    }

    public Boolean getTap() {
        return tap.get();
    }

    public void setTap(Boolean tap) {
        this.tap.set(tap);
    }

    public Boolean getBank_acc() {
        return bank_acc.get();
    }

    public void setBank_acc(Boolean bank_acc) {
        this.bank_acc.set(bank_acc);
    }
    
    
    
    
}
