
---
# Encryption Program Using AES

## Deskripsi Program
`Encryption Program Using AES` adalah sebuah aplikasi Java sederhana yang memungkinkan pengguna untuk mengenkripsi dan mendekripsi pesan menggunakan algoritma Advanced Encryption Standard (AES). Program ini mendukung generasi kunci AES dan penggunaan kunci ini untuk melakukan enkripsi dan dekripsi pesan teks.

Program ini telah melalui beberapa refaktorisasi untuk meningkatkan keterbacaan, maintainability, dan modularitas kode, termasuk penerapan metode `Extract Method`, `Rename Method`, `Introduce Local Variable`, dan `Extract Constant`.

## Fitur
- **Enkripsi AES**: Mengenkripsi pesan teks dengan kunci AES.
- **Dekripsi AES**: Mendekripsi pesan teks yang telah dienkripsi menggunakan kunci AES yang sama.
- **Pengulangan Penggunaan**: Program dapat digunakan berkali-kali selama sesi berjalan.

## Persyaratan
- Java Development Kit (JDK) versi 8 atau lebih baru.
- Maven (untuk mengelola dependensi jika proyek ini dikembangkan lebih lanjut).

## Cara Menjalankan Program
1. **Clone repository** atau unduh kode sumber.
2. **Buka proyek di IDE favorit** Anda (seperti IntelliJ IDEA atau VS Code) atau gunakan **Command Prompt/Terminal**.

### Menjalankan di Command Line
1. Buka terminal di direktori proyek.
2. Jalankan perintah berikut untuk menjalankan program:
    ```shell
    javac EncryptionProgramRefactored.java
    java EncryptionProgramRefactored
    ```

### Menjalankan di IntelliJ IDEA
1. Buka IntelliJ IDEA dan impor proyek.
2. Klik kanan pada file `EncryptionProgramRefactored.java` dan pilih **Run 'EncryptionProgramRefactored.main()'**.

## Penggunaan
1. Saat program berjalan, menu akan tampil dengan pilihan:
    - `1` untuk enkripsi pesan
    - `2` untuk dekripsi pesan
    - `0` untuk keluar
2. Masukkan nomor pilihan, kemudian ikuti instruksi yang diberikan.

### Contoh
```plaintext
--- MENU ---
1. Enkripsi menggunakan AES
2. Dekripsi menggunakan AES
0. Keluar
Pilih opsi: 1

Masukkan pesan: Hello, World!
Hasil Enkripsi (AES): 7GHljk3mKa5hD...
Kunci AES (simpan untuk dekripsi): sdfsdf23lFjwe...
```

## Lisensi
Proyek ini dilisensikan di bawah lisensi MIT.