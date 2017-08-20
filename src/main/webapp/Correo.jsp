<%-- 
    Document   : Correo
    Created on : 08-18-2017, 04:50:59 PM
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
     <body class="teal lighten-2">
        <div class="container"
               <form  method="POST" action="CorrServ" name="DEMO" enctype="multipart/form-data">
                           
                        <div class="card horizontal">
                            <div class="card-stacked">
                                <div class="card-content">
                                    <h1 class="header center">Nuevo mensaje<h1>
                                    <br/>
                                    <label class="black-text">Para</label>
                                    <select id="cmbPersonas" name="cmbPersonas">

                                        <option  disabled selected class="white-text"> Seleccione una Persona</option>
                                        <%
                                            for (Personas temp : new PersonasCtrl().constTodo()) {
                                        %>
                                        <option value="<%=temp.getCorrePers()%>"><%=temp.getNombrPers()%> <%=temp.getApelPers()%></option>;
                                        <%
                                            }
                                        %>
                                    </select> <br/>
                                    <label class="black-text">CC</label>
                                    <select id="cmbPersonas" name="cmbPersonas">

                                        <option  disabled selected class="white-text"> Seleccione una Persona</option>
                                        <%
                                            for (Personas temp : new PersonasCtrl().constTodo()) {
                                        %>
                                       <option value="<%=temp.getCorrePers()%>"><%=temp.getNombrPers()%> <%=temp.getApelPers()%></option>;
                                        <%
                                            }
                                        %>
                                    </select> <br/>
                                    <label class="black-text">CCO</label>
                                    <select id="cmbPersonas" name="cmbPersonas">

                                        <option  disabled selected class="white-text"> Seleccione una Persona</option>
                                        <%
                                            for (Personas temp : new PersonasCtrl().constTodo()) {
                                        %>
                                       <option value="<%=temp.getCorrePers()%>"><%=temp.getNombrPers()%> <%=temp.getApelPers()%></option>;
                                        <%
                                            }
                                        %>
                                    </select> <br/>
                                    
                                     <label>Asunto:</label>
                                  <input type="text" name="asun" id="asun" value="${asun}" required> <br>
                                     <label>Mensaje:</label>
                                  <input type="text" name="mensa" id="mensa" value="${mensa}" required> <br>
                                </div>
                                <ul>
                                    <li><a href="index.jsp">Mantenimiento usuarios</a></li>
                                </ul>            
                                <div class="card-action center">
                                    <button class="btn waves-effect waves-light" type="submit" name="btoJuga" value="Consultar">Enviar
                                    </button>
                                    <button class="btn waves-effect waves-light red darken-4" type="submit" name="btoJuga" value="Consultar">Cancelar
                                    </button>
                                </div>
                            </div>
                        </div>
                        
                        </form>
                        </div>

 <script>
        $(document).ready(function() {
            $('select').material_select();
          });
    </script>
    </body>
</html>
