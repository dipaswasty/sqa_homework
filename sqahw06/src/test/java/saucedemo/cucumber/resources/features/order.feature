Feature: Cart input

    Scenario: User memasukkan barang ke dalam Cart
        Given Halaman produk telah ditampilkan seluruhnya
        When User menekan tombol klik Add to Cart pada produk yang diinginkan
        And User menekan tombol klik keranjang pada pojok kanan atas
        Then User dapat melihat isi produk yang dimasukkan ke dalam Cart