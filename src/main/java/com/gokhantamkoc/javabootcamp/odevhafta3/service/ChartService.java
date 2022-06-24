package com.gokhantamkoc.javabootcamp.odevhafta3.service;

import com.gokhantamkoc.javabootcamp.odevhafta3.repository.CSVRepository;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;
import java.io.IOException;
import java.util.List;

public class ChartService {
	CSVRepository cryptoDataCSVRepository;
	
	public ChartService(CSVRepository cryptoDataCSVRepository) {
		this.cryptoDataCSVRepository = cryptoDataCSVRepository;
	}
	
	public CandleStickChart createChartFromCryptoData() throws IOException {
		// Bu metodu doldurmanizi bekliyoruz.

		CandleStickChart candleStickChart = new CandleStickChart("BTC/USDT");

		try {
			List<Candle> candles = this.cryptoDataCSVRepository.readCSV("Binance_BTCUSDT_d.csv");

			for (Candle candle : candles) {
				candleStickChart.addCandle(
						candle.getTime(),
						candle.getOpen(),
						candle.getHigh(),
						candle.getLow(),
						candle.getClose(),
						candle.getVolume());
			}
		}

		catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return candleStickChart;
	}
}

