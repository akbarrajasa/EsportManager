package com.mycompany.esportmanager;

import java.util.ArrayList;
import java.util.HashMap;

public class TimEsport {
    private String namaTim;

    private RuangLatihan ruangLatihan;

    private ArrayList<Pemain> daftarPemain;
    private HashMap<String, Staf> dataStaf;

    public TimEsport(String namaTim) {
        this.namaTim = namaTim;
        this.ruangLatihan = new RuangLatihan("Ruang Latihan Utama", 10);
        this.daftarPemain = new ArrayList<>();
        this.dataStaf = new HashMap<>();
    }

    public void bukaMarkas() {
        System.out.println("\n*** Menginisialisasi markas " + this.namaTim + " ***");
        ruangLatihan.bukaRuangan();
    }

    public void tambahPemain(Pemain p) {
        daftarPemain.add(p);
        System.out.println("Sukses! Pemain ditambahkan. (Total pemain: " + daftarPemain.size() + ")");
    }

    public void lihatSemuaPemain() {
        if (daftarPemain.isEmpty()) {
            System.out.println("Belum ada pemain yang tersimpan");
            return;
        }
        for (int i = 0; i < daftarPemain.size(); i++) {
            Pemain p = daftarPemain.get(i);
            System.out.print((i + 1) + ". ");
            p.tampilkanInfo();
            simulasiLatihan(p);
            if (p instanceof DapatBertanding) {
                ((DapatBertanding) p).ikutTurnamen();
            }
            if (p instanceof DapatStreaming) {
                ((DapatStreaming) p).mulaiStreaming();
            }
            System.out.println();
        }
        System.out.println(" Total Pemain yang Terdaftar: " + daftarPemain.size());
    }

    public void cariPemain(String nickname) throws PemainTidakDitemukanException {
        System.out.println("Mencari pemain dengan Nickname: " + nickname);
        boolean ditemukan = false;
        for (Pemain p : daftarPemain) {
            if (p.getNickname().equalsIgnoreCase(nickname)) {
                p.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PemainTidakDitemukanException(
                    "Gagal: Pemain dengan nickname '" + nickname + "' tidak terdaftar di sistem.");
        }
    }

    public void cariPemain(int usia) throws PemainTidakDitemukanException {
        System.out.println("Mencari pemain dengan (Angka) Usia: " + usia);
        boolean ditemukan = false;
        for (Pemain p : daftarPemain) {
            if (p.getUsia() == usia) {
                p.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PemainTidakDitemukanException(
                    "Gagal: Tidak ada pemain berusia " + usia + " tahun di sistem.");
        }
    }

    public void simulasiLatihan(Pemain pemain) {
        System.out.println("Simulasi latihan untuk " + pemain.getNickname()
                + " (objek asli: " + pemain.getClass().getSimpleName() + ")");
        pemain.caraLatihan();
    }

    public void simulasiLatihanSeluruhTim() {
        System.out.println("Simulasi latihan SELURUH TIM:");
        for (Pemain p : daftarPemain) {
            simulasiLatihan(p);
            System.out.println();
        }
    }

    public void tambahStaf(Staf s) throws Exception {
        if (dataStaf.containsKey(s.getKode())) {
            throw new Exception("Kode staf '" + s.getKode() + "' sudah terdaftar (Key harus unik)!");
        }
        dataStaf.put(s.getKode(), s);
        System.out.println("Berhasil menambahkan staf!");
    }

    public void cariStaf(String kode) {
        if (dataStaf.containsKey(kode)) {
            System.out.println("Ditemukan! Nama: " + dataStaf.get(kode).getNama());
        } else {
            System.out.println("Staf dengan kode tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaStaf() {
        System.out.println("Total Staf Terdaftar: " + dataStaf.size());
        for (Staf s : dataStaf.values()) {
            System.out.println("- Kode: " + s.getKode() + " | Nama: " + s.getNama());
        }
    }

    public Staf getStaf(String kode) { return dataStaf.get(kode); }
    public Pemain getPemain(int index) { return daftarPemain.get(index); }
    public int getJumlahPemain() { return daftarPemain.size(); }
}
