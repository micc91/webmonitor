/* globals Chart:false, feather:false */

/*(showHideChart)()*/

function showHideChart(xdata, ydata) {
  'use strict'

  feather.replace()

  var btn = document.getElementById('btn-chart');
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

    var myChart = new Chart(ctx, {
      type: 'bar',
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
    btn.setAttribute('class', 'btn btn-sm btn-outline-secondary');
    ctx.style.display = 'none';
    //ctx.style.height = '0';
  }
}
