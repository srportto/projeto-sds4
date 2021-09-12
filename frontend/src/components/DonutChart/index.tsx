import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

type ChartData = {
  labels: string[];
  series: number[];

}

const DonutChart = () => {
  let chartData: ChartData = { labels: [], series: [] };

  axios.get(`${BASE_URL}/sales/amount-by-seller`)
    .then(response => { 
      const data = response.data as SaleSum[];
      const mylabels = data.map(itemSaleSum => itemSaleSum.sellername);
      const mySeries = data.map(itemSaleSum => itemSaleSum.sum);

      chartData = {labels: mylabels, series: mySeries}

      console.log(chartData); 
    });

  // const mockData = {
  //   series: [477138, 499928, 444867, 220426, 473088],
  //   labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
  // }

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }} //labels and more options 
      series={chartData.series} //dados
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;