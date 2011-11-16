<%@ page import="drools.grailsgorm.Casa" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'casa.label', default: 'Casa')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a>
    </span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label"
                                                                               args="[entityName]"/></g:link></span>
</div>

<div class="body">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
        <table>
            <thead>
            <tr>

                <g:sortableColumn property="id" title="${message(code: 'casa.id.label', default: 'Id')}"/>

                <g:sortableColumn property="dono" title="${message(code: 'casa.dono.label', default: 'Dono')}"/>
            </tr>
            </thead>
            <tbody>
            <g:each in="${casaInstanceList}" status="i" var="casaInstance">
                <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                    <td><g:link action="show"
                                id="${casaInstance.id}">${fieldValue(bean: casaInstance, field: "id")}</g:link></td>

                    <td>${fieldValue(bean: casaInstance, field: "dono")}</td>

                </tr>
            </g:each>
            </tbody>
        </table>
    </div>

    <div class="paginateButtons">
        <g:paginate total="${casaInstanceTotal}"/>
    </div>
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
