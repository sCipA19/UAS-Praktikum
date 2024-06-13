import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Kendaraan28 {
    private String noTNKB;
    private String nama;
    private String jenis;
    private int cc;
    private int tahun;
    private int bulanHarusBayar;

    public Kendaraan28(String noTNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        this.noTNKB = noTNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getCc() {
        return cc;
    }

    public int getTahun() {
        return tahun;
    }

    public int getBulanHarusBayar() {
        return bulanHarusBayar;
    }

    public String toString() {
        return "Kendaraan{" +
                "noTNKB='" + noTNKB + '\'' +
                ", nama='" + nama + '\'' +
                ", jenis='" + jenis + '\'' +
                ", cc=" + cc +
                ", tahun=" + tahun +
                ", bulanHarusBayar=" + bulanHarusBayar +
                '}';
    }
}
