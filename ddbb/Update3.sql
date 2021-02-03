create procedure usp_login(
	@correo varchar(60),
	@contrasena varchar(30)
)
as
begin
select count (*) from usuario where correo=@correo and contrasena=@contrasena
end

go