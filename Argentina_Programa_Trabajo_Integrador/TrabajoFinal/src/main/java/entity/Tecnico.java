package entity;

import lombok.Data;
import java.util.List;

@Data
public class Tecnico {

    private int idTecnico;
    private String nombre;
    private List<String> especialidades;

}


