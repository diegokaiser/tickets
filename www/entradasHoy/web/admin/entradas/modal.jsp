<div class="row">
    <div class="col-sm-12 text-right">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-plus"></i>&nbsp;&nbsp;Agregar Entrada
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Entrada</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="<%=request.getContextPath()%>/EntradaController" method="POST">
                            <input type="hidden" id="processing" name="processing" value="insertarEntrada">      
                            
                            <div class="form-group text-left">
                                <label for="idPelicula">Pélicula</label>
                                <select class="form-control" id="idPelicula" name="idPelicula">
                                    ${pelicula.idPelicula}
                                    <c:forEach var="pelicula" items="${peliculas}">                                
                                        <option value="${pelicula.idPelicula}">${pelicula.nombre}</option>
                                    </c:forEach>
                                </select>
                            </div>    
                                      
                            <div class="form-group text-left">
                                <label for="idSala">Sala</label>
                                <select class="form-control" id="idSala" name="idSala">
                                    ${sala.idSala}
                                    <c:forEach var="sala" items="${salas}">                                
                                        <option value="${sala.idSala}">${sala.numero} - ${sala.nombreCine} - ${sala.direccion} </option>
                                    </c:forEach>
                                </select>
                            </div>                                     
                                      
                            <div class="form-group text-left">
                                <label for="precio">Precio</label>
                                <input type="text" class="form-control" id="precio" name="precio" >
                            </div>
                                      
                            <div class="form-group text-left">
                                <label for="stock">Stock</label>
                                <input type="number" class="form-control" id="stock" name="stock" >
                            </div>
                            <div class="form-group text-left">
                                <label for="estado">Estado</label>
                                <input type="number" class="form-control" id="estado" name="estado" >
                            </div>
                            <div class="form-group text-left">
                                <label for="tipo">Tipo</label>
                                <input type="Text" class="form-control" id="tipo" name="tipo" >
                            </div>                                                           
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block my-4">Agregar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>