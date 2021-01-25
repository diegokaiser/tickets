Tipo_usuario 

INSERT INTO Usuario(nombre, apellido,correo,contraseña,tipoDocumento,numeroDocumento,idTipoUsuario)
	VALUES ('Josue', 'El dios del sistema')

	DBCC CHECKIDENT (Usuario, RESEED, 0)



SELECT * FROM Tipo_Usuario

update Tipo_usuario set descripcion='Semidios del sistema' where idTipoUsuario=2 


create table hola(
saludo bit not null)
insert into hola(saludo) values ('0')
select * from Usuario