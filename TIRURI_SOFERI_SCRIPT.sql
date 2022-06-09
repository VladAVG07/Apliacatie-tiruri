DROP TABLE SOFERI;
CREATE TABLE SOFERI
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NUME VARCHAR(100) NOT NULL,
PRENUME VARCHAR(100) NOT NULL,
CNP VARCHAR(13) NOT NULL,
IMAGEPATH VARCHAR(100) NOT NULL
);


ALTER TABLE SOFERI ADD PRIMARY KEY(ID);
ALTER TABLE SOFERI ADD UNIQUE(CNP);


DROP TABLE TIRURI;
CREATE TABLE TIRURI
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
MARCA INTEGER NOT NULL,
MODEL VARCHAR(100) NOT NULL,
NR_INMATRICULARE VARCHAR(7) NOT NULL,
STARE INTEGER NOT NULL
);

ALTER TABLE TIRURI ADD PRIMARY KEY(ID);
ALTER TABLE TIRURI ADD UNIQUE(NR_INMATRICULARE);

DROP TABLE MARCA;
CREATE TABLE MARCA
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NUME VARCHAR(100) NOT NULL,
ACTIVA INTEGER NOT NULL
);

ALTER TABLE MARCA ADD PRIMARY KEY(ID);
ALTER TABLE MARCA ADD UNIQUE(NUME);

DROP TABLE SOFERI_TIRURI;
CREATE TABLE SOFERI_TIRURI
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
SOFER INTEGER NOT NULL,
TIR INTEGER NOT NULL
);

ALTER TABLE SOFERI_TIRURI ADD PRIMARY KEY(ID);

DROP TABLE INREGISTRARI;
CREATE TABLE INREGISTRARI
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
SOFERI_TIRURI INTEGER NOT NULL,
DATA_SOSIRE DATE NOT NULL,
DATA_PLECARE DATE
);

ALTER TABLE INREGISTRARI ADD PRIMARY KEY(ID);

DROP TABLE STARI;
CREATE TABLE STARI
(
ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
NUME VARCHAR(100) NOT NULL,
VALID INTEGER NOT NULL
);

ALTER TABLE STARI ADD PRIMARY KEY(ID);
ALTER TABLE STARI ADD UNIQUE(NUME);

ALTER TABLE TIRURI
ADD FOREIGN KEY(MARCA)
REFERENCES MARCA(ID);

ALTER TABLE TIRURI
ADD FOREIGN KEY(STARE)
REFERENCES STARI(ID);

ALTER TABLE SOFERI_TIRURI
ADD FOREIGN KEY(SOFER)
REFERENCES SOFERI(ID);

ALTER TABLE SOFERI_TIRURI
ADD FOREIGN KEY(TIR)
REFERENCES TIRURI(ID);

ALTER TABLE INREGISTRARI
ADD FOREIGN KEY(SOFERI_TIRURI)
REFERENCES SOFERI_TIRURI(ID);
