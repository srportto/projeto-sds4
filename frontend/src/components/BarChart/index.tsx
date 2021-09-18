import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSuccess } from 'types/sale';
import { round } from 'utils/format';
import { BASE_URL } from 'utils/requests';

type seriesData = {
  name: string;
  data: number[];
}

type Chartdata = {
  labels: {
    categories: string[];
  };
  series: seriesData[];
}

const BarChart = () => {
  const [chartData, setChartData] = useState<Chartdata>({
    labels: {
      categories: []
    },
    series: [
      {
        name: "",
        data: []
      }
    ]
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`)
      .then(response => {
        const data = response.data as SaleSuccess[];
        const mylabels = data.map(itemSaleSum => itemSaleSum.sellername);
        const mySeries = data.map(itemSaleSum => round(100.0 * itemSaleSum.deals / itemSaleSum.visited, 1));

        setChartData({
          labels: {
            categories: mylabels
          },
          series: [
            {
              name: "% Success",
              data: mySeries
            }
          ]
        });
      });

  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  return (
    <Chart
      options={{ ...options, xaxis: chartData.labels }} //labels and more options 
      series={chartData.series} //dados
      type="bar"
      height="240"
    />
  );
}

export default BarChart;