package Tiempo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo(23,2,12);
        Tiempo tiempo2 = new Tiempo(23,2,12);
        Tiempo tiempo3 = new Tiempo(23,2,13);

        System.out.println(tiempo.equals(tiempo2));
        System.out.println(tiempo.equals(tiempo3));

        System.out.println(tiempo);
    }

}