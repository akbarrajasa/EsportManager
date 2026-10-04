Esport Manager

Nama: (M. Akbar Rajasa) NPM : (2517051051)

Tentang Program

Esport Manager adalah program berbasis teks untuk mencatat pemain esport. Program ini dibuat dari modifikasi contoh SmartLibrary. Kalau SmartLibrary mengelola koleksi perpustakaan, program ini mengelola data pemain dari empat divisi: Mobile Legends, PES, Dota 2, dan PUBG.

Setiap pemain punya data umum (nickname, nama asli, usia) dan satu data khusus sesuai divisinya.

Struktur Class
Pemain (superclass)
 ├── PemainML     -> hero utama
 ├── PemainPES    -> klub andalan
 ├── PemainDota   -> MMR
 └── PemainPUBG   -> jumlah chicken dinner
 
Pemain : class induk, berisi data umum dan method dasar.
PemainML, PemainPES, PemainDota, PemainPUBG : class anak yang mewarisi Pemain dan menambah data khusus.
EsportManager : class utama yang berisi menu dan alur program.

Fitur

Menu yang tersedia:
Tambah Pemain - pilih divisi, lalu isi datanya
Lihat Daftar Pemain - menampilkan semua pemain beserta info latihannya
Cari Pemain - cari berdasarkan nickname atau berdasarkan usia
Keluar

Program menyimpan maksimal 10 pemain
