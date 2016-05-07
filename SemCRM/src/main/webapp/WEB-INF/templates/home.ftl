<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Главная</title>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css"/>
    <link rel="stylesheet" type="text/css" href="/css/local.css"/>

    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>

    <!-- you need to include the shieldui css and js assets in order for the charts to work -->
    <link rel="stylesheet" type="text/css"
          href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css"/>
    <link id="gridcss" rel="stylesheet" type="text/css"
          href="http://www.shieldui.com/shared/components/latest/css/dark-bootstrap/all.min.css"/>

    <script type="text/javascript"
            src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
    <script type="text/javascript" src="http://www.prepbootstrap.com/Content/js/gridData.js"></script>
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
            <a class="navbar-brand" href="/home">Admin Panel</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul id="active" class="nav navbar-nav side-nav">
                <li class="selected"><a href="/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <#if name??>
                <li><a href="/profile"><i class="fa fa-tasks"></i> Профиль</a></li>
                <li><a href="/supply"><i class="fa fa-globe"></i> Поставки</a></li>
                <#else>
                <li><a href="/signin"><i class="fa fa-list-ol"></i> Вход</a></li>
                <li><a href="/registration"><i class="fa fa-font"></i> Register</a></li>
                </#if>
                <!--<li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i> Bootstrap Grid</a></li>-->
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-user">
                <#if name??>
                <li class="dropdown messages-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Сообщения
                        <span class="badge">2</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">2 новых сообщения</li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Предупреждение безопасности</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Предупреждение безопасности</span>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="#">Перейти во входящие <span class="badge">2</span></a></li>
                    </ul>
                </li>

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
                <li class="divider-vertical"></li>
                <li>
                    <form class="navbar-search">
                        <input type="text" placeholder="Search" class="form-control">
                    </form>
                </li>
            </ul>
        </div>
    </nav>

    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1>Главная
                    <#if name??><small> Заказы и прочее</small></#if>
                </h1>
                <#if name??>
                <div class="alert alert-dismissable alert-warning">
                    <button data-dismiss="alert" class="close" type="button">&times;</button>
                    Lorem ipsum dolor sit amet
                    <br/>
                    Lorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit
                    amet
                </div>
                </#if>
            </div>
        </div>
    </div>

    <#if name??>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <p>
                <a href="/supply/request">
                    <button type="button" class="btn btn-primary btn-lg btn-block">Сделать запрос на поставку</button>
                </a>
            </p>
        </div>
        <div class="col-lg-4"></div>
    </div>
    <br>

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <p>
                <a href="/supply/send">
                    <button type="button" class="btn btn-primary btn-lg btn-block">Отправить поставку</button>
                </a>
            </p>
        </div>
        <div class="col-lg-4"></div>
    </div>
    <br>

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <p>
                <button type="button" class="btn btn-primary btn-lg btn-block">Купить билет</button>
            </p>
        </div>
        <div class="col-lg-4"></div>
    </div>
    <br>
    <#else >
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <p>
                    <a href="/signin"><button type="button" class="btn btn-primary btn-lg btn-block">Войти в систему</button></a>
                </p>
            </div>
            <div class="col-lg-4"></div>
        </div>
        <br>

        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <p>
                    <a href="/registration"><button type="button" class="btn btn-primary btn-lg btn-block">Зарегистрироваться</button></a>
                </p>
            </div>
            <div class="col-lg-4"></div>
        </div>
        <br>
    </#if>


    <script type="text/javascript">
        jQuery(function ($) {
            var performance = [12, 43, 34, 22, 12, 33, 4, 17, 22, 34, 54, 67],
                    visits = [123, 323, 443, 32],
                    traffic = [
                        {
                            Source: "Direct", Amount: 323, Change: 53, Percent: 23, Target: 600
                        },
                        {
                            Source: "Refer", Amount: 345, Change: 34, Percent: 45, Target: 567
                        },
                        {
                            Source: "Social", Amount: 567, Change: 67, Percent: 23, Target: 456
                        },
                        {
                            Source: "Search", Amount: 234, Change: 23, Percent: 56, Target: 890
                        },
                        {
                            Source: "Internal", Amount: 111, Change: 78, Percent: 12, Target: 345
                        }];


            $("#shieldui-chart1").shieldChart({
                theme: "dark",

                primaryHeader: {
                    text: "Visitors"
                },
                exportOptions: {
                    image: false,
                    print: false
                },
                dataSeries: [{
                    seriesType: "area",
                    collectionAlias: "Q Data",
                    data: performance
                }]
            });

            $("#shieldui-chart2").shieldChart({
                theme: "dark",
                primaryHeader: {
                    text: "Traffic Per week"
                },
                exportOptions: {
                    image: false,
                    print: false
                },
                dataSeries: [{
                    seriesType: "pie",
                    collectionAlias: "traffic",
                    data: visits
                }]
            });

            $("#shieldui-grid1").shieldGrid({
                dataSource: {
                    data: traffic
                },
                sorting: {
                    multiple: true
                },
                rowHover: false,
                paging: false,
                columns: [
                    {field: "Source", width: "170px", title: "Source"},
                    {field: "Amount", title: "Amount"},
                    {field: "Percent", title: "Percent", format: "{0} %"},
                    {field: "Target", title: "Target"},
                ]
            });
        });
    </script>
</body>
</html>