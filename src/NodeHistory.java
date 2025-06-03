public class NodeHistory {

    TransaksiPengisian dataTrs;
    NodeHistory next;

    public NodeHistory(TransaksiPengisian dataTrs, NodeHistory next) {
        this.dataTrs = dataTrs;
        this.next = next;
    }

}
