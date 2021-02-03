use SistemaCine

alter table usuario 
add  estado bit null 

ALTER TABLE usuario
ADD DEFAULT 0 FOR estado
GO
