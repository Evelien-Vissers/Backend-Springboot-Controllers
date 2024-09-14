package com.techiteasy.demo.models;
//De 'models' vertegenwoordigen de data-objecten die worden opgeslagen in de database. Deze klasse kan gebruikt worden om een tabel te genereren in de database via JPA.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//@Entity markeert deze klasse als een JPA-entiteit (wat betekent dat deze overeenkomst met een tabel in de database)
@Entity
public class Television {

    @Id //Dit attribuut geeft aan dat het veld 'id' de primaire sleutel is.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Deze annotatie zorgt ervoor dat de waarde van 'id' automatisch wordt gegenereerd door de database wanneer een nieuwe rij wordt ingevoegd
    private long id;
    private String type;
    private String brand;
    private String name;
    private Double price;
    private Double availableSize;
    private Integer refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambilight;
    private Integer originalStock;
    private Integer sold;

    //Default constructor - dit is handig wanneer je een object wilt aanmaken zonder onmiddellijk waarden toe te wijzen aan de velden.
    public Television() {

    }
    //Constructor met parameters - initialiseert specifieke waarden
    public Television(String type, String brand, String name, Double price, Double availableSize, Integer refreshRate, String screenType, String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl, Boolean hdr, Boolean bluetooth, Integer originalStock, Integer sold) {
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.originalStock = originalStock;
        this.sold = sold;
    }
    //Getters en setters - de methodes die worden gebruikt om toegang te krijgen tot en het wijzigen van de waarden van de velden in een object.
    //Getters - methodes die toestaan om de waarde van een prive-veld/variabele van een object op te halen en worden gebruikt om informatie van een object te lezen zonder de waarde van het veld direct te wijzigen
    //Setters - methodes waarmee je de waarde van een prive-veld kan wijzigen en wordt gebruikt om een waarde toe te wijzen aan een veld in een object.

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Double getAvailableSize() {
        return availableSize;
    }
    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }
    public Integer getRefreshRate() {
        return refreshRate;
    }
    public void setRefreshRate(Integer refreshRate) {
        this.refreshRate = refreshRate;
    }
    public String getScreenType() {
        return screenType;
    }
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
    public String getScreenQuality() {
        return screenQuality;
    }
    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }
    public Boolean getSmartTv() {
        return smartTv;
    }
    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }
    public Boolean getWifi() {
        return wifi;
    }
    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }
    public Boolean getVoiceControl() {
        return voiceControl;
    }
    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }
    public Boolean getHdr() {
        return hdr;
    }
    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }
    public Boolean getBluetooth() {
        return bluetooth;
    }
    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }
    public Integer getOriginalStock() {
        return originalStock;
    }
    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }
    public Integer getSold() {
        return sold;
    }
    public void setSold(Integer sold) {
        this.sold = sold;
    }

}

