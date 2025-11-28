public class kuis2 {
    public static void main(String[] args) {

        String[] menu = {"Italian Food", "Korean Food", "Chinese Food", "Khas Jogja", "Khas Madura"};
        String[] jenisLayanan = {"Dine In", "Delivery", "Takeout"};
        int[][] pembelianPelanggan = {
            {6, 8, 4},
            {10, 16, 11}, 
            {9, 14, 10}, 
            {12, 5, 7}, 
            {5, 8, 5}
        };
        int hargaMakananLuarNegeri = 50000, hargaMakananDalamNegeri = 35000;

        System.out.println("=====TOTAL PEMBELIAN TIAP MENU=====");
        for (int i = 0; i < pembelianPelanggan.length; i++) {
            int total = 0;
            for (int j = 0; j < pembelianPelanggan[i].length; j++) {
                total += pembelianPelanggan[i][j];
            }
            System.out.println(menu[i] + " : " + total);
        }

        int totalPemasukan = 0;
        System.out.println("==== TOTAL PEMASUKAN RESTORAN DALAM 1 HARI ====");
        for (int i = 0; i < menu.length; i++) {
            int totalPorsi = 0;
            for (int j = 0; j < pembelianPelanggan[i].length; j++) {
                totalPorsi += pembelianPelanggan[i][j];
            }

            int hargaMenu;
            if (i <= 2) { 
                hargaMenu = hargaMakananLuarNegeri; 
            } else {
                hargaMenu = hargaMakananDalamNegeri;
            }
            int pemasukanDalam1Hari = totalPorsi * hargaMenu;
            totalPemasukan += pemasukanDalam1Hari;
            System.out.println(menu[i] + " : Rp " + pemasukanDalam1Hari);
        }

        System.out.println("-----------------------------------------");
        System.out.println("TOTAL PEMASUKAN RESTORAN : Rp " + totalPemasukan);
    }
}
