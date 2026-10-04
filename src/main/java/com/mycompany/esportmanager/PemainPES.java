package com.mycompany.esportmanager;

public class PemainPES extends Pemain {
    private String klubAndalan;

    public PemainPES(String nickname, String namaAsli, int usia, String klubAndalan) {
        super(nickname, namaAsli, usia);
        this.setKlubAndalan(klubAndalan);
    }

    public String getKlubAndalan() { return this.klubAndalan; }

    public void setKlubAndalan(String klubAndalan) {
        if (klubAndalan == null || klubAndalan.trim().isEmpty()) {
            this.klubAndalan = "Belum ada";
        } else {
            this.klubAndalan = klubAndalan.trim();
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[%-14s] ", "PES");
        super.tampilkanInfo();
        System.out.printf(" | Klub Andalan: %s%n", this.klubAndalan);
    }

    @Override
    public void caraLatihan() {
        System.out.println("-> Info Latihan: Sparring 1v1 online memakai klub " + this.klubAndalan + ".");
    }
}
