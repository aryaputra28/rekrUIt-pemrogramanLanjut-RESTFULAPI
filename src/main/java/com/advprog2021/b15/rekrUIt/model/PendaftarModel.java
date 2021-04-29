package com.advprog2021.b15.rekrUIt.model;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Pendaftar")
public class PendaftarModel extends UserModel {

    @Column
    private String npm;

    @Column
    private String namaLengkap;

    @Column
    private String fakultas;

    @Column
    private String kontak;

}
