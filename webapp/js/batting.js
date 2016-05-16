$(document).ready(function() {
	var url = window.location.href;
	var id = getUrlParameter('id');
	sendRequest("http://localhost:8586/batting?id=" + id, displayStats);

	$("#bat_search").click(function() {
 
		var player = $('#batsman').val();
		sendRequest("http://localhost:8586/batting?id=" + id+"&playerName="+player, displayStats);
	});
});
function displayStats(res) {
	console.log(res);
	var batavgHtml = "<tr><th>PLAYER</th><th>MATCHES</th><th>INNGS</th> <th>NOTOUTS</th><th>RUNS</th><th>HIGHSCORE</th><th>AVG</th><th>STRIKERATE</th><th>HUNDREDS</th><th>FIFTIES</th><th>ZEROES</th><th>FOURS</th><th>SIXES</th></tr>";
	for (var i = 0; i < res.length; i++) {
//		private int id;
//		private String player;
//		private int teamid;
//		private int matches;
//		private int inngs;
//		private int no;
//		private int runs;
//		private String highscore;
//		private float avg;
//		private float bf;
//		private float strikerate;
//		private int hundred;
//		private int zero;
//		private int four;
//		private int six;
//		private int fifty;
		batavgHtml += "<tr>";
		batavgHtml += "<td>" + res[i]["player"] + "</td>";
		batavgHtml += "<td>" + res[i]["matches"] + "</td>";
		batavgHtml += "<td>" +res[i]["inngs"] + "</td>";
		batavgHtml += "<td>" +  res[i]["no"] + "</td>";
		batavgHtml += "<td>" +  res[i]["runs"] + "</td>";
		batavgHtml += "<td>" +  res[i]["highscore"] + "</td>";
		batavgHtml += "<td>" +  res[i]["player"] + "</td>";
		batavgHtml += "<td>" +  res[i]["player"] + "</td>";
		batavgHtml += "<td>" + res[i]["player"] + "</td>";
		batavgHtml += "<td>" +  res[i]["player"] + "</td>";
		batavgHtml += "<td>" + res[i]["player"] + "</td>";
		batavgHtml += "<td>" +  res[i]["player"] + "</td>";
		batavgHtml += "<td>" +  res[i]["player"] + "</td>";
		batavgHtml += "</tr>";
	}
	console.log("Html appending..")
	$("#avg").html(batavgHtml);
}

function getUrlParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var sURLVariables = sPageURL.split('&');
	for (var i = 0; i < sURLVariables.length; i++) {
		var sParameterName = sURLVariables[i].split('=');
		if (sParameterName[0] == sParam) {
			return sParameterName[1];
		}
	}
}