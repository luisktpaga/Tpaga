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

public class Refound {

	@SuppressWarnings("unchecked")
	public static Refound refounder() {
		try {
			String webPage = (App.URL_BASE_API)+(App.REFOUND);
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
			
			obj.put("id", App.CHARGE);
			
			
			String input = obj.toString();

			OutputStream os = urlConnection.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (urlConnection.getResponseCode() != HttpURLConnection.HTTP_ACCEPTED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ urlConnection.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(urlConnection.getInputStream())));


			JSONObject jsonObject = (JSONObject) JSONValue.parse(br.readLine());
			System.out.println(jsonObject.toJSONString());


		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}