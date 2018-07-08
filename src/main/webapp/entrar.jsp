<%-- 
    Document   : entrar
    Created on : 29/06/2018, 20:15:53
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
            <div class="container-fluid pb-2">
                <div class="row mb-3">
                    <div class="col col-lg-2">
                    </div>
                    <div class="col col-lg-8">
                        <div class="container my-5">
                            <form id="formLogin" action="Login" method="post">                            
                                <div class="alert alert-danger collapse" id="alert" role="alert"></div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label>Login</label>
                                        <input type="text" class="form-control" id="txtLogin" name="login" placeholder="Digite seu login">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12">
                                        <label>Senha</label>
                                        <input type="password" class="form-control" name="senha" id="txtSenha1" placeholder="Digite sua senha">
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </form
                        </div>
                    </div>
                    <div class="col col-lg-2">
                    </div>                    
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
