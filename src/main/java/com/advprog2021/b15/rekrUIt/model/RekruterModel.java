package com.advprog2021.b15.rekrUIt.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Rekruter")
public class RekruterModel extends UserModel{

    @Column
    private String namaRekruter;

    @Column
    private String deskripsiRekruter;
}
