package co.tpaga.conexion.tpagaConexion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.Color;



public class Tpaga extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	//Inicializamos 
	JTabbedPane tabbedPane 				= new JTabbedPane(JTabbedPane.TOP);
	
	JPanel panel	 					= new JPanel();
	JPanel panel_3 						= new JPanel();
	JPanel panel_1 						= new JPanel();
	JPanel panel_5 						= new JPanel();
	JPanel panel_2 						= new JPanel();
	
	JLabel lblNewLabel 					= new JLabel("Nombre ");
	JLabel lblTelefono 					= new JLabel("Telefono");
	JLabel lblGenero 					= new JLabel("Genero");
	JLabel lblApellido 					= new JLabel("Apellido");
	JLabel lblEmail 					= new JLabel("Email");
		
	JLabel lblNombreImpreso 			= new JLabel("Nombre Impreso");
	JLabel lblMesDeExpiracion 			= new JLabel("Mes de expiracion");
	JLabel lblAoDeExpiracion 			= new JLabel("Año de expiracion");
	JLabel lblNumero 					= new JLabel("Numero");
	
	JLabel lblValorDeLa 				= new JLabel("Valor de la compra");
	JLabel lblMoneda 					= new JLabel("Moneda");
	JLabel lblDescripcion 				= new JLabel("Descripcion");
	JLabel lblCuotas 					= new JLabel("Cuotas");
	JLabel lblNOrden 					= new JLabel("N° Orden");
	JLabel lblIva 						= new JLabel("IVA");
	
	JTextField textFieldNombre			= new JTextField();
	JTextField textFieldTelefono 		= new JTextField();
	JTextField textFieldApellido		= new JTextField();
	JTextField textFieldIdNumber		= new JTextField();
	JTextField textFieldEmail			= new JTextField();
	
	JTextField textFieldCnombre 		= new JTextField();
	JTextField textFieldCmes 			= new JTextField();
	JTextField textFieldCaño 			= new JTextField();
	JTextField textFieldCnumero 		= new JTextField();
	
	JTextField textFieldMonto 			= new JTextField();
	JTextField textFieldMoneda 			= new JTextField();
	JTextField textFieldDescripcion 	= new JTextField();
	JTextField textFieldCuotas 			= new JTextField();
	JTextField textFieldOrden 			= new JTextField();
	JTextField textFieldIva 			= new JTextField();
	
	JButton btnProcesarCompra 			= new JButton("Procesar compra");
	JButton btnReversarCompra 			= new JButton("Reversar compra");
	JButton btnCrearCliente 			= new JButton("Crear Cliente");
	JButton btnAgregarTarjeta 			= new JButton("Agregar tarjeta");
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox<String> generos			= new JComboBox();
	
	
	
	//Crea todo lo grafico
	public Tpaga() {
		inicializaComponentes();

	}

	private void inicializaComponentes(){
		setResizable(false);
		setTitle("Tpaga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(null);


		tabbedPane.setBounds(0, 0, 624, 441);
		getContentPane().add(tabbedPane);


		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(null);


		panel_3.setToolTipText("");
		panel_3.setBounds(12, 12, 599, 403);
		panel.add(panel_3);
		panel_3.setLayout(null);


		lblNewLabel.setBounds(125, 38, 90, 14);
		panel_3.add(lblNewLabel);

		textFieldNombre.setBounds(245, 35, 185, 20);
		panel_3.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer.email			=textFieldEmail.getText();
				Customer.firsName		=textFieldNombre.getText();
				Customer.gender			=(String) generos.getSelectedItem();
				Customer.lastName		=textFieldApellido.getText();
				Customer.legalIdNumber	=textFieldIdNumber.getText();
				Customer.phone			=textFieldTelefono.getText();
				
				Customer.createCustomer();
				
				textFieldEmail.setText("");
				textFieldNombre.setText("");
				textFieldApellido.setText("");
				textFieldIdNumber.setText("");
				textFieldTelefono.setText("");
			}
		});

		btnCrearCliente.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCrearCliente.setBounds(455, 368, 132, 23);
		panel_3.add(btnCrearCliente);

		lblApellido.setBounds(125, 82, 90, 14);
		panel_3.add(lblApellido);

		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(245, 79, 185, 20);
		panel_3.add(textFieldApellido);

		JLabel lblNIdentificacion = new JLabel("N° Identificacion");
		lblNIdentificacion.setBounds(125, 191, 115, 14);
		panel_3.add(lblNIdentificacion);

		textFieldIdNumber = new JTextField();
		textFieldIdNumber.setColumns(10);
		textFieldIdNumber.setBounds(245, 188, 185, 20);
		panel_3.add(textFieldIdNumber);

		lblEmail.setBounds(125, 256, 115, 14);
		panel_3.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(245, 253, 185, 20);
		panel_3.add(textFieldEmail);
		lblTelefono.setBounds(125, 316, 115, 14);

		panel_3.add(lblTelefono);
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(245, 313, 185, 20);

		panel_3.add(textFieldTelefono);
		lblGenero.setBounds(125, 131, 90, 14);

		panel_3.add(lblGenero);
		generos.setBounds(245, 129, 185, 20);
		
		panel_3.add(generos);
		generos.addItem("N/A");
		generos.addItem("M");
		generos.addItem("F");
		
		
		tabbedPane.addTab("Tarjetas", null, panel_1, null);
		panel_1.setLayout(null);

		panel_5.setBounds(10, 11, 599, 391);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		lblNombreImpreso.setBounds(37, 29, 149, 14);
		
		panel_5.add(lblNombreImpreso);
		textFieldCnombre.setColumns(10);
		textFieldCnombre.setBounds(177, 27, 363, 20);
		
		panel_5.add(textFieldCnombre);
		lblMesDeExpiracion.setBounds(37, 92, 149, 14);
		
		panel_5.add(lblMesDeExpiracion);
		textFieldCmes.setForeground(Color.LIGHT_GRAY);
		textFieldCmes.setFont(new Font("DialogInput", textFieldCmes.getFont().getStyle(), textFieldCmes.getFont().getSize()));
		textFieldCmes.setText("mm");
		textFieldCmes.setColumns(10);
		textFieldCmes.setBounds(177, 90, 363, 20);
		
		panel_5.add(textFieldCmes);
		lblAoDeExpiracion.setBounds(37, 177, 149, 14);
		
		panel_5.add(lblAoDeExpiracion);
		textFieldCaño.setForeground(Color.LIGHT_GRAY);
		textFieldCaño.setFont(new Font("DialogInput", textFieldCaño.getFont().getStyle(), textFieldCaño.getFont().getSize()));
		textFieldCaño.setText("yyyy");
		textFieldCaño.setColumns(10);
		textFieldCaño.setBounds(177, 175, 363, 20);
		
		panel_5.add(textFieldCaño);
		lblNumero.setBounds(37, 264, 149, 14);
		
		panel_5.add(lblNumero);
		textFieldCnumero.setForeground(Color.LIGHT_GRAY);
		textFieldCnumero.setFont(new Font("DialogInput", textFieldCnumero.getFont().getStyle(), textFieldCnumero.getFont().getSize()));
		textFieldCnumero.setText("xxxxxxxxxxxxxxxx");
		textFieldCnumero.setColumns(10);
		textFieldCnumero.setBounds(177, 262, 363, 20);
		
		panel_5.add(textFieldCnumero);
		
		btnAgregarTarjeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tokenyze.cardHolderName			=textFieldCnombre.getText();
				Tokenyze.expirationMonth		=textFieldCmes.getText();
				Tokenyze.expirationYear			=textFieldCaño.getText();
				Tokenyze.primaryAccountNumber	=textFieldCnumero.getText();
				
				Tokenyze.createToken();
				CCardCustomer.createTokenCC();
				
				textFieldCnombre.setText("");
				textFieldCmes.setText("");
				textFieldCaño.setText("");
				textFieldCnumero.setText("");
			}
		});
		btnAgregarTarjeta.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnAgregarTarjeta.setBounds(408, 344, 132, 23);
		panel_5.add(btnAgregarTarjeta);
		
		tabbedPane.addTab("Compras", null, panel_2, null);
		panel_2.setLayout(null);
		lblValorDeLa.setBounds(12, 15, 176, 14);
		
		panel_2.add(lblValorDeLa);
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(220, 13, 185, 20);
		
		panel_2.add(textFieldMonto);
		lblMoneda.setBounds(12, 67, 176, 14);
		
		panel_2.add(lblMoneda);
		textFieldMoneda.setColumns(10);
		textFieldMoneda.setBounds(220, 65, 185, 20);
		
		panel_2.add(textFieldMoneda);
		lblDescripcion.setBounds(12, 126, 176, 14);
		
		panel_2.add(lblDescripcion);
		textFieldDescripcion.setColumns(10);
		textFieldDescripcion.setBounds(220, 124, 185, 20);
		
		panel_2.add(textFieldDescripcion);
		textFieldCuotas.setColumns(10);
		textFieldCuotas.setBounds(220, 189, 185, 20);
		
		panel_2.add(textFieldCuotas);
		lblCuotas.setBounds(12, 191, 176, 14);
		
		panel_2.add(lblCuotas);
		lblNOrden.setBounds(12, 256, 176, 14);
		
		panel_2.add(lblNOrden);
		textFieldOrden.setColumns(10);
		textFieldOrden.setBounds(220, 254, 185, 20);
		
		panel_2.add(textFieldOrden);
		lblIva.setBounds(12, 322, 176, 14);
		
		panel_2.add(lblIva);
		textFieldIva.setColumns(10);
		textFieldIva.setBounds(220, 320, 185, 20);
		
		panel_2.add(textFieldIva);
		btnProcesarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Charge.amount			=Integer.parseInt(textFieldMonto.getText());
				Charge.installments		=Integer.parseInt(textFieldCuotas.getText());
				Charge.taxAmount		=Integer.parseInt(textFieldIva.getText());
				
				Charge.currency			=textFieldMoneda.getText();
				Charge.description		=textFieldDescripcion.getText();
				Charge.orderId			=textFieldOrden.getText();
				
				Charge.charguer();
				
				textFieldMonto.setText("");
				textFieldCuotas.setText("");
				textFieldIva.setText("");
				textFieldMoneda.setText("");
				textFieldDescripcion.setText("");
				textFieldOrden.setText("");
			}
		});
		btnProcesarCompra.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnProcesarCompra.setBounds(246, 362, 132, 23);
		
		panel_2.add(btnProcesarCompra);
		btnReversarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Refound.refounder();
			}
		});
		btnReversarCompra.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnReversarCompra.setBounds(475, 362, 132, 23);
		
		panel_2.add(btnReversarCompra);

	}
}