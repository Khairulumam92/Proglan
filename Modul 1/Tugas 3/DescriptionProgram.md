
### Deskripsi Formal
**Judul** : Sistem Pembelian Tiket Wisata Online

**Tujuan** : Membuat sebuah program Java untuk pembelian tiket wisata secara online yang dapat menangani berbagai jenis tiket dan harga yang bervariasi tergantung pada hari, serta umur pembeli.

1. **Input** :
   Nama Pengguna (String)
    - Hari (String, contoh: Senin, Selasa, Rabu, Kamis, Jumat, Sabtu, Minggu)
    - Tanggal (String, format: dd-mm-yyyy)
    - Jenis Tiket (String, contoh: "Reguler" atau "Terusan")
    - Kategori Usia (String, contoh: "Dewasa" atau "Anak-anak")
2. **Proses**:
    - Validasi input: Semua input harus diisi. Jika ada yang kosong, tampilkan pesan "data harus diisi".
    - Penentuan harga tiket berdasarkan jenis tiket dan kategori usia.
    - Penambahan 20% pada harga tiket jika hari adalah Sabtu atau Minggu.
3. **Output**:
    - Total harga tiket yang harus dibayar.

**Algoritma** :
1. Menerima input dari pengguna.
2. Validasi input: Jika ada input yang kosong, tampilkan pesan "data harus diisi".
3. Tentukan harga tiket berdasarkan jenis tiket dan kategori usia.
4. Jika hari adalah Sabtu atau Minggu, tambahkan 20% pada harga tiket.
5. Tampilkan total harga tiket yang harus dibayar.

### Deskripsi Informal

Pemilik tempat wisata berencana membuat sistem pemesanan tiket secara daring. 
Terdapat dua jenis tiket yang tersedia: tiket reguler dan tiket terusan. 
Untuk tiket reguler, harganya 75 ribu bagi dewasa dan 60 ribu bagi anak-anak. 
Sementara itu, tiket terusan dihargai 100 ribu untuk dewasa dan 85 ribu untuk anak-anak. 
Jika tiket dibeli pada hari Sabtu atau Minggu, harga akan naik sebesar 20% dari harga aslinya. 
Pengguna diwajibkan mengisi nama, hari, serta tanggal kunjungan. Jika salah satu dari informasi 
tersebut tidak diisi, sistem akan menampilkan pesan "data harus diisi".