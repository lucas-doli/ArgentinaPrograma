-- Insertar registros en la tabla Cliente
INSERT INTO Cliente (razon_social, CUIT, servicio) VALUES
    ('Empresa 1', '1234567890', 'Servicio 1'),
    ('Empresa 2', '0987654321', 'Servicio 2'),
    ('Empresa 3', '2468013579', 'Servicio 3'),
    ('Empresa 4', '9876543210', 'Servicio 4'),
    ('Empresa 5', '1357924680', 'Servicio 5'),
    ('Empresa 6', '1122334455', 'Servicio 6'),
    ('Empresa 7', '6677889900', 'Servicio 7'),
    ('Empresa 8', '5544332211', 'Servicio 8'),
    ('Empresa 9', '9998887776', 'Servicio 9'),
    ('Empresa 10', '4445556667', 'Servicio 10');

-- Insertar registros en la tabla Tecnico
INSERT INTO Tecnico (nombre, especialidades) VALUES
    ('Técnico 1', 'Especialidad 1, Especialidad 2'),
    ('Técnico 2', 'Especialidad 2, Especialidad 3'),
    ('Técnico 3', 'Especialidad 3, Especialidad 4'),
    ('Técnico 4', 'Especialidad 4, Especialidad 5'),
    ('Técnico 5', 'Especialidad 5, Especialidad 6'),
    ('Técnico 6', 'Especialidad 6, Especialidad 7'),
    ('Técnico 7', 'Especialidad 7, Especialidad 8'),
    ('Técnico 8', 'Especialidad 8, Especialidad 9'),
    ('Técnico 9', 'Especialidad 9, Especialidad 10'),
    ('Técnico 10', 'Especialidad 10, Especialidad 1');

-- Insertar registros en la tabla Incidente
INSERT INTO Incidente (id_cliente, descripcion_problema, tipo_problema, id_tecnico_asignado, estado, fecha_resolucion) VALUES
    (1, 'Problema 1', 'Tipo A', 1, 'Pendiente', '2023-11-20 10:00:00'),
    (2, 'Problema 2', 'Tipo B', 2, 'En proceso', '2023-11-21 12:00:00'),
    (3, 'Problema 3', 'Tipo C', 3, 'Resuelto', '2023-11-22 15:00:00'),
    (4, 'Problema 4', 'Tipo D', 4, 'Pendiente', '2023-11-23 14:00:00'),
    (5, 'Problema 5', 'Tipo E', 5, 'En proceso', '2023-11-24 11:00:00'),
    (6, 'Problema 6', 'Tipo F', 6, 'Resuelto', '2023-11-25 16:00:00'),
    (7, 'Problema 7', 'Tipo G', 7, 'Pendiente', '2023-11-26 13:00:00'),
    (8, 'Problema 8', 'Tipo H', 8, 'En proceso', '2023-11-27 09:00:00'),
    (9, 'Problema 9', 'Tipo I', 9, 'Resuelto', '2023-11-28 08:00:00'),
    (10, 'Problema 10', 'Tipo J', 10, 'Pendiente', '2023-11-29 17:00:00');

-- Insertar registros en la tabla Reporte
INSERT INTO Reporte (id_tecnico, estado_incidentes) VALUES
    (1, 'Pendiente'),
    (2, 'En proceso'),
    (3, 'Resuelto'),
    (4, 'Pendiente'),
    (5, 'En proceso'),
    (6, 'Resuelto'),
    (7, 'Pendiente'),
    (8, 'En proceso'),
    (9, 'Resuelto'),
    (10, 'Pendiente');

-- Insertar registros en la tabla Incidente_Reporte (relacionando incidentes y reportes)
INSERT INTO Incidente_Reporte (id_incidente, id_reporte) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8),
    (9, 9),
    (10, 10);
