public class TiketPesawat extends Pemesanan implements Tiket {

    public TiketPesawat(String nama, String asal, String tujuan, double Tiket, double diskon) {
        super(asal, tujuan, Tiket);
    }

    @Override
    public double hitungBiayaTiket() {

        return Tiket + (Tiket * (diskon / 100));
    }

    @Override
    public double hitungDiskon() {

        return Tiket * (diskon / 100);
    }

    @Override
    public void tampilkanInformasi() {
        System.out.println("Nama Penumpang: " + nama);
        System.out.println("Asal: " + asal);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Harga Tiket: " + Tiket);
        System.out.println("Diskon: " + diskon + "%");
        System.out.println("Biaya Tiket Setelah Diskon: " + hitungBiayaTiket());
        System.out.println("Jumlah Diskon: " + hitungDiskon());
    }

}