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
		
		InputStreamReader  isr = new InputStreamReader(inputStream);

		try (BufferedReader bufferedReader = new BufferedReader(isr)) {
			String line = null;

			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {

				if (count != 0) {
					String[] n = line.split(",");
					Candle candle = new Candle(Long.parseLong(n[0]), Double.parseDouble(n[3]),
							Double.parseDouble(n[4]), Double.parseDouble(n[5]), Double.parseDouble(n[6]),
							Double.parseDouble(n[7]));

					candles.add(candle);
				}
				++count;
			}
		}
		catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
