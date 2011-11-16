<%@ page import="drools.grailsgorm.DroolsLog" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'casa.label', default: 'Casa')}"/>
    <title>Drools Log</title>
</head>

<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
    </span>
    <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label"
                                                                           args="[entityName]"/></g:link></span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label"
                                                                               args="[entityName]"/></g:link></span>
</div>

<div class="body">
    <h1>Resultado da mudança de temperatura para ${temperatura} graus</h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
        <ul>
            <g:each in="${DroolsLog.all}" status="i" var="log">
                <li class="${(i % 2) == 0 ? 'odd' : 'even'}">
                    ${log.descricao}
                </li>
            </g:each>
        </ul>
    </div>
    <br><br>
    <div class="ar">
        <h2>Mudar temperatura</h2>
        <g:form action="temperatura">
            <input type="text" name="temperatura">
            <input type="submit" value="Alterar">
        </g:form>
    </div>
</div>
</body>
</html>
