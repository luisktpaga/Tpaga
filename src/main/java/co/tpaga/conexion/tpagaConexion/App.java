package co.tpaga.conexion.tpagaConexion;

import javax.swing.SwingUtilities;

public class App 
{
	public static String CLIENTE;
	public static String CCTOKEN;
	public static String CUSTOMERCC;
	public static String CHARGE;
	
	public static String URL_BASE_API	 	="https://sandbox.tpaga.co/api/";
	public static String CUSTOMER 			= "customer";
	public static String TOKEN 				= "tokenize/credit_card";
	public static String CREDITCAR			="/credit_card_token";
	public static String CHARGUECC 			= "charge/credit_card";
	public static String REFOUND			= "refund/credit_card";
	public static String PRIVATE_KEY 		= "h7pet7tkq9up8cnv1lhml8upob4da8kc";
	public static String PUBLIC_KEY 		= "h21er6uj5d0bo6b12jkjbe1q77aph5tr";

	public static void main( String[] args )
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Tpaga frame = new Tpaga();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
