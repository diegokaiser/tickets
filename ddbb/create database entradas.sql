-- Base de datos entradas

------------------
-- Creando ddbb --
------------------
create database entradas

-- recuerden cambiar las rutas en filename
on primary
(
	name='entradas_data',
	filename='E:\ISIL\IV\Desarrollo de aplicaciones empresariales I\ProjectoGrupal\ddbb\entradas.mdf',
	size=8mb,
	maxsize=200mb,
	filegrowth=8mb)
log on
(
	name='entradas_log',
	filename='E:\ISIL\IV\Desarrollo de aplicaciones empresariales I\ProjectoGrupal\ddbb\entradas.ldf',
	size=8mb,
	maxsize=200mb,
	filegrowth=8mb)

-----------------
-- ddbb en uso --
-----------------

use entradas
go