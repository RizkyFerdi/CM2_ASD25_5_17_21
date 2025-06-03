public class TransaksiPengisian {

    Kendaraan kendaraan;
    Bbm bbm;
    int jumlahLiter;

    public TransaksiPengisian() {
    }

    public TransaksiPengisian(Kendaraan kendaraan, Bbm bbm, int jumlahLiter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.jumlahLiter = jumlahLiter;
    }

    void tampilTransaksi(double total) {
        System.out.println(kendaraan.platNomor + " \t" + kendaraan.tipe + " \t\t" + bbm.namaBbm + " \t" + total);
    }
}
