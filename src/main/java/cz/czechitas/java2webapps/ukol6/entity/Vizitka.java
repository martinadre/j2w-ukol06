package cz.czechitas.java2webapps.ukol6.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
public class Vizitka {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Length(max = 100)
    private String celeJmeno;

    @NotBlank
    @Length(max = 100)
    private String firma;

    @NotBlank
    @Length(max = 100)
    private String ulice;

    @NotBlank
    @Length(max = 100)
    private String obec;

    @NotBlank
    @Pattern(regexp = "\\d{5}")
    private String psc;

    @Length(max = 100)
    @Email
    private String email;

    @Length(min = 9, max = 20)
    @Pattern(regexp = "\\+?\\d+")
    private String telefon;

    @Length(max = 100)
    private String web;


    public Vizitka() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCeleJmeno() {
        return celeJmeno;
    }

    public void setCeleJmeno(String celeJmeno) {
        this.celeJmeno = celeJmeno;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getUlice() {
        return ulice;
    }

    public void setUlice(String ulice) {
        this.ulice = ulice;
    }

    public String getObec() {
        return obec;
    }

    public void setObec(String obec) {
        this.obec = obec;
    }

    public String getPsc() {
        return psc;
    }

    public void setPsc(String psc) {
        this.psc = psc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCelaAdresa () {
        return ulice + ", " + obec + ", " + psc;
    }


}
