 
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    <i class="fa fa-plus"></i> Agregar cine
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
            <div class="modal-body text-left">
                <form action="<%=request.getContextPath()%>/CineController" method="POST">
                    <input type="hidden" id="processing" name="processing" value="agregarCine">
                    <input type="hidden"  id="idCine" name="idCine" >                        
                    <div class="form-group pt-4">
                        <label for="nombre">Nombre:</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" >
                    </div>
                        
                    <div class="form-group">
                        <label for="direccion">Dirección</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" >
                    </div>
                        
                    <div class="form-group">
                        <label for="logo">Logo</label>
                        <input type="text" class="form-control" id="logo" name="logo" >
                    </div>
                        
                    <div class="form-group">
                        <label for="estado">Estado</label>
                        <input type="number" class="form-control" id="estado" name="estado" >
                    </div>
                    <div class="form-group">
                        <label for="idDistrito">Distrito</label>
                        <select class="form-control" name="distrito" id="distrito">
                                    <option value="0" selected>Distrito</option>
                                    <option value="1">LIMA</option>}
                                    <option value="2">ANCON</option>
                                    <option value="3">ATE</option>
                                    <option value="4">BREÑA</option>
                                    <option value="5">CARABAYLLO</option>
                                    <option value="6">COMAS</option>
                                    <option value="7">CHACLACAYO</option>
                                    <option value="8">CHORRILLOS</option>
                                    <option value="9">LA VICTORIA</option>
                                    <option value="10">LA MOLINA</option>
                                    <option value="11">LINCE</option>
                                    <option value="12">LURIGANCHO</option>
                                    <option value="13">LURIN</option>
                                    <option value="14">MAGDALENA DEL MAR</option>
                                    <option value="15">MIRAFLORES</option>
                                    <option value="16">PACHACAMAC</option>
                                    <option value="17">PUEBLO LIBRE</option>
                                    <option value="18">PUCUSANA</option>
                                    <option value="19">PUENTE PIEDRA</option>
                                    <option value="20">PUNTA HERMOSA</option>
                                    <option value="21">PUNTA NEGRA</option>
                                    <option value="22">RIMAC</option>
                                    <option value="23">SAN BARTOLO</option>
                                    <option value="24">SAN ISIDRO</option>
                                    <option value="25">BARRANCO</option>
                                    <option value="26">SAN MARTIN DE PORRES</option>
                                    <option value="27">SAN MIGUEL</option>
                                    <option value="28">SANTA MARIA DEL MAR</option>
                                    <option value="29">SANTA ROSA</option>
                                    <option value="30">SANTIAGO DE SURCO</option>
                                    <option value="31">SURQUILLO</option>
                                    <option value="32">VILLA MARIA DEL TRIUNFO</option>
                                    <option value="33">JESUS MARIA</option>
                                    <option value="34">INDEPENDENCIA</option>
                                    <option value="35">EL AGUSTINO</option>
                                    <option value="36">SAN JUAN DE MIRAFLORES</option>                     
                                    <option value="37">SAN JUAN DE LURIGANCHO</option>
                                    <option value="38">SAN LUIS</option>
                                    <option value="39">CIENEGUILLA</option>
                                    <option value="40">SAN BORJA</option>
                                    <option value="41">VILLA EL SALVADOR</option>
                                    <option value="42">LOS OLIVOS</option>
                                    <option value="43">SANTA ANITA</option>
                                    <option value="44">CALLAO</option>
                                    <option value="45">BELLAVISTA</option>
                                    <option value="46">LA PUNTA</option>
                                    <option value="47">CARMEN DE LA LEGUA-REYNOSO</option>
                                    <option value="48">LA PERLA</option>                                                                      
                                    <option value="49">VENTANILLA</option>
                                    <option value="50">SURCO</option>                                                         
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