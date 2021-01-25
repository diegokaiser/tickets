--INSERTAR DATOS EN TIPO DE USUARIO

	INSERT INTO Tipo_usuario (nombre, descripcion)
	VALUES ('Usuario', 'Semi  dios del sistema')

--INSERTAR DATOS EN USUARIO

INSERT INTO Usuario([nombre],[apellido],[correo],[contraseña],[tipoDocumento],[numeroDocumento],[idTipousuario])
					VALUES('Jane','Armstrong','purus.Duis@magnaSedeu.net','MKS75KAB9FT',0,'48826733',3);

--INSERTAR DATOS EN CINE

INSERT INTO Cine (nombre,direccion,idDistrito,estado)
					VALUES('Cineplanet','Calle las Camelias 277',36,1)

--INSERTAR DATOS EN SALA


INSERT INTO Sala (numero,idCine,capacidad,tipoSala,estado)
					VALUES(1,1,250,'2D',1);

-- INSERTAR DATOS EN PELICULA 	

INSERT INTO Pelicula(nombre,duracion,fechaEstreno,idioma,pais,subtitulos,doblada,genero,estado)
					VALUES('El hombre araña','2:01:00','2002-05-16','Ingles','EEUU',1,1,'Accion/fantasia',1);

-- INSERTAR DATOS EN ENTRADA 

INSERT INTO Entrada(precio,tipo,estado,idSala,idPelicula,stock)
					VALUES(20,'2D',1,1,1,250);



-- INSERTAR DATOS EN COMPRA 

INSERT INTO Compra(idUsuario,idEntrada,numeroEntradas,total,estado)
					VALUES(1,1,1,20,250);


-- INSERTAR DATOS EN USUARIO_ENTRADA

INSERT INTO Usuario_Entrada(idCompra,estado)
					VALUES(1,1);


select * from Cine
select * from Compra
select * from Distrito
select * from Entrada
select * from Pelicula
select * from Sala
select * from Tipo_Usuario
select * from Usuario
select * from Usuario_Entrada

