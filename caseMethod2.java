import java.util.Scanner;

public class caseMethod2 {
   
    static String[] nama = new String[100];
    static String[] nim = new String[100];
    static double[] ipk = new double[100];
    static String[] jenis = new String[100];
    static int[] penghasilanOrangtua = new int[100];
    static int jumlahData = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        while (true) {
            menu();
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    tambahData(sc);
                    break;
                case 2:
                    tampilData();
                    break;
                case 3:
                    cariJenis(sc);
                    break;
                case 4:
                    hitungRatarata();
                    break;
                case 5:
                    System.out.println("Program telah selesai. Terimakasih!");
                    return;

                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } 
    }
    static void menu(){
        System.out.println("\n=== Sistem Pendaftaran Beasiswa ===");
        System.out.println("1. Tambah Data Pendaftaran");
        System.out.println("2. Tampilkan Semua Pendaftar");
        System.out.println("3. Cari Pendaftar Berdasarkan Jenis Beasiswa");
        System.out.println("4. Hitung Rata-rata IPK per Jenis Beasiswa");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu (1-5): ");
    }
    static void tambahData(Scanner sc) {
        System.out.println("\n=== Tambah Data Pendaftar ===");
        System.out.print("Nama Mahasiswa: ");
        nama[jumlahData] = sc.nextLine();

        System.out.print("NIM: ");
        nim[jumlahData] = sc.nextLine();

        System.out.print("IPK terakhir: ");
        ipk[jumlahData] = sc.nextDouble();
        sc.nextLine();

        String jenisBeasiswa;
            System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset): ");
            jenisBeasiswa = sc.nextLine();

            if (jenisBeasiswa.equalsIgnoreCase("Reguler") || jenisBeasiswa.equalsIgnoreCase("Unggulan") || jenisBeasiswa.equalsIgnoreCase("Riset")) {
                jenis[jumlahData] = jenisBeasiswa;
            } else {
                System.out.print("Jenis beasiswa tidak valid! Ulangi.");
            }

        int gaji;
            System.out.print("Penghasilan orang tua (maksimal 2000000): ");
            gaji = sc.nextInt();
            sc.nextLine();

            if (gaji <= 2000000) {
                penghasilanOrangtua[jumlahData] = gaji;
                jumlahData++;
                System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + jumlahData);
            } else {
                System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
            }
    }

    static void tampilData() {
        if (jumlahData == 0) {
            System.out.println("Belum ada pendaftar");
            return;
        }
        System.out.printf("%-20s %-12s %-6s %-10s %-12s\n","Nama", "NIM", "IPK", "Beasiswa", "Penghasilan");

         for (int i = 0; i < jumlahData; i++) {
            System.out.printf("%-20s %-12s %-6.2f %-10s %-12d\n", nama[i], nim[i], ipk[i], jenis[i], penghasilanOrangtua[i]);
        }
    }

    static void cariJenis(Scanner sc) {
        System.out.print("Masukkan jenis beasiswa yang dicari: ");
        String cari = sc.nextLine();
        System.out.println("\n=== HASIL PENCARIAN ===");

        boolean ditemukan = false;

        for (int i = 0; i < jumlahData; i++) {
            if (jenis[i].equalsIgnoreCase(cari)) {
                System.out.printf("%s | %s | %.2f | %s | %d\n", nama[i], nim[i], ipk[i], jenis[i], penghasilanOrangtua[i]);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada pendaftar dengan jenis: " + cari);
        }
    }

    static void hitungRatarata() {
        hitungRata("Reguler");
        hitungRata("Unggulan");
        hitungRata("Riset");
    }
    static void hitungRata(String jenisBeasiswa) {
        double totalipk = 0;
        int jumlahMahasiswa = 0;

        for (int i = 0; i < jumlahData; i++) {
            if (jenis[i].equalsIgnoreCase(jenisBeasiswa)) {
                totalipk += ipk[i];
                jumlahMahasiswa++;
            }
        }

        if (jumlahMahasiswa == 0) {
            System.out.println("Rata-rata IPK " + jenisBeasiswa + ": Tidak ada pendaftar.");
        } else {
            System.out.printf("Rata-rata IPK %s: %.2f\n", jenisBeasiswa, (totalipk / jumlahMahasiswa));
        }
    }
} 
