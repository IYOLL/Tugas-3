import java.util.ArrayList;
import java.util.Scanner;

/**
 * Kelas Kas digunakan untuk mengelola saldo uang kas dan mencatat
 * riwayat transaksi pemasukan dan pengeluaran.
 */
class Kas {
    private double sld;
    private final ArrayList<String> rwytransaksi;

    /**
     * Konstruktor untuk membuat objek Kas baru dengan saldo awal 0 dan riwayat transaksi kosong.
     */
    public Kas() {
        this.sld = 0.0;
        this.rwytransaksi = new ArrayList<>();
    }

    /**
     * Mendapatkan saldo saat ini.
     *
     * @return saldo saat ini.
     */
    public double getSld() {
        return sld;
    }

    /**
     * Menambahkan pemasukan ke saldo dan mencatatnya dalam riwayat transaksi.
     *
     * @param jumlah     jumlah pemasukan yang ingin ditambahkan.
     * @param keterangan keterangan untuk pemasukan.
     */
    public void Tpemasukan(double jumlah, String keterangan) {
        if (jumlah > 0) {
            sld += jumlah;
            rwytransaksi.add("Pemasukan: " + jumlah + " (" + keterangan + ")");
            System.out.println("Pemasukan berhasil ditambahkan.");
        } else {
            System.out.println("Jumlah pemasukan tidak valid.");
        }
    }

    /**
     * Menambahkan pengeluaran dari saldo dan mencatatnya dalam riwayat transaksi.
     *
     * @param jumlah     jumlah pengeluaran yang ingin ditambahkan.
     * @param keterangan keterangan untuk pengeluaran.
     */
    public void tpengeluaran(double jumlah, String keterangan) {
        if (jumlah > 0 && jumlah <= sld) {
            sld -= jumlah;
            rwytransaksi.add("Pengeluaran: " + jumlah + " (" + keterangan + ")");
            System.out.println("Pengeluaran berhasil ditambahkan.");
        } else {
            System.out.println("Jumlah pengeluaran tidak valid atau saldo tidak cukup.");
        }
    }

    /**
     * Menampilkan riwayat semua transaksi yang telah dilakukan.
     */
    public void riwayatTransaksi() {
        if (rwytransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            System.out.println("Riwayat Transaksi:");
            for (String transaksi : rwytransaksi) {
                System.out.println(transaksi);
            }
        }
    }
}

/**
 * Kelas Main yang digunakan sebagai titik masuk untuk menjalankan program
 * pengelolaan uang kas.
 */
public class Main {
    /**
     * Metode utama untuk menjalankan program pengelolaan uang kas.
     *
     * @param args argumen baris perintah.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Kas kas = new Kas();
        int pilihan;

        do {
            System.out.println("\n=== Pengelolaan Uang Kas Kelas ===");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Tampilkan Saldo");
            System.out.println("4. Tampilkan Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan jumlah pemasukan: ");
                    double pemasukan = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Masukkan keterangan: ");
                    String ketPemasukan = scanner.nextLine();
                    kas.Tpemasukan(pemasukan, ketPemasukan);
                    break;
                case 2:
                    System.out.print("Masukkan jumlah pengeluaran: ");
                    double pengeluaran = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Masukkan keterangan: ");
                    String ketPengeluaran = scanner.nextLine();
                    kas.tpengeluaran(pengeluaran, ketPengeluaran);
                    break;
                case 3:
                    System.out.println("Saldo saat ini: Rp" + kas.getSld());
                    break;
                case 4:
                    kas.riwayatTransaksi();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Opsi tidak valid, coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
