DROP SEQUENCE SQ_ID_EMPRESA;
DROP SEQUENCE SQ_ID_EMPRESA_DIFUSORA;
DROP SEQUENCE SQ_ID_USUARIO;
DROP SEQUENCE SQ_ID_ARTISTA;

create sequence SQ_ID_EMPRESA
start with 1
increment by 1
nocache;

create sequence SQ_ID_EMPRESA_DIFUSORA
start with 1
increment by 1
nocache;

create sequence SQ_ID_ARTISTA
start with 5
increment by 1
nocache;

create sequence SQ_ID_USUARIO
start with 1
increment by 1
nocache;

create sequence SQ_ID_LOG
start with 1
increment by 1
nocache;


