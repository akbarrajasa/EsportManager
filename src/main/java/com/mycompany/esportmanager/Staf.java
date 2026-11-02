package com.mycompany.esportmanager;

public class Staf {
    private String kode;
    private String nama;

    public Staf(String kode, String nama) throws Exception {
        if (kode == null || kode.trim().isEmpty()) {
            throw new Exception("Kode staf tidak boleh kosong!");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new Exception("Nama staf tidak boleh kosong!");
        }
        this.kode = kode.trim();
        this.nama = nama.trim();
    }

    public String getKode() { return kode; }
    public String getNama() { return nama; }
}
