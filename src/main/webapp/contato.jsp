<%-- 
    Document   : contato
    Created on : 29/06/2018, 20:07:35
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
                <div class="row mb-3">
                    <div class="col col-lg-2">
                    </div>
                    <div class="col col-lg-8">
                        <form>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputEmail4">Nome</label>
                                    <input type="text" class="form-control" id="inputEmail4" placeholder="Nome do seu login">
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="inputPassword4">Conta</label>
                                    <input type="number" class="form-control" id="inputPassword4" placeholder="Numero da sua conta">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputAddress">Endereço</label>
                                <input type="text" class="form-control" id="inputAddress" placeholder="Seu Endereço">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputCity">Cidade</label>
                                    <input type="text" class="form-control" id="inputCity">
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="inputState">Estado</label>
                                    <select id="inputState" class="form-control">
                                        <option selected>Rio de Janeiro</option>
                                        <option>Outro</option>
                                    </select>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="inputZip">Cep</label>
                                    <input type="text" class="form-control" id="inputZip">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>
                    </div>
                    <div class="col col-lg-2">
                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
