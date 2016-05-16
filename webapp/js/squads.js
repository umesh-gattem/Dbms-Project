$(document).ready(function() {
	$(".team a").click(function() {
		console.log(this.id)
		window.location.href = "http://localhost:8586/html/select.htm"+"?id="+this.id;
	});
});