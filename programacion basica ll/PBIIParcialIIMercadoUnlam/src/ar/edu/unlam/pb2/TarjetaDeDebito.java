package ar.edu.unlam.pb2;

public class TarjetaDeDebito extends Pagadora {
    public TarjetaDeDebito(Double sueldo, Long numero, String titular, String fechaDeVencimiento,Integer codigoDeSeguridad) {
        super(sueldo, numero, titular, codigoDeSeguridad, fechaDeVencimiento);
    }
}
