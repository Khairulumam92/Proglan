public interface Tiket {
    static void main(String[] args) {
        TiketPesawat tiket = new TiketPesawat("John Doe", "Jakarta", "Bali", 1000000, 10);
        tiket.tampilkanInformasi();
    }

    double hitungBiayaTiket();

    double hitungDiskon();

    void tampilkanInformasi();
}
