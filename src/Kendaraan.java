public class Kendaraan {

    String platNomor;
    String tipe;
    String merk;

    Kendaraan(String platNomor, String tipe, String merk) {
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merk = merk;
    }

    void tampilInformasi() {
        System.out.println(platNomor + "\t" + tipe + "\t" + merk);
    }

}
