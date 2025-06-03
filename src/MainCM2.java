import java.util.Scanner;

public class MainCM2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        Bbm[] arrBbm = new Bbm[4];
        arrBbm[0] = new Bbm("Pertalite", 10000);
        arrBbm[1] = new Bbm("Pertamax", 12400);
        arrBbm[2] = new Bbm("Biosolar", 6800);
        arrBbm[3] = new Bbm("Dexlite", 13400);
        Bbm dataBbm = new Bbm();
        AntrianBbm list = new AntrianBbm();
        int pilihan;
        do {
            System.out.println("\n++++++++++++++++++++++++++++++++");
            System.out.println("Sistem Antrian SPBU");
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Cek Sisa Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Sort Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.println("++++++++++++++++++++++++++++++++");
            System.out.print("Pilih menu : ");
            pilihan = input.nextInt();
            input.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.print("Input Plat Nomor : ");
                    String plat = input.nextLine();
                    System.out.print("Input jenis kendaraan : ");
                    String tipe = input.nextLine();
                    System.out.print("Input Merk: ");
                    String merk = input.nextLine();
                    Kendaraan transport = new Kendaraan(plat, tipe, merk);
                    list.AddAntrian(transport);
                    break;
                case 2:
                    list.printAntrian();
                    break;
                case 3:
                    int sisa = list.cekSisaAntrian();
                    System.out.println("Sisa Kendaraan : " + sisa);

                    break;
                case 4:
                    System.out.println("Kendaraan : " + list.head1.kendaraan.platNomor);
                    System.out.println("Daftar Jenis BBM : ");
                    dataBbm.tampilInformasi(arrBbm);
                    System.out.print("Input Jenis BBM : ");
                    String jenisBbm = input.nextLine();
                    Bbm namaBbm = list.searchBbm(arrBbm, jenisBbm);
                    if (namaBbm == null) {
                        System.out.println("Jenis BBM tidak ditemukan!");
                        break;
                    }
                    Kendaraan kendaraanDilayani = list.layaniKendaraan();
                    System.out.print("Jumlah Liter : ");
                    int liter = input.nextInt();
                    TransaksiPengisian transaksiPengisian = new TransaksiPengisian(kendaraanDilayani, namaBbm, liter);
                    list.riwayatTransaksi(transaksiPengisian);
                    System.out.println("Transaksi Berhasil");
                    break;
                case 5:
                    list.tampilRiwayat();
                    break;
                case 6:

                    break;
                case 0:
                    System.out.println("\nTerima Kasih!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid.");
            }
        } while (pilihan != 0);

        input.close();
    }
}
