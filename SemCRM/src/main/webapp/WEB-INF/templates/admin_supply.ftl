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
            <a class="navbar-brand" href="/admin/home">На главную</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="/admin/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <!--li><a href="/profile"><i class="fa fa-tasks"></i> Профиль</a></li-->
                <li class="selected"><a href="/admin/supply"><i class="fa fa-globe"></i> Поставки</a></li>
                <li><a href="timeline.html"><i class="fa fa-font"></i> Хронология</a></li>
                <!--li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
                <li><a href="typography.html"><i class="fa fa-font"></i> Typography</a></li>
                <li><a href="bootstrap-elements.html"><i class="fa fa-list-ul"></i> Bootstrap Elements</a></li>
                <li><a href="bootstrap-grid.html"><i class="fa fa-table"></i Bootstrap Grid</a></li-->
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
            <#if user??>
                <li class="dropdown user-dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i
                            class="fa fa-user"></i>${admin}<b class="caret"></b>
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
            <div class="col-lg-12">
                <h1 id="nav-tabs">Поставки</h1>
                <div>
                    <ul class="nav nav-tabs" style="margin-bottom: 15px">
                        <li class="active">
                            <a href="#processing" data-toggle="tab" aria-expanded="true">В обработке</a>
                        </li>
                        <li>
                            <a href="#success" data-toggle="tab" aria-expanded="false">Завершенные</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade active in" id="processing">
                        <#if requestedSupplies??>
                            <#list requestedSupplies as reqSup>
                            <#if reqSup.getStatus() == "processing">
                                <div>
                                    <h2>${reqSup.getName()}</h2>
                                    <p>${reqSup.getDescription()}</p>
                                    <div class="text-left">
                                        <p><i class="fa fa-calendar"></i> ${reqSup.getDate()}</p>
                                    </div>
                                    <div class="well well-sm col-lg-3">
                                        <#list users as u>
                                            <#if reqSup.getRequesterId() == u.getId()>
                                                <p>${u.getFirstName() + " " + u.getLastName()}</p>
                                            </#if>
                                        </#list>
                                    </div>
                                </div><br><br><br>
                                <hr/>
                            </#if>
                            </#list>
                        <#else >
                            <div>
                                <h2>
                                    Ни одного запроса на поставки еще не поступило.
                                </h2>
                            </div>
                        </#if>
                        </div>


                        <div class="tab-pane fade" id="success">
                        <#if sentSupplies??>
                            <#list sentSupplies as s>
                            <div>
                                <h2>${s.getName()}</h2>
                                <div class="text-left">
                                    <p><i class="fa fa-calendar"></i> ${s.getDate()}</p>
                                </div>
                                <div class="well well-sm col-lg-3">
                                    <#list users as u>
                                        <#if s.getRecieverId() == u.getId()>
                                            <p>${u.getFirstName() + " " + u.getLastName()}</p>
                                        </#if>
                                    </#list>
                                </div>
                                <br><br><br>
                            </#list>
                        <#else >
                            <div>
                                <h2>
                                    Ни одной поставки еще не было отправлено.
                                </h2>
                            </div>
                        </#if>
                        </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

</body>
</html>