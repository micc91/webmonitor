function sortTable(id, index, order) {

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
                if(order == 'asc') {
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


