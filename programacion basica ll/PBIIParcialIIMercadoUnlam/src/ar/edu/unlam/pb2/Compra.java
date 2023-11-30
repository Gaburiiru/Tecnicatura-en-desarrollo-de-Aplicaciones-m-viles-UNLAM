package ar.edu.unlam.pb2;

import java.util.Date;

public class Compra {
    private double monto;
    private Comercio comercio;
    private Date fecha;

    public Compra(double monto, Comercio comercio) {
        this.monto = monto;
        this.comercio = comercio;
        this.fecha = new Date();
    }

    public double getMonto() {
        return monto;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public Date getFecha() {
        return fecha;
    }
}
