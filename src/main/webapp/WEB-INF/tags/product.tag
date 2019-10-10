<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ attribute name="productNumber" required="true" %>

<div class="row">
   	<div class="product">
       	Product ${productNumber+1}
    </div>
   	<div class="col-25">
      <label for="fname">Quantity</label>
    </div>
    <div class="col-75">
    	<form:input path="products[${productNumber}].quantity" name="products[${productNumber}].quantity" value="" placeholder="2"/>
	</div>
    <div class="col-25">
		<label for="fname">Description</label>
    </div>
    <div class="col-75">
	    <form:input path="products[${productNumber}].description" name="products[${productNumber}].description" value="" placeholder="Chocolate bar" />
    </div>
    <div class="col-25">
	    <label for="fname">Price</label>
	</div>
	<div class="col-75">
		<form:input path="products[${productNumber}].price" name="products[${productNumber}].price" value="" placeholder="2.49" />
	</div>
	<div class="col-25">
		<label for="fname">Product Types</label>
	</div>
	<div class="col-75">
		<form:select path="products[${productNumber}].productType" name="products[${productNumber}].productType" value="" placeholder="OTHER" >
			<form:options items="${productTypes}" />
		</form:select>
	</div>
	<div class="col-25">
		<label for="fname">Imported</label>
	</div>
	<div class="col-75">
		<form:checkbox path="products[${productNumber}].imported" name="products[${productNumber}].imported" value="" /> <span>Check if product is imported</span>
	</div>
</div>