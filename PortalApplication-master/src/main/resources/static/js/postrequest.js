$( document ).ready(function() {
	
	var url = window.location;
	
	// SUBMIT FORM
    $("#upload-file-form").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		name : $("#name").val(),

			price :  $("#price").val(),

			description :  $("#description").val(),

			selectedcategory :  $("#selectedcategory").val(),

			imageUrl :  $("#imageUrl").val()


    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : url + "/postcustomer",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result) {
				if(result.status == "Done"){
					alert('product is saved ');
					$("#postResultDiv").html("<strong>" + "Post Successfully! Customer's Info: FirstName = " 
							+ result.data.name + " ,LastName = " + result.data.price +result.data.description+result.data.selectedcategory +result.data.imageUrl +"</strong>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!"+e);
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#name").val("");
    	$("#price").val("");
		$("#description").val("");
		$("#imageUrl").val("");
    }
})