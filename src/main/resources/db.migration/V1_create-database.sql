--Ancient Code
--/*
--*RM552292  Julia Nery
--*RM98163  Júlia Figueiredo
--*RM552389  Isabelli Heloiza
--*RM550562  Larissa Akemi
--*RM94679  Vínicius Becker
--*/
--EXCLUSÃO DE TABELAS EXISTENTES--
DROP TABLE tbCliente CASCADE CONSTRAINTS;
DROP TABLE tbBicicleta CASCADE CONSTRAINTS;
DROP TABLE tbSeguro CASCADE CONSTRAINTS;
DROP TABLE tbMarca CASCADE CONSTRAINTS;
DROP TABLE tbModelo CASCADE CONSTRAINTS;
DROP TABLE tbCor CASCADE CONSTRAINTS;
DROP TABLE tbTipoSeguro CASCADE CONSTRAINTS;
DROP TABLE tbMeioPag CASCADE CONSTRAINTS;
DROP TABLE tbCobAdc CASCADE CONSTRAINTS;
DROP TABLE tbCobAdc_seguro CASCADE CONSTRAINTS;

--CRIAÇÃO DA TABELA QUE GUARDARA OS DADOS DOS CLIENTES--
CREATE TABLE tbCliente(
    cpfCliente NUMBER(11) CONSTRAINT cliente_cpf_pk PRIMARY KEY,
    nomeCliente VARCHAR(45) CONSTRAINT cliente_nm_nn NOT NULL,
    telCliente NUMBER(11)  CONSTRAINT cliente_tel_nn NOT NULL,
    emailCliente VARCHAR(60)  CONSTRAINT cliente_email_nn NOT NULL,
    cepCliente NUMBER(8)  CONSTRAINT cliente_cep_nn NOT NULL,
    logCliente VARCHAR(45)  CONSTRAINT cliente_log_nn NOT NULL,
    numLogCliente VARCHAR(8)  CONSTRAINT cliente_numLog_nn NOT NULL,
    bairroCliente VARCHAR(45)  CONSTRAINT cliente_bairro_nn NOT NULL,
    compCliente VARCHAR(35)  CONSTRAINT cliente_comp_nn NOT NULL,
    cidadeCliente VARCHAR(30)  CONSTRAINT cliente_cidade_nn NOT NULL,
    ufCliente CHAR(2)  CONSTRAINT cliente_uf_nn NOT NULL,
    senhaCliente VARCHAR(16) CONSTRAINT cliente_senha_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA AS MARCAS--
CREATE TABLE tbMarca(
    idMarca NUMBER(5)  CONSTRAINT marca_id_pk PRIMARY KEY,
    nomeMarca VARCHAR(30) CONSTRAINT marca_nm_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA OS MODELOS--
CREATE TABLE tbModelo(
    idModelo NUMBER(5)  CONSTRAINT modelo_id_pk PRIMARY KEY,
    nomeModelo VARCHAR(30) CONSTRAINT modelo_nm_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA AS CORES--
CREATE TABLE tbCor(
    idCor NUMBER(5)  CONSTRAINT cor_id_pk PRIMARY KEY,
    nomeCor VARCHAR(30) CONSTRAINT cor_nm_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA OS DADOS DAS BICICLETAS--
CREATE TABLE tbBicicleta(
    numSerie varchar(20)  CONSTRAINT bicicleta_id_pk PRIMARY KEY,
    valorNF NUMBER(8,2) CONSTRAINT bicicleta_valor_nn NOT NULL,
    qtdWatts NUMBER(3),
    fotoLateral VARCHAR(400),
    fotoFrontal VARCHAR(400),
    fotoTraseira VARCHAR(400),
    fotoNumSerie VARCHAR(400),
    tbCliente_cpfCliente NUMBER(11) CONSTRAINT tbBicicleta_tbCliente_fk REFERENCES tbCliente,
    tbMarca_idMarca NUMBER(5) CONSTRAINT tbBicicleta_tbMarca_fk REFERENCES tbMarca,
    tbCor_idCor  NUMBER(5) CONSTRAINT tbBicicleta_tbCor_fk REFERENCES tbCor,
    tbModelo_idModelo NUMBER(5) CONSTRAINT tbBicicleta_tbModelo_fk REFERENCES tbModelo
);


--CRIAÇÃO DA TABELA QUE GUARDARA OS TIPOS DE SEGURO EXISTENTES--
CREATE TABLE tbTipoSeguro(
    idTipoSeguro NUMBER(5)  CONSTRAINT tipoSeguro_id_pk PRIMARY KEY,
    tipoSeguro VARCHAR(25) CONSTRAINT tipoSeguro_nm_nn NOT NULL,
    valorTipoSeguro NUMBER(6,2) CONSTRAINT tipoSeguro_valor_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA OS POSSIVEIS MEIOS DE PAGAMENTO--
CREATE TABLE tbMeioPag(
    idMeioPag NUMBER(5)  CONSTRAINT meioPag_id_pk PRIMARY KEY,
    nomeMeioPag VARCHAR(30) CONSTRAINT meioPag_nm_nn NOT NULL
);

--CRIAÇÃO DA TABELA QUE GUARDARA AS SOLICTAÇÕES DE SEGURO--
CREATE TABLE tbSeguro(
    idSeguro NUMBER(5)  CONSTRAINT seguro_id_pk PRIMARY KEY,
    valorSeguro NUMBER(6,2) CONSTRAINT seguro_valor_nn NOT NULL,
    statusSeguro VARCHAR(9) CONSTRAINT seguro_status_nn NOT NULL,
    tbMeioPag_idMeioPag NUMBER(5) CONSTRAINT tbSeguro_tbMeioPag_fk REFERENCES tbMeioPag,
    tbTipoSeguro_idTipoSeguro NUMBER(5) CONSTRAINT tbSeguro_tbTipoSeguro_fk REFERENCES tbTipoSeguro,
    tbBicicleta_numSerie VARCHAR(20) CONSTRAINT tbSeguro_tbBicicleta_fk REFERENCES tbBicicleta
);

--CRIAÇÃO DA TABELA QUE GUARDARA OS POSSIVEIS ADICIONAIS NO SEGURO--
CREATE TABLE tbCobAdc(
    idCobAdc NUMBER(5)  CONSTRAINT cobAdc_id_pk PRIMARY KEY,
    coberturaAdc VARCHAR(30) CONSTRAINT cobAdc_nm_nn NOT NULL
);

--CRIAÇÃO DA ASSOCIATIVA ENTRE SEGURO E ADICIONAIS--
CREATE TABLE tbCobAdc_Seguro(
    idCobAdc_Seguro NUMBER(5)  CONSTRAINT cobAdc_Seguro_id_pk PRIMARY KEY,
    valorCobAdc VARCHAR(30) CONSTRAINT cobAdc_seguro_valor_nn NOT NULL,
    tbCobAdc_idCobAdc NUMBER(5) CONSTRAINT tbCobAdc_Seguro_tbCobAdc_fk REFERENCES tbCobAdc,
    tbSeguro_idSeguro NUMBER(5) CONSTRAINT tbCobAdc_Seguro_tbSeguro_fk REFERENCES tbSeguro
);
