package com.mycompany.esportmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EsportManager {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            TimEsport timUnila = new TimEsport("Unila Esport");

            System.out.println("========================================");
            System.out.println("   SELAMAT DATANG DI ESPORT MANAGER!    ");
            System.out.println("========================================");
            timUnila.bukaMarkas(); 
            
            try {
                timUnila.tambahPemain(new PemainML("Kairi", "Kairi Pratama", 21, "Gusion"));
                timUnila.tambahPemain(new PemainPES("Messi10", "Rizky Maulana", 22, "Barcelona"));
                timUnila.tambahPemain(new PemainDota("Miracle", "Dimas Saputra", 24, 9500));
                timUnila.tambahPemain(new PemainPUBG("SniperX", "Andi Wijaya", 20, 35));
                timUnila.tambahPemain(new PemainML("Lemon", "Bagas Nugroho", 19, "Lancelot"));

                timUnila.tambahStaf(new Staf("STF001", "Coach Hendra"));
                timUnila.tambahStaf(new Staf("STF002", "Analis Dinda"));
                timUnila.tambahStaf(new Staf("STF003", "Manajer Rudi"));
            } catch (Exception e) {
                System.out.println("[ERROR DATA AWAL] " + e.getMessage());
            }

            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\nMenu Utama:");
                System.out.println("1. Tambah Pemain");
                System.out.println("2. Lihat Daftar Pemain");
                System.out.println("3. Cari Pemain (Demo Custom Exception)");
                System.out.println("4. Simulasi Latihan");
                System.out.println("5. Manajemen Staf (Demo HashMap)");
                System.out.println("6. Sesi Latihan (Demo Association)");
                System.out.println("7. Info Markas Tim (Demo Composition)");
                System.out.println("8. Keluar");
                System.out.print("Pilih Menu 1-8: ");

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
                                timUnila.tambahPemain(new PemainML(nickname, namaAsli, usia, scanner.nextLine()));
                            } else if (divisi == 2) {
                                System.out.print("Masukkan Klub Andalan: ");
                                timUnila.tambahPemain(new PemainPES(nickname, namaAsli, usia, scanner.nextLine()));
                            } else if (divisi == 3) {
                                System.out.print("Masukkan MMR: ");
                                int mmr = scanner.nextInt();
                                scanner.nextLine();
                                timUnila.tambahPemain(new PemainDota(nickname, namaAsli, usia, mmr));
                            } else if (divisi == 4) {
                                System.out.print("Masukkan Jumlah Chicken Dinner: ");
                                int chicken = scanner.nextInt();
                                scanner.nextLine();
                                timUnila.tambahPemain(new PemainPUBG(nickname, namaAsli, usia, chicken));
                            } else {
                                System.out.println("Divisi tidak valid, pemain tidak ditambahkan.");
                            }
                        }
                        case 2 -> {
                            System.out.println("\n-- Daftar Pemain Esport --");
                            timUnila.lihatSemuaPemain();
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
                                    timUnila.cariPemain(scanner.nextLine());
                                } else if (modeCari == 2) {
                                    System.out.print("Masukkan Usia: ");
                                    int angkaKunci = scanner.nextInt();
                                    scanner.nextLine();
                                    timUnila.cariPemain(angkaKunci);
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            } catch (PemainTidakDitemukanException e) {
                                System.out.println("Peringatan: " + e.getMessage());
                            } finally {
                                System.out.println("-> Sesi pencarian selesai dieksekusi.");
                            }
                        }
                        case 4 -> {
                            System.out.println("\n-- Simulasi Latihan --");
                            if (timUnila.getJumlahPemain() == 0) {
                                System.out.println("Belum ada pemain yang tersimpan");
                            } else {
                                System.out.println("1. Latihan satu pemain");
                                System.out.println("2. Latihan seluruh tim");
                                System.out.print("Pilih (1/2): ");
                                int modeSim = scanner.nextInt();
                                scanner.nextLine();

                                if (modeSim == 1) {
                                    for (int i = 0; i < timUnila.getJumlahPemain(); i++) {
                                        System.out.println((i + 1) + ". " + timUnila.getPemain(i).getNickname());
                                    }
                                    System.out.print("Pilih nomor pemain: ");
                                    int no = scanner.nextInt();
                                    scanner.nextLine();
                                    if (no >= 1 && no <= timUnila.getJumlahPemain()) {
                                        System.out.println();
                                        timUnila.simulasiLatihan(timUnila.getPemain(no - 1));
                                    } else {
                                        System.out.println("Nomor pemain tidak valid.");
                                    }
                                } else if (modeSim == 2) {
                                    System.out.println();
                                    timUnila.simulasiLatihanSeluruhTim();
                                } else {
                                    System.out.println("Pilihan tidak valid.");
                                }
                            }
                        }
                        case 5 -> {
                            System.out.println("\n-- Kelola Staf --");
                            System.out.println("1. Tambah Staf");
                            System.out.println("2. Cari Staf");
                            System.out.println("3. Lihat Semua");
                            System.out.print("Pilih: ");
                            int menuS = scanner.nextInt();
                            scanner.nextLine();

                            if (menuS == 1) {
                                System.out.print("Masukkan Kode Staf: ");
                                String kode = scanner.nextLine();
                                System.out.print("Masukkan Nama: ");
                                String nama = scanner.nextLine();
                                timUnila.tambahStaf(new Staf(kode, nama));
                            } else if (menuS == 2) {
                                System.out.print("Kode staf yg dicari: ");
                                timUnila.cariStaf(scanner.nextLine());
                            } else if (menuS == 3) {
                                timUnila.lihatSemuaStaf();
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }
                        }
                        case 6 -> {
                            System.out.println("\n-- Sesi Latihan (Asosiasi) --");
                            System.out.print("Masukkan Kode Staf Pelatih: ");
                            String inputKode = scanner.nextLine();

                            Staf pelatih = timUnila.getStaf(inputKode);

                            if (pelatih == null) {
                                System.out.println("Gagal: Staf belum terdaftar!");
                            } else if (timUnila.getJumlahPemain() == 0) {
                                System.out.println("Gagal: Belum ada pemain yang bisa dilatih.");
                            } else {
                                for (int i = 0; i < timUnila.getJumlahPemain(); i++) {
                                    System.out.println((i + 1) + ". " + timUnila.getPemain(i).getNickname());
                                }
                                System.out.print("Pilih nomor pemain yg ingin dilatih: ");
                                int noPemain = scanner.nextInt() - 1;
                                scanner.nextLine();

                                if (noPemain >= 0 && noPemain < timUnila.getJumlahPemain()) {
                                    Pemain pemainLatih = timUnila.getPemain(noPemain);
                                    TransaksiLatihan.prosesSesi(pelatih, pemainLatih);
                                } else {
                                    System.out.println("Nomor pemain tidak valid!");
                                }
                            }
                        }
                        case 7 -> {
                            System.out.println("\n-- Info Markas Tim (Komposisi) --");
                            timUnila.bukaMarkas();
                        }
                        case 8 -> {
                            System.out.println("Terima kasih telah menggunakan Esport Manager!");
                            isRunning = false;
                        }
                        default -> System.out.println("Pilihan tidak valid. Silahkan masukkan angka 1-8.");
                    }
                    if (isRunning && pilihan >= 1 && pilihan <= 7) {
                        System.out.print("Tekan Enter untuk melanjutkan...");
                        scanner.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan angka.");
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
                }
            }
        }
    }
}
