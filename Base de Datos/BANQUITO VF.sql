/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     4/12/2023 00:27:16                           */
/*==============================================================*/


drop table AMORTIZACION;

drop index IDX_CLIENTE_TIPO;

drop index IDXU_CLIENTE_COD;

drop table CLIENTE;

drop table CLIENTE_DATO_ADICIONAL;

drop table CLIENTE_PERSONA_RELACION;

drop table CREDITO;

drop table CREDITO_TRANSACCION;

drop index IDXU_NUMERO_CUENTA;

drop table CUENTA;

drop table CUENTA_INTERVINIENTE;

drop table DATO_ADICIONAL;

drop table INTERES_MORA;

drop table PARTICIPES;

drop table TASA_INTERES;

drop index IDX_FECHA_CREACION;

drop table TIPO_CUENTA;

drop table TIPO_RELACION;

drop index IDXU_CODIGO_UNICO;

drop table TRANSACCION;

/*==============================================================*/
/* Table: AMORTIZACION                                          */
/*==============================================================*/
create table AMORTIZACION (
   COD_AMORTIZACION     SERIAL               not null,
   COD_CREDITO          INT4                 null,
   NUMERO_CUOTA         NUMERIC(2)           null,
   MONTO_CUOTA          NUMERIC(18,2)        null,
   ESTADO_CUOTA         VARCHAR(3)           null
      constraint CKC_ESTADO_CUOTA_AMORTIZA check (ESTADO_CUOTA is null or (ESTADO_CUOTA in ('PAG','NPG','VIG') and ESTADO_CUOTA = upper(ESTADO_CUOTA))),
   FECHA_PAGO           TIMESTAMP            null,
   FECHA_MAXIMA         TIMESTAMP            null,
   INTERES_CUOTA        NUMERIC(18,2)        null,
   constraint PK_AMORTIZACION primary key (COD_AMORTIZACION)
);

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE (
   COD_CLIENTE          SERIAL               not null,
   TIPO_CLIENTE         VARCHAR(3)           not null
      constraint CKC_TIPO_CLIENTE_CLIENTE check (TIPO_CLIENTE in ('NAT','JUR') and TIPO_CLIENTE = upper(TIPO_CLIENTE)),
   TIPO_IDENTIFICACION  VARCHAR(3)           not null
      constraint CKC_TIPO_IDENTIFICACI_CLIENTE check (TIPO_IDENTIFICACION in ('CED','PAS','RUC') and TIPO_IDENTIFICACION = upper(TIPO_IDENTIFICACION)),
   NUMERO_IDENTIFICACION VARCHAR(20)          not null,
   NOMBRE               VARCHAR(100)         not null,
   DIRECCION            VARCHAR(200)         not null,
   CORREO_ELECTRONICO   VARCHAR(100)         not null,
   TELEFONO             VARCHAR(15)          not null,
   constraint PK_CLIENTE primary key (COD_CLIENTE)
);

/*==============================================================*/
/* Index: IDXU_CLIENTE_COD                                      */
/*==============================================================*/
create unique index IDXU_CLIENTE_COD on CLIENTE (
COD_CLIENTE
);

/*==============================================================*/
/* Index: IDX_CLIENTE_TIPO                                      */
/*==============================================================*/
create  index IDX_CLIENTE_TIPO on CLIENTE (
TIPO_CLIENTE
);

/*==============================================================*/
/* Table: CLIENTE_DATO_ADICIONAL                                */
/*==============================================================*/
create table CLIENTE_DATO_ADICIONAL (
   COD_DATO_ADICIONAL   VARCHAR(10)          not null,
   COD_CLIENTE          INT4                 not null,
   VALOR_ALFANUMERICO   VARCHAR(100)         not null,
   VALOR_NUMERICO       NUMERIC(20,2)        not null,
   VALOR_FECHA          DATE                 not null,
   constraint PK_CLIENTE_DATO_ADICIONAL primary key (COD_DATO_ADICIONAL, COD_CLIENTE)
);

/*==============================================================*/
/* Table: CLIENTE_PERSONA_RELACION                              */
/*==============================================================*/
create table CLIENTE_PERSONA_RELACION (
   COD_CLIENTE_PERSONA_RELACION SERIAL               not null,
   COD_TIPO_RELACION    VARCHAR(3)           not null,
   COD_CLIENTE_EMPRESA  INT4                 not null,
   COD_CLIENTE_PERSONA  INT4                 not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_CLIENTE_ check (ESTADO in ('ACT','INA') and ESTADO = upper(ESTADO)),
   FECHA_INICIO         DATE                 not null,
   FECHA_FIN            DATE                 null,
   constraint PK_CLIENTE_PERSONA_RELACION primary key (COD_CLIENTE_PERSONA_RELACION)
);

/*==============================================================*/
/* Table: CREDITO                                               */
/*==============================================================*/
create table CREDITO (
   COD_CREDITO          SERIAL               not null,
   COD_TASA_INTERES     VARCHAR(8)           null,
   COD_CUENTA           INT4                 not null,
   TIPO_CREDITO         VARCHAR(3)           not null
      constraint CKC_TIPO_CREDITO_CREDITO check (TIPO_CREDITO in ('CON')),
   PLAZO                NUMERIC(2)           not null
      constraint CKC_PLAZO_CREDITO check (PLAZO between 3 and 60),
   MONTO                NUMERIC(7,2)         not null
      constraint CKC_MONTO_CREDITO check (MONTO between 1000 and 10000),
   SALDO_PENDIENTE      NUMERIC(7,2)         not null,
   FECHA_CREACION       TIMESTAMP            not null,
   FECHA_APROBACION     TIMESTAMP            null,
   FECHA_FINALIZACION   TIMESTAMP            not null,
   ULTIMA_FECHA_MODIFICACION TIMESTAMP            null,
   ESTADO               VARCHAR(3)           not null default 'ACT'
      constraint CKC_ESTADO_CREDITO check (ESTADO in ('ACT','APR','PEN','MOR','ANU','REC','PAG') and ESTADO = upper(ESTADO)),
   INTERES_TOTAL        NUMERIC(5,2)         null,
   constraint PK_CREDITO primary key (COD_CREDITO)
);

/*==============================================================*/
/* Table: CREDITO_TRANSACCION                                   */
/*==============================================================*/
create table CREDITO_TRANSACCION (
   COD_CREDITO_TRANSACCION SERIAL               not null,
   COD_CREDITO          INT4                 null,
   MONTO_PRINCIPAL      NUMERIC(18,2)        not null,
   FEHA_CREACION        TIMESTAMP            not null,
   METODO_PAGO          VARCHAR(4)           not null
      constraint CKC_METODO_PAGO_CREDITO_ check (METODO_PAGO in ('TDIR','TINT','EFEC') and METODO_PAGO = upper(METODO_PAGO)),
   MONTO_INTERES        NUMERIC(18,2)        not null,
   MONTO_TOTAL          NUMERIC(18,2)        not null,
   constraint PK_CREDITO_TRANSACCION primary key (COD_CREDITO_TRANSACCION)
);

/*==============================================================*/
/* Table: CUENTA                                                */
/*==============================================================*/
create table CUENTA (
   COD_CUENTA           SERIAL               not null,
   COD_TIPO_CUENTA      VARCHAR(10)          not null,
   COD_CLIENTE          INT4                 null,
   NUMERO_CUENTA        VARCHAR(8)           not null,
   SALDO_CONTABLE       NUMERIC(18,2)        not null,
   SALDO_DISPONIBLE     NUMERIC(18,2)        not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_CUENTA check (ESTADO in ('ACT','INA','BLO','CER','RES','CON') and ESTADO = upper(ESTADO)),
   FECHA_CREACION       TIMESTAMP            not null,
   FECHA_ULTIMO_CAMBIO  TIMESTAMP            not null,
   constraint PK_CUENTA primary key (COD_CUENTA)
);

/*==============================================================*/
/* Index: IDXU_NUMERO_CUENTA                                    */
/*==============================================================*/
create unique index IDXU_NUMERO_CUENTA on CUENTA (
NUMERO_CUENTA
);

/*==============================================================*/
/* Table: CUENTA_INTERVINIENTE                                  */
/*==============================================================*/
create table CUENTA_INTERVINIENTE (
   COD_CUENTA           INT4                 not null,
   COD_CLIENTE_PERSONA  INT4                 not null,
   FECHA_INICIO         TIMESTAMP            not null,
   FECHA_FIN            TIMESTAMP            null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_CUENTA_I check (ESTADO in ('ACT','INA') and ESTADO = upper(ESTADO)),
   constraint PK_CUENTA_INTERVINIENTE primary key (COD_CUENTA, COD_CLIENTE_PERSONA)
);

/*==============================================================*/
/* Table: DATO_ADICIONAL                                        */
/*==============================================================*/
create table DATO_ADICIONAL (
   COD_DATO_ADICIONAL   VARCHAR(10)          not null,
   TIPO_CLIENTE         VARCHAR(3)           not null
      constraint CKC_TIPO_CLIENTE_DATO_ADI check (TIPO_CLIENTE in ('NAT','JUR') and TIPO_CLIENTE = upper(TIPO_CLIENTE)),
   NOMBRE               VARCHAR(50)          not null,
   TIPO_DATO            VARCHAR(3)           not null
      constraint CKC_TIPO_DATO_DATO_ADI check (TIPO_DATO in ('ALF','NUM','FEC') and TIPO_DATO = upper(TIPO_DATO)),
   LONGITUD             NUMERIC(2)           null,
   constraint PK_DATO_ADICIONAL primary key (COD_DATO_ADICIONAL)
);

/*==============================================================*/
/* Table: INTERES_MORA                                          */
/*==============================================================*/
create table INTERES_MORA (
   COD_INTERES_MORA     SERIAL               not null,
   COD_CREDITO          INT4                 null,
   MONTO                NUMERIC(18,2)        not null,
   DIAS_MOROSOS         NUMERIC(3)           not null,
   ESTADO               VARCHAR(3)           not null default 'PEN'
      constraint CKC_ESTADO_INTERES_ check (ESTADO in ('PAG','PEN') and ESTADO = upper(ESTADO)),
   DESCRIPCION          VARCHAR(200)         null,
   constraint PK_INTERES_MORA primary key (COD_INTERES_MORA)
);

/*==============================================================*/
/* Table: PARTICIPES                                            */
/*==============================================================*/
create table PARTICIPES (
   COD_CREDITO          INT4                 not null,
   COD_CUENTA           INT4                 not null,
   constraint PK_PARTICIPES primary key (COD_CREDITO, COD_CUENTA)
);

/*==============================================================*/
/* Table: TASA_INTERES                                          */
/*==============================================================*/
create table TASA_INTERES (
   COD_TASA_INTERES     VARCHAR(8)           not null,
   TIPO_TASA_INTERES    VARCHAR(3)           not null
      constraint CKC_TIPO_TASA_INTERES_TASA_INT check (TIPO_TASA_INTERES in ('FIJ','VAR') and TIPO_TASA_INTERES = upper(TIPO_TASA_INTERES)),
   NOMBRE               VARCHAR(50)          not null,
   TASA_MINIMA          NUMERIC(5,2)         not null,
   TASA_MAXIMA          NUMERIC(5,2)         not null,
   constraint PK_TASA_INTERES primary key (COD_TASA_INTERES)
);

/*==============================================================*/
/* Table: TIPO_CUENTA                                           */
/*==============================================================*/
create table TIPO_CUENTA (
   COD_TIPO_CUENTA      VARCHAR(10)          not null,
   COD_TASA_INTERES     VARCHAR(8)           null,
   NOMBRE               VARCHAR(50)          not null,
   DESCRIPCION          VARCHAR(500)         not null,
   TIPO_CAPITALIZACION  VARCHAR(3)           not null
      constraint CKC_TIPO_CAPITALIZACI_TIPO_CUE check (TIPO_CAPITALIZACION in ('DIA','MEN') and TIPO_CAPITALIZACION = upper(TIPO_CAPITALIZACION)),
   FORMA_CAPITALIZACION VARCHAR(3)           not null
      constraint CKC_FORMA_CAPITALIZAC_TIPO_CUE check (FORMA_CAPITALIZACION in ('SAL','SPR') and FORMA_CAPITALIZACION = upper(FORMA_CAPITALIZACION)),
   MAXIMO_NUMERO_INTERVINIENTES NUMERIC(2)           not null,
   FECHA_CREACION       DATE                 not null,
   constraint PK_TIPO_CUENTA primary key (COD_TIPO_CUENTA)
);

/*==============================================================*/
/* Index: IDX_FECHA_CREACION                                    */
/*==============================================================*/
create unique index IDX_FECHA_CREACION on TIPO_CUENTA (
FECHA_CREACION
);

/*==============================================================*/
/* Table: TIPO_RELACION                                         */
/*==============================================================*/
create table TIPO_RELACION (
   COD_TIPO_RELACION    VARCHAR(3)           not null,
   NOMBRE               VARCHAR(30)          not null,
   constraint PK_TIPO_RELACION primary key (COD_TIPO_RELACION)
);

/*==============================================================*/
/* Table: TRANSACCION                                           */
/*==============================================================*/
create table TRANSACCION (
   COD_TRANSACCION      SERIAL               not null,
   COD_CUENTA           INT4                 not null,
   COD_UNICO            VARCHAR(64)          not null,
   TIPO_AFECTACION      VARCHAR(1)           not null
      constraint CKC_TIPO_AFECTACION_TRANSACC check (TIPO_AFECTACION in ('D','C')),
   VALOR_DEBE           NUMERIC(18,2)        not null,
   VALOR_HABER          NUMERIC(18,2)        not null,
   TIPO_TRANSACCION     VARCHAR(8)           not null
      constraint CKC_TIPO_TRANSACCION_TRANSACC check (TIPO_TRANSACCION in ('DEPOSITO','RETIRO','TRANSFRE','TRANSFEN','IVA','ISD','COMISION')),
   DETALLE              VARCHAR(50)          not null,
   FECHA_CREACION       TIMESTAMP            not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_TRANSACC check (ESTADO in ('ACT','EXI','FAL','ABO','EPR') and ESTADO = upper(ESTADO)),
   FECHA_AFECTACION     TIMESTAMP            null,
   constraint PK_TRANSACCION primary key (COD_TRANSACCION)
);

/*==============================================================*/
/* Index: IDXU_CODIGO_UNICO                                     */
/*==============================================================*/
create unique index IDXU_CODIGO_UNICO on TRANSACCION (
COD_UNICO
);

alter table AMORTIZACION
   add constraint FK_AMO_A_CRE foreign key (COD_CREDITO)
      references CREDITO (COD_CREDITO)
      on delete restrict on update restrict;

alter table CLIENTE_DATO_ADICIONAL
   add constraint FK_CLI_DATO_ADI_A_CLI foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CLIENTE_DATO_ADICIONAL
   add constraint FK_CLI_DATO_ADI_A_DATO_ADI foreign key (COD_DATO_ADICIONAL)
      references DATO_ADICIONAL (COD_DATO_ADICIONAL)
      on delete restrict on update restrict;

alter table CLIENTE_PERSONA_RELACION
   add constraint FK_CLI_PERS_REL_A_CLI_EMP foreign key (COD_CLIENTE_PERSONA)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CLIENTE_PERSONA_RELACION
   add constraint FK_CLI_PERS_REL_A_CLI_PER foreign key (COD_CLIENTE_EMPRESA)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CLIENTE_PERSONA_RELACION
   add constraint FK_CLI_PER_REL_A_TIPO_REL foreign key (COD_TIPO_RELACION)
      references TIPO_RELACION (COD_TIPO_RELACION)
      on delete restrict on update restrict;

alter table CREDITO
   add constraint FK_CRE_A_CUE foreign key (COD_CUENTA)
      references CUENTA (COD_CUENTA)
      on delete restrict on update restrict;

alter table CREDITO
   add constraint FK_CRE_A_TAS_INT foreign key (COD_TASA_INTERES)
      references TASA_INTERES (COD_TASA_INTERES)
      on delete restrict on update restrict;

alter table CREDITO_TRANSACCION
   add constraint FK_CRE_TRA_A_CRE foreign key (COD_CREDITO)
      references CREDITO (COD_CREDITO)
      on delete restrict on update restrict;

alter table CUENTA
   add constraint FK_CUE_A_CLI foreign key (COD_CLIENTE)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CUENTA
   add constraint FK_CUE_A_TIP_CUE foreign key (COD_TIPO_CUENTA)
      references TIPO_CUENTA (COD_TIPO_CUENTA)
      on delete restrict on update restrict;

alter table CUENTA_INTERVINIENTE
   add constraint FK_CUE_INT_A_CLI foreign key (COD_CLIENTE_PERSONA)
      references CLIENTE (COD_CLIENTE)
      on delete restrict on update restrict;

alter table CUENTA_INTERVINIENTE
   add constraint FK_CUE_INT_A_CUE foreign key (COD_CUENTA)
      references CUENTA (COD_CUENTA)
      on delete restrict on update restrict;

alter table INTERES_MORA
   add constraint FK_INT_MOR_CRE foreign key (COD_CREDITO)
      references CREDITO (COD_CREDITO)
      on delete restrict on update restrict;

alter table PARTICIPES
   add constraint FK_PAR_A_CRE foreign key (COD_CREDITO)
      references CREDITO (COD_CREDITO)
      on delete restrict on update restrict;

alter table PARTICIPES
   add constraint FK_PAR_A_CUE foreign key (COD_CUENTA)
      references CUENTA (COD_CUENTA)
      on delete restrict on update restrict;

alter table TIPO_CUENTA
   add constraint FK_TIP_CUE_A_TAS_INT foreign key (COD_TASA_INTERES)
      references TASA_INTERES (COD_TASA_INTERES)
      on delete restrict on update restrict;

alter table TRANSACCION
   add constraint FK_TRA_A_CUE foreign key (COD_CUENTA)
      references CUENTA (COD_CUENTA)
      on delete restrict on update restrict;

