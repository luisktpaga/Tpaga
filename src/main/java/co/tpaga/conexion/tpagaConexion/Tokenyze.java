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

public class Tokenyze {

	public static String cardHolderName;
	public static String expirationMonth;
	public static String expirationYear;
	public static String primaryAccountNumber;
	
	@SuppressWarnings("unchecked")
	public static Tokenyze createToken() {
		try {
			String webPage = (App.URL_BASE_API)+(App.TOKEN);
			String name =  App.PUBLIC_KEY;
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
			
			obj.put("cardHolderName", cardHolderName);
			obj.put("expirationMonth", expirationMonth);
			obj.put("expirationYear", expirationYear);
			obj.put("primaryAccountNumber", primaryAccountNumber);
			
			String input = obj.toString();

			OutputStream os = urlConnection.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ urlConnection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));

			JSONObject jsonObject = (JSONObject) JSONValue.parse(br.readLine());
			System.out.println(jsonObject.toJSONString());

			App.CCTOKEN = (String) jsonObject.get("token");
			System.out.println(App.CCTOKEN);


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}