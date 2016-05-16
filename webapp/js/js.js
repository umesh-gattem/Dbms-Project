var x=3;
var y=4;
var z=x+y;
document.getElementById("demo").innerHTML= z;

var teamHtml;
teamHtml+="<tr><th>TEAMS</th><th>MATCHES</th><th>WON</th>	<th>LOST</th><th>TIED</th><th>N/R</th><th>POINTS</th></tr>"

var teams[]={"India","ausr","newzelnd","bangldsh","India","ausr","newzelnd","bangldsh"}
for(var i=0;i<5;i++){
	teamHtml+="<tr>";
	teamHtml+="<td>"+teams[i]+"</td>";
	teamHtml+="<td>"+matches[i]+"</td>";
	teamHtml+="<td>"+win[i]+"</td>";
	teamHtml+="<td>"++"</td>";
	teamHtml+="<td>"++"</td>";
	teamHtml+="<td>"++"</td>";
	teamHtml+="</tr>";
}
$("#teams").html(teamHtml);