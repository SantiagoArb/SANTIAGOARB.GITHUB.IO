<%-- 
    Document   : Modal
    Created on : 23/10/2017, 05:00:53 PM
    Author     : clan-
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--Modal para el Registro de Materias-->                        
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="Modal_RegistrarEmp" >
    <div class="modal-dialog modal-lg" role="document">
        <form method="post" action="">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="form_top">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h2>Registro de <span>Empresa</span></h2>
                    </div> 
                </div>
                <div class="modal-body" >
                    <div class="container-fluid" >
                        <input name="COD_materia" class="input" type="text" placeholder="&#128272; Codigo de la Materia" required autofocus list="Quest"/>     
                        <datalist id="Quest">
                           
                        </datalist>
                        <input size="46" name="nombre_materia" class="input" type="text" placeholder="Nombre de la Materia" required autofocus><br>
                        <input size="70" name="grupos" class="input" type="text" placeholder="&#128100;Escribe los grupos separandolos por un punto y coma(;)">
                        Este campo no es obligatorio, solo en caso de querer registrar uno o mas grupos asociados a la materia.
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="RegistroEmpresa" type="submit" class="btn btn-default" name="RegistroEmpresa">Registrar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </form>
    </div>
</div>

<div class="modal fade" id="ModalEliminar" role="dialog">
    <div class="modal-dialog"> 
        <!-- Modal content-->
        <form method="post" action="">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h2 style="text-align: center"><span>Eliminar a <div id="Estudiante"></div></span></h2>
                </div>
                <div class="modal-body" style="background-color: #31B1E5">
                    <h4 style="text-align: center; color: #ffffff">¿Esta seguro que desea eliminar el usuario?</h4>

                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-default" name="Delete_Es" style="background-color: #d43f3a; color: white;">Aceptar</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                </div>
            </div>
        </form>
        <!--End -->
    </div>
</div>

