public class Bbm {

    String namaBbm;
    double hargaPerLiter;

    Bbm() {

    }

    Bbm(String namaBbm, double hargaPerLiter) {
        this.namaBbm = namaBbm;
        this.hargaPerLiter = hargaPerLiter;
    }

    void tampilInformasi(Bbm[] arrBbm) {
        System.out.println("Jenis BBM\t Harga");
        for (Bbm bbm : arrBbm) {
            System.out.println(bbm.namaBbm + "  \t" + bbm.hargaPerLiter);
        }
    }

}