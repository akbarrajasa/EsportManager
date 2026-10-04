package com.mycompany.esportmanager;

public class PemainPUBG extends Pemain {
    private int chickenDinner;

    public PemainPUBG(String nickname, String namaAsli, int usia, int chickenDinner) {
        super(nickname, namaAsli, usia);
        this.setChickenDinner(chickenDinner);
    }

    public int getChickenDinner() { return this.chickenDinner; }

    public void setChickenDinner(int chickenDinner) {
        if (chickenDinner >= 0) {
            this.chickenDinner = chickenDinner;
        } else {
            System.out.println("Jumlah Chicken Dinner tidak boleh negatif, diisi 0.");
            this.chickenDinner = 0;
        }
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[%-14s] ", "PUBG");
        super.tampilkanInfo();
        System.out.printf(" | Chicken Dinner: %d%n", this.chickenDinner);
    }

    @Override
    public void caraLatihan() {
        System.out.println("-> Info Latihan: Scrim 16 tim dan latihan rotasi zona.");
    }
}
