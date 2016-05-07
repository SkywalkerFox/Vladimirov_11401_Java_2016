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
            <a class="navbar-brand" href="/home">На главную</a>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav side-nav">
                <li><a href="/home"><i class="fa fa-bullseye"></i> Главная</a></li>
                <li><a href="/profile"><i class="fa fa-tasks"></i> Профиль</a></li>
                <li class="selected"><a href="/supply"><i class="fa fa-globe"></i> Поставки</a></li>
                <!--li><a href="/signin"><i class="fa fa-list-ol"></i> Вход</a></li>
                <li><a href="/registration"><i class="fa fa-font"></i> Register</a></li>
                <li><a href="timeline.html"><i class="fa fa-font"></i> Timeline</a></li>
                <li><a href="forms.html"><i class="fa fa-list-ol"></i> Forms</a></li>
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
                            class="fa fa-user"></i>${user.getFirstName()}<b
                            class="caret"></b>
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
                            <a href="#requested" data-toggle="tab" aria-expanded="true">Запрошенные</a>
                        </li>
                        <li>
                            <a href="#sent" data-toggle="tab" aria-expanded="false">Отправленные</a>
                        </li>
                        <li>
                            <a href="#processing" data-toggle="tab" aria-expanded="false">В обработке</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade active in" id="requested">
                        <#if requestedSupplies??>
                            <#list requestedSupplies as reqSup>
                                <div>
                                    <h2>${reqSup.getName()}</h2>
                                    <#if reqSup.getStatus() == "processing">
                                        <span class="label label-primary">В обработке</span>
                                    <#else>
                                        <span class="label label-success">Завершена</span>
                                    </#if>
                                    <p>${reqSup.getDescription()}</p>
                                    <div class="text-left">
                                        <p><i class="fa fa-calendar"></i> ${reqSup.getDate()}</p>
                                    </div>

                                </div><br><br><br>
                                <hr/>
                            </#list>
                        <#else >
                            <div>
                                <h2>
                                    Вы еще не запросили ни об одной поставке.<a href="/supply/request">Сделайте это
                                    прямо сейчас!</a>
                                </h2>
                            </div>
                        </#if>
                        </div>


                        <div class="tab-pane fade" id="sent">
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
                                </div><br><br><br>
                                <hr/>
                            </#list>
                        <#else >
                            <div>
                                <h2>
                                    Вы еще не отправили ни одной поставки.<a href="/supply/send">Сделайте это прямо
                                    сейчас!</a>
                                </h2>
                            </div>
                        </#if>
                        </div>
                        </div>


                        <div class="tab-pane fade" id="processing">
                        <#if requestedSuppliesAll??>
                            <#list requestedSuppliesAll as reqSupAll>
                                <#if reqSupAll.getStatus() == "processing">
                                <div>
                                    <h2>${reqSupAll.getName()}</h2>
                                    <span class="label label-primary">В обработке</span>
                                    <p>${reqSupAll.getDescription()}</p>
                                    <div class="text-left">
                                        <p><i class="fa fa-calendar"></i> ${reqSupAll.getDate()}</p>
                                    </div>
                                    <div class="well well-sm col-lg-3">
                                        <#list users as u>
                                            <#if reqSupAll.getRequesterId() == u.getId()>
                                        ${u.getFirstName() + " " + u.getLastName()}
                                        </#if>
                                        </#list>
                                    </div>
                                    <#if user.getId() != reqSupAll.getRequesterId()>
                                        <div class="text-left col-lg-3">
                                            <a href="/supply/send?sname=${reqSupAll.getName()}&size=${reqSupAll.getSize()}&reciever=${reqSupAll.getRequesterId()}&date=${reqSupAll.getDate()}">
                                                <i class="fa fa-plus"></i> Отправить
                                            </a>
                                        </div>
                                    </#if>
                                    <br><br><br>
                                    <hr/>
                                </#if>
                            </#list>
                        <#else >
                            <div>
                                <h2>
                                    Нет ни одной поставки в обработке в данный момент.
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
