function animateLoading(eltId) {
    var elt = document.getElementById(eltId);
    var message = 'Loading...';
    if(eltId === 'btn-new-run') {
        message = 'Creating launch...';
    } else if (eltId === 'btn-signin') {
        message = 'Signing in...';
    } else if(eltId === 'btn-update-prefs') {
        message = 'Saving...';
    } else if(eltId === 'btn-update') {
        message = 'Updating...';
    }
    elt.innerHTML = '<span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span> '+message;
}

function updateDatesInNewRunForm(lwsize) {
    var lwduration = 10 * 60000;

    if(lwsize !== undefined) {
        lwduration = lwsize * 60000;// from minutes to milliseconds
    }

    var now = new Date();
    var beginD = now.getDate().toString().padStart(2,'0')+"/"+(now.getMonth()+1).toString().padStart(2,'0')+"/"+now.getFullYear();
    var beginT = now.getHours().toString().padStart(2,'0')+":"+now.getMinutes().toString().padStart(2,'0')+":"+now.getSeconds().toString().padStart(2,'0');

    var endEpoch = now.getTime() + lwduration;
    var end = new Date();
    end.setTime(endEpoch);
    var endD = end.getDate().toString().padStart(2,'0')+"/"+(end.getMonth()+1).toString().padStart(2,'0')+"/"+end.getFullYear();
    var endT = end.getHours().toString().padStart(2,'0')+":"+end.getMinutes().toString().padStart(2,'0')+":"+end.getSeconds().toString().padStart(2,'0');

    var pDate = beginD;

    var beginDField = document.getElementById('inputStartD');
    var beginTField = document.getElementById('inputStartT');
    var endDField   = document.getElementById('inputEndD');
    var endTField   = document.getElementById('inputEndT');
    var pDateField  = document.getElementById('inputPdate');

    if(beginDField.value === '') { beginDField.value = beginD; }
    if(beginTField.value === '') { beginTField.value = beginT; }
    if(endDField.value   === '') { endDField.value   = endD; }
    if(endTField.value   === '') { endTField.value   = endT; }
    if(pDateField.value  === '') { pDateField.value  = pDate; }
}

function updateNewRunForm(id) {
    var newdata = document.getElementById(id).value.toString();
    var fields = newdata.split("|");
    var value = fields[0];
    var inputTsk = document.getElementById('inputTask');
    var inputSes = document.getElementById('inputSession');
    var inputUpr = document.getElementById('inputUproc');
    var inputMu = document.getElementById('inputMu');
    var inputQueue = document.getElementById('inputQueue');
    var inputUser = document.getElementById('inputUser');
    if(id === 'inputTask') {
        if(value !== 'none') {
            var session = fields[1];
            var uproc = fields[2];
            var mu = fields[3];
            var queue = fields[4];
            var user = fields[5];
            if(session === "") { session = 'none'; }
            for(var ii = 0; ii<inputSes.options.length; ii++) {
                var sesfields = inputSes.options[ii].value.split("|");
                var sesname = sesfields[0];
                if(sesname === session) {
                    inputSes.selectedIndex = ii;
                }
            }
            for(var ii = 0; ii<inputUpr.options.length; ii++) {
                if(inputUpr.options[ii].value === uproc) {
                    inputUpr.selectedIndex = ii;
                }
            }
            for(var ii = 0; ii<inputMu.options.length; ii++) {
                if(inputMu.options[ii].value === mu) {
                    inputMu.selectedIndex = ii;
                }
            }
            inputQueue.value = queue;
            inputUser.value = user;
        }
    } else {
        if(id === 'inputSession') {
            inputTsk.selectedIndex = 0;
            if(value !== 'none') {
                var uproc = fields[1];
                for(var ii = 0; ii<inputUpr.options.length; ii++) {
                    if(inputUpr.options[ii].value === uproc) {
                        inputUpr.selectedIndex = ii;
                    }
                }
            }
        } else {
            if(id === 'inputUproc') {
                inputTsk.selectedIndex = 0;
                inputSes.selectedIndex = 0;
            } else {
                if(id === 'inputMu') {
                    inputTsk.selectedIndex = 0;
                }
            }
        }
    }
}

function refreshJobRunsManually() {
    animateLoading('btn-dhb-refresh-manual');
    var refreshInterval = document.getElementById('select-refresh').value;
    var offset = document.getElementById('select-offset').value;
    var btnChartPie = document.getElementById('btn-chart-pie');
    var btnChartBar = document.getElementById('btn-chart-bar');
    var displayChart = 'none';
    if(btnChartBar.className === 'btn btn-sm btn-secondary') {
        displayChart = 'bar';
    } else if(btnChartPie.className === 'btn btn-sm btn-secondary') {
        displayChart = 'pie';
    }
    if(refreshInterval !== 'none') {
        window.setTimeout(refreshJobRuns, refreshInterval);
    }
    window.location.search = '?refresh=true&offset='+offset+'&chart='+displayChart+'&timer='+refreshInterval;
}

function refreshJobRuns() {
    animateLoading('btn-dhb-refresh-manual');
    var refreshInterval = document.getElementById('select-refresh').value;
    var offset = document.getElementById('select-offset').value;
    var btnChartPie = document.getElementById('btn-chart-pie');
    var btnChartBar = document.getElementById('btn-chart-bar');
    var displayChart = 'none';
    if(btnChartBar.className === 'btn btn-sm btn-secondary') {
        displayChart = 'bar';
    } else if(btnChartPie.className === 'btn btn-sm btn-secondary') {
        displayChart = 'pie';
    }
    if(refreshInterval !== 'none') {
        window.setTimeout(refreshJobRuns, refreshInterval);
        window.location.search = '?refresh=true&offset='+offset+'&chart='+displayChart+'&timer='+refreshInterval;
    }
}

function setAutoRefreshJobRuns() {
    var refreshInterval = document.getElementById('select-refresh').value;
    if(refreshInterval !== 'none') {
        window.setTimeout(refreshJobRuns, refreshInterval);
    } else {
        window.clearTimeout();
    }
}

function searchInPage(styleToApply) {
    var table, rows;
    var cell;
    var eltList;
    var found = 0;
    var ii;
    var result;
    tosearch = document.getElementById('searchtext');

    table = document.getElementById('jobrunsTable');
    if(table !== null) {
        rows = table.rows;

        for (ii = 1; ii < rows.length; ii++) {
            for (ij = 1; ij < 7; ij++) {
                //cell = rows[ii].getElementsByTagName("TD")[ij];
                cell = rows[ii];
                result = cell.innerText.search(tosearch.value);
                if (result >= 0) {
                    rows[ii].setAttribute("class", styleToApply);
                    found++;
                }
            }
        }
    } else {
        // we are in another page than dashboard: info (select not possible, only highlight search results, means fileterd style)
        eltList = document.getElementsByClassName('themed-grid-col');
        for(ii = 0; ii < eltList.length; ii++) {
            cell = eltList[ii];
            if(cell.innerText.search(tosearch.value) >= 0) {
                var currentStyle = cell.getAttribute("class");
                cell.setAttribute("class", currentStyle+" filtered");
                found++;
            }
        }
        var idList = ["htrace-", "joblog-", "reslog-"];
        var elt;
        var eltexist;
        for(ij = 0; ij < idList.length; ij++) {
            eltexist = true;
            ii = 0;
            while (eltexist) {
                elt = document.getElementById(idList[ij] + ii);
                if (elt === null) {
                    eltexist = false;
                } else {
                    cell = elt;
                    if (cell.innerText.search(tosearch.value) >= 0) {
                        var currentStyle = cell.getAttribute("class");
                        cell.setAttribute("class", currentStyle + " filtered2");
                        found++;
                    }
                }
                ii++;
            }
        }
    }
    console.log("search "+tosearch.value+" result="+found+" rows found out of "+ii)
}

function clearSearchInPage() {
    var table, rows;
    var cell;
    var eltList;
    var found = 0;
    var currentStyle;
    var newStyle;
    var tosearch = document.getElementById('searchtext');

    table = document.getElementById('jobrunsTable');
    if (table !== null) {
        rows = table.rows;

        for (ii = 1; ii < rows.length; ii++) {
            currentStyle = rows[ii].getAttribute("class");
            if(currentStyle !== null) {
                if (currentStyle.search("filtered") >= 0) {
                    newStyle = currentStyle.replace("filtered", "");
                    rows[ii].setAttribute("class", newStyle);
                }
                if (currentStyle.search("selected-row") >= 0) {
                    newStyle = currentStyle.replace("selected-row", "");
                    rows[ii].setAttribute("class", newStyle);
                }
            }
        }
    } else {
        var idList = ["htrace-", "joblog-", "reslog-"];
        var elt;
        var eltexist;
        var ii;
        for(ij = 0; ij < idList.length; ij++) {
            eltexist = true;
            ii = 0;
            while (eltexist) {
                elt = document.getElementById(idList[ij] + ii);
                if (elt === null) {
                    eltexist = false;
                } else {
                    currentStyle = elt.getAttribute("class");
                    if(currentStyle !== null) {
                        if (currentStyle.search("filtered2") >= 0) {
                            newStyle = currentStyle.replace("filtered2", "");
                            elt.setAttribute("class", newStyle);
                            found++;
                        }
                    }
                }
                ii++;
            }
        }
        eltList = document.getElementsByClassName('themed-grid-col');
        for(ii = 0; ii < eltList.length; ii++) {
            cell = eltList[ii];
            currentStyle = cell.getAttribute("class");
            if(currentStyle !== null) {
                if (currentStyle.search("filtered") >= 0) {
                    newStyle = currentStyle.replace("filtered", "");
                    cell.setAttribute("class", newStyle);
                    found++;
                }
            }
        }

    }
}


function sortTable(tblid, index, order) {
    console.log('sorting table id=', tblid, " index=", index, " order=", order)
    var table, rows, switching, i, x, y, shouldSwitch;

    table = document.getElementById('jobrunsTable');
    allbtns = document.getElementsByClassName('btn-sm')
    for(ii=0; ii<allbtns.length;ii++) {
        allbtns[ii].setAttribute('class','btn btn-sm btn-outline-secondary')
    }
    selectedBtn = document.getElementById("btn-sort-"+index+"-"+order).setAttribute('class','btn btn-sm btn-secondary')
    switching = true;
    /*Make a loop that will continue until
    no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.rows;
        /*Loop through all table rows (except the
        first, which contains table headers):*/
        for (i = 1; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
            one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[index];
            y = rows[i + 1].getElementsByTagName("TD")[index];
            //console.log(i,"elt x=",x.innerText.toString()," elt y=", y.innerText.toString())
            //check if the two rows should switch place:
            if(order === 'asc') {
                if (x.innerText.toString() < y.innerText.toString()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            } else {
                if (x.innerText.toString() > y.innerText.toString()) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch = true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            //console.log("switching row ",i)
            /*If a switch has been marked, make the switch
            and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
        } else {
            console.log('no switch')
        }
    }
}

function copyTableToArray(tblid) {
    var myTableArray = [];

    $("table#jobrunsTable tr").each(function() {
        var arrayOfThisRow = [];
        var tableData = $(this).find('td');
        if (tableData.length > 0) {
            tableData.each(function() { arrayOfThisRow.push($(this).text()); });
            myTableArray.push(arrayOfThisRow);
        }
    });
    return myTableArray;
}
/*
    var newTableBody = document.createElement("tbody");
    for(var i=0, len=arrayOfRows.length; i<len; i++) {
        newTableBody.appendChild(rows[arrayOfRows[i].oldIndex].cloneNode(true));
    }
    table.replaceChild(newTableBody,tbody);
*/
    function CompareRowOfText(a,b) {
        var aval = a.value;
        var bval = b.value;
        return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
    } // function CompareRowOfText()

    function CompareRowOfNumbers(a,b) {
        var aval = /\d/.test(a.value) ? parseFloat(a.value) : 0;
        var bval = /\d/.test(b.value) ? parseFloat(b.value) : 0;
        return( aval == bval ? 0 : (aval > bval ? 1 : -1) );
    } // function CompareRowOfNumbers()

    function GetDateSortingKey(format,text) {
        if( format.length < 1 ) { return ""; }
        format = format.toLowerCase();
        text = text.toLowerCase();
        text = text.replace(/^[^a-z0-9]*/,"");
        text = text.replace(/[^a-z0-9]*$/,"");
        if( text.length < 1 ) { return ""; }
        text = text.replace(/[^a-z0-9]+/g,",");
        var date = text.split(",");
        if( date.length < 3 ) { return ""; }
        var d=0, m=0, y=0;
        for( var i=0; i<3; i++ ) {
            var ts = format.substr(i,1);
            if( ts == "d" ) { d = date[i]; }
            else if( ts == "m" ) { m = date[i]; }
            else if( ts == "y" ) { y = date[i]; }
        }
        d = d.replace(/^0/,"");
        if( d < 10 ) { d = "0" + d; }
        if( /[a-z]/.test(m) ) {
            m = m.substr(0, 3);
            switch (m) {
                case "jan" :
                    m = String(1);
                    break;
                case "feb" :
                    m = String(2);
                    break;
                case "mar" :
                    m = String(3);
                    break;
                case "apr" :
                    m = String(4);
                    break;
                case "may" :
                    m = String(5);
                    break;
                case "jun" :
                    m = String(6);
                    break;
                case "jul" :
                    m = String(7);
                    break;
                case "aug" :
                    m = String(8);
                    break;
                case "sep" :
                    m = String(9);
                    break;
                case "oct" :
                    m = String(10);
                    break;
                case "nov" :
                    m = String(11);
                    break;
                case "dec" :
                    m = String(12);
                    break;
                default    :
                    m = String(0);
            }
        }
        m = m.replace(/^0/,"");
        if( m < 10 ) { m = "0" + m; }
        y = parseInt(y);
        if( y < 100 ) { y = parseInt(y) + 2000; }
        return "" + String(y) + "" + String(m) + "" + String(d) + "";
    } // function GetDateSortingKey()

/* globals Chart:false, feather:false */
/*(showHideChart)()*/
function showHideChart(xdata, ydata, graphType) {
    'use strict'

    var otherType;

    if(graphType === 'bar') {
        otherType = 'pie'
    } else {
        otherType = 'bar';
    }
    var otherBtn = document.getElementById('btn-chart-'+otherType);
    var btn = document.getElementById('btn-chart-'+graphType);
    var show;
    // Graphs
    var ctx = document.getElementById('jobChart');

    if (btn.getAttribute('class') == 'btn btn-sm btn-secondary') {
        show = false;
    } else {
        show = true;
    }

    if(show) {
        btn.setAttribute('class', 'btn btn-sm btn-secondary');
        otherBtn.setAttribute('class','btn btn-sm btn-outline-secondary');
        ctx.style.display = '';
        //ctx.style.height = '500';
        // eslint-disable-next-line no-unused-vars

        var bgc1 = "rgba(255, 99, 132, 0.2)";
        var bgc2 = "rgba(255, 159, 64, 0.2)";
        var bgc3 = "rgba(255, 205, 86, 0.2)";
        var bgc4 = "rgba(75, 192, 192, 0.2)";
        var bgc5 = "rgba(54, 162, 235, 0.2)";
        var bgc6 = "rgba(153, 102, 255, 0.2)";
        var bgc7 = "rgba(201, 203, 207, 0.2)";
        var bgc8 = "rgba(0, 203, 0, 0.2)";
        var bc1 = "rgb(255, 99, 132)";
        var bc2 = "rgb(255, 159, 64)";
        var bc3 = "rgb(255, 205, 86)";
        var bc4 = "rgb(75, 192, 192)";
        var bc5 = "rgb(54, 162, 235)";
        var bc6 = "rgb(153, 102, 255)";
        var bc7 = "rgb(201, 203, 207)";
        var bc8 = "rgb(0, 203, 0)";
        var bgcolor = [];
        var bordercolor = [];
        for(var ii=0;ii<xdata.length; ii++) {
            switch (xdata[ii]) {
                case 'LAUNCH_WAIT': bgcolor[ii] = bgc4; bordercolor[ii] = bc4;
                    break;
                case 'EVENT_WAIT': bgcolor[ii] = bgc3; bordercolor[ii] = bc3;
                    break;
                case 'PENDING': bgcolor[ii] = bgc6; bordercolor[ii] = bc6;
                    break;
                case 'DISABLED': bgcolor[ii] = bgc7; bordercolor[ii] = bc7;
                    break;
                case 'WATCHING': bgcolor[ii] = bgc5; bordercolor[ii] = bc5;
                    break;
                case 'TIME_OVERRUN': bgcolor[ii] = bgc2; bordercolor[ii] = bc2;
                    break;
                case 'REFUSED': bgcolor[ii] = bgc1; bordercolor[ii] = bc1;
                    break;
                case 'COMPLETED': bgcolor[ii] = bgc8; bordercolor[ii] = bc8;
                    break;
                case 'ABORTED': bgcolor[ii] = bgc1; bordercolor[ii] = bc1;
                    break;
                case 'RUNNING': bgcolor[ii] = bgc5; bordercolor[ii] = bc5;
                    break;
                default: bgcolor[ii] = bgc7; bordercolor[ii] = bc7;
                    break;
            }
        }

        if(graphType === 'bar') {
            var myChart = new Chart(ctx, {
                type: graphType,
                data: {
                    labels: xdata,
                    datasets: [{
                        data: ydata,
                        lineTension: 0,
                        backgroundColor: bgcolor,
                        borderColor: bordercolor,
                        borderWidth: 2,
                        pointBackgroundColor: '#007bff'
                    }]
                },
                options: {
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: false
                            }
                        }]
                    },
                    legend: {
                        display: false
                    }
                }
            })
        } else {
            var myChart = new Chart(ctx, {
                type: graphType,
                data: {
                    labels: xdata,
                    datasets: [{
                        data: ydata,
                        lineTension: 0,
                        backgroundColor: bgcolor,
                        borderColor: bordercolor,
                        borderWidth: 2,
                        pointBackgroundColor: '#007bff'
                    }]
                },
                options: {
                    legend: {
                        display: false
                    }
                }
            })
        }

    } else {
        btn.setAttribute('class', 'btn btn-sm btn-outline-secondary');
        ctx.style.display = 'none';
        //ctx.style.height = '0';
    }
}