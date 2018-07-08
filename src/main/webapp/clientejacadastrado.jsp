<%-- 
    Document   : erro_login
    Created on : 26/05/2018, 23:55:00
    Author     : luizlaljr
--%>

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
                            <h1>Cliente já cadastrado no banco de dados!</h1>
                            <h4>Faça seu login.</h4>
                        </div>

                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
