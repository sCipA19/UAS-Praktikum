class TransaksiPajak28 {
    private static int kodeCounter = 1; // Auto-increment kode

    private int kode;
    private long nominalBayar;
    private long denda;
    private int bulanBayar;
    private Kendaraan28 kendaraan;

    // Constructor
    public TransaksiPajak28(long nominalBayar, long denda, int bulanBayar, Kendaraan28 kendaraan) {
        this.kode = kodeCounter++;
        this.nominalBayar = nominalBayar;
        this.denda = denda;
        this.bulanBayar = bulanBayar;
        this.kendaraan = kendaraan;
    }

    // Getters
    public int getKode() {
        return kode;
    }

    public long getNominalBayar() {
        return nominalBayar;
    }

    public long getDenda() {
        return denda;
    }

    public int getBulanBayar() {
        return bulanBayar;
    }

    public Kendaraan28 getKendaraan() {
        return kendaraan;
    }

    public String toString() {
        return String.format("%-5d %-10s %-20s %-15s %-10d %-10d",
                kode, kendaraan.getNoTNKB(), kendaraan.getNama(),
                "Rp " + nominalBayar, denda, bulanBayar);
    }
}