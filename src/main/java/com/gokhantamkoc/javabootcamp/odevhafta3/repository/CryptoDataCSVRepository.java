package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz
		
		BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
		String line = null;

		while((line = br.readLine()) != null) {
			String[] n = line.split(",");

			Candle candle = new Candle(Long.parseLong(n[0]), Double.parseDouble(n[1]),
					Double.parseDouble(n[2]), Double.parseDouble(n[3]), Double.parseDouble(n[4]),
					Double.parseDouble(n[5]));

			candles.add(candle);
		}

		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
