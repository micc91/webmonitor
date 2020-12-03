function highlight(e) {
//  if (selected[0]) selected[0].className = '';
  if(e.target.parentNode.className === '') {
    e.target.parentNode.className = 'selected-row';
  } else {
    e.target.parentNode.className = '';
  }
}

var table    = document.getElementById('jobRunsTableBody');
var selected = table.getElementsByClassName('selected-row');
table.onclick = highlight;

function actionOnJob(action) {
  var selectedRows = this.table.getElementsByClassName("selected-row" );
  var paramList;
  var newParamList;
  var status;

  if(selectedRows.length > 1) {
    paramList='idlist='
    for (var ii = 0; ii < selectedRows.length; ii++) {
      if(paramList !== 'idlist=') { paramList = paramList+','; }
      paramList = paramList + selectedRows[ii].getElementsByTagName("TD")[0].innerText;
    }
    newParamList=paramList;
    status=selectedRows[0].getElementsByTagName("TD")[2].getElementsByTagName("a")[0].getAttribute("href").replace(/^.*status=/,'').replace(/&step=.*$/,'');
  }
  else {
    paramList = selectedRows[0].getElementsByTagName("TD")[2].getElementsByTagName("a")[0].getAttribute("href");

//  var newParamList = encodeURI(paramList.replace(/^.*info\?/, ""));
    newParamList = paramList.replace(/^.*info\?/, "");
    status = paramList.replace(/^.*status=/,'').replace(/&step=.*$/,'');
  }
    console.log("oldParamList = " + paramList);
    console.log("newParamList = " + newParamList);
    //Possible actions:
    // rerun: completed, aborted, refused
    // update: launch_wait, event_wait, time_overrun, disabled
    // delete: any status
    // stop/cancel: running
    // hold: event_wait, launch_wait
    // release: disabled
    // force completion: aborted, time_overrun, disabled, launch_wait
    // bypass: event_wait, launch_wait
    // skip exec: event_wait, launch_wait
    if(action === 'rerun') {
        if(status === 'COMPLETED' || status === 'ABORTED' || status === 'REFUSED') {
          var newUrl = window.location.origin + window.location.pathname.replace("dashboard", action);
          $('<a href="' + newUrl + '?' + newParamList + "&" + "action=" + action + '"/>')[0].click();
        }
    } else if(action === 'update') {
      if(status === 'LAUNCH_WAIT' || status === 'EVENT_WAIT' || status === 'TIME_OVERRUN' || status === 'DISABLED') {
        var newUrl = window.location.origin + window.location.pathname.replace("dashboard", action);
        $('<a href="' + newUrl + '?' + newParamList + "&" + "action=" + action + '"/>')[0].click();
      }
    } else if(action === 'delete') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
    } else if(action === 'stop') {
      if(status === 'RUNNING') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    } else if(action === 'hold') {
      if(status === 'LAUNCH_WAIT' || status === 'EVENT_WAIT') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    } else if(action === 'release') {
      if(status === 'DISABLED') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    } else if(action === 'force') {
      if(status === 'ABORTED' || status === 'TIME_OVERRUN' || status === 'DISABLED' || status === 'LAUNCH_WAIT') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    } else if(action === 'bypass') {
      if(status === 'LAUNCH_WAIT' || status === 'EVENT_WAIT') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    } else if(action === 'skip') {
      if(status === 'LAUNCH_WAIT' || status === 'EVENT_WAIT') {
        window.location.search = "?" + newParamList + "&" + "action=" + action;
      }
    }

}

