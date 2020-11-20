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
    var myChart = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: xdata,
        datasets: [{
          data: ydata,
          lineTension: 0,
          backgroundColor: 'transparent',
          borderColor: '#007bff',
          borderWidth: 4,
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
