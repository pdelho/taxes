<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	
	<title>Taxes Calculator</title>
	<!-- META JS and CSS -->
	<tags:metajscss/>
</head>

<body>

<h1>Products input</h1>
<div class="container">
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.
<br>
When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.
<br>
Input the price per unit

</div>

<br>

<div class="container">
 	<spring:url value="/receipt" var="receipt" />
        <form:form method="post" action="${receipt}" modelAttribute="productForm">
			<input id="productTypes" type="hidden" value="${productTypes}">
			<c:choose>
				
				<c:when test="${productForm.products eq null}">
					<!-- First product -->
					<input id="productCount" type="hidden" value="1">
					<!-- Product row -->
					<div class="row">
						<tags:product productNumber="0" isReceipt="false"/>
					</div>
				</c:when>
				<c:otherwise>
					<input id="productCount" type="hidden" value="${fn:length(productForm.products)+1}">
					<c:forEach items="${productForm.products}" var="product" varStatus="productCount">
						<div class="row">
							<c:if test="${not (productCount.index eq 0)}"><hr></c:if>
							<tags:product productNumber="${productCount.index}" isReceipt="false"></tags:product>
						</div>
					</c:forEach>
				</c:otherwise>
			
			</c:choose>
			
			
			<div id ="productsEnd"></div>
			
			<hr>
			<div class="col-50">
				<input type="button" class="add" id="addProduct" value="Add One Product">
			</div>
			<div class="col-50">
				<input type="button" class="remove" id="removeProduct" value="Remove Last Product">
			</div>
			
			<c:set var="productCount" value="${productCount+1}"/>
			<%-- <!-- Product row -->
			<tags:product productNumber="${productCount}"/> --%>
			<br>
			<br>
			<br>
			<hr>
			<input type="submit" value="Submit"/>
        </form:form>
</div>


</body>

</html>
