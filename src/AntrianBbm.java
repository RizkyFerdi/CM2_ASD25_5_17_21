public class AntrianBbm {
    NodeAntrian head1;
    NodeHistory head2;
    NodeAntrian tail;
    TransaksiPengisian transaksiPengisian;
    int size;

    boolean isEmpty() {
        if (head1 == null) {
            return true;
        } else if (head2 == null) {
            return true;
        } else {
            return false;
        }
    }

    public void AddAntrian(Kendaraan Kendaraan) {
        NodeAntrian ndInput = new NodeAntrian(Kendaraan, null);
        if (isEmpty()) {
            head1 = ndInput;

            tail = ndInput;
            System.out.println(">> Kendaraan Masuk Ke Dalam Antrian");
            size++;
        } else {
            tail.next = ndInput;
            tail = ndInput;
            System.out.println(">> Kendaraan Masuk ke Dalam Antrian");
            size++;
        }
    }

    public void printAntrian() {
        if (!isEmpty()) {
            NodeAntrian tmp = head1;
            System.out.println("Antrian Kendaraan:\t");
            System.out.println("Plat\t Tipe\t Merk");
            System.out.println("-------------------------------------");
            while (tmp != null) {
                tmp.kendaraan.tampilInformasi();
                tmp = tmp.next;
            }
            System.out.println("");
        } else {
            System.out.println("Antrian Kosong\n");
        }
    }

    int cekSisaAntrian() {
        return size;
    }

    Kendaraan layaniKendaraan() {
        if (isEmpty()) {
            System.out.println("Antrean kosong, tidak dapat dipanggil!");
            return null;
        }

        Kendaraan kendaraanDilayani = head1.kendaraan;
        head1 = head1.next;

        if (head1 == null) {
            tail = null;
        }

        size--;
        return kendaraanDilayani;
    }

    void riwayatTransaksi(TransaksiPengisian input) {
        NodeHistory ndInput = new NodeHistory(input, null);
        if (isEmpty()) {
            head2 = ndInput;
        } else {
            NodeHistory temp = head2;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = ndInput;
        }
    }

    void tampilRiwayat() {
        if (isEmpty()) {
            System.out.println("Riwayat transaksi kosong!");
            return;
        } else {
            NodeHistory temp = head2;
            System.out.println("Plat \tJenis Kdr \t Jenis BBM \t Total");
            while (temp != null) {
                double total = temp.dataTrs.bbm.hargaPerLiter * temp.dataTrs.jumlahLiter;
                temp.dataTrs.tampilTransaksi(total);
                temp = temp.next;
            }
        }
    }

    Bbm searchBbm(Bbm[] arrBbm, String input) {
        for (int i = 0; i < arrBbm.length; i++) {
            if (arrBbm[i].namaBbm.equalsIgnoreCase(input)) {
                return arrBbm[i];
            }
        }
        return null;
    }

    public void sortByPlat() {
        if (head2 == null || head2.next == null)
            return;
        boolean swap;
        do {
            swap = false;
            NodeHistory current = head2;
            while (current.next != null) {
                if (current.dataTrs.kendaraan.platNomor.compareTo(current.next.dataTrs.kendaraan.platNomor) > 0) {
                    Kendaraan temp = current.dataTrs.kendaraan;
                    current.dataTrs.kendaraan = current.next.dataTrs.kendaraan;
                    current.next.dataTrs.kendaraan = temp;
                    swap = true;
                }
                current = current.next;
            }
        } while (swap);
    }
}
