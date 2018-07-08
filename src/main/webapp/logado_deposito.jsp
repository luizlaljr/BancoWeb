<%-- 
    Document   : logado_deposito
    Created on : 30/06/2018, 01:03:23
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
                                <% int conta = (int) session.getAttribute("contaLogada");%>
                                <h5><span class="badge badge-pill badge-light">CONTA nº <%= conta%></span></h5>
                            </div>
                            <form id="formDeposito" method="post" action="Deposito">
                                <div class="form-group">
                                    <label for="conta">Conta</label>
                                    <input type="text" class="form-control" id="conta" name="conta" placeholder="Digite o número da conta.">
                                </div>
                                <div class="form-group">
                                    <label for="valor">Valor</label>
                                    <input type="text" class="form-control" id="valor" name="valor" placeholder="Digite o valor a ser depositado.">
                                </div>
                                <button type="submit" class="btn btn-primary">Depositar</button>
                            </form>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
