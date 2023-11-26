package actividad2;

import java.util.ArrayList;
import java.util.List;

public class TransformadorStrings {
    public static List<String> transformarLista(List<String> lista, Transformador transformador) {
        List<String> resultado = new ArrayList<>();

        for (String cadena : lista) {
            resultado.add(transformador.transformar(cadena));
        }

        return resultado;
    }

}
