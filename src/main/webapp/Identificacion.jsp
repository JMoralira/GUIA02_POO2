<%-- 
    Document   : Identificacion
    Created on : 08-19-2017, 07:31:20 PM
    Author     : Jose Lira
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="com.sv.udb.controlador.PersonasCtrl"%>
<%@page import="com.sv.udb.modelo.Personas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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

        <h1>${mensAler}</h1>
        <div class="container">
            <%
                for (Personas temp : new PersonasCtrl().constTodo()) {
                    byte[] photo = temp.getFoto();
                    String bphoto = Base64.getEncoder().encodeToString(photo);
            %>
            <h2 class="header">Identificación personal</h2>
            <div class="card horizontal">
                <div class="card-image">                      
                    <img src="data:image/*;base64,<%=bphoto%>" class="materialboxed" width="100" height="100">
                </div>
                <div class="card-stacked">
                    <div class="card-content">


                        <label class="blue-text">ID CARD</label> <%= temp.getDuiPers()%><br/>

                        <label>Nombre: </label><%= temp.getNombrPers()%> <%= temp.getApelPers()%><br/>

                        <label>Genero: </label> <%= temp.getGenePers()%><br/>

                        <label>Fecha nacimiento: </label> <%= temp.getFechaNaciPers()%><br/>

                    </div>
                    <%
                        }
                    %>
                    <div class="card-action">
                        <a href="index.jsp">Regresar</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
