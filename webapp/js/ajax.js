function sendRequest(url1,calback) {
	console.log("sending request..");
	$.ajax({
		url : url1,
		success : function(result) {
			calback(result);
		},error: function(err){
			console.log("error is "+JSON.stringify(err.responseText));
		}
	});
}
