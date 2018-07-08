<%-- 
    Document   : cliente
    Created on : 31/03/2018, 18:05:37
    Author     : luizlaljr
--%>

<%@page import="com.mycompany.bancoweb.model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" >

        <!-- Style -->
        <link rel="stylesheet" href="css/style.css" type="text/css" >

        <title>Banco Web</title>
    </head>
    <body>
        <%@include file="WEB-INF/cabecalho_deslogado.jspf" %>
        <div class="section-content">
            <div class="container-fluid">
                <div class="row">                                            
                    <div class="col col-lg-12">
                        <div class="text-center my-3">   
                            <% Cliente cliente = (Cliente) request.getAttribute("cliente");%>
                            <h2>Seja Bem Vindo, Sr(a). <%= cliente.getNome()%></h2>
                            <h3>O número da sua nova conta é: <b><%= cliente.getConta()%></b></h3>
                            <a href="entrar.jsp">Clique neste link para realizar o login no sistema.</a>
                        </div>

                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
