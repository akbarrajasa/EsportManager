package com.mycompany.esportmanager;

public class Pemain {
    private String nickname;
    private String namaAsli;
    private int usia;

    private static int totalPemainBerhasilDibuat = 0;

    public Pemain(String nickname, String namaAsli, int usia) {
        this.setNickname(nickname);
        this.setNamaAsli(namaAsli);
        this.setUsia(usia);
        totalPemainBerhasilDibuat++;
    }

    public String getNickname() { return this.nickname; }
    public String getNamaAsli() { return this.namaAsli; }
    public int getUsia() { return this.usia; }

    public void setNickname(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            System.out.println("Nickname tidak boleh kosong, diisi 'Anonim'.");
            this.nickname = "Anonim";
        } else {
            this.nickname = nickname.trim();
        }
    }

    public void setNamaAsli(String namaAsli) {
        if (namaAsli == null || namaAsli.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong, diisi 'Tanpa Nama'.");
            this.namaAsli = "Tanpa Nama";
        } else {
            this.namaAsli = namaAsli.trim();
        }
    }

    public void setUsia(int usia) {
        if (usia >= 15 && usia <= 40) {
            this.usia = usia;
        } else {
            System.out.println("Usia harus 15-40 tahun, diisi default 17.");
            this.usia = 17;
        }
    }

    public static int getTotalPemainBerhasilDibuat() {
        return totalPemainBerhasilDibuat;
    }

    public void tampilkanInfo() {
        System.out.printf("Nickname: %-10s | Nama: %-15s | Usia: %d", 
                          this.nickname, this.namaAsli, this.usia);
    }

    public void caraLatihan() {
        System.out.println("-> Info Latihan: Latihan umum bersama tim.");
    }
}
