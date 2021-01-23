CREATE DATABASE SistemaCine
GO

USE SistemaCine
GO

Create table [Tipo_Usuario] (
	[idTipoUsuario] Tinyint IDENTITY(1,1) NOT NULL,
	[nombre] Varchar(20) NOT NULL,
	[descripcion] Varchar(40) NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL,
	[admiModificacion] Varchar(20) NULL
) 
GO

ALTER TABLE [Tipo_Usuario]
ADD CONSTRAINT pk_idTipoUsuario PRIMARY KEY ([idTipoUsuario])
GO
ALTER TABLE [Tipo_Usuario]
ADD CONSTRAINT df_fechaRegistro DEFAULT GETDATE() FOR [fechaRegistro]
GO
ALTER TABLE [Tipo_Usuario]
ADD CONSTRAINT uq_nombre UNIQUE ([nombre])
GO




Create table [Usuario] (
	[idUsuario] Integer IDENTITY(1,1) NOT NULL,
	[nombre] Char(40) NOT NULL,
	[apellido] Varchar(40)NOT NULL,
	[correo] Varchar(40) NOT NULL,
	[contraseña] Varchar(30) NOT NULL,
	[tipoDocumento] Bit NOT NULL,
	[numeroDocumento] Varchar(15) NOT NULL,
	[idTipoUsuario] Tinyint NOT NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL
) 
GO

ALTER TABLE [Usuario]
ADD CONSTRAINT pk_idUsuario PRIMARY KEY ([idUsuario])
GO
ALTER TABLE [Usuario]
ADD CONSTRAINT fk_Usuario_Tipo_Usuario FOREIGN KEY ([idTipoUsuario])
REFERENCES [Tipo_Usuario] ([idTipoUsuario])
GO
ALTER TABLE [Usuario]
ADD CONSTRAINT df_fechaRegistroU DEFAULT GETDATE() FOR [fechaRegistro]
GO
ALTER TABLE [Usuario]
ADD CONSTRAINT uq_numeroDocumento UNIQUE ([numeroDocumento])
GO
ALTER TABLE [Usuario]
ADD CONSTRAINT uq_correo UNIQUE ([correo])
GO

Create table [Cine] (
	[idCine] Integer IDENTITY(1,1) NOT NULL,
	[nombre] Varchar(50) NOT NULL,
	[direccion] Varchar(50) NOT NULL,
	[distrito] Varchar(40) NOT NULL,
	[logo] Image NULL,
	[estado] Bit NOT NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL,
	[admiModificacion] Varchar(20) NULL
) 
GO

ALTER TABLE [Cine]
ADD CONSTRAINT pk_idCine PRIMARY KEY ([idCine])
GO
ALTER TABLE [Cine]
ADD CONSTRAINT df_fechaRegistroC DEFAULT GETDATE() FOR [fechaRegistro]
GO

Create table [Sala] (
	[idSala] Tinyint IDENTITY(1,1) NOT NULL,
	[numero] Smallint NOT NULL,
	[idCine] Integer NOT NULL,
	[capacidad] Tinyint NOT NULL,
	[tipoSala] Char(2) NOT NULL,
	[estado] Bit NOT NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL,
	[admiModificacion] Varchar(20) NULL
) 
GO

ALTER TABLE [Sala]
ADD CONSTRAINT pk_idSala PRIMARY KEY ([idSala])
GO

ALTER TABLE [Sala]
ADD CONSTRAINT fk_Sala_Cine FOREIGN KEY ([idCine])
REFERENCES [Cine] ([idCine])
GO

ALTER TABLE [Sala]
ADD CONSTRAINT df_fechaRegistroS DEFAULT GETDATE() FOR [fechaRegistro]
GO



Create table [Pelicula] (
	[idPelicula] Integer IDENTITY(1,1) NOT NULL,
	[nombre] Varchar(40) NOT NULL,
	[duracion] Varchar(10) NOT NULL,
	[fechaEstreno] Datetime NOT NULL,
	[idioma] Varchar(30) NULL,
	[pais] Varchar(30) NULL,
	[subtitulos] Bit NULL,
	[doblada] Bit NULL,
	[portada] Image NULL,
	[descripcion] Varchar(300) NULL,
	[genero] Varchar(30)NOT NULL,
	[estado] Bit NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL,
	[admiModificacion] Varchar(20) NULL
) 
GO

ALTER TABLE [Pelicula]
ADD CONSTRAINT pk_idPelicula PRIMARY KEY ([idPelicula])
GO

ALTER TABLE [Pelicula]
ADD CONSTRAINT df_fechaRegistroP DEFAULT GETDATE() FOR [fechaRegistro]
GO


Create table [Entrada] (
	[idEntrada] Integer IDENTITY(1,1) NOT NULL,
	[precio] Money NOT NULL,
	[tipo] Char(2) NOT NULL,
	[estado] Bit NOT NULL,
	[idSala] Tinyint NOT NULL,
	[idPelicula] Integer NOT NULL,
	[stock] Smallint NOT NULL,
	[fechaRegistro] Datetime NOT NULL,
	[fechaModificacion] Datetime NULL,
	[admiModificacion] Varchar(20) NULL
) 
GO

ALTER TABLE [Entrada]
ADD CONSTRAINT pk_idEntrada PRIMARY KEY ([idEntrada])
GO

ALTER TABLE [Entrada]
ADD CONSTRAINT fk_Entrada_Sala FOREIGN KEY ([idSala])
REFERENCES [Sala] ([idSala])
GO


ALTER TABLE [Entrada]
ADD CONSTRAINT fk_EntradaPelicula FOREIGN KEY ([idPelicula])
REFERENCES [Pelicula] ([idPelicula])
GO

ALTER TABLE [Entrada]
ADD CONSTRAINT df_fechaRegistroE DEFAULT GETDATE() FOR [fechaRegistro]
GO


Create table [Compra] (
	[idCompra] Integer IDENTITY(1,1) NOT NULL,
	[idUsuario] Integer NOT NULL,
	[idEntrada] Integer NOT NULL,
	[numeroEntradas] Tinyint NOT NULL,
	[total] Money NOT NULL,
	[estado] Bit NOT NULL,
	[fechaCompra] Datetime NOT NULL
) 
GO

ALTER TABLE [Compra]
ADD CONSTRAINT pk_idCompra PRIMARY KEY ([idCompra])
GO


ALTER TABLE [Compra]
ADD CONSTRAINT fk_Compra_Entrada FOREIGN KEY ([idEntrada])
REFERENCES [Entrada] ([idEntrada])
GO

ALTER TABLE [Compra]
ADD CONSTRAINT fk_Compra_Usuario FOREIGN KEY ([idUsuario])
REFERENCES [Usuario] ([idUsuario])
GO

ALTER TABLE [Compra]
ADD CONSTRAINT df_fechaCompra DEFAULT GETDATE() FOR [fechaCompra]
GO


Create table [Usuario_Entrada] (
	[idUsuarioEntrada] Integer  IDENTITY(1,1) NOT NULL,
	[idCompra] Integer NOT NULL,
	[estado] Bit NOT NULL,
	[fechaRegistro] Datetime NOT NULL
) 
GO

ALTER TABLE [Usuario_Entrada]
ADD CONSTRAINT pk_idUsuarioEntrada PRIMARY KEY ([idUsuarioEntrada])
GO

ALTER TABLE [Usuario_Entrada]
ADD CONSTRAINT fk_Compra_Entrada_Compra FOREIGN KEY ([idCompra])
REFERENCES [Compra] ([idCompra])
GO


