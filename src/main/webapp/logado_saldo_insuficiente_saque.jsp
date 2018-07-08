<%-- 
    Document   : logado_saque
    Created on : 30/06/2018, 01:01:02
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
                            <form id="formSaque" method="post" action="Saque">
                                <% float saldo = (float) request.getAttribute("saldo");%>
                                <div class="form-group">
                                    <label for="valorConta">Saldo disponível</label>
                                    <input type="text" class="form-control" id="saldoDisponivel" name="saldo" value="<%= saldo%>">
                                </div>
                                <div class="form-group">
                                    <label for="valorSaque">Digite valor de saque:</label>                                    
                                    <input type="text" class="form-control is-invalid" id="saque" name="valor" placeholder="R$ 0.00" required>
                                    <div class="invalid-feedback">
                                        Saldo insuficente ou é valor menor ou igual a zero.
                                    </div>                                    
                                </div>
                                <button type="submit" class="btn btn-primary">Sacar</button>
                            </form>
                        </div>
                    </div>                   
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>

