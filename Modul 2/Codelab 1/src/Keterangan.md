### Ketentuan
Diberikan program yang mengelola informasi produk dan inventaris. Kode ini memiliki beberapa area yang memerlukan refactoring untuk meningkatkan keterbacaan dan maintainability. Lakukan refactoring terhadap kode tersebut dengan menggunakan teknik-teknik berikut:

1. Buat **getter** dan **setter** untuk untuk **name, price, dan stock** dalam kelas Product. Tambahkan juga **setter** untuk **product dan location** dalam kelas **Inventory**. (Clue: Encapsulate Field)
2. Perkenalkan **konstanta baru** untuk **diskon** dalam kelas **Product** jika belum ada. (Clue: Introduce Constant)
3. Lakukanlah **refactoring** pada perhitungan harga diskon di **metode displayProduct()** sehingga **tidak** memerlukan lagi **variabel discountedPrice**. (Clue: Inline Variable)
4. Ekstrak **logika** perhitungan **harga diskon** dalam **metode displayProduct()** ke dalam **metode terpisah** dalam kelas **Product**, beri **nama** **calculateDiscount().** (Clue: Extract Method)
5. **Pindahkan metode main** dari kelas **MainApp ke dalam kelas baru bernama Main (buat baru),** dan pastikan bahwa kelas **MainApp dihapus** setelahnya. (Clue: Move method)