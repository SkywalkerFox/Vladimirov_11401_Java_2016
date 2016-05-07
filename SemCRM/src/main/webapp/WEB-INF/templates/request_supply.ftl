<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Поставки</title>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/local.css"/>

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
            <a class="navbar-brand" href="home.ftl">На главную</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <li><a href="/profile"><i class="fa fa-tasks"></i> Профиль</a></li>
                <li class="selected"><a href="/supply/"><i class="fa fa-globe"></i> Поставки</a></li>
                <!--li><a href="/signin"><i class="fa fa-list-ol"></i> Вход</a></li>
                <li><a href="/registration"><i class="fa fa-font"></i> Регистрация</a></li>
                <li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i> Bootstrap Grid</a></li-->
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-user">
                <li class="dropdown messages-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Сообщения
                        <span class="badge">2</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">2 новых сообщения</li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Предупреждени</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Security alert</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#">Go to Inbox <span class="badge">2</span></a></li>
                    </ul>
                </li>
            <#if name??>
                <li class="dropdown user-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${name}<b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/profile"><i class="fa fa-user"></i> Профиль</a></li>
                        <li><a href="#"><i class="fa fa-gear"></i> Настройки</a></li>
                        <li class="divider"></li>
                        <li><a href="/logout"><i class="fa fa-power-off"></i> Выйти</a></li>

                    </ul>
                </li>
            </#if>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper">

        <div class="row">

            <div class="col-lg-12 text-center v-center">

                <h1>Запрос на поставку</h1>
                <p class="lead">Введите название и опишите необходимое</p>

                <br>
                <br>
                <br>

                <form action="/supply/request" method="post" class="col-lg-12">
                    <div class="input-group" style="width: 700px; text-align: center; margin: 0 auto;">
                        <input id="" name="name" class="form-control input-lg" placeholder="Название" type="text"><br><br>
                        <textarea id="" name="description" class="form-control input-lg" rows="3" maxlength="200" placeholder="Описание"></textarea><br><br>
                        <div class="form-group col-lg-2">
                            <label for="size">Количество:</label>
                            <input id="size" name="size" class="form-control">
                        </div><br><br><br><br><br><br><br>
                        <input class="btn btn-lg btn-primary" type="submit" value="Отправить"/>
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
</div>

</body>
</html>
