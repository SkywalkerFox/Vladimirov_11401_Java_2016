<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - Dark Admin</title>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/local.css" />

    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<div id="wrapper">
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home">Back to Admin</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <li class="selected"><a href="/signin"><i class="fa fa-list-ol"></i> Вход</a></li>
                <li><a href="/registration"><i class="fa fa-font"></i> Register</a></li>
                <!--<li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i > Bootstrap Grid</a></li>-->
            </ul>

        </div>
    </nav>

    <div id="page-wrapper">

        <div class="row">

            <div class="col-lg-12 text-center v-center">

                <h1>Вход</h1>
                <p class="lead">Введите свои данные, чтобы войти в систему</p>

                <br>
                <br>
                <br>

                <form action="/signin/process" method="post" class="col-lg-12">
                    <div class="input-group" style="width: 340px; text-align: center; margin: 0 auto;">
                        <input id="email" name="email" class="form-control input-lg" placeholder="Email" type="email"><br><br>
                        <input id="password" name="password" class="form-control input-lg" placeholder="Пароль" type="password">
                            <span class="input-group-btn">
                                <input class="btn btn-lg btn-primary" type="submit" value="OK"/></span>
                    </div>
                </form>
            </div>
        </div>
        <br><br><br><br><br><br><br><br><br>
        <div class="text-center">
            <h1>Follow us</h1>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center v-center" style="font-size: 39pt;">
                <a href="#"><span class="avatar"><i class="fa fa-google-plus"></i></span></a>
                <a href="#"><span class="avatar"><i class="fa fa-linkedin"></i></span></a>
                <a href="#"><span class="avatar"><i class="fa fa-facebook"></i></span></a>
                <a href="#"><span class="avatar"><i class="fa fa-github"></i></span></a>
            </div>

        </div>
        <!-- /.row -->

    </div>
    <!-- /#page-wrapper -->
</div>
</body>
</html>