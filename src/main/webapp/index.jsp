<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="com.sv.udb.controlador.PersonasCtrl"%>
<%@page import="com.sv.udb.modelo.Personas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel='stylesheet' href='webjars/materialize/0.97.3/dist/css/materialize.min.css'>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script type="text/javascript" src="webjars/jquery/2.1.4/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.min.js"></script>
        <title>JSP Page</title>
    </head>
     <body>
        <div class="container">
            <center><h1>Mantenimiento de Personas</h1></center>
        <h1>${mensAler}</h1>
        <form method="POST" action="PersonasServ" name="DEMO" enctype="multipart/form-data">
                    <label for="codi">Codigo:</label>
                    <input type="text" name="codi" id="codi" value="${codi}" readonly> <br/>
                    <label for="nomb">Nombre:</label>
                    <input type="text" name="nomb" id="nomb" value="${nomb}" required> <br/>
                    <label for="apel">Apellido:</label>
                    <input type="text" name="apel" id="apel" value="${apel}" required> <br/>
                    <label for="coditipopers">Codigo tipo persona</label>
                    <input type="text" name="coditipopers" id="coditipopers" value="${coditipopers}" required> <br/>
                    <label for="gene">Genero:</label>
                    <input type="text" name="gene" id="gene" value="${gene}" required> <br/>
                    <label for="fechnaci">Fecha nacimiento:</label>
                    <input type="text" name="fechnaci" id="fechnaci" value="${fechnaci}" required> <br/>
                    <label for="dui">DUI:</label>
                    <input type="text" name="dui" id="dui" value="${dui}" required> <br/>
                    <label for="nit">NIT:</label>
                    <input type="text" name="nit" id="nit" value="${nit}" required> <br/>
                    <label for="tiposang">Tipo sangre:</label>
                    <input type="text" name="tiposang" id="tiposang" value="${tiposang}" required> <br/>
                    <label for="codiubicgeog">Cod ubicacion geografica:</label>
                    <input type="text" name="codiubicgeog" id="codiubicgeog" value="${codiubicgeog}" required> <br/>
                    <label for="corr">Correo:</label>
                    <input type="text" name="corr" id="corr" value="${corr}" required> <br/>
                    <label for="fechalta">Fecha alta:</label>
                    <input type="text" name="fechalta" id="fechalta" value="${fechalta}" required> <br/>
                    <label for="fechbaja">Fecha baja:</label>
                    <input type="text" name="fechbaja" id="fechbaja" value="${fechbaja}" required> <br/>
                    <label for="esta">Estado:</label>
                    <input type="text" name="esta" id="esta" value="${esta}" required> <br/>
        <div class="input-field col s12 m12 l12">
            <div class="file-field input-field">
            <button class="btn">
         <i class="material-icons">insert_photo</i>
        <input type='file' name='imagen' id="img"/> 
        </button>
                <div class="file-path-wrapper">
                            <input class="file-path validate" name="ima" type="text" value="${ima}" placeholder='1200x1200px máx., 2MB máx., PNG/JPG/GIF '>
                </div> 
        </div>
        </div>
                <button class="btn waves-effect waves-light" type="submit" name="btonPers" value="Guardar"> Guardar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPers" value="Modificar">Modificar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPers" value="Eliminar">Eliminar
                <i class="material-icons right">send</i>
                </button>
                <button class="btn waves-effect waves-light" type="submit" name="btonPers" value="Nuevo">Nuevo
                <i class="material-icons right">send</i>
                </button>


        <ul>
            <li><a href="Correo.jsp">Enviar correos</a></li>
        </ul>            
        </form>
        
        <h1>La Tabla</h1>
        <form method="POST" action="PersonasServ" name="TABLA">
        <table>
            <thead>
            <tr>
                <th>Cons</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Foto</th>
                <th>Genero</th>
                <th>Fecha nacimiento</th>
                <th>DUI</th>
                <th>NIT</th>
                <th>Tipo sangre</th>
                <th>Correo</th>
            </tr>
            </thead>
            <tbody>
            
            <%
            for (Personas temp : new PersonasCtrl().constTodo())
            {
                  byte[] photo = temp.getFoto();
                    String bphoto = Base64.getEncoder().encodeToString(photo);
            %>
            <tr>
                <td><p><input name="codiPersRadi" type="radio" id="<%=temp.getCodiPers()%>" value="<%=temp.getCodiPers()%>" />
                 <label for="<%=temp.getCodiPers()%>"></label></p></td>
                <td><%= temp.getNombrPers()%></td>
                <td><%= temp.getApelPers() %></td>
                  <td><img src="data:image/*;base64,<%=bphoto%>" class="materialboxed" width="100" height="100"></td>
                <td><%= temp.getGenePers() %></td>
                <td><%= temp.getFechaNaciPers()%></td>
                <td><%= temp.getDuiPers()%></td>
                <td><%= temp.getNitPers() %></td>
                <td><%= temp.getTipoSangrePers()%></td>
                <td><%= temp.getCorrePers() %></td>
            </tr>
            <%
            }
            %>
        </tbody>
        </table>
            <button class="btn waves-effect waves-light" type="submit" name="btonPers" value="Consultar">Consultar
            <i class="material-icons right">send</i>
            </button>
        </form>
        </div>
    </body>
    
</html>
