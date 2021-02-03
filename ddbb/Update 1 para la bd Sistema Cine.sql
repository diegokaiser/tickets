USE  SistemaCine
GO
--MODIFICAR LA LOGINTUD DEL CAMPO EN TIPO_USUARIO A 50
ALTER TABLE Tipo_Usuario
ALTER COLUMN admiModificacion VARCHAR(50) 
GO

--AGREGAR COLUMNA admiModificacion EN USUARIO
ALTER TABLE Usuario 
ADD admiModificacion Varchar(50)
GO

--HACER EL CAMPO FECHA DE CINE UNICO
ALTER TABLE Cine
ADD CONSTRAINT uq_direccion UNIQUE (direccion)
GO

--MODIFICAR LA LOGINTUD DEL CAMPO EN CINE A 50
ALTER TABLE Cine
ALTER COLUMN admiModificacion VARCHAR(50) 
GO

--MODIFICAR LA LOGINTUD DEL CAMPO EN SALA A 50
ALTER TABLE Sala
ALTER COLUMN admiModificacion VARCHAR(50) 
GO

--MODIFICAR LA LOGINTUD DEL CAMPO EN PELICULA A 50
ALTER TABLE Pelicula
ALTER COLUMN admiModificacion VARCHAR(50) 
GO

--MODIFICAR LA LOGINTUD DEL CAMPO EN ENTRDA A 50
ALTER TABLE Entrada
ALTER COLUMN admiModificacion VARCHAR(50) 
GO

--MODIFICAR TIPO EN LA TABLA ENTRADA A NULL ;
ALTER TABLE Entrada
ALTER column tipo Char(2)  NULL
GO

--AGREGAR VALOR 0 POR DEFECTO EN ESTADO DE COMPRA
ALTER TABLE compra ADD DEFAULT 0 FOR estado;
GO

--MODIFICAR COMPRA EN LA TABLA ENTRADA A NULL ;
ALTER TABLE compra
ALTER column total money null
GO

--AGREGAR VALOR 0 POR DEFECTO EN ESTADO DE USUARIO_ENTRADA
ALTER TABLE Usuario_entrada
ADD DEFAULT 0 FOR estado
GO

--TRIGGER DE UPDATE DE TIPO USUARIO
CREATE TRIGGER TR_Update_Tipo_Usuario
ON Tipo_usuario
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idTipoUsuario INT 
SELECT @idTipoUsuario= idTipoUsuario FROM inserted
UPDATE Tipo_Usuario SET admiModificacion =SYSTEM_USER WHERE  idTipoUsuario=@idTipoUsuario
UPDATE Tipo_Usuario SET fechaModificacion= GETDATE() WHERE  idTipoUsuario=@idTipoUsuario
GO

--TRIGGER DE UPDATE USUARIO
CREATE TRIGGER TR_Update_Usuario
ON Usuario
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idUsuario INT 
SELECT @idUsuario= idUsuario FROM inserted
UPDATE Usuario SET admiModificacion =SYSTEM_USER WHERE  idUsuario=@idUsuario
UPDATE Usuario SET fechaModificacion= GETDATE() WHERE  idUsuario=@idUsuario
GO

--TRIGGER DE UPDATE CINE
CREATE TRIGGER TR_Update_Cine
ON Cine
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idCine INT 
SELECT @idCine= idCine FROM inserted
UPDATE Cine SET admiModificacion =SYSTEM_USER WHERE  idCine=@idCine
UPDATE Cine SET fechaModificacion= GETDATE() WHERE  idCine=@idCine
GO

--TRIGGER DE UPDATE SALA
CREATE TRIGGER TR_Update_Sala
ON Sala
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idSala INT 
SELECT @idSala= idSala FROM inserted
UPDATE Sala SET admiModificacion =SYSTEM_USER WHERE idSala=@idSala
UPDATE Sala SET fechaModificacion= GETDATE() WHERE idSala=@idSala
GO

--TRIGGER DE UPDATE PELICULA
CREATE TRIGGER TR_Update_Pelicula
ON Pelicula
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idPelicula INT 
SELECT @idPelicula= idPelicula FROM inserted
UPDATE Pelicula SET admiModificacion =SYSTEM_USER WHERE idPelicula=@idPelicula
UPDATE Pelicula SET fechaModificacion= GETDATE() WHERE idPelicula=@idPelicula
GO

--TRIGGER DE UPDATE ENTRADA
CREATE TRIGGER TR_Update_Entrada
ON Entrada
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idEntrada INT,@tipo CHAR(2), @idSala INT 
SELECT @idEntrada= idPelicula FROM inserted
UPDATE Entrada SET admiModificacion =SYSTEM_USER WHERE idEntrada=@idEntrada
UPDATE Entrada SET fechaModificacion= GETDATE() WHERE idEntrada=@idEntrada

SELECT @idSala=idSala FROM inserted
SELECT @tipo= tipoSala FROM Sala WHERE idSala=@idSala
SELECT @idEntrada=idEntrada FROM inserted
UPDATE Entrada SET tipo = @tipo WHERE idEntrada=@idEntrada
GO

GO

--TRIGGER DE INSERT ENTRADA
CREATE TRIGGER TR_Insert_Entrada
ON Entrada
FOR INSERT
AS
SET NOCOUNT ON 
DECLARE @tipo CHAR(2), @idSala INT, @idEntrada INT
SELECT @idSala=idSala FROM inserted
SELECT @tipo= tipoSala FROM Sala WHERE idSala=@idSala
SELECT @idEntrada=idEntrada FROM inserted
UPDATE Entrada SET tipo = @tipo WHERE idEntrada=@idEntrada
UPDATE
GO

--TRIGGER DE INSERT COMPRA
ALTER TRIGGER TR_Insert_Compra
ON Compra
FOR INSERT
AS
SET NOCOUNT ON 
DECLARE @idCompra INT, @idEntrada INT,@precio MONEY, @numeroEntradas MONEY,@stock SMALLINT
SELECT @idCompra=idCompra FROM inserted
SELECT @idEntrada=identrada FROM inserted
SELECT @stock= stock FROM Entrada WHERE idEntrada=@idEntrada
SELECT @precio= precio FROM Entrada WHERE idEntrada=@idEntrada
SELECT @numeroEntradas=numeroEntradas FROM inserted
UPDATE Compra SET total = @precio *@numeroEntradas WHERE idCompra=@idCompra

IF(@numeroEntradas=1)
	BEGIN
	   UPDATE Entrada SET stock = @stock -1 WHERE idEntrada=@idEntrada
	END
IF(@numeroEntradas=2)
	BEGIN
		UPDATE Entrada SET stock = @stock -2 WHERE idEntrada=@idEntrada
	END
GO

--TRIGGER DE UPDATE COMPRA
ALTER TRIGGER TR_Update_Compra
ON Compra
FOR UPDATE
AS
SET NOCOUNT ON 
DECLARE @idCompra INT, @idEntrada INT,@estado bit, @Stock SMALLINT,@numeroEntradas TINYINT
SELECT @idCompra=idCompra FROM inserted
SELECT @idEntrada=identrada FROM inserted
SELECT @numeroEntradas=numeroEntradas FROM inserted

SELECT @Stock= stock from Entrada WHERE idEntrada=@idEntrada
SELECT @estado= estado from inserted

IF  @estado = 0
	BEGIN 
		IF(@numeroEntradas=1)
			BEGIN
				 UPDATE Entrada SET stock = @stock +1 WHERE idEntrada=@idEntrada
			END
		IF(@numeroEntradas=2)
			BEGIN
				UPDATE Entrada SET stock = @stock +2 WHERE idEntrada=@idEntrada
			END
	END



IF @estado =1
	BEGIN
		IF(@numeroEntradas=1)
			BEGIN
				INSERT INTO Usuario_Entrada(idCompra) Values(@idCompra)
			END
		IF(@numeroEntradas=2)
			BEGIN
				INSERT INTO Usuario_Entrada(idCompra) Values(@idCompra)
				INSERT INTO Usuario_Entrada(idCompra) Values(@idCompra)
			END
	END
  

		

		



