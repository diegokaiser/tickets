<div class="row">
    <div class="col-sm-12 text-right">
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-plus"></i>&nbsp;&nbsp;Agregar cine
        </button>
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agregar Cine</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="<%=request.getContextPath()%>/CineController" method="POST">
                            <input type="hidden" id="processing" name="processing" value="agregarCine">
                            <input type="hidden"  id="idCine" name="idCine" >                        
                            <div class="form-group pt-4 text-left">
                                <label for="nombre">Nombre:</label>
                                <input type="text" class="form-control" id="nombre" name="nombre" >
                            </div>
                                      
                            <div class="form-group text-left">
                                <label for="direccion">Dirección</label>
                                <input type="text" class="form-control" id="direccion" name="direccion" >
                            </div>
                                      
                            <div class="form-group text-left">
                                <label for="logo">Logo</label>
                                <input type="text" class="form-control" id="logo" name="logo" >
                            </div>
                                      
                            <div class="form-group text-left">
                                <label for="estado">Estado</label>
                                <input type="number" class="form-control" id="estado" name="estado" >
                            </div>
                            <div class="form-group text-left">
                                <label for="idDistrito">Distrito</label>
                                <select class="form-control" id="idDistrito" name="idDistrito">
                                    ${distrito.idDistrito}
                                    <c:forEach var="distrito" items="${distritos}">                                
                                        <option value="${distrito.idDistrito}">${distrito.nombre}</option>
                                    </c:forEach>
                                </select>
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