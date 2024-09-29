public class MaxFinder {
    /**
     * Fungsi untuk mencari nilai maksimum dari tiga bilangan bulat.
     *
     * @param a Bilangan bulat pertama.
     * @param b Bilangan bulat kedua.
     * @param c Bilangan bulat ketiga.
     * @return Nilai maksimum dari ketiga bilangan bulat.
     */
    public static int findMax(int a, int b, int c) {
        // Pertama, kita bandingkan a dan b untuk mencari nilai maksimum dari keduanya.
        int maxAB = Math.max(a, b);

        // Kemudian, kita bandingkan hasilnya dengan c untuk mencari nilai maksimum dari ketiganya.
        int maxABC = Math.max(maxAB, c);

        // Terakhir, kita mengembalikan nilai maksimum dari ketiganya.
        return maxABC;
    }

    public static void main(String[] args) {
        // Contoh penggunaan fungsi findMax.
        System.out.println(findMax(1, 2, 3));  // Output: 3
        System.out.println(findMax(-1, -2, -3));  // Output: -1
        System.out.println(findMax(0, 0, 1));  // Output: 1
    }
}