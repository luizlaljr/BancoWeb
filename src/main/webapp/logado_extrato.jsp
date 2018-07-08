<%-- 
    Document   : logado_extrato
    Created on : 30/06/2018, 01:02:26
    Author     : luizlaljr
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.bancoweb.model.Movimento"%>
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
                        <% List<Movimento> extrato = (List) request.getAttribute("extrato");%>
                        <div class="container my-5">
                            <div class="mb-4">
                                <% int conta = (int) request.getAttribute("conta");%>
                                <h5><span class="badge badge-pill badge-light">CONTA nº <%= conta%></span></h5>
                            </div>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">DESCRIÇÃO</th>
                                        <th scope="col">VALOR (R$)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Movimento mov : extrato) {
                                    %>                                    
                                    <%if (mov.getTipo_mov() == 1) {%>
                                    <tr class="text-primary font-weight-bold">
                                        <td>Deposito</td>
                                        <%} else if (mov.getTipo_mov() == 2) {%>
                                    <tr class="text-danger font-weight-bold">
                                        <td>Saque</td>
                                        <%} else if (mov.getTipo_mov() == 3) {%>
                                    <tr class="text-warning font-weight-bold">
                                        <td>Pagamento</td>
                                        <%}%>
                                        <td><%=mov.getValor()%></td>
                                    </tr>
                                    <%}%>
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
