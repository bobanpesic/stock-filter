
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class MakeMeRich {
	public static final List<String> symbols = Arrays.asList("AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
			"AMZN", "CRAY", "CSCO", "SNE", "GOOG", "INTC", "INTU", "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");

	public static void main(String[] args) throws IOException {

		// 1. Print these symbols using a Java 8 for-each and lambdas
		symbols.stream().forEach(System.out::println);
		// 2. Use the StockUtil class to print the price of Bitcoin
		System.out.println(StockUtil.prices.get("BTC-USD"));
		// 3. Create a new List of StockInfo that includes the stock price
		List<Double> stockInfo = StockUtil.prices.values().stream().collect(Collectors.toList());
		// 4. Find the highest-priced stock under $500
		List<Double> highPricedStock = stockInfo.stream().filter(price -> price < 500).sorted()
				.collect(Collectors.toList());
		Collections.reverse(highPricedStock);
		System.out.println(highPricedStock);
		System.out.println(highPricedStock.get(0));

		// lesson16

		URL request = new URL("https://cat-fact.herokuapp.com/facts/random");
		String response = IOUtils.toString(request.openStream(), "UTF-8");
		JSONObject json = new JSONObject(response);
		String randomACatFact = json.getString("text");
		System.out.println("Random cat fact: \n" + randomACatFact);

	}

}
