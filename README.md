Esta es una aplicacion demo para consumir metodos post de el api rest de Tpaga para

# Tpaga

Permitiendo la creacion de clientes nuevos, guardar tarjetas de credito, realizar compras y su reversos.

implementa las librerias de java.net y java.io ademas de librerias de json para el manejo de de este tipo de archivos ademas de una libreria de apache para el cifrado en base64 de las llaver privadas y publicas.

Un ejemplo del codigo para consumir un servicio seria el siguiente metodo GET para obtener la informacion de un cliente.


			
      String webPage = (App.URL_BASE_API)+"customer/i0ih8d8hcddv984kl7ou4iehrl7akroj";
			String name =  App.PRIVATE_KEY;
      String password = "";
      String authString = name + ":" + password;
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			
			URL url = new URL(webPage);
			URLConnection urlConnection = url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			JSONObject jsonObject = (JSONObject) JSONValue.parse(isr.readLine());
			System.out.println(jsonObject.toJSONString());

Retornando la informacion del cliente solicitado en un JSONString convertido desde un JsonObject
