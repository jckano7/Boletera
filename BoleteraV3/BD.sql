create database boletera;

use boletera;

create table regla (
id_regla INT NOT NULL auto_increment,
digito int not null,
posicion int not null,
primary key (id_regla)
);

create table tiraje (
id_tiraje INT NOT NULL auto_increment,
folio_inicial int not null,
folio_final int not null,
numero_digitos int not null,
numero_folios int not null,
primary key (id_tiraje)
);

create table tiraje_regla (
id_regla INT NOT NULL,
id_tiraje int not null,
primary key (id_regla, id_tiraje),
foreign key (id_regla) 
	references regla(id_regla),
foreign key (id_tiraje)
	references tiraje(id_tiraje)
);

create table boleto (
id_boleto INT NOT NULL auto_increment,
id_tiraje int not null,
fecha timestamp,
primary key (id_boleto),
foreign key (id_tiraje)
	references tiraje(id_tiraje)
);

create table folio (
id_boleto int not null,
folio varchar(10) not null,
primary key (id_boleto, folio),
foreign key (id_boleto)
	references boleto(id_boleto)
);

create table posicion(
id_posicion int not null auto_increment,
id_boleto int not null,
posicion_x int not null,
posicion_y int not null,
color_R int not null,
color_G int not null,
color_B int not null,
tamanio int not null,
primary key (id_posicion),
foreign key (id_boleto)
	references boleto(id_boleto)
);