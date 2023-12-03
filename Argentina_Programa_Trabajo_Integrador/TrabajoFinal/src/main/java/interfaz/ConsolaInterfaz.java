package interfaz;

import java.util.Scanner;

public class ConsolaInterfaz {

    private Scanner scanner;

    public ConsolaInterfaz() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("**********************************************");
        System.out.println(mensaje);
    }

    public String leerEntrada() {
        return scanner.nextLine();
    }

}
