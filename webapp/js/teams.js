var teamHtml;
teamHtml += "<tr><th>TEAMS</th><th>MATCHES</th><th>WON</th> <th>LOST</th><th>TIED</th><th>N/R</th><th>POINTS</th></tr>"
$(document).ready(
		function() {
			console.log("ready!");
			var teams = [ "India", "Australia", "New Zealand", "Bangladesh",
					"South Africa", "England", "West Indies", "Afganistan",
					"Scotland", "Ireland", "Zimbabwe", "Sri Lanka", "Pakistan",
					"United Arab Emirates" ];
			var matches = [ "6", "6", "6", "6", "6", "6", "6", "6", "6", "6",
					"6", "6", "6", "6" ];
			var win = [ "6", "4", "6", "3", "4", "2", "3", "1", "0", "3", "1",
					"4", "4", "0" ];
			var lost = [ "0", "1", "0", "2", "2", "4", "3", "5", "6", "3", "5",
					"2", "2", "6" ];
			var tied = [ "0", "1", "0", "1", "0", "0", "0", "0", "0", "0", "0",
					"0", "0", "0" ];
			var netrun = [ "+1.827", "+2.257", "2", "2", "2", "2", "2", "2",
					"2", "2", "2", "2", "2", "2" ];
			var points = [ "12", "8", "12", "6", "8", "4", "6", "2", "0", "6",
					"2", "8", "8", "0" ];
			for (var i = 0; i < 14; i++) {
				teamHtml += "<tr>";
				teamHtml += "<td>" + teams[i] + "</td>";
				teamHtml += "<td>" + matches[i] + "</td>";
				teamHtml += "<td>" + win[i] + "</td>";
				teamHtml += "<td>" + lost[i] + "</td>";
				teamHtml += "<td>" + tied[i] + "</td>";
				teamHtml += "<td>" + netrun[i] + "</td>";
				teamHtml += "<td>" + points[i] + "</td>";
				teamHtml += "</tr>";
			}
			$("#teams").html(teamHtml);
		});
