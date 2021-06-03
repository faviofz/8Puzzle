package juego;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;

public class JUEGO4x4 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JMenuBar menuBar;
	private JButton btnReiniciar;
	private JButton btnx;
	protected JButton button;
	protected JButton button_1;
	protected JButton button_2;
	protected JButton button_3;
	protected JButton button_4;
	protected JButton button_5;
	protected JButton button_6;
	protected JButton button_7;
	protected JButton button_8;
	protected JButton button_9;
	protected JButton button_10;
	protected JButton button_11;
	protected JButton button_12;
	protected JButton button_13;
	protected JButton button_14;
	protected JButton button_15;
	static int contarmovimientos=1;
	private JLabel lblTiempo;
	private static JLabel labelcronometro;
	private JLabel lblMovimientos;
	private JTextField textField;
	private JLabel lblBestScore;
	private JLabel lblTiempo_1;
	private JLabel label_1;
	private JLabel lblMovimientos_1;
	private JTextField textField_1;
	static ArrayList<JButton> listabotones;
	private static String MejorTiempo=null;
	private static String MejorMovimiento=null;
	private Timer t;
	private static int hora=0, minuto=0, segundo=0;
	private ActionListener acciones = new ActionListener(){

	        @Override
	        public void actionPerformed(ActionEvent ae) {
	           ++segundo;
	            if(segundo==60) 
	            {
	                segundo = 0;
	                ++minuto;
	            }
	            if(minuto==60)
	            {
	                minuto = 0;
	                ++hora;
	            }
	            actualizarLabel();
	        }

	        
	    };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUEGO4x4 frame = new JUEGO4x4();
					frame.setVisible(true);
					frame.setTitle("15-Puzzle");
					frame.setIconImage(new ImageIcon(getClass().getResource("/imagenes/152.png")).getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JUEGO4x4() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		panel_1.setBounds(0, 37, 334, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		button = new JButton("");
		button.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button.addActionListener(this);
		button.setBounds(0, 0, 81, 71);
		panel_1.add(button);
		
		button_1 = new JButton("");
		button_1.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_1.addActionListener(this);
		button_1.setBounds(80, 0, 81, 71);
		panel_1.add(button_1);
		
		button_2 = new JButton("");
		button_2.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_2.addActionListener(this);
		button_2.setBounds(160, 0, 81, 71);
		panel_1.add(button_2);
		
		button_3 = new JButton("");
		button_3.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_3.addActionListener(this);
		button_3.setBounds(240, 0, 81, 71);
		panel_1.add(button_3);
		
		button_4 = new JButton("");
		button_4.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_4.setBounds(0, 74, 81, 71);
		button_4.addActionListener(this);
		panel_1.add(button_4);
		
		button_5 = new JButton("");
		button_5.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_5.addActionListener(this);
		button_5.setBounds(80, 74, 81, 71);
		panel_1.add(button_5);
		
		button_6 = new JButton("");
		button_6.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_6.addActionListener(this);
		button_6.setBounds(160, 74, 81, 71);
		panel_1.add(button_6);
		
		button_7 = new JButton("");
		button_7.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_7.addActionListener(this);
		button_7.setBounds(240, 74, 81, 71);
		panel_1.add(button_7);
		
		button_8 = new JButton("");
		button_8.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_8.addActionListener(this);
		button_8.setBounds(0, 150, 81, 71);
		panel_1.add(button_8);
		
		button_9 = new JButton("");
		button_9.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_9.addActionListener(this);
		button_9.setBounds(80, 150, 81, 71);
		panel_1.add(button_9);
		
		button_10 = new JButton("");
		button_10.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_10.addActionListener(this);
		button_10.setBounds(160, 150, 81, 71);
		panel_1.add(button_10);
		
		button_11 = new JButton("");
		button_11.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_11.addActionListener(this);
		button_11.setBounds(240, 150, 81, 71);
		panel_1.add(button_11);
		
		button_12 = new JButton("");
		button_12.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_12.setBounds(0, 223, 81, 71);
		button_12.addActionListener(this);
		panel_1.add(button_12);
		
		button_13 = new JButton("");
		button_13.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_13.addActionListener(this);
		button_13.setBounds(80, 223, 81, 71);
		panel_1.add(button_13);
		
		button_14 = new JButton("");
		button_14.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_14.addActionListener(this);
		button_14.setBounds(160, 223, 81, 71);
		panel_1.add(button_14);
		
		button_15 = new JButton("");
		button_15.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_15.addActionListener(this);
		button_15.setBounds(240, 223, 81, 71);
		panel_1.add(button_15);
		
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(336, 37, 188, 149);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblBestScore = new JLabel("Best Score");
		lblBestScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblBestScore.setBounds(29, 0, 100, 14);
		panel_2.add(lblBestScore);
		
		lblTiempo_1 = new JLabel("Tiempo:");
		lblTiempo_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTiempo_1.setBounds(10, 25, 62, 14);
		panel_2.add(lblTiempo_1);
		
		label_1 = new JLabel("00:00:00");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(93, 24, 85, 14);
		panel_2.add(label_1);
		
		lblMovimientos_1 = new JLabel("Movimientos:");
		lblMovimientos_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMovimientos_1.setBounds(10, 64, 112, 14);
		panel_2.add(lblMovimientos_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(107, 62, 47, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(135, 206, 235));
		panel_3.setBounds(336, 185, 188, 146);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiempo.setBounds(0, 11, 68, 14);
		panel_3.add(lblTiempo);
		
		labelcronometro = new JLabel("00:00:00");
		labelcronometro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelcronometro.setBounds(93, 11, 85, 14);
		panel_3.add(labelcronometro);
		
		lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMovimientos.setBounds(0, 54, 89, 14);
		panel_3.add(lblMovimientos);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(108, 51, 46, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 524, 21);
		contentPane.add(menuBar);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addActionListener(this);
		menuBar.add(btnReiniciar);
		
		btnx = new JButton("Jugar 3x3");
		btnx.addActionListener(this);
		menuBar.add(btnx);
		
//		cronometro.start();
		
		listabotones = new ArrayList<JButton>();
		
		listabotones.add(button);
		listabotones.add(button_1);
		listabotones.add(button_2);
		listabotones.add(button_3);
		listabotones.add(button_4);
		listabotones.add(button_5);
		listabotones.add(button_6);
		listabotones.add(button_7);
		listabotones.add(button_8);
		listabotones.add(button_9);
		listabotones.add(button_10);
		listabotones.add(button_11);
		listabotones.add(button_12);
		listabotones.add(button_13);
		listabotones.add(button_14);
		listabotones.add(button_15);
		
		
		cargarJuego();
		t = new Timer(1000, acciones);
		t.start();
		
		
	}
	
//	Thread cronometro =new Thread(){
//		@Override
//		
//		public void run(){
//			int segundo=0,minuto=0,hora=0;
//			
//			ejecutarCronometro(segundo,minuto,hora);
//			
//		}
//
//		
//	};
	
	private void ganaste(){
		int i=0;
		String auxiliar="";
		boolean bandera=true;
		while(i<listabotones.size()-1 && bandera==true){
			auxiliar=""+(i+1);
			
			if(!auxiliar.equals(listabotones.get(i).getText())){
				bandera=false;
			}
			
			
			auxiliar=null;
			i+=1;
		}
		if(bandera==true){
			t.stop();
			button_15.setText("16");
			button_15.setVisible(true);
			JOptionPane.showMessageDialog(null, "HAZ GANADO");
			MejorTiempo(textField.getText(),labelcronometro.getText());
		}
	}
	private void MejorTiempo(String text, String text2) {
		if(MejorTiempo == null){
			MejorTiempo=text2;
			MejorMovimiento=text;
			textField_1.setText(MejorMovimiento);
			label_1.setText(MejorTiempo);
		}else{
			if(MejorTiempo.compareTo(text2)>0){//text2<MejorTiempo
				MejorTiempo=text2;
				MejorMovimiento=text;
				textField_1.setText(MejorMovimiento);
				label_1.setText(MejorTiempo);
				
			}
		}
		
		
		
	}

	private void actualizarLabel() {
		// TODO Auto-generated method stub
		ejecutarCronometro(segundo,minuto,hora);
	}
	
	public void ejecutarCronometro(int segundo, int minuto, int hora) {
		String Textseg="",Textmin="",Texths="",Textoetiqueta="";
		
				if(segundo<10){
					Textseg="0"+segundo;
				}else{
					Textseg=""+segundo;
				}
				
				
			
				if(minuto<10){
					Textmin="0"+minuto;
				}else{
					Textmin=""+minuto;
				}
				if(hora<10){
					Texths="0"+hora;
				}else{
					Texths=""+hora;
				}
				
				
				Textoetiqueta=Texths+":"+Textmin+":"+Textseg;
				
				labelcronometro.setText(Textoetiqueta);	
				
				
}
	
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnx) {
			try {
				actionPerformedBtnx(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == btnReiniciar) {
			try {
				actionPerformedBtnReiniciar(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == button_15) {
			actionPerformedButton_15(arg0);
		}
		if (arg0.getSource() == button_14) {
			actionPerformedButton_14(arg0);
		}
		if (arg0.getSource() == button_13) {
			actionPerformedButton_13(arg0);
		}
		if (arg0.getSource() == button_12) {
			actionPerformedButton_12(arg0);
		}
		if (arg0.getSource() == button_11) {
			actionPerformedButton_11(arg0);
		}
		if (arg0.getSource() == button_10) {
			actionPerformedButton_10(arg0);
		}
		if (arg0.getSource() == button_9) {
			actionPerformedButton_9(arg0);
		}
		if (arg0.getSource() == button_8) {
			actionPerformedButton_8(arg0);
		}
		if (arg0.getSource() == button_7) {
			actionPerformedButton_7(arg0);
		}
		if (arg0.getSource() == button_6) {
			actionPerformedButton_6(arg0);
		}
		if (arg0.getSource() == button_5) {
			actionPerformedButton_5(arg0);
		}
		if (arg0.getSource() == button_4) {
			actionPerformedButton_4(arg0);
		}
		if (arg0.getSource() == button_3) {
			actionPerformedButton_3(arg0);
		}
		if (arg0.getSource() == button_2) {
			actionPerformedButton_2(arg0);
		}
		if (arg0.getSource() == button_1) {
			actionPerformedButton_1(arg0);
		}
		if (arg0.getSource() == button) {
			actionPerformedButton(arg0);
		}
	}
	
	


	public void contarMovimientos(){
		
		textField.setText(String.valueOf(contarmovimientos++));
	}
	protected void actionPerformedButton(ActionEvent arg0) {
		
		if(button_1.isVisible()==false){
			mover(button_1, button);
			contarMovimientos();
			}
			if(button_4.isVisible()==false){
				mover(button_4,button);
				contarMovimientos();
			}
			
			ganaste();
		
	}
	protected void actionPerformedButton_1(ActionEvent arg0) {
		if(button.isVisible()==false){
			mover(button, button_1);
			contarMovimientos();
			}
			if(button_2.isVisible()==false){
				mover(button_2,button_1);
				contarMovimientos();
			}
			if(button_5.isVisible()==false){
				mover(button_5,button_1);
				contarMovimientos();
			}
			
			ganaste();
			
		
		
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		if(button_1.isVisible()==false){
			mover(button_1, button_2);
			contarMovimientos();
			}
			if(button_3.isVisible()==false){
				mover(button_3,button_2);
				contarMovimientos();
			}
			if(button_6.isVisible()==false){
				mover(button_6,button_2);
				contarMovimientos();
			}
			
			ganaste();
	}
	protected void actionPerformedButton_3(ActionEvent arg0) {
		
		if(button_7.isVisible()==false){
			mover(button_7, button_3);
			contarMovimientos();
			}
			if(button_2.isVisible()==false){
				mover(button_2,button_3);
				contarMovimientos();
			}
			
			ganaste();
	}
	private void actionPerformedButton_4(ActionEvent arg0) {
		
		if(button.isVisible()==false){
			mover(button, button_4);
			contarMovimientos();
			}
			if(button_5.isVisible()==false){
				mover(button_5,button_4);
				contarMovimientos();
			}
			if(button_8.isVisible()==false){
				mover(button_8,button_4);
				contarMovimientos();
			}
			
			ganaste();
	}
	protected void actionPerformedButton_5(ActionEvent arg0) {
		
		if(button_4.isVisible()==false){
			mover(button_4, button_5);
			contarMovimientos();
			}
			if(button_1.isVisible()==false){
				mover(button_1,button_5);
				contarMovimientos();
			}
			if(button_9.isVisible()==false){
				mover(button_9,button_5);
				contarMovimientos();
			}
			if(button_6.isVisible()==false){
				mover(button_6,button_5);
				contarMovimientos();
			}
			
			ganaste();
		
	}
	protected void actionPerformedButton_6(ActionEvent arg0) {
		
		if(button_5.isVisible()==false){
			mover(button_5, button_6);
			contarMovimientos();
			}
			if(button_2.isVisible()==false){
				mover(button_2,button_6);
				contarMovimientos();
			}
			if(button_7.isVisible()==false){
				mover(button_7,button_6);
				contarMovimientos();
			}
			if(button_10.isVisible()==false){
				mover(button_10,button_6);
				contarMovimientos();
			}
			
			ganaste();
	}
	protected void actionPerformedButton_7(ActionEvent arg0) {
		
		if(button_3.isVisible()==false){
			mover(button_3, button_7);
			contarMovimientos();
			}
			if(button_6.isVisible()==false){
				mover(button_6,button_7);
				contarMovimientos();
			}
			if(button_11.isVisible()==false){
				mover(button_11,button_7);
				contarMovimientos();
			}

			ganaste();
	}
	protected void actionPerformedButton_8(ActionEvent arg0) {
		
		if(button_9.isVisible()==false){
			mover(button_9, button_8);
			contarMovimientos();
			}
			if(button_4.isVisible()==false){
				mover(button_4,button_8);
				contarMovimientos();
			}
			if(button_12.isVisible()==false){
				mover(button_12,button_8);
				contarMovimientos();
			}
			
			ganaste();
		
	}
	protected void actionPerformedButton_9(ActionEvent arg0) {
		

		if(button_5.isVisible()==false){
			mover(button_5, button_9);
			contarMovimientos();
			}
			if(button_10.isVisible()==false){
				mover(button_10,button_9);
				contarMovimientos();
			}
			if(button_8.isVisible()==false){
				mover(button_8,button_9);
				contarMovimientos();
			}
			if(button_13.isVisible()==false){
				mover(button_13,button_9);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	protected void actionPerformedButton_10(ActionEvent arg0) {
		

		if(button_6.isVisible()==false){
			mover(button_6, button_10);
			contarMovimientos();
			}
			if(button_9.isVisible()==false){
				mover(button_9,button_10);
				contarMovimientos();
			}
			if(button_11.isVisible()==false){
				mover(button_11,button_10);
				contarMovimientos();
			}
			if(button_14.isVisible()==false){
				mover(button_14,button_10);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	protected void actionPerformedButton_11(ActionEvent arg0) {
		
		
		if(button_7.isVisible()==false){
			mover(button_7, button_11);
			contarMovimientos();
			}
			if(button_10.isVisible()==false){
				mover(button_10,button_11);
				contarMovimientos();
			}
			if(button_15.isVisible()==false){
				mover(button_15,button_11);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	
	private void actionPerformedButton_12(ActionEvent arg0) {
		
		if(button_8.isVisible()==false){
			mover(button_8, button_12);
			contarMovimientos();
			}
			if(button_13.isVisible()==false){
				mover(button_13,button_12);
				contarMovimientos();
			}
			
			ganaste();
			
			
	}

	protected void actionPerformedButton_13(ActionEvent arg0) {
		
		if(button_9.isVisible()==false){
			mover(button_9, button_13);
			contarMovimientos();
			}
			if(button_12.isVisible()==false){
				mover(button_12,button_13);
				contarMovimientos();
			}
			if(button_14.isVisible()==false){
				mover(button_14,button_13);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	protected void actionPerformedButton_14(ActionEvent arg0) {
	
		if(button_13.isVisible()==false){
			mover(button_13, button_14);
			contarMovimientos();
			}
			if(button_10.isVisible()==false){
				mover(button_10,button_14);
				contarMovimientos();
			}
			if(button_15.isVisible()==false){
				mover(button_15,button_14);
				contarMovimientos();
			}
			
			ganaste();
		
	}
	protected void actionPerformedButton_15(ActionEvent arg0) {
		
		if(button_11.isVisible()==false){
			mover(button_11, button_15);
			contarMovimientos();
			}
			if(button_14.isVisible()==false){
				mover(button_14,button_15);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	
	public static void mover(JButton a,JButton b){
		a.setText(b.getText());
		a.setVisible(true);
		b.setVisible(false);
	}
	protected void actionPerformedBtnReiniciar(ActionEvent arg0) throws IOException {
		
		for(int i=0;i<listabotones.size();i++){
			if(listabotones.get(i).isVisible()== false){
				listabotones.get(i).setVisible(true);
			}
		}
		
		
		
		
//		ejecutarCronometro(0,0,0);
		t.stop();
		minuto=0;segundo=0;hora=0;
		actualizarLabel();
		t.start();
		
		contarmovimientos=0;
		contarMovimientos();
		
		cargarJuego();
//		labelcronometro.setText("00:00:00");
		
		
	}
	protected void actionPerformedBtnx(ActionEvent arg0) throws IOException {
		
		JUEGO2 juego3x3 =new JUEGO2();
		juego3x3.setVisible(true);
		t.stop();
		minuto=0;segundo=0;hora=0;
		actualizarLabel();
		this.dispose();
	}
	
	public static void cargarJuego() throws IOException{
		
		String BfReader="";
		
		BufferedReader bf=null;
		
		bf=getBuffered("C:\\Users\\Alumno\\workspace\\8-Puzzle\\8-Puzzle\\matriz_2.txt");
		int i=0;
		while((BfReader=bf.readLine())!= null&& i<16){
			
			
			if(BfReader.equals("16")){
				listabotones.get(i).setVisible(false);
			}
			listabotones.get(i).setText(BfReader);
			i+=1;
		}
		
//		System.out.println("\n\n");
//		while(i<texto.length()){
//			
//			resp=""+texto.charAt(i);
//			
//			System.out.print(i+":"+resp+"\n");
//			
//			if(resp=="+"){
//				resp=""+texto.charAt(i+1);
//				
//			}else{
//				resp=resp+texto.charAt(i);
//			}
//			
//			if(resp.equals("16")){
//				listabotones.get(i).setVisible(false);
//			}
//			listabotones.get(i).setText(resp);
////			
//			
//			i+=1;
//	
//		}
		
		
			
		
	}
	
	public static BufferedReader getBuffered(String direccion){
		FileReader fr= null;
		BufferedReader bf=null;
		
		
		try{
			
			File Archivo = new File(direccion);
			if(!Archivo.exists()){
				System.out.println("Error.No se encontro archivo.");
			}else{
				fr= new FileReader(direccion);
				bf= new BufferedReader(fr);
			}
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return bf;
	}
	
}
