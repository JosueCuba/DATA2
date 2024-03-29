CREATE TABLE departamento (
    clvdpto    NUMBER(3)
        CONSTRAINT pk_clvdpto PRIMARY KEY,
    coddpto    CHAR(10)
        CONSTRAINT un_coddpto UNIQUE,
    nombdpto   CHAR(20)
        CONSTRAINT nn_nombdpto NOT NULL
);

CREATE TABLE areaconoc (
    clvarea    NUMBER(3)
        CONSTRAINT pk_clvarea PRIMARY KEY,
    codarea    CHAR(10)
        CONSTRAINT un_codarea UNIQUE,
    nombarea   CHAR(30)
        CONSTRAINT nn_nombarea NOT NULL,
    clvdpto    NUMBER(3),
    CONSTRAINT fk_clvdptoarea FOREIGN KEY ( clvdpto )
        REFERENCES departamento ( clvdpto )
);

CREATE TABLE profesor (
    clvprof    NUMBER(3)
        CONSTRAINT pk_clvprof PRIMARY KEY,
    codprof    CHAR(10)
        CONSTRAINT un_codprof UNIQUE,
    nombprof   CHAR(30)
        CONSTRAINT nn_nombprof NOT NULL,
    clvarea    NUMBER(3),
    CONSTRAINT fk_clvareaprof FOREIGN KEY ( clvarea )
        REFERENCES areaconoc ( clvarea )
);

CREATE TABLE asignatura (
    clvasign    NUMBER(3)
        CONSTRAINT pk_clvasign PRIMARY KEY,
    codasign    CHAR(10)
        CONSTRAINT un_codasign UNIQUE,
    nombasign   CHAR(30)
        CONSTRAINT nn_nombasign NOT NULL,
    tt_ht       NUMBER(3),
    tt_hp       NUMBER(3),
    clvarea     NUMBER(3),
    CONSTRAINT fk_clvareaasig FOREIGN KEY ( clvarea )
        REFERENCES areaconoc ( clvarea )
);

CREATE TABLE titulacion (
    clvtitulo    NUMBER(3)
        CONSTRAINT pk_clvtitulo PRIMARY KEY,
    codtitulo    CHAR(10)
        CONSTRAINT un_codtitulo UNIQUE,
    nombtitulo   CHAR(20)
        CONSTRAINT nn_nombtitulo NOT NULL
);

CREATE TABLE imparteasign (
    clvprof    NUMBER(3),
    clvasign   NUMBER(3),
    ht         NUMBER(4),
    hp         NUMBER(4),
    CONSTRAINT fk_clvprofimpasg FOREIGN KEY ( clvprof )
        REFERENCES profesor ( clvprof ),
    CONSTRAINT fk_clvasigimpasg FOREIGN KEY ( clvasign )
        REFERENCES asignatura ( clvasign )
);

CREATE TABLE asigntitulo (
    clvasign    NUMBER(3),
    clvtitulo   NUMBER(3),
    CONSTRAINT fk_clvasgasgtit FOREIGN KEY ( clvasign )
        REFERENCES asignatura ( clvasign ),
    CONSTRAINT fk_clvtitasgtit FOREIGN KEY ( clvtitulo )
        REFERENCES titulacion ( clvtitulo )
);


INSERT INTO Departamento VALUES ( 1, '284D', 'DIEI');
INSERT INTO Departamento VALUES ( 2, '285D', 'ING.MEC.');
INSERT INTO Departamento VALUES ( 3, '286D', 'MAT.APL.');
INSERT INTO AreaConoc VALUES ( 1, 'AC001', 'LENG. Y SIST. INFORM.', 1);
INSERT INTO AreaConoc VALUES ( 2, 'AC002', 'TECN. ELECTRONICA', 1);
INSERT INTO AreaConoc VALUES ( 3, 'AC003', 'ING. ELECTRICA', 1);
INSERT INTO AreaConoc VALUES ( 4, 'AC004', 'ING. DE TRANSPORTES', 2);
INSERT INTO AreaConoc VALUES ( 5, 'AC005', 'EXPR. GRAFICA', 2);
INSERT INTO AreaConoc VALUES ( 6, 'AC006', 'MATEM. APLICADA', 3);
INSERT INTO AreaConoc VALUES ( 7, 'AC007', 'TECN. MATEMATICA', 3);
INSERT INTO Profesor VALUES ( 1, 'PRF001', 'S. VELILLA', 1);
INSERT INTO Profesor VALUES ( 2, 'PRF002', 'J. CAMPOS', 1);
INSERT INTO Profesor VALUES ( 3, 'PRF003', 'J. NAVARRO', 2);
INSERT INTO Profesor VALUES ( 4, 'PRF004', 'A. MTNEZ.', 2);
INSERT INTO Profesor VALUES ( 5, 'PRF005', 'I. RAMIREZ', 3);
INSERT INTO Profesor VALUES ( 6, 'PRF006', 'E. CAROD', 3);
INSERT INTO Profesor VALUES ( 7, 'PRF007', 'A. MIRAVETE', 4);
INSERT INTO Profesor VALUES ( 8, 'PRF008', 'J. ORTAS', 4);
INSERT INTO Profesor VALUES ( 9, 'PRF009', 'E. ZUBIAURRE', 5);
INSERT INTO Profesor VALUES ( 10, 'PRF010', 'G. TRAVER', 5);
INSERT INTO Profesor VALUES ( 11, 'PRF011', 'V. CAMARENA', 6);
INSERT INTO Profesor VALUES ( 12, 'PRF012', 'C. BUDRIA', 6);
INSERT INTO Profesor VALUES ( 13, 'PRF013', 'J.M. CORREAS', 7);
INSERT INTO Profesor VALUES ( 14, 'PRF014', 'M. AGUADO', 7);
INSERT INTO Asignatura VALUES ( 1, 'ASG001', 'INFORMATICA', 90, 30, 1);
INSERT INTO Asignatura VALUES ( 2, 'ASG002', 'FICH. y B.DATOS', 45, 20, 1);
INSERT INTO Asignatura VALUES ( 3, 'ASG003', 'ELECTRONICA DIGITAL', 60, 35, 2);
INSERT INTO Asignatura VALUES ( 4, 'ASG004', 'MICROELECTRONICA', 20, 10, 2);
INSERT INTO Asignatura VALUES ( 5, 'ASG005', 'ELECTROTECNIA', 30, 30, 3);
INSERT INTO Asignatura VALUES ( 6, 'ASG006', 'LINEAS Y REDES', 25, 15, 3);
INSERT INTO Asignatura VALUES ( 7, 'ASG007', 'FERROCARRILES', 10, 10, 4);
INSERT INTO Asignatura VALUES ( 8, 'ASG008', 'TRACCION ELECTR.', 20, 20, 4);
INSERT INTO Asignatura VALUES ( 9, 'ASG009', 'DIBUJO I', 40, 20, 5);
INSERT INTO Asignatura VALUES ( 10, 'ASG010', 'GEOM. DESCRIPTIVA', 40, 10, 5);
INSERT INTO Asignatura VALUES ( 11, 'ASG011', 'ALGEBRA', 60, 0, 6);
INSERT INTO Asignatura VALUES ( 12, 'ASG012', 'GEOM. DIFERENCIAL', 40, 0, 6);
INSERT INTO Asignatura VALUES ( 13, 'ASG013', 'CALCULO', 20, 10, 7);
INSERT INTO Asignatura VALUES ( 14, 'ASG014', 'CALCULO NUMERICO', 40, 20, 7);
INSERT INTO Titulacion VALUES ( 1, 'TIT001', 'ING. INFORMATICA');
INSERT INTO Titulacion VALUES ( 2, 'TIT002', 'ING. TELECOMUNICAC.');
INSERT INTO Titulacion VALUES ( 3, 'TIT003', 'ING. INDUSTRIAL');
INSERT INTO Titulacion VALUES ( 4, 'TIT004', 'ING. TECN. ELECTRON.');
INSERT INTO ImparteAsign VALUES ( 1, 1, 3, 4);
INSERT INTO ImparteAsign VALUES ( 1, 2, 23, 44);
INSERT INTO ImparteAsign VALUES ( 14, 14, 13, 0);
INSERT INTO AsignTitulo VALUES ( 1, 1);
INSERT INTO AsignTitulo VALUES ( 1, 2);
INSERT INTO AsignTitulo VALUES ( 1, 3);
INSERT INTO AsignTitulo VALUES ( 1, 4);
INSERT INTO AsignTitulo VALUES ( 2, 1);
INSERT INTO AsignTitulo VALUES ( 2, 2);
INSERT INTO AsignTitulo VALUES ( 2, 3);
INSERT INTO AsignTitulo VALUES ( 2, 4)