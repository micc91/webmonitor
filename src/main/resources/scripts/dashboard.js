function highlight(e) {
  if (selected[0]) selected[0].className = '';
  e.target.parentNode.className = 'selected-row';
}

var table    = document.getElementById('jobRunsTableBody');
var selected = table.getElementsByClassName('selected-row');
table.onclick = highlight;

function actionOnJob(action){
  var paramList = this.table.getElementsByClassName("selected-row" )[0].getElementsByTagName("TD")[1].getElementsByTagName("a")[0].getAttribute("href");
  for(var ii = 0; ii < paramList.length; ii++) {
    var newParamList = paramList[ii].replace(/^.*info\?/, "");
    console.log("oldParamList = " + paramList[ii]);
    console.log("newParamList = " + newParamList);
    window.location.search = "?" + newParamList + "&" + "action=" + action;
  }
}

