package com.mycompany.esportmanager;

public class RuangLatihan {
    private String namaRuangan;
    private int kapasitasKursi;

    public RuangLatihan(String namaRuangan, int kapasitasKursi) {
        this.namaRuangan = namaRuangan;
        this.kapasitasKursi = kapasitasKursi;
    }

    public String getNamaRuangan() { return namaRuangan; }
    public int getKapasitasKursi() { return kapasitasKursi; }

    public void bukaRuangan() {
        System.out.println("-> [" + namaRuangan + "] dibuka. Kapasitas: " + kapasitasKursi + " kursi gaming.");
    }
}
