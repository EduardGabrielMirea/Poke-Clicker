package poke.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Evoluciones {
    @Id
    private int e1;

    private int e2;
    private int e3;

    public Evoluciones() {
    }

    public Evoluciones(int e1, int e2, int e3) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
    }

    public Evoluciones(int e1, int e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public int getE1() {
        return e1;
    }

    public int getE2() {
        return e2;
    }

    public int getE3() {
        return e3;
    }

    public void setE1(int e1) {
        this.e1 = e1;
    }

    public void setE3(int e3) {
        this.e3 = e3;
    }

    public void setE2(int e2) {
        this.e2 = e2;
    }

    @Override
    public String toString() {
        return "Evoluciones{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                ", e3=" + e3 +
                '}';
    }
}
