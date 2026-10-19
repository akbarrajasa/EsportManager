package com.mycompany.esportmanager;

public class PemainML extends Pemain implements DapatBertanding, DapatStreaming {
    private String heroUtama;

    public PemainML(String nickname, String namaAsli, int usia, String heroUtama) {
        super(nickname, namaAsli, usia);
        this.setHeroUtama(heroUtama);
    }

    public String getHeroUtama() { return this.heroUtama; }

    public void setHeroUtama(String heroUtama) {
        if (heroUtama == null || heroUtama.trim().isEmpty()) {
            this.heroUtama = "Belum ada";
        } else {
            this.heroUtama = heroUtama.trim();
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[%-14s] ", "Mobile Legends");
        super.tampilkanInfo();
        System.out.printf(" | Hero Utama: %s%n", this.heroUtama);
    }

    @Override
    public void caraLatihan() {
        System.out.println("-> Info Latihan: Scrim draft pick dan drill hero " + this.heroUtama + ".");
    }

    @Override
    public void ikutTurnamen() {
        System.out.println("-> [TURNAMEN] " + this.getNickname() + " mendaftar turnamen MPL bersama tim, hero andalan " + this.heroUtama + ".");
    }

    @Override
    public void mulaiStreaming() {
        System.out.println("-> [STREAMING] Live streaming rank Mythic Glory dengan hero " + this.heroUtama + ".");
    }
}
