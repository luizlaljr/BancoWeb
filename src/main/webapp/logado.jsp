<%-- 
    Document   : logado
    Created on : 26/05/2018, 23:42:15
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
                        <div class="text-center my-3">   
                            <% String nome = (String) request.getAttribute("cliente");%>
                            <h4>Seja Bem Vindo, Sr(a). <%= nome%></h4>
                            <% int conta = (int) request.getAttribute("conta");%>
                            <h5>Conta nº <%= conta%></h5>
                            <h6>Escolha uma das opções do menu esquerdo para efetuar suas transações</h6>
                        </div>

                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>