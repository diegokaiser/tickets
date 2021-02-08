CREATE procedure usp_listarPeliculas
as
begin
select * from pelicula 
end
go

CREATE procedure usp_listarPeliculasSinestrenar
as
begin
select * from pelicula where estado=0
end
go

CREATE procedure usp_listarPeliculasRecomendadas
as
begin
select * from pelicula where recomendada=1
end
go