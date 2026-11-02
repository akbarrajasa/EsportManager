package com.mycompany.esportmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EsportManager {

    public static void cariPemain(String nickname, ArrayList<Pemain> daftarPemain)
            throws PemainTidakDitemukanException {
        System.out.println("Mencari pemain dengan Nickname: " + nickname);
        boolean ditemukan = false;
        for (int i = 0; i < daftarPemain.size(); i++) {
            if (daftarPemain.get(i).getNickname().equalsIgnoreCase(nickname)) {
                daftarPemain.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PemainTidakDitemukanException(
                    "Gagal: Pemain dengan nickname '" + nickname + "' tidak terdaftar di sistem.");
        }
    }

    public static void cariPemain(int usia, ArrayList<Pemain> daftarPemain)
            throws PemainTidakDitemukanException {
        System.out.println("Mencari pemain dengan (Angka) Usia: " + usia);
        boolean ditemukan = false;
        for (int i = 0; i < daftarPemain.size(); i++) {
            if (daftarPemain.get(i).getUsia() == usia) {
                daftarPemain.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new PemainTidakDitemukanException(
                    "Gagal: Tidak ada pemain berusia " + usia + " tahun di sistem.");
        }
    }

    public static void simulasiLatihan(Pemain pemain) {
        System.out.println("Simulasi latihan untuk " + pemain.getNickname()
                + " (objek asli: " + pemain.getClass().getSimpleName() + ")");
        pemain.caraLatihan();
    }

    public static void simulasiLatihan(ArrayList<Pemain> daftarPemain) {
        System.out.println("Simulasi latihan SELURUH TIM:");
        for (int i = 0; i < daftarPemain.size(); i++) {
            simulasiLatihan(daftarPemain.get(i));
            System.out.println();
        }
    }

    public static void isiDataContoh(ArrayList<Pemain> daftarPemain) throws Exception {
        daftarPemain.add(new PemainML("Kairi", "Kairi Pratama", 21, "Gusion"));
        daftarPemain.add(new PemainPES("Messi10", "Rizky Maulana", 22, "Barcelona"));
        daftarPemain.add(new PemainDota("Miracle", "Dimas Saputra", 24, 9500));
        daftarPemain.add(new PemainPUBG("SniperX", "Andi Wijaya", 20, 35));
        daftarPemain.add(new PemainML("Lemon", "Bagas Nugroho", 19, "Lancelot"));
    }

    public static void tambahStaf(HashMap<String, String> dataStaf, String kode, String nama)
            throws Exception {
        if (kode == null || kode.trim().isEmpty()) {
            throw new Exception("Kode staf tidak boleh kosong!");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new Exception("Nama staf tidak boleh kosong!");
        }
        if (dataStaf.containsKey(kode)) {
            throw new Exception("Kode staf '" + kode + "' sudah terdaftar (Key harus unik)!");
        }
        dataStaf.put(kode, nama);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Pemain> daftarPemain = new ArrayList<>();
            HashMap<String, String> dataStaf = new HashMap<>();

            try {
                isiDataContoh(daftarPemain);
                tambahStaf(dataStaf, "STF001", "Coach Hendra");
                tambahStaf(dataStaf, "STF002", "Analis Dinda");
                tambahStaf(dataStaf, "STF003", "Manajer Rudi");
            } catch (Exception e) {
                System.out.println("[ERROR DATA AWAL] " + e.getMessage());
            }

            boolean isRunning = true;

            System.out.println("========================================");
            System.out.println("   SELAMAT DATANG DI ESPORT MANAGER!    ");
            System.out.println("========================================");
            System.out.println("Data awal dimuat: " + daftarPemain.size() + " pemain, "
                    + dataStaf.size() + " staf.");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Pemain");
                System.out.println("2. Lihat Daftar Pemain");
                System.out.println("3. Cari Pemain (Demo Custom Exception)");
                System.out.println("4. Simulasi Latihan");
                System.out.println("5. Manajemen Staf (Demo HashMap)");
                System.out.println("6. Keluar");
                System.out.print("Pilih Menu 1-6: ");

                try {
                    int pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1 -> {
                            System.out.println("\n-- Pilih Divisi --");
                            System.out.println("1. Mobile Legends");
                            System.out.println("2. PES");
                            System.out.println("3. Dota 2");
                            System.out.println("4. PUBG");
                            System.out.print("Pilihan (1/2/3/4): ");

                            int divisi = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Nickname: ");
                            String nickname = scanner.nextLine();

                            System.out.print("Masukkan Nama Asli: ");
                            String namaAsli = scanner.nextLine();

                            System.out.print("Masukkan Usia: ");
                            int usia = scanner.nextInt();
                            scanner.nextLine();

                            if (divisi == 1) {
                                System.out.print("Masukkan Hero Utama: ");
                                String hero = scanner.nextLine();
                                daftarPemain.add(new PemainML(nickname, namaAsli, usia, hero));
                            } else if (divisi == 2) {
                                System.out.print("Masukkan Klub Andalan: ");
                                String klub = scanner.nextLine();
                                daftarPemain.add(new PemainPES(nickname, namaAsli, usia, klub));
                            } else if (divisi == 3) {
                                System.out.print("Masukkan MMR: ");
                                int mmr = scanner.nextInt();
                                scanner.nextLine();
                                daftarPemain.add(new PemainDota(nickname, namaAsli, usia, mmr));
                            } else if (divisi == 4) {
                                System.out.print("Masukkan Jumlah Chicken Dinner: ");
                                int chicken = scanner.nextInt();
                                scanner.nextLine();
                                daftarPemain.add(new PemainPUBG(nickname, namaAsli, usia, chicken));
                            } else {
                                System.out.println("Divisi tidak valid, pemain tidak ditambahkan.");
                                break;
                            }
                            System.out.println("Sukses! Pemain berhasil ditambahkan. (Total pemain: "
                                    + daftarPemain.size() + ")");

                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        }
                        case 2 -> {
                            System.out.println("\n-- Daftar Pemain Esport --");
                            if (daftarPemain.isEmpty()) {
                                System.out.println("Belum ada pemain yang tersimpan");
                            } else {
                                for (int i = 0; i < daftarPemain.size(); i++) {
                                    Pemain p = daftarPemain.get(i);
                                    System.out.print((i + 1) + ". ");
                                    p.tampilkanInfo();
                                    simulasiLatihan(p);

                                    if (p instanceof DapatBertanding) {
                                        DapatBertanding petanding = (DapatBertanding) p;
                                        petanding.ikutTurnamen();
                                    }
                                    if (p instanceof DapatStreaming) {
                                        DapatStreaming streamer = (DapatStreaming) p;
                                        streamer.mulaiStreaming();
                                    }
                                    System.out.println("");
                                }
                                System.out.println("\n Total Pemain yang Terdaftar: " + daftarPemain.size());
                            }
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        }
                        case 3 -> {
                            System.out.println("\n-- Fitur Cari Pemain --");
                            System.out.println("1. Cari berdasarkan Nickname");
                            System.out.println("2. Cari berdasarkan Usia");
                            System.out.print("Pilih (1/2): ");
                            int modeCari = scanner.nextInt();
                            scanner.nextLine();

                            try {
                                if (modeCari == 1) {
                                    System.out.print("Masukkan Nickname: ");
                                    String kataKunci = scanner.nextLine();
                                    cariPemain(kataKunci, daftarPemain); // overload versi String
                                } else if (modeCari == 2) {
                                    System.out.print("Masukkan Usia: ");
                                    int angkaKunci = scanner.nextInt();
                                    scanner.nextLine();
                                    cariPemain(angkaKunci, daftarPemain); // overload versi int
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            } catch (PemainTidakDitemukanException e) {
                                System.out.println("Peringatan: " + e.getMessage());
                            } finally {
                                System.out.println("-> Sesi pencarian selesai dieksekusi.");
                            }
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        }
                        case 4 -> {
                            System.out.println("\n-- Simulasi Latihan --");
                            if (daftarPemain.isEmpty()) {
                                System.out.println("Belum ada pemain yang tersimpan");
                            } else {
                                System.out.println("1. Latihan satu pemain");
                                System.out.println("2. Latihan seluruh tim");
                                System.out.print("Pilih (1/2): ");
                                int modeSim = scanner.nextInt();
                                scanner.nextLine();

                                if (modeSim == 1) {
                                    for (int i = 0; i < daftarPemain.size(); i++) {
                                        System.out.println((i + 1) + ". " + daftarPemain.get(i).getNickname());
                                    }
                                    System.out.print("Pilih nomor pemain: ");
                                    int no = scanner.nextInt();
                                    scanner.nextLine();
                                    if (no >= 1 && no <= daftarPemain.size()) {
                                        System.out.println();
                                        simulasiLatihan(daftarPemain.get(no - 1));
                                    } else {
                                        System.out.println("Nomor pemain tidak valid.");
                                    }
                                } else if (modeSim == 2) {
                                    System.out.println();
                                    simulasiLatihan(daftarPemain);
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            }
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        }
                        case 5 -> {
                            System.out.println("\n-- Kelola Staf Tim (HashMap) --");
                            System.out.println("1. Tambah Staf Baru");
                            System.out.println("2. Cari Staf via Kode");
                            System.out.println("3. Tampilkan Semua Staf");
                            System.out.print("Pilih: ");
                            int menuStaf = scanner.nextInt();
                            scanner.nextLine();

                            if (menuStaf == 1) {
                                System.out.print("Masukkan Kode Staf (sebagai Key): ");
                                String kode = scanner.nextLine();
                                System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                                String nama = scanner.nextLine();

                                tambahStaf(dataStaf, kode, nama);
                                System.out.println("Berhasil menambahkan staf!");
                            } else if (menuStaf == 2) {
                                System.out.print("Masukkan Kode Staf yang dicari: ");
                                String cariKode = scanner.nextLine();

                                if (dataStaf.containsKey(cariKode)) {
                                    System.out.println("Ditemukan! Nama: " + dataStaf.get(cariKode));
                                } else {
                                    System.out.println("Staf dengan kode tersebut tidak terdaftar.");
                                }
                            } else if (menuStaf == 3) {
                                System.out.println("Total Staf Terdaftar: " + dataStaf.size());
                                for (String kunci : dataStaf.keySet()) {
                                    System.out.println("- Kode: " + kunci + " | Nama: " + dataStaf.get(kunci));
                                }
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        }
                        case 6 -> {
                            System.out.println("Terima kasih telah menggunakan Esport Manager!");
                            isRunning = false;
                        }
                        default -> System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                    scanner.nextLine(); // buang input salah agar tidak infinite loop
                } catch (Exception e) {
                    System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
                }
            }
        }
    }
}
