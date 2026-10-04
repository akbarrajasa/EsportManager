package com.mycompany.esportmanager;

public class PemainDota extends Pemain {
    private int mmr;

    public PemainDota(String nickname, String namaAsli, int usia, int mmr) {
        super(nickname, namaAsli, usia);
        this.setMmr(mmr);
    }

    public int getMmr() { return this.mmr; }

    public void setMmr(int mmr) {
        if (mmr >= 0 && mmr <= 15000) {
            this.mmr = mmr;
        } else {
            System.out.println("MMR harus 0-15000, diisi default 0.");
            this.mmr = 0;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[%-14s] ", "Dota 2");
        super.tampilkanInfo();
        System.out.printf(" | MMR: %d%n", this.mmr);
    }

    @Override
    public void caraLatihan() {
        System.out.println("-> Info Latihan: Scrim 5v5 dan latihan last hit.");
    }
}
