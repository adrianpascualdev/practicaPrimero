package Tiempo;

public class Tiempo {

    private int hora, minutos;

    private float segundos;

    public Tiempo(int hora, int minutos, float segundos1) {

        if (hora < 0 || hora > 23) {
            throw new IllegalArgumentException("Hora no valido");
        }
        if (minutos < 0 || minutos > 59) {
            throw new IllegalArgumentException("Minutos no valido");
        }
        if (segundos1 < 0 || segundos1 > 59) {
            throw new IllegalArgumentException("Segundos no valido");
        }

        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos1;
    }

    public int getHora() {
        return hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public float getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return String.format("El tiempo es de %d horas, %d segundos y %.2f segundos", hora, minutos, segundos);
    }

    @Override
    public boolean equals(Object o) {
        Tiempo t = (Tiempo) o;
        return this.hora == t.hora && this.minutos == t.minutos && this.segundos == t.segundos;
    }

}

class TestTiempo {

    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo(23,2,12);
        Tiempo tiempo2 = new Tiempo(23,2,12);
        Tiempo tiempo3 = new Tiempo(23,2,13);

        checkEquals(tiempo,tiempo2);
        checkEquals(tiempo,tiempo3);

        System.out.println(tiempo);
    }

    public static void checkEquals(Tiempo tiempo, Tiempo tiempo2) {
        System.out.println(tiempo.equals(tiempo2) ? "Son iguales" : "No son iguales");
    }

}


