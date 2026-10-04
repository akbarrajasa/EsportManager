# Esport Manager (Tugas Gabungan LKP 2-5)

Modifikasi dari SmartLibrary (Koleksi -> BukuCetak/EBook/Majalah) menjadi manajemen pemain esport.

```
Pemain (superclass)
 |- PemainML    (heroUtama)
 |- PemainPES   (klubAndalan)
 |- PemainDota  (mmr)
 |- PemainPUBG  (chickenDinner)
```

## Lokasi implementasi tiap modul (untuk screenshot potongan kode)

| Modul | Materi | File : baris |
|---|---|---|
| 2 | Scanner, array, while, switch-case | `EsportManager.java` : 37-58 |
| 2 | if-else (pilih divisi, mode cari), for loop | `EsportManager.java` : 81-100, 117, 137-141 |
| 2 | printf | `Pemain.java` : 60-62, `PemainML.java` : 23-25 |
| 3 | Class, field, constructor, instansiasi `new` | `Pemain.java` : 4-20, `EsportManager.java` : 84-98 |
| 4 | private + getter/setter + validasi + `this` | `Pemain.java` : 6-8, 14-52 |
| 4 | static (variabel & method) | `Pemain.java` : 11, 55 |
| 4 | Overloading `cariPemain` | `EsportManager.java` : 8, 20 |
| 5 | extends, `super(...)`, `super.tampilkanInfo()` | `PemainML.java` : 3, 7, 24 |
| 5 | Overriding `@Override` | `PemainML.java` : 21-31 |

## Cara tes cepat (input 5 pemain)
Menu 1 sebanyak 5 kali (ML, ML, PES, Dota, PUBG), lalu menu 2 untuk menampilkan, menu 3 untuk cari, menu 4 keluar.

## Push GitHub
```
git init
git add .
git commit -m "Tugas Gabungan LKP 2-5"
git branch -M main
git remote add origin https://github.com/<username>/<repo>.git
git push -u origin main
```
