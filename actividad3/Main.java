package actividad3;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> listaStrings = List.of("hola", "qué", "tal", "como", "estás?");

        // Convertir lista a mayúsculas
        List<String> listaMayusculas = Ejercicio1.convertirAMayusculas(listaStrings);

        // Imprimir el resultado
        System.out.println("Lista original: " + listaStrings);
        System.out.println("Lista en mayúsculas: " + listaMayusculas);


        // Ejercicio2

        List<String> listaStrings2 = List.of("hola", "qué", "tal", "estás");

        // Concatenar palabras con más de "n" caracteres
        int longitudMinima = 3;
        String resultado = Ejercicio2.concatenarPalabrasMasLargas(listaStrings, longitudMinima);

        // Imprimir el resultado
        System.out.println("Lista original2: " + listaStrings);
        System.out.println("Palabras con más de " + longitudMinima + " caracteres: " + resultado);


    }
}
