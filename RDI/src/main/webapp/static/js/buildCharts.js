
function buildLine(ydata,xdata,ytitle,title) {
	//build the line
    Highcharts.chart('line-labels-upper-left', {
        chart: {
            type: 'line'
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: ydata
    });
    
    Highcharts.chart('line-labels-upper-right', {
        chart: {
            type: 'line'
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: ydata
    });
    
    Highcharts.chart('line-labels-lower-left', {
        chart: {
            type: 'line'
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: ydata
    });
    
    Highcharts.chart('line-labels-lower-right', {
        chart: {
            type: 'line'
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: ydata
    });
}

function buildLineNew(ele,ydata,xdata,ytitle,title) {
	//build the line
    Highcharts.chart(ele, {
        chart: {
            type: 'line'
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: ydata
    });
      
}
 // Build the pie
function buildPie(){
    Highcharts.chart('pie-legend', {
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Browser market shares January, 2015 to May, 2015'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: false
                },
                showInLegend: true
            }
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: [{
                name: 'Microsoft Internet Explorer',
                y: 56.33
            }, {
                name: 'Chrome',
                y: 24.03,
                sliced: true,
                selected: true
            }, {
                name: 'Firefox',
                y: 10.38
            }, {
                name: 'Safari',
                y: 4.77
            }, {
                name: 'Opera',
                y: 0.91
            }, {
                name: 'Proprietary or Undetectable',
                y: 0.2
            }]
        }]
    });
}

function bulidColumn(ydata,xdata,ytitle,title){
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'line-labels',
            type: 'column',
            options3d: {
                enabled: true,
                alpha: 0,
                beta: 0,
                depth: 100,
                viewDistance: 25
            }
        },
        title: {
            text: title
        },
        subtitle: {
            text: 'Source: 物价局'
        },
        xAxis: {
            categories: xdata
        },
        yAxis: {
            title: {
                text: ytitle
            }
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        series: ydata
    });
	function showValues() {
	    $('#alpha-value').html(chart.options.chart.options3d.alpha);
	    $('#beta-value').html(chart.options.chart.options3d.beta);
	    $('#depth-value').html(chart.options.chart.options3d.depth);
	}
	$('#sliders input').on('input change', function () {
	    chart.options.chart.options3d[this.id] = this.value;
	    showValues();
	    chart.redraw(false);
	});
	showValues(); 
}