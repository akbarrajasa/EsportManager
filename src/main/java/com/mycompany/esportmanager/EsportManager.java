package com.mycompany.esportmanager;

import java.util.Scanner;

public class EsportManager {

    public static void cariPemain(String nickname, Pemain[] daftarPemain, int jumlahPemain) {
        System.out.println("Mencari pemain dengan Nickname: " + nickname);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPemain; i++) {
            if (daftarPemain[i].getNickname().equalsIgnoreCase(nickname)) {
                daftarPemain[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pemain tidak ditemukan.");
    }

    public static void cariPemain(int usia, Pemain[] daftarPemain, int jumlahPemain) {
        System.out.println("Mencari pemain dengan (Angka) Usia: " + usia);
        boolean ditemukan = false;
        for (int i = 0; i < jumlahPemain; i++) {
            if (daftarPemain[i].getUsia() == usia) {
                daftarPemain[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) System.out.println("Pemain tidak ditemukan.");
    }

    public static void simulasiLatihan(Pemain pemain) {
        pemain.caraLatihan();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Pemain[] daftarPemain = new Pemain[10];

            int jumlahPemain = 0;
            boolean isRunning = true;

            System.out.println("========================================");
            System.out.println("   SELAMAT DATANG DI ESPORT MANAGER!    ");
            System.out.println("========================================");

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Pemain");
                System.out.println("2. Lihat Daftar Pemain");
                System.out.println("3. Cari Pemain");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu 1-4: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (jumlahPemain < daftarPemain.length) {
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
                                daftarPemain[jumlahPemain] = new PemainML(nickname, namaAsli, usia, hero);
                            } else if (divisi == 2) {
                                System.out.print("Masukkan Klub Andalan: ");
                                String klub = scanner.nextLine();
                                daftarPemain[jumlahPemain] = new PemainPES(nickname, namaAsli, usia, klub);
                            } else if (divisi == 3) {
                                System.out.print("Masukkan MMR: ");
                                int mmr = scanner.nextInt();
                                scanner.nextLine();
                                daftarPemain[jumlahPemain] = new PemainDota(nickname, namaAsli, usia, mmr);
                            } else if (divisi == 4) {
                                System.out.print("Masukkan Jumlah Chicken Dinner: ");
                                int chicken = scanner.nextInt();
                                scanner.nextLine();
                                daftarPemain[jumlahPemain] = new PemainPUBG(nickname, namaAsli, usia, chicken);
                            } else {
                                System.out.println("Divisi tidak valid, pemain tidak ditambahkan.");
                                jumlahPemain--;
                            }

                            jumlahPemain++;
                            System.out.println("Proses tambah pemain selesai.");
                            System.out.print("Tekan Enter untuk melanjutkan...");
                            scanner.nextLine();
                        } else {
                            System.out.println("Maaf, kapasitas roster sudah penuh!");
                        }
                    }
                    case 2 -> {
                        System.out.println("\n-- Daftar Pemain Esport --");
                        if (jumlahPemain == 0) {
                            System.out.println("Belum ada pemain yang tersimpan");
                        } else {
                            for (int i = 0; i < jumlahPemain; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarPemain[i].tampilkanInfo();
                                simulasiLatihan(daftarPemain[i]);
                                System.out.println("");
                            }

                            System.out.println("\n Total Pemain yang Terdaftar: " + Pemain.getTotalPemainBerhasilDibuat());
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

                        if (modeCari == 1) {
                            System.out.print("Masukkan Nickname: ");
                            String kataKunci = scanner.nextLine();
                            cariPemain(kataKunci, daftarPemain, jumlahPemain);
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Usia: ");
                            int angkaKunci = scanner.nextInt();
                            scanner.nextLine();
                            cariPemain(angkaKunci, daftarPemain, jumlahPemain);
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                    case 4 -> {
                        System.out.println("Terima kasih telah menggunakan Esport Manager!");
                        isRunning = false;
                    }
                    default -> {
                        System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-4.");
                    }
                }
            }
        }
    }
}
