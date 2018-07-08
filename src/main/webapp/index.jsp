<%-- 
    Document   : index
    Created on : 29/06/2018, 19:47:57
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
        <div class="section-carousel">
            <div class="container-fluid pb-2">    
                <div class="row mb-3">
                    <div class="col col-lg-12">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100" height="460" src="image/carrocel_1.bmp" alt="First slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" height="460" src="image/carrocel_2.bmp" alt="Second slide">
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100" height="460" src="image/carrocel_3.bmp" alt="Third slide">
                                </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section-card">
            <div class="container-fluid">
                <div class="row mb-3">
                    <div class="col col-lg-12">
                        <div class="card-group">
                            <div class="card text-white bg-primary mx-2">
                                <div class="card-header">Investimentos</div>
                                <div class="card-body">
                                    <h5 class="card-title">Aumente sua rentabilidade</h5>
                                    <p class="card-text">O melhor time de insvetidores para aumentar seus lucros.</p>
                                </div>
                            </div>
                            <div class="card text-white bg-warning mx-2">
                                <div class="card-header">Previdência Privada</div>
                                <div class="card-body">
                                    <h5 class="card-title">Melhore sua aposentadoria</h5>
                                    <p class="card-text">Tenha sussego quando decidir parar de trabalhar.</p>
                                </div>
                            </div>
                            <div class="card text-white bg-success mx-2">
                                <div class="card-header">Cartão de Crédito</div>
                                <div class="card-body">
                                    <h5 class="card-title">Aumente seu poder de compra</h5>
                                    <p class="card-text">Compre mais e tenha 30 dias para efetuar o pagamento.</p>
                                </div>
                            </div>
                            <div class="card text-white mx-2" id="cardEmp">
                                <div class="card-header">Empréstimo</div>
                                <div class="card-body">
                                    <h5 class="card-title">Realize seus sonhos</h5>
                                    <p class="card-text">Forma rápida e segura de realizar seu sonho.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="WEB-INF/rodape.jspf" %>
    </body>
</html>
