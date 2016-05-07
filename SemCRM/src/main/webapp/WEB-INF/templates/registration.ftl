<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Dark Admin</title>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/local.css"/>

    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>

    <style>

        div {
            padding-bottom: 20px;
        }

    </style>
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
                <li><a href="/signin"><i class="fa fa-list-ol"></i> Вход</a></li>
                <li class="selected"><a href="/registration"><i class="fa fa-font"></i> Регистрация</a></li>
                <!--<li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i > Bootstrap Grid</a></li>-->
            </ul>

        </div>
    </nav>

    <div>
        <div class="row text-center">
            <h2>Новая регистрация</h2>
        </div>
        <form class="userform" action="/registration" method="post">
            <div>
                <label for="firstname" class="col-md-2">
                    Имя:
                </label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Введите имя">
                </div>
                <div class="col-md-1">
                    <i class="fa fa-lock fa-2x"></i>
                </div>
            </div>
            <div>
                <label for="lastname" class="col-md-2">
                    Фамилия:
                </label>
                <div class="col-md-9">
                    <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Введите фамилию">
                </div>
                <div class="col-md-1">
                    <i class="fa fa-lock fa-2x"></i>
                </div>
            </div>
            <div>
                <label for="email" class="col-md-2">
                    Email адрес:
                </label>
                <div class="col-md-9">
                    <input type="email" class="form-control" id="email" name="email" placeholder="Введите email">
                    <p class="help-block">
                        Пример: yourname@domain.com
                    </p>
                </div>
                <div class="col-md-1">
                    <i class="fa fa-lock fa-2x"></i>
                </div>
            </div>
            <div>
                <label for="password" class="col-md-2">
                    Пароль:
                </label>
                <div class="col-md-9">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Введите пароль">
                    <p class="help-block">
                        Минимум: 6 символов
                    </p>
                </div>
                <div class="col-md-1">
                    <i class="fa fa-lock fa-2x"></i>
                </div>
            </div>
            <div>
                <label for="sex" class="col-md-2">
                    Пол:
                </label>
                <div class="col-md-10">
                    <label class="radio">
                        <input type="radio" name="sex" id="sex" value="male" checked>
                        Мужской
                    </label>
                    <label class="radio">
                        <input type="radio" name="sex" id="Radio1" value="female">
                        Женский
                    </label>
                </div>
            </div>
            <div>
                <label for="country" class="col-md-2">
                    Страна:
                </label>
                <div class="col-md-9">
                    <select name="country" id="country" class="form-control">
                        <option>--Выберите--</option>
                        <option>Россия</option>
                        <option>США</option>
                        <option>Китай</option>
                        <option>Индия</option>
                        <option>Другие</option>
                    </select>
                </div>
            </div>
            <!--div>
                <label for="uploadimage" class="col-md-2">
                    Загрузить фото:
                </label>
                <div class="col-md-10">
                    <input type="file" name="uploadimage" id="uploadimage">
                    <p class="help-block">
                        Поддерживаемые форматы: jpeg, jpg, gif, png
                    </p>
                </div>
            </div>
            <div>
                <div class="col-md-2">
                </div>
                <div class="col-md-10">
                    <label>
                        <input type="checkbox">Подтверждаю, что принимаю условия использоования данного сайта</label>
                </div>
            </div-->
            <div class="row">
                <div class="col-md-2">
                </div>
                <div class="col-md-10">
                    <input type="submit" name="submit" id="submit" class="btn btn-info" value="Зарегистрироваться" />
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
