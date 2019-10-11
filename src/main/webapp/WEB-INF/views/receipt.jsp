<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	
	<title>Taxes Result</title>
	<!-- META JS and CSS -->
	<tags:metajscss/>
</head>

<body>
<h1>Result</h1>
<div class="container">
	Receipt with its products, sales taxes and total price
	<br>
	For each product, the price represent the total amount including taxes (this is, quantity times price with taxes)
</div>

<br>

<div class="container">
	<spring:url value="/receipt" var="receiptUrl" />
	<form:form method="get" action="${receiptUrl}" modelAttribute="productForm">
	
		<c:forEach items="${receipt.products}" var="product" varStatus="productCount">
		<div class="row">
			<c:if test="${not (productCount.index eq 0)}"><hr></c:if>
			<tags:product productNumber="${productCount.index}" isReceipt="true"></tags:product>
		</div>
		</c:forEach>
		<hr>
		<div class="row">
			<div class="col-25">
				<label>Sales Taxes</label>
		    </div>
		    <div class="col-75 total">
				${receipt.taxes}
		    </div>
		</div>
		<div class="row">
			<div class="col-25">
				<label>Total</label>
		    </div>
		    <div class="col-75 total">
				${receipt.totalPrice}
		    </div>
		</div>
		<hr>
		<div class="row">
			<div class="col-50">
				<input type="submit" value="Restart products"/>
			</div>
			<div class="col-50">
				<input type="button" class="edit" value="Edit products"  onclick="window.history.back()"> 
			</div>
		</div>
	</form:form>

</div>


</body>
</html>
