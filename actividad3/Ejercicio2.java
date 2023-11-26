package actividad3;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio2 {

    public static String concatenarPalabrasMasLargas(List<String> lista, int n) {
        return lista.stream()
                .filter(s -> s.length() > n)
                .collect(Collectors.joining(", "));
    }


}
