<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Dark Admin</title>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/local.css" />

    <script type="text/javascript" src="/js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>

    <!-- you need to include the shieldui css and js assets in order for the charts to work -->
    <link rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/light-bootstrap/all.min.css" />
    <link id="gridcss" rel="stylesheet" type="text/css" href="http://www.shieldui.com/shared/components/latest/css/dark-bootstrap/all.min.css" />

    <script type="text/javascript" src="http://www.shieldui.com/shared/components/latest/js/shieldui-all.min.js"></script>
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
            <a class="navbar-brand" href="/admin/home">Admin Panel</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul id="active" class="nav navbar-nav side-nav">
                <li class="selected"><a href="/admin/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <!--li><a href="portfolio.html"><i class="fa fa-tasks"></i> Portfolio</a></li-->
                <li><a href="/admin/supply"><i class="fa fa-globe"></i> Поставки</a></li>
                <li><a href=""><i class="fa fa-font"></i> Хронология</a></li>
                <!--li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i> Bootstrap Grid</a></li-->
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-user">
                <li class="dropdown messages-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> Messages <span class="badge">2</span> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">2 New Messages</li>
                        <li class="message-preview">
                            <a href="#">
                                <span class="avatar"><i class="fa fa-bell"></i></span>
                                <span class="message">Security alert</span>
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
                <li class="dropdown user-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${admin}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <!--li><a href="#"><i class="fa fa-user"></i> Profile</a></li-->
                        <li><a href="#"><i class="fa fa-gear"></i> Settings</a></li>
                        <li class="divider"></li>
                        <li><a href="/logout"><i class="fa fa-power-off"></i> Выйти</a></li>

                    </ul>
                </li>
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
                <h1>Главная <small>Статистика и прочее</small></h1>
                <div class="alert alert-dismissable alert-warning">
                    <button data-dismiss="alert" class="close" type="button">&times;</button>
                    Добро пожаловать на главную панель администратора! Следите за пользователями, управляйте содержимым и многое другое.
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-md-8">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Visits Based on a 10 days data</h3>
                    </div>
                    <div class="panel-body">
                        <div id="shieldui-chart1"></div>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-rss"></i> Последние события на сайте</h3>
                    </div>
                    <div class="panel-body feed">
                        <#if activities??>
                        <#list activities as a>
                            <section class="feed-item">
                                <div class="icon pull-left">
                                    <#if a.getType() == "request">
                                        <i class="fa fa-shopping-cart"></i>
                                    </#if>
                                    <#if a.getType() == "sending">
                                        <i class="fa fa-send"></i>
                                    </#if>
                                    <#if a.getType() == "registration">
                                        <i class="fa fa-plus-square"></i>
                                    </#if>
                                </div>
                                <div class="feed-item-body">
                                <div class="text">
                                    ${a.getDescription()}
                                </div>
                                <div class="time pull-left">
                                    ${a.getDate()}
                                </div>
                                </div>
                            </section>
                        </#list>
                        </#if>

                            <#if (activities?size > 6) >
                        <section class="feed-item">
                            <div class="icon pull-left">
                                <i class="fa fa-arrow-down"></i>
                            </div>
                            <div class="feed-item-body">
                                <div class="text">
                                    <a href="#">Load more...</a>
                                </div>
                            </div>
                        </section>
                            </#if>
                    </div>
                </div>
            </div>
        </div>

        <!--ТАБЛИЦА С ПОЛЬЗОВАТЕЛЯМИ-->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Пользователи</h3>
                    </div>
                    <div class="panel-body">
                        <div class="sui-grid sui-grid-core">
                            <div class="sui-gridheader">
                                <table class="sui-table">
                                    <colgroup>
                                        <col style="width: 170px">
                                        <col>
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr class="sui-columnheader">
                                        <th data-field="Users" class="sui-headercell">
                                            <a href="#" class="sui-link">Пользователи</a>
                                        </th>
                                        <th data-field="Requested" class="sui-headercell">
                                            <a href="#" class="sui-link">Запрошенные поставки</a>
                                        </th>
                                        <th data-field="Sent" class="sui-headercell">
                                            <a href="#" class="sui-link">Отправленные поставки</a>
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody class="sui-hide">
                                    <tr>
                                        <#list users as u>
                                            <td></td>
                                        </#list>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="sui-gridcontent">
                                <table class="sui-table">
                                    <colgroup>
                                        <col style="width: 170px;">
                                        <col>
                                        <col>
                                    </colgroup>
                                    <tbody>
                                    <#list users as u>
                                    <tr class="sui-row">
                                        <td class="sui-cell"><a href="/admin/timeline/${u.getId()}">${u.getFirstName()} ${u.getLastName()}</td>
                                        <td class="sui-cell">
                                            <#list requested?keys as key>
                                                <#if u.getEmail() == key>
                                                    ${requested[key]}
                                                </#if>
                                            </#list>
                                        </td>
                                        <td class="sui-cell">
                                            <#list sent?keys as key>
                                                <#if u.getEmail() == key>
                                                    ${sent[key]}
                                                </#if>
                                            </#list>
                                        </td>
                                    </tr>
                                    </#list>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="row">
            <div class="col-lg-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Logins per week</h3>
                    </div>
                    <div class="panel-body">
                        <div id="shieldui-chart2"></div>
                    </div>
                </div>
            </div>

            <div class="col-lg-4">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-magnet"></i> Server Overview</h3>
                    </div>
                    <div class="panel-body">
                        <ul class="server-stats">
                            <li>
                                <div class="key pull-right">CPU</div>
                                <div class="stat">
                                    <div class="info">60% / 37°C / 3.3 Ghz</div>
                                    <div class="progress progress-small">
                                        <div style="width: 70%;" class="progress-bar progress-bar-danger"></div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="key pull-right">Mem</div>
                                <div class="stat">
                                    <div class="info">29% / 4GB (16 GB)</div>
                                    <div class="progress progress-small">
                                        <div style="width: 29%;" class="progress-bar"></div>
                                    </div>
                                </div>
                            </li>
                            <li>
                                <div class="key pull-right">LAN</div>
                                <div class="stat">
                                    <div class="info">6 Mb/s <i class="fa fa-caret-down"></i>&nbsp; 3 Mb/s <i class="fa fa-caret-up"></i></div>
                                    <div class="progress progress-small">
                                        <div style="width: 48%;" class="progress-bar progress-bar-inverse"></div>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>

            <div class="col-lg-4">
                <header>
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a data-toggle="tab" href="#users">Пользователи</a>
                        </li>
                        <li class="">
                            <a data-toggle="tab" href="#top">Популярные</a>
                        </li>
                    </ul>
                </header>
                <div class="body tab-content">
                    <div class="tab-pane clearfix active" id="users">
                        <h5 class="tab-header"><i class="fa fa-calendar-o fa-2x"></i> Последние вошедшие в систему</h5>
                        <ul class="news-list">
                            <#list lastLoggedIn as last>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <#list users as u>
                                        <div class="name">
                                            <a href="#">
                                                <#if u.getId() == last.getUserId()> ${u.getFirstName()} ${u.getLastName()}</#if>
                                            </a>
                                        </div>
                                    </#list>
                                    <div class="time">Последний вход: ${last.getDate()}</div>
                                </div>
                            </li>
                            </#list>
                        </ul>
                    </div>
                    <div class="tab-pane" id="top">
                        <h5 class="tab-header"><i class="fa fa-star fa-2x"></i> Самые активные</h5>
                        <ul class="news-list news-list-no-hover">
                            <#list activeUsers?keys as key>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <#list users as u>
                                        <div class="name">
                                            <a href="#">
                                                <#if u.getEmail() == key> ${u.getFirstName()} ${u.getLastName()}</#if>
                                            </a>
                                        </div>
                                    </#list>
                                </div>
                            </li>
                            </#list>
                        </ul>
                    </div>
                    <div class="tab-pane" id="dropdown1">
                        <h5 class="tab-header"><i class="fa fa-comments fa-2x"></i> Top Commenters</h5>
                        <ul class="news-list">
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <div class="name"><a href="#">Edin Garey</a></div>
                                    <div class="comment">
                                        Nemo enim ipsam voluptatem quia voluptas sit aspernatur
                                        aut odit aut fugit,sed quia
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <div class="name"><a href="#">Firel Lund</a></div>
                                    <div class="comment">
                                        Duis aute irure dolor in reprehenderit in voluptate velit
                                        esse cillum dolore eu fugiat.
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <div class="name"><a href="#">Jessica Desingter</a></div>
                                    <div class="comment">
                                        Excepteur sint occaecat cupidatat non proident, sunt in
                                        culpa qui officia deserunt.
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <div class="name"><a href="#">Novel Forel</a></div>
                                    <div class="comment">
                                        Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusantium doloremque.
                                    </div>
                                </div>
                            </li>
                            <li>
                                <i class="fa fa-user fa-4x pull-left"></i>
                                <div class="news-item-info">
                                    <div class="name"><a href="#">Wedol Reier</a></div>
                                    <div class="comment">
                                        Laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis
                                        et quasi.
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- /#wrapper -->

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
                { field: "Source", width: "170px", title: "Source" },
                { field: "Amount", title: "Amount" },
                { field: "Percent", title: "Percent", format: "{0} %" },
                { field: "Target", title: "Target" },
            ]
        });
    });
</script>
</body>
</html>