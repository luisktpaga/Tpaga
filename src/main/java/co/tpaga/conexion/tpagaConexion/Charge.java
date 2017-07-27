package co.tpaga.conexion.tpagaConexion;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Charge {

	public static int amount;
	public static String currency;
	public static String description;
	public static int installments;
	public static String orderId;
	public static int taxAmount;

	@SuppressWarnings("unchecked")
	public static Charge charguer() {
		try {
			String webPage = (App.URL_BASE_API)+(App.CHARGUECC);
			String name =  App.PRIVATE_KEY;
			String password = "";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoOutput(true);
			urlConnection.setRequestMethod("POST");
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			urlConnection.addRequestProperty("content-type", "raw");
			
			JSONObject obj = new JSONObject();
			
			obj.put("amount", amount);
			obj.put("creditCard",App.CUSTOMERCC);
			obj.put("currency", currency);
			obj.put("description",description);
			obj.put("installments",installments);
			obj.put("orderId",orderId);
			obj.put("taxAmount",taxAmount);
			
			String input = obj.toString();

			OutputStream os = urlConnection.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ urlConnection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(urlConnection.getInputStream())));


			JSONObject jsonObject = (JSONObject) JSONValue.parse(br.readLine());
			System.out.println(jsonObject.toJSONString());

			App.CHARGE = (String) jsonObject.get("id");
			System.out.println(App.CHARGE);


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}