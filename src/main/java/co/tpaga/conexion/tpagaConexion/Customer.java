package co.tpaga.conexion.tpagaConexion;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Customer {

	
	public static String email;
	public static String firsName;
	public static String lastName;
	public static String gender;
	public static String legalIdNumber;
	public static String phone;

	public static void customer(){
		try {
			String webPage = (App.URL_BASE_API)+"customer/i0ih8d8hcddv984kl7ou4iehrl7akroj";
			String name =  App.PRIVATE_KEY;
			String password = "";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();

			System.out.println("*** BEGIN ***");
			System.out.println(result);
			System.out.println("*** END ***");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	@SuppressWarnings("unchecked")
	public static Customer createCustomer() {
		try {
			String webPage = (App.URL_BASE_API)+(App.CUSTOMER);
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

			obj.put("email", email);
			obj.put("firstName", firsName);
			obj.put("gender", gender);
			obj.put("lastName", lastName);
			obj.put("legalIdNumber", legalIdNumber);
			obj.put("phone", phone);

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

			App.CLIENTE = (String) jsonObject.get("id");
			
			System.out.println(App.CLIENTE);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
}
