$(document).ready(function() {
	$("#header1 a").click(function() {
		var url = window.location.href;
		console.log(url);
		var id = getUrlParameter('id');
		console.log(id);
		if(this.id == 'bat')
			window.location.href = "http://localhost:8586/html/avg.htm"+"?id="+id;
		else
			window.location.href = "http://localhost:8586/html/bowling_avg.htm"+"?id="+id;
	});
});

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}    