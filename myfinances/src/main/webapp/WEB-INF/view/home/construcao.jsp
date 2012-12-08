<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>

<!-- URL's -->
<c:url value="/resources/img/favicon.png" var="logo"/>

<!-- STRINGS -->
<fmt:message key="view.construcao.banner.titulo" var="tituloBanner"/>
<fmt:message key="view.construcao.banner.descricao" var="descricaoBanner"/>
<fmt:message key="view.construcao.banner.botao.titulo" var="tituloBotaoDetalhes"/>
<fmt:message key="view.construcao.popup.titulo" var="tituloPopup"/>
<fmt:message key="view.construcao.popup.lista.titulo" var="tituloListaPopup"/>
<fmt:message key="view.construcao.popup.lista.itemA" var="itemAListaPopup"/>
<fmt:message key="view.construcao.popup.lista.itemB" var="itemBListaPopup"/>
<fmt:message key="view.construcao.popup.lista.itemC" var="itemCListaPopup"/>
<fmt:message key="view.construcao.popup.lista.itemD" var="itemDListaPopup"/>
<fmt:message key="view.construcao.popup.lista.itemE" var="itemEListaPopup"/>
<fmt:message key="view.construcao.popup.lista.final" var="finalListaPopup"/>


<!-- HEADER -->
<c:import url="/resources/html/header.jsp"/>

<!-- ALERTA -->
<div class="container">
	<br><br><br><br><br><br>
    <div class="hero-unit">
	    <h1>${tituloBanner}</h1>
	    <p>${descricaoBanner}</p>
	    <p>
	    <a id="btnDetalhes" class="btn btn-primary btn-large">${tituloBotaoDetalhes}</a>
    </div>
</div>

<!-- POPUP -->
<tag:popup id="popup" component="btnDetalhes" imagem="${logo}" titulo="${tituloPopup}" retornar="retornar">
	<jsp:attribute name="texto">
		<p>${tituloListaPopup}</p>
		<ul>
			<li>${itemAListaPopup}</li>
			<li>${itemBListaPopup}</li>
			<li>${itemCListaPopup}</li>
			<li>${itemDListaPopup}</li>
			<li>${itemEListaPopup}</li>
		</ul>
		<p>${finalListaPopup}</p>
	</jsp:attribute>
</tag:popup>

<!-- FOOTER -->
<c:import url="/resources/html/footer.jsp"/>