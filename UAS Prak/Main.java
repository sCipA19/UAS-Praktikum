import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<TransaksiPajak28> transaksiList = new ArrayList<>();
    private static List<Kendaraan28> kendaraanList = new ArrayList<>(); // Added for demonstration
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize some example vehicles
        initializeKendaraan();

        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih (1—5): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (pilihan) {
                case 1:
                    System.out.println("Anda memilih: 1. Daftar Kendaraan");
                    daftarKendaraan();
                    break;
                case 2:
                    System.out.println("Anda memilih: 2. Bayar pajak");
                    bayarPajak();
                    break;
                case 3:
                    System.out.println("Anda memilih: 3. Tampilkan seluruh transaksi");
                    tampilkanTransaksi();
                    break;
                case 4:
                    System.out.println("Anda memilih: 4. Urutkan transaksi berdasarkan pemilik");
                    urutkanTransaksi();
                    break;
                case 5:
                    System.out.println("Anda memilih: 5. Keluar");
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih antara 1-5.");
                    break;
            }

            System.out.println(); // Membuat baris kosong untuk memisahkan output
        } while (pilihan != 5);

        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("Menu");
        System.out.println("1. Daftar Kendaraan");
        System.out.println("2. Bayar pajak");
        System.out.println("3. Tampilkan seluruh transaksi");
        System.out.println("4. Urutkan transaksi berdasarkan pemilik");
        System.out.println("5. Keluar");
    }

    private static void initializeKendaraan() {
        // Example vehicles (replace with actual initialization logic if needed)
        kendaraanList.add(new Kendaraan28("B 1234 AB", "Toyota Avanza", "Mobil", 1300, 2018, 6));
        kendaraanList.add(new Kendaraan28("B 5678 CD", "Honda Civic", "Mobil", 2000, 2019, 7));
        kendaraanList.add(new Kendaraan28("B 9876 EF", "Suzuki Ertiga", "Mobil", 1500, 2020, 8));
    }

    private static void daftarKendaraan() {
        System.out.println("Daftar Kendaraan:");
        for (Kendaraan28 kendaraan : kendaraanList) {
            System.out.println(kendaraan.getNoTNKB() + " - " + kendaraan.getNama());
        }
    }

    private static void bayarPajak() {
        System.out.println("Masukkan data untuk pembayaran pajak:");
        System.out.print("No TNKB: ");
        String noTNKB = scanner.nextLine();
        System.out.print("Nominal bayar: Rp ");
        long nominalBayar = scanner.nextLong();
        scanner.nextLine(); // Consume newline character
        System.out.print("Denda: Rp ");
        long denda = scanner.nextLong();
        scanner.nextLine(); // Consume newline character
        System.out.print("Bulan bayar: ");
        int bulanBayar = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Cari kendaraan berdasarkan noTNKB
        Kendaraan28 kendaraan = cariKendaraanByNoTNKB(noTNKB);
        if (kendaraan != null) {
            // Buat transaksi baru dan tambahkan ke list transaksi
            TransaksiPajak28 transaksiBaru = new TransaksiPajak28(nominalBayar, denda, bulanBayar, kendaraan);
            transaksiList.add(transaksiBaru);
            System.out.println("Pembayaran pajak berhasil dilakukan.");
        } else {
            System.out.println("Kendaraan dengan No TNKB " + noTNKB + " tidak ditemukan.");
        }
    }

    private static Kendaraan28 cariKendaraanByNoTNKB(String noTNKB) {
        for (Kendaraan28 kendaraan : kendaraanList) {
            if (kendaraan.getNoTNKB().equals(noTNKB)) {
                return kendaraan;
            }
        }
        return null; // Return null if not found
    }

    private static void tampilkanTransaksi() {
        if (transaksiList.isEmpty()) {
            System.out.println("Belum ada transaksi yang dicatat.");
        } else {
            System.out.println("Daftar Transaksi");
            System.out.println("Kode  TNKB       Nama                Pembayaran   Denda     Bulan");
            for (TransaksiPajak28 transaksi : transaksiList) {
                System.out.printf("%-5d %-10s %-20s %-15s %-10d %-10d\n",
                        transaksi.getKode(), transaksi.getKendaraan().getNoTNKB(), transaksi.getKendaraan().getNama(),
                        "Rp " + transaksi.getNominalBayar(), transaksi.getDenda(), transaksi.getBulanBayar());
            }
            // Hitung total pendapatan
            long totalPendapatan = hitungTotalPendapatan();
            System.out.println("\nTOTAL PENDAPATAN");
            System.out.println("Pendapatan hari ini: Rp " + totalPendapatan);
        }
    }

    private static long hitungTotalPendapatan() {
        long total = 0;
        for (TransaksiPajak28 transaksi : transaksiList) {
            total += transaksi.getNominalBayar() + transaksi.getDenda();
        }
        return total;
    }

    private static void urutkanTransaksi() {
        if (transaksiList.isEmpty()) {
            System.out.println("Belum ada transaksi yang dicatat.");
        } else {
            Collections.sort(transaksiList, Comparator.comparing(t -> t.getKendaraan().getNama()));
            System.out.println("Transaksi diurutkan berdasarkan pemilik kendaraan.");
            tampilkanTransaksi();
        }
    }
}
