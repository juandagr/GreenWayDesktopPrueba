-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2017-08-22 14:12:09.01

-- enum
CREATE TYPE categorias_inversion AS ENUM ('APS', 'Equipos y maquinaria');
CREATE TYPE categorias_costos_operacionales AS ENUM ('Mano de obra', 'Insecticidas-acaricidas', 'Fungicidas', 'Herbicidas', 'Coadyuvantes', 'Fertilizantes foliares', 'Fertilizantes edaficos', 'Otros gastos-imprevistos');
CREATE TYPE dia_semana AS ENUM ('lunes', 'martes', 'miercoles', 'jueves', 'viernes', 'sabado', 'domingo');
CREATE TYPE semana_año AS ENUM('1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29'
, '30', '31', '32', '33', '34', '35', '36', '37', '38', '39', '40', '41', '42', '43', '44', '45', '46', '47', '48', '49', '50', '51', '52');
CREATE TYPE cargo_empleado AS ENUM ('Gerente', 'Administrador', 'Digitador');
CREATE TYPE estado_civil_empleado AS ENUM ('soltero', 'casado', 'viudo', 'divorciado');

-- tables
-- Table: Cliente
CREATE TABLE Cliente (
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    identificacion varchar(10)  NOT NULL,
    telefono varchar(10)  NOT NULL,
    direccion varchar(100)  NOT NULL,
    estado boolean  NOT NULL,
    correo varchar(100)  NULL,
    fotografia varchar(150)  NULL,
    CONSTRAINT Cliente_pk PRIMARY KEY (identificacion)
);

-- Table: Cultivo
CREATE TABLE Cultivo (
    identificador varchar(50)  NOT NULL,
    nombre varchar(50)  NOT NULL,
    descripcion varchar(500)  NOT NULL,
    CONSTRAINT Cultivo_pk PRIMARY KEY (identificador)
);

-- Table: Empleado
CREATE TABLE Empleado (
    nombre varchar(50)  NOT NULL,
    apellido varchar(50)  NOT NULL,
    identificacion varchar(10)  NOT NULL,
    cargo cargo_empleado  NOT NULL,
    telefono varchar(10)  NOT NULL,
    direccion varchar(40)  NOT NULL,
    estado boolean  NOT NULL,
    fotografia varchar(150)  NOT NULL,
    correo varchar(100)  NOT NULL,
    fecha_de_nacimiento date  NOT NULL,
    estado_civil estado_civil_empleado  NOT NULL,
    CONSTRAINT Empleado_pk PRIMARY KEY (identificacion)
);

-- Table: Lote
CREATE TABLE Lote (
    Cliente_identificacion varchar(10)  NOT NULL,
    Cultivo_identificador varchar(50)  NOT NULL,
    identificador varchar(100)  NOT NULL,
    area decimal(12,2)  NOT NULL,
    numero_plantas int  NOT NULL,
    costo_por_hora decimal(12,2)  NOT NULL,
    CONSTRAINT Lote_pk PRIMARY KEY (identificador)
);

-- Table: Produccion
CREATE TABLE Produccion (
    Lote_identificador varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    selecta decimal(10)  NOT NULL,
    corriente decimal(10)  NOT NULL,
    industrial decimal(10)  NOT NULL,
    CONSTRAINT Produccion_pk PRIMARY KEY (Lote_identificador,semana,dia)
);

-- Table: Ubicacion
CREATE TABLE Ubicacion (
    Lote_identificador varchar(100)  NOT NULL,
    departamento varchar(50)  NOT NULL,
    municipio varchar(50)  NOT NULL,
    vereda varchar(50)  NULL,
    CONSTRAINT Ubicacion_pk PRIMARY KEY (Lote_identificador)
);

-- Table: Usuario
CREATE TABLE Usuario (
    usuario varchar(100)  NOT NULL,
    password varchar(100)  NOT NULL,
    estado boolean  NOT NULL,
    Empleado_identificacion varchar(10)  NOT NULL,
    CONSTRAINT Usuario_pk PRIMARY KEY (usuario)
);

-- Table: Valor_factura
CREATE TABLE Valor_factura (
    Cliente_identificacion varchar(10)  NOT NULL,
    valor decimal(12,2)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    CONSTRAINT Valor_factura_pk PRIMARY KEY (Cliente_identificacion,semana)
);

-- Table: costos_comercializacion
CREATE TABLE costos_comercializacion (
    items_de_comercializacion_item varchar(100)  NOT NULL,
    Lote_identificador varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    valor decimal(12,2)  NOT NULL,
    CONSTRAINT costos_comercializacion_pk PRIMARY KEY (items_de_comercializacion_item,Lote_identificador,anio,semana,dia)
);

-- Table: costos_inversion
CREATE TABLE costos_inversion (
    Lote_identificador varchar(100)  NOT NULL,
    items_de_inversion_item varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    valor decimal(12,2)  NOT NULL,
    CONSTRAINT costos_inversion_pk PRIMARY KEY (Lote_identificador,items_de_inversion_item,anio,semana,dia)
);

-- Table: costos_operacionales
CREATE TABLE costos_operacionales (
    Lote_identificador varchar(100)  NOT NULL,
    items_de_inversion_item varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    horas int  NOT NULL,
    CONSTRAINT costos_operacionales_pk PRIMARY KEY (Lote_identificador,items_de_inversion_item,anio,semana,dia)
);

-- Table: costos_operacionales_otros
CREATE TABLE costos_operacionales_otros (
    Lote_identificador varchar(100)  NOT NULL,
    items_de_inversion_item varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    valor decimal(12,2)  NOT NULL,
    CONSTRAINT costos_operacionales_otros_pk PRIMARY KEY (Lote_identificador,items_de_inversion_item,anio,semana,dia)
);

-- Table: costos_operacionales_producto
CREATE TABLE costos_operacionales_producto (
    Lote_identificador varchar(100)  NOT NULL,
    items_de_inversion_item varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    costo_producto decimal(12,2)  NOT NULL,
    presentacion decimal(12,2)  NOT NULL,
    volumen_gastado decimal(12,2)  NOT NULL,
    costo_final decimal(12,2)  NOT NULL,
    CONSTRAINT costos_operacionales_producto_pk PRIMARY KEY (Lote_identificador,items_de_inversion_item,anio,semana,dia)
);

-- Table: historia_clinica
CREATE TABLE historia_clinica (
    Lote_identificador varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    descripcion varchar(50000)  NOT NULL,
    CONSTRAINT historia_clinica_pk PRIMARY KEY (Lote_identificador,anio,semana,dia)
);

-- Table: historial_aplicacion
CREATE TABLE historial_aplicacion (
    Lote_identificador varchar(100)  NOT NULL,
    id_historial varchar(100)  NOT NULL,
    anio varchar(20)  NOT NULL,
    semana semana_año  NOT NULL,
    dia dia_semana  NOT NULL,
    objetivo_biologico varchar(20)  NOT NULL,
    producto_utilizado varchar(20)  NOT NULL,
    dosis_por_litro decimal(12,2)  NOT NULL,
    volumen_utilizado decimal(12,2)  NOT NULL,
    CONSTRAINT historial_aplicacion_pk PRIMARY KEY (Lote_identificador,id_historial,anio,semana,dia)
);

-- Table: items_de_comercializacion
CREATE TABLE items_de_comercializacion (
    id serial  NOT NULL,
    item varchar(100)  NOT NULL,
    CONSTRAINT items_de_comercializacion_pk PRIMARY KEY (item)
);

-- Table: items_de_costos_operacionales
CREATE TABLE items_de_costos_operacionales (
    id serial  NOT NULL,
    categoria categorias_costos_operacionales  NOT NULL,
    item varchar(100)  NOT NULL,
    CONSTRAINT items_de_costos_operacionales_pk PRIMARY KEY (item)
);

-- Table: items_de_inversion
CREATE TABLE items_de_inversion (
    id serial  NOT NULL,
    categoria categorias_inversion  NOT NULL,
    item varchar(100)  NOT NULL,
    CONSTRAINT items_de_inversion_pk PRIMARY KEY (item)
);

-- foreign keys
-- Reference: Lote_Cliente (table: Lote)
ALTER TABLE Lote ADD CONSTRAINT Lote_Cliente
    FOREIGN KEY (Cliente_identificacion)
    REFERENCES Cliente (identificacion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Lote_Cultivo (table: Lote)
ALTER TABLE Lote ADD CONSTRAINT Lote_Cultivo
    FOREIGN KEY (Cultivo_identificador)
    REFERENCES Cultivo (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Produccion_Lote (table: Produccion)
ALTER TABLE Produccion ADD CONSTRAINT Produccion_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Tcostos_operacionales_producto_Lote (table: costos_operacionales_producto)
ALTER TABLE costos_operacionales_producto ADD CONSTRAINT Tcostos_operacionales_producto_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Tcostos_operacionales_producto_items_de_inversion (table: costos_operacionales_producto)
ALTER TABLE costos_operacionales_producto ADD CONSTRAINT Tcostos_operacionales_producto_items_de_inversion
    FOREIGN KEY (items_de_inversion_item)
    REFERENCES items_de_costos_operacionales (item)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Ubicacion_Lote (table: Ubicacion)
ALTER TABLE Ubicacion ADD CONSTRAINT Ubicacion_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Usuario_Empleado (table: Usuario)
ALTER TABLE Usuario ADD CONSTRAINT Usuario_Empleado
    FOREIGN KEY (Empleado_identificacion)
    REFERENCES Empleado (identificacion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Valor_factura_Cliente (table: Valor_factura)
ALTER TABLE Valor_factura ADD CONSTRAINT Valor_factura_Cliente
    FOREIGN KEY (Cliente_identificacion)
    REFERENCES Cliente (identificacion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_comercializacion_Lote (table: costos_comercializacion)
ALTER TABLE costos_comercializacion ADD CONSTRAINT costos_comercializacion_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_comercializacion_items_de_comercializacion (table: costos_comercializacion)
ALTER TABLE costos_comercializacion ADD CONSTRAINT costos_comercializacion_items_de_comercializacion
    FOREIGN KEY (items_de_comercializacion_item)
    REFERENCES items_de_comercializacion (item)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_inversion_Lote (table: costos_inversion)
ALTER TABLE costos_inversion ADD CONSTRAINT costos_inversion_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_inversion_items_de_inversion (table: costos_inversion)
ALTER TABLE costos_inversion ADD CONSTRAINT costos_inversion_items_de_inversion
    FOREIGN KEY (items_de_inversion_item)
    REFERENCES items_de_inversion (item)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_operacionales_Lote (table: costos_operacionales)
ALTER TABLE costos_operacionales ADD CONSTRAINT costos_operacionales_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_operacionales_items_de_inversion (table: costos_operacionales)
ALTER TABLE costos_operacionales ADD CONSTRAINT costos_operacionales_items_de_inversion
    FOREIGN KEY (items_de_inversion_item)
    REFERENCES items_de_costos_operacionales (item)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_operacionales_otros_Lote (table: costos_operacionales_otros)
ALTER TABLE costos_operacionales_otros ADD CONSTRAINT costos_operacionales_otros_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: costos_operacionales_otros_items_de_inversion (table: costos_operacionales_otros)
ALTER TABLE costos_operacionales_otros ADD CONSTRAINT costos_operacionales_otros_items_de_inversion
    FOREIGN KEY (items_de_inversion_item)
    REFERENCES items_de_costos_operacionales (item)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: historia_clinica_Lote (table: historia_clinica)
ALTER TABLE historia_clinica ADD CONSTRAINT historia_clinica_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: historial_aplicacion_Lote (table: historial_aplicacion)
ALTER TABLE historial_aplicacion ADD CONSTRAINT historial_aplicacion_Lote
    FOREIGN KEY (Lote_identificador)
    REFERENCES Lote (identificador)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

