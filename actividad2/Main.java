package actividad2;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<String> listaStrings = List.of("hola", "que", "tal", "como", "estas?");

        // Definir la lógica de transformación
        Transformador convertirAMayusculas = s -> s.toUpperCase();

        // Aplicar la transformación a la lista sin importación estática
        List<String> resultado = TransformadorStrings.transformarLista(listaStrings, convertirAMayusculas);

        // Imprimir el resultado
        System.out.println("Lista original: " + listaStrings);
        System.out.println("Lista transformada: " + resultado);


    }
}