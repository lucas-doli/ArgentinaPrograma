package actividad3;

import java.util.List;
import java.util.stream.Collectors;

public class Ejercicio1 {

    public static List<String> convertirAMayusculas(List<String> lista) {
        return lista.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

}
