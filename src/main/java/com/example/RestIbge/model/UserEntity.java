package com.example.RestIbge.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class UserEntity {

    @Id
    private String noticiasRelease;
    private String tipodeNoticias;
    private String release;



    // Método construtor da classe
    public UserEntity(String noticiasRelease, String tipodeNoticias, String release) {
        this.noticiasRelease = noticiasRelease;
        this.tipodeNoticias = tipodeNoticias;
        this.release = release;
    }

    public UserEntity() {

    }

    // Getters e Setters
    public String getNoticiasRelease() {
        return noticiasRelease;
    }

    public void setNoticiasRelease(String noticiasRelease) {
        this.noticiasRelease = noticiasRelease;
    }

    public String getTipodeNoticias() {
        return tipodeNoticias;
    }

    public void setTipodeNoticias(String tipodeNoticias) {
        this.tipodeNoticias = tipodeNoticias;
    }

    public String getRelease() {
        return release;
    }
    public void setRelease(String date) {
        this.release = release;
    }

}