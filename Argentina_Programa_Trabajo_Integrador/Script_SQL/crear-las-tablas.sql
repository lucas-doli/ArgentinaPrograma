
CREATE TABLE Cliente (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    razon_social VARCHAR(255),
    CUIT VARCHAR(20),
    servicio TEXT
);

CREATE TABLE Tecnico (
    id_tecnico INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    especialidades TEXT
);

CREATE TABLE Incidente (
    id_incidente INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    descripcion_problema TEXT,
    tipo_problema VARCHAR(100),
    id_tecnico_asignado INT,
    estado VARCHAR(50),
    fecha_resolucion DATETIME,
    FOREIGN KEY (id_cliente) REFERENCES Cliente(id_cliente),
    FOREIGN KEY (id_tecnico_asignado) REFERENCES Tecnico(id_tecnico)
);

CREATE TABLE Reporte (
    id_reporte INT PRIMARY KEY AUTO_INCREMENT,
    id_tecnico INT,
    estado_incidentes VARCHAR(50),
    FOREIGN KEY (id_tecnico) REFERENCES Tecnico(id_tecnico)
);

CREATE TABLE Incidente_Reporte (
    id_incidente INT,
    id_reporte INT,
    FOREIGN KEY (id_incidente) REFERENCES Incidente(id_incidente),
    FOREIGN KEY (id_reporte) REFERENCES Reporte(id_reporte),
    PRIMARY KEY (id_incidente, id_reporte)
);
