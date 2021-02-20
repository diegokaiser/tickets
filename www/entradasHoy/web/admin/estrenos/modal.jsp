 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    <i class="fa fa-plus"></i> Agregar Pelicula
</button>
    
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Agregar Pelicula</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-left">
                <form action="<%=request.getContextPath()%>/PeliculaController" method="POST">
                    <input type="hidden" id="processing" name="processing" value="agregarPelicula">                   
                    <div class="form-group pt-4">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" >
                    </div>
                        
                    <div class="form-group">
                        <label for="duracion">Duración</label>
                        <input type="text" class="form-control" id="duracion" name="duracion" >
                    </div>
                        
                    <div class="form-group">
                        <label for="fechaEstreno">Fecha de estreno</label>
                        <input type="text" class="form-control" id="fechaEstreno" name="fechaEstreno" >
                    </div>
                        
                    <div class="form-group">
                        <label for="idioma">Idioma</label>
                        <input type="text" class="form-control" id="idioma" name="idioma" >
                    </div>
                    <div class="form-group">
                        <label for="pais">País de origen</label>
                        <input type="text" class="form-control" id="pais" name="pais" >
                    </div>  
                    <div class="form-group">
                        <label for="subtitulos">Subtítulos</label>
                        <input type="number" class="form-control" id="subtitulos" name="subtitulos" >
                    </div>   
                    <div class="form-group">
                        <label for="doblada">Doblada</label>
                        <input type="number" class="form-control" id="doblada" name="doblada" >
                    </div>   
                    <div class="form-group">
                        <label for="portada">Portada</label>
                        <input type="text" class="form-control" id="portada" name="portada" >
                    </div>   
                    <div class="form-group">
                        <label for="descripcion">Descripción</label>
                        <input type="text" class="form-control" id="descripcion" name="descripcion" >
                    </div>   
                    <div class="form-group">
                        <label for="genero">Género</label>
                        <input type="text" class="form-control" id="genero" name="genero" >
                    </div>      
                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <input type="number" class="form-control" id="estado" name="estado" >
                    </div>                      
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary btn-block my-4">Agregar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>