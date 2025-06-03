public class AntrianBbm {
    NodeAntrian head;
    NodeAntrian tail;
    int size;

    boolean isEmpty() {
        return (head == null);
    }

    public void AddAntrian(Kendaraan Kendaraan) {
        NodeAntrian ndInput = new NodeAntrian(Kendaraan, null);
        if (isEmpty()) {
            head = ndInput;
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
            NodeAntrian tmp = head;
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

}
