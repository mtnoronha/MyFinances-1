<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!-- URL's -->
<c:url value="/resources/jquery/JQuery.js" var="jquery"/>
<c:url value="/resources/bootstrap/js/bootstrap.js" var="bootstrap_js"/>
<c:url value="/resources/bootstrap/css/bootstrap-cosmo.css" var="bootstrap_css" />
<c:url value="/resources/img/logo.png" var="logo"/>
<c:url value="/resources/img/favicon.png" var="favicon"/>
<c:url value="/resources/img/background.jpg" var="background"/>
<c:url value="/" var="home"/>

<!-- STRINGS -->
<fmt:message key="view.propriedade.sistema.nome" var="nomeSistema"/>
<fmt:message key="view.propriedade.sistema.status" var="statusSistema"/>
<fmt:message key="view.propriedade.sistema.descricao" var="descricaoSistema"/>
<fmt:message key="view.propriedade.sistema.chaves" var="palavrasChave"/>
<fmt:message key="view.header.formbusca.botao" var="tituloBotaoBusca"/>
<fmt:message key="view.header.formbusca.legenda" var="legendaCampoBusca"/>

<html>

<head>
	<!-- ICONE -->
	<title>
	<c:choose>
		<c:when test="${param.title != null}">${param.title}</c:when>
		<c:otherwise>${nomeSistema} - ${statusSistema}</c:otherwise>
	</c:choose>
	</title>
	
	<!-- FAVICON -->
	<link type="image/png" rel="icon" href="${favicon}">
	
	<!-- CSS -->
	<link type="text/css" rel="stylesheet" href="${bootstrap_css}"/>
	
	<!-- METAS -->
	<c:choose>
		<c:when test="${param.metaDescricao != null}">
			<meta name="description" content="${param.metaDescricao}"/>
		</c:when>
		<c:otherwise>
			<meta name="description" content="${descricaoSistema}"/>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${param.metaKeywords!= null}">
			<meta name="description" content="${param.metaKeywords}"/>
		</c:when>
		<c:otherwise>
			<meta name="keywords" content="${palavrasChave}"/>
		</c:otherwise>
	</c:choose>
	<meta name="expires" content="never"/>
</head>

<!-- IMPORT JQUERY+BOOTSTRAP -->
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrap_js}"></script>

<body background="${background}">
	
    <!-- BARRA DE NAVEGAÇÃO -->
    <div class="navbar navbar-fixed-top">
	    <div class="navbar-inner">
		    <div class="container pull-left">
		    	<a class="brand" href="${home}"><b>${nomeSistema}</b></a>
		    </div>
		    <form id="formPesquisa" class="navbar-search pull-right">
		    	<div class="input-prepend">
					<span class="add-on"><i class="icon-search"></i></span>
					<input style="margin-right: 10px;" id="txtBusca" class="span3" type="text" placeholder="${legendaCampoBusca}">
				</div>
		    </form>
	    </div>
    </div>
    
    <br>

    <!-- HEADER -->
    <div style="background-color: #4682B4;height: 80px;" class="page-header">
    
    	<center>${nomeSistema} - ${descricaoSistema}</center>
	    
	</div>
	
	<br><br>  