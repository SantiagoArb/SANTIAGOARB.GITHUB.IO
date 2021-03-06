--REGLAS DE EMPRESA(POLI MUSIC)--
ALTER TABLE EMPRESA ADD CONSTRAINT PK_EMPRESA PRIMARY KEY(ID_EMPRESA);
ALTER TABLE EMPRESA ADD CONSTRAINT NN_NOMBRE_EMPRESA CHECK(NOMBRE_EMPRESA IS NOT NULL);
ALTER TABLE EMPRESA ADD CONSTRAINT NN_NIT_EMPRESA CHECK(NIT_EMPRESA IS NOT NULL);

--REGLAS EMPRESA DIFUSORA--
ALTER TABLE EMPRESA_DIFUSORA ADD CONSTRAINT PK_EMPRESA_DIFUSORA PRIMARY KEY(ID_EMPRESA_D);
ALTER TABLE EMPRESA_DIFUSORA ADD CONSTRAINT FK_EMAYOR FOREIGN KEY(ID_EMAYOR) REFERENCES EMPRESA(ID_EMPRESA);
ALTER TABLE EMPRESA_DIFUSORA ADD CONSTRAINT NN_NIT_EMPRESA_D CHECK(NIT_EMPRESA_D IS NOT NULL);
ALTER TABLE EMPRESA_DIFUSORA ADD CONSTRAINT NN_NOMBRE_EMPRESA_D CHECK(NOM_EMPRESA_D IS NOT NULL);

--REGLAS ARTISTA--
ALTER TABLE ARTISTA ADD CONSTRAINT PK_ID_ARTISTA PRIMARY KEY(ID_ARTISTA);
ALTER TABLE ARTISTA ADD CONSTRAINT FK_ID_EMPRESA_D_ART FOREIGN KEY(ID_EMPRESA_D_ART) REFERENCES EMPRESA_DIFUSORA(ID_EMPRESA_D);
ALTER TABLE ARTISTA ADD CONSTRAINT NN_NOM_ARTISTA CHECK(NOM_ARTISTA IS NOT NULL);
ALTER TABLE ARTISTA ADD CONSTRAINT NN_NOM_REPRESENTANTE CHECK(NOM_REPRESENTANTE IS NOT NULL);
ALTER TABLE ARTISTA ADD CONSTRAINT NN_DOC_REPRESENTANTE CHECK(DOC_REPRESENTANTE IS NOT NULL);
ALTER TABLE ARTISTA ADD CONSTRAINT NN_TEL_REPRESENTANTE CHECK(TEL_REPRESENTANTE IS NOT NULL);
ALTER TABLE ARTISTA ADD CONSTRAINT NN_COR_REPRESENTANTE CHECK(COR_REPRESENTANTE IS NOT NULL);


--REGLAS VENTAS--
ALTER TABLE VENTAS ADD CONSTRAINT PK_ID_VENTAS PRIMARY KEY(ID_VENTAS);
ALTER TABLE VENTAS ADD CONSTRAINT FK_ID_ARTISTA FOREIGN KEY(ID_ARTISTA_VE) REFERENCES ARTISTA(ID_ARTISTA);


--REGLAS REGALIAS--
ALTER TABLE REGALIAS ADD CONSTRAINT PK_ID_REGALIAS PRIMARY KEY(ID_REGALIAS);
ALTER TABLE REGALIAS ADD CONSTRAINT FK_ID_VENTAS_RE FOREIGN KEY(ID_VENTAS_RE) REFERENCES VENTAS(ID_VENTAS);


--REGLAS DE USUARIO--
ALTER TABLE USUARIO ADD CONSTRAINT PK_ID_USUARIO PRIMARY KEY(ID_USUARIO);
ALTER TABLE USUARIO ADD CONSTRAINT FK_ID_EMPRESA_U FOREIGN KEY(ID_EMPRESA_U) REFERENCES EMPRESA(ID_EMPRESA);


--REGLAS DE LOG--
ALTER TABLE LOG ADD CONSTRAINT PK_ID_LOG PRIMARY KEY(ID_LOG);
ALTER TABLE LOG ADD CONSTRAINT FK_ID_USUARIO FOREIGN KEY(ID_USUARIO_LOG) REFERENCES USUARIO(ID_USUARIO);

--REGLAS DE INFORMES--
ALTER TABLE INFORMES ADD CONSTRAINT PK_ID_INFORME PRIMARY KEY(ID_INFORME);
ALTER TABLE INFORMES ADD CONSTRAINT FK_ID_USUARIO_INF FOREIGN KEY(ID_USUARIO_INF) REFERENCES USUARIO(ID_USUARIO);

