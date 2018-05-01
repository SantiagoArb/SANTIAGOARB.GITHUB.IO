<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="../favicon.ico">
        <title>S&SMusic</title>
        <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
        <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="../css/jquery.bxslider.css">
        <link rel="stylesheet" type="text/css" href="../css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="../css/animate.css">
        <link rel="stylesheet" type="text/css" href="../css/style.css">
        <link rel="stylesheet" type="text/css" href="../css/main.css">   
        <script src="https://code.jquery.com/jquery-3.3.1.js" type="text/javascript" ></script>
    </head>
    <body>
        <div class="loader"></div>
        <div id="myDiv">
            <!--HEADER-->
            <header id="main-header">
                <nav class="navbar navbar-default navbar-fixed-top" style="background-color: rgb(73, 84, 105)">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="../index.html">S&S<span class="logo-dec"><img src="../img/ser01.png">USIC</span></a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="active"><a href="#">Inicio</a></li>
                                <li class=""><a href="#contact">Contactenos</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>

            <script type="text/javascript">
                $(document).ready(function () {
                    $('#btn_Ingreso').click(function () {
                        alert("entro.");
                        var nick = $('#nick').val();
                        var password = $('#password').val();
                        $.post('../prueba', {nick: nick}, function (result) {
                            $('#msg_errorIngreso').html(result);
                            setTimeout(function () {
                                $('#msg_errorIngreso').fadeOut(3000);
                            }, 3000);
                        });
                    });
                });
            </script>
            <!--/ HEADER-->
            <section id="blog" class="section-padding wow fadeInUp delay-05s">    
            </section>
            <section id="blog" class="section-padding wow fadeInUp delay-05s">

                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center">
                            <h2 class="service-title pad-bt15">Bienvenido</h2>
                            <hr class="bottom-line">
                            <div id="formDiv">
                                <span id="msg_errorIngreso" style="color: #ff0000"></span>
                                <form class="form_in">   
                                    <input id="nick" name="nick" class="input" type="text" placeholder="&#128100; Usuario" required autofocus>
                                    <input id="password" name="password" class="input" type="password" placeholder="&#128273; Contraseña" required autofocus>
                                    <a href="../Ingreso_Registro/In_Re.jsp" style="font-size: small; text-align: left">¿Olvidaste tu contraseña?</a>
                                    <div class="btn_form">
                                        <input id="btn_Ingreso" name="btn_Ingreso" class="btn_submit" type="button" value="Ingresar">
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!---->
            <section id="contact" class="section-padding wow fadeInUp delay-05s">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-center white">
                            <h2 class="service-title pad-bt15">Mantente en contacto con nosotros</h2>
                            <p class="sub-title pad-bt15">Si tienes alguna duda, con respecto a ¿quienes somos? o ¿como funciona el programa?, <br>puedes contactarnos</p>
                            <hr class="bottom-line white-bg">
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="loction-info white">
                                <p><i class="fa fa-map-marker fa-fw pull-left fa-2x"></i>Politecnico Colombiano J.I.C<br>Medellin, Antioquia</p>
                                <p><i class="fa fa-envelope-o fa-fw pull-left fa-2x"></i>santiago_cardona82141@elpoli.edu.co <br>santiago_arbelaez82141@elpoli.edu.co</p>
                                <p><i class="fa fa-phone fa-fw pull-left fa-2x"></i>+57 302-420-9853</p>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div class="contact-form">
                                <div id="sendmessage">Tu mensaje ha sido enviado. Gracias!</div>
                                <div id="errormessage"></div>
                                <form action="" method="post" role="form" class="contactForm">
                                    <div class="col-md-6 padding-right-zero">
                                        <div class="form-group">
                                            <input type="text" name="name" class="form-control" id="name" placeholder="Nombre" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
                                            <div class="validation"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" id="email" placeholder="Correo electronico" data-rule="email" data-msg="Please enter a valid email" />
                                            <div class="validation"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="subject" id="subject" placeholder="Titulo" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                                            <div class="validation"></div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <textarea class="form-control" name="message" rows="5" data-rule="required" data-msg="Por favor, escriba algo para nosotros" placeholder="Mensaje"></textarea>
                                            <div class="validation"></div>
                                        </div>
                                        <button type="submit" class="btn btn-primary btn-submit">ENVIAR</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!---->
            <!---->
            <footer id="footer">
                <div class="container">
                    <div class="row text-center">
                        <p>&copy;Santiago Cardona & Santiago Arbelaez. Todos los Derechos Reservados.</p>
                        <div class="credits">
                            Tema Diseñador por <a href="https://bootstrapmade.com/">Bootstrap Themes</a>
                        </div>
                    </div>
                </div>
            </footer>
            <!---->
        </div>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/jquery.easing.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/wow.js"></script>
        <script src="../js/jquery.bxslider.min.js"></script>
        <script src="../js/custom.js"></script>

    </body>
</html>
