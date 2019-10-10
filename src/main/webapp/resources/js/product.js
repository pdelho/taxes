$( document ).ready(function() {

	$( "#addProduct" ).click(function() 
	{
		// Increase the counter and set it
		var productNumber = $("#productCount");
		productNumber.val(+productNumber.val() +1);
		// And add it before the end (0 index based)
		$(newProductContent(productNumber.val()-1)).insertBefore("#productsEnd");
	});
	
	$( "#removeProduct" ).click(function() 
	{
		// Check if there is more than one
		if ($(this).parent().prevAll(".row").length >=2)
		{
			var productNumber = $("#productCount");
			productNumber.val(+productNumber.val() -1);
			$(this).parent().prevAll(".row")[0].remove();
			$("#productsEnd").prev("hr").remove()
		}
		else
		{
			alert("You need at least one product");
		}



	});
	
	function newProductContent (productNumber)
	{
		// Harcoding the tag (consider AJAX, warning if new type of product!!!)
		return "\n	<hr>" +
				"\n	<div class=\"row\">" +
				"\t		<div class=\"product\">" +
				"\n\t		Product " + productNumber +
				"\n    	</div>" +
				"\n\t	<div class=\"col-25\">" +
				"\n     	<label for=\"fname\">Quantity</label>" +
				"\n    	</div>" +
				"\n    	<div class=\"col-75\">" +
				"\n\t		<input id=\"products" + productNumber + ".quantity\" name=\"products[" + productNumber + "].quantity\" placeholder=\"2\" type=\"text\" value=\"\">" +
				"\n	\t	</div>" +
				"\n    	<div class=\"col-25\">" +
				"\n\t\t		<label for=\"fname\">Description</label>" +
				"\n    	</div>" +
				"\n    	<div class=\"col-75\">" +
				"\n\t		<input id=\"products" + productNumber + ".description\" name=\"products[" + productNumber + "].description\" placeholder=\"Chocolate bar\" type=\"text\" value=\"\">" +
				"\n    	</div>" +
				"\n    	<div class=\"col-25\">" +
				"\n\t   	<label for=\"fname\">Price</label>" +
				"\n\t	</div>" +
				"\n\t	<div class=\"col-75\">" +
				"\n\t\t		<input id=\"products" + productNumber + ".price\" name=\"products[" + productNumber + "].price\" placeholder=\"2.49\" type=\"text\" value=\"\">" +
				"\n\t	</div>" +
				"\n\t	<div class=\"col-25\">" +
				"\n\t\t		<label for=\"fname\">Product Types</label>" +
				"\n\t	</div>" +
				"\n\t	<div class=\"col-75\">" +
				"\n\t\t		<select id=\"products" + productNumber + ".productType\" name=\"products[" + productNumber + "].productType\" placeholder=\"OTHER\">" +
				"\n\t\t\t		<option value=\"OTHER\">OTHER</option><option value=\"BOOK\">BOOK</option><option value=\"FOOD\">FOOD</option><option value=\"MEDICAL\">MEDICAL</option>" +
				"\n\t\t		</select>" +
				"\n\t	</div>" +
				"\n\t	<div class=\"col-25\">" +
				"\n\t\t		<label for=\"fname\">Imported</label>" +
				"\n\t	</div>" +
				"\n\t	<div class=\"col-75\">" +
				"\n\t\t		<input id=\"products" + productNumber + ".imported" + productNumber + "\" name=\"products[" + productNumber + "].imported\" type=\"checkbox\" value=\"true\"><input type=\"hidden\" name=\"_products[" + productNumber + "].imported\" value=\"on\"> <span>Check if product is imported</span>" +
				"\n\t	</div>" +
				"\n		</div>"
	}

});