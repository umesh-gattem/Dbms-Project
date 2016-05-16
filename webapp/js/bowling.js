$(document)
		.ready(
				function() {
					var url = window.location.href;
					var id = getUrlParameter('id');
					sendRequest("http://localhost:8586/bowling?id=" + id,
							displayStats);

					$("#bowlSearch").click(
							function() {

								var player = $('#bowler').val();
								sendRequest("http://localhost:8586/bowling?id="
										+ id + "&playerName=" + player,
										displayStats);
							});
				});
function displayStats(res) {
	console.log(res);
	var bowlavgHtml;
	bowlavgHtml += "<tr><th>PLAYER</th><th>MATCHES</th><th>INNGS</th> <th>OVERS</th><th>MAIDENS</th><th>RUNS</th><th>WICKETS</th><th>BBI</th><th>AVG</th><th>ECONOMY</th><th>SR</th><th>FOURS</th><th>FIVES</th><th>CATCHES</th><th>STUMPS</th></tr>";
	for (var i = 0; i < res.length; i++) {
//		private String player;
//		private int teamid;
//		private int matches;
//		private int inns;
//		private int overs;
//		private int maidens;
//		private int runs;
//		private int wickets;
//		private String BBI;
//		private float average;
//		private float economy;
//		private float SR;
//		private int four;
//		private int six;
//		private int catches;
//		private int stumps;
		bowlavgHtml += "<tr>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "<td>" + res[i]["player"] + "</td>";
		bowlavgHtml += "</tr>";
	}
	$("#bavg").html(bowlavgHtml);
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