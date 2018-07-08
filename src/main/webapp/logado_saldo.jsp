<%-- 
    Document   : logado_saldo
    Created on : 30/06/2018, 00:59:28
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
        <%@include file="WEB-INF/cabecalho.jspf" %>
        <div class="section-content">
            <div class="container-fluid">
                <div class="row">                    
                    <%@include file="WEB-INF/logado_menu.jspf"%>                        
                    <div class="col col-lg-9">
                        <div class="container my-5">
                            <div class="mb-4">
                                <% int conta = (int) request.getAttribute("conta");%>
                                <h5><span class="badge badge-pill badge-light">CONTA nº <%= conta%></span></h5>
                            </div>
                            <table class="table">
                                <% float saldo = (float) request.getAttribute("valor");%>
                                <thead>
                                    <tr>
                                        <th scope="col">DESCRIÇÃO</th>
                                        <th scope="col">VALOR (R$)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="font-weight-bold">
                                        <td>Saldo Disponível para Saque</th>
                                        <td><%= saldo%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>                        
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>

