package com.extendo.LOB.entity;


import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "new_table")
public class Lob {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    @NotNull
    private String lobCode;
    @Column
    private String lobDescription;
    @Column
    private String lobShortDescription;
    @Column
    private String lobUrl;
    @Column
    private String lobDescriptionByLink;
    @Column
    private Date lobEffectiveFromDate;
    @Column
    private Date lobEffectiveTill;

    public Lob(){

    }


    public String getLobCode() {
        return lobCode;
    }

    public void setLobCode(String lobCode) {
        this.lobCode = lobCode;
    }

    public String getLobDescription() {
        return lobDescription;
    }

    public void setLobDescription(String lobDescription) {
        this.lobDescription = lobDescription;
    }

    public String getLobShortDescription() {
        return lobShortDescription;
    }

    public void setLobShortDescription(String lobShortDescription) {
        this.lobShortDescription = lobShortDescription;
    }

    public String getLobUrl() {
        return lobUrl;
    }

    public void setLobUrl(String lobUrl) {
        this.lobUrl = lobUrl;
    }

    public String getLobDescriptionByLink() {
        return lobDescriptionByLink;
    }

    public void setLobDescriptionByLink(String lobDescriptionByLink) {
        this.lobDescriptionByLink = lobDescriptionByLink;
    }

    public Date getLobEffectiveFromDate() {
        return lobEffectiveFromDate;
    }

    public void setLobEffectiveFromDate(Date lobEffectiveFromDate) {
        this.lobEffectiveFromDate = lobEffectiveFromDate;
    }

    public Date getLobEffectiveTill() {
        return lobEffectiveTill;
    }

    public void setLobEffectiveTill(Date lobEffectiveTill) {
        this.lobEffectiveTill = lobEffectiveTill;
    }


    public Lob orElseThrow(Object o) {
        return null;
    }

    public Lob orElse(Object o) {
        return null;
    }
}
