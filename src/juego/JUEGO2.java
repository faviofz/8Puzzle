package juego;


import java.util.*;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Font;
import javax.swing.JButton;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

import javax.swing.JMenuBar;

import javax.swing.JOptionPane;


import java.awt.Color;
import java.awt.EventQueue;

public class JUEGO2 extends JFrame implements ActionListener {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JPanel panel;
	protected JButton button;
	protected JButton button_1;
	protected JButton button_2;
	protected JButton button_3;
	protected JButton button_4;
	protected JButton button_5;
	protected JButton button_6;
	protected JButton button_7;
	protected JButton button_8;
	private JLabel lblMovimientos;
	private JLabel lblTiempo;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTiempo_1;
	private JLabel lblMovimientos_1;
	private JLabel lblBestScore;
	private JMenuBar menuBar;
	private JButton btnJugar;
	private JButton btnJugarx;
	static int contarmovimientos=1;
	private JTextField textField;
	private static JLabel labelcronometro;
	private JTextField textField_1;
	private JLabel label_1;
	
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
	    
//	static int segundo=0,minutos=0,hora=0;
//	Thread cronometro = new Thread();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JUEGO2 frame = new JUEGO2();
					frame.setIconImage(new ImageIcon(getClass().getResource("/imagenes/8-32.jpg")).getImage());
					frame.setVisible(true);
					frame.setTitle("8-Puzzle");
					
					
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
	public JUEGO2() throws IOException {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 350);
		
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		btnJugar = new JButton("Reiniciar");
		menuBar.add(btnJugar);
		btnJugar.addActionListener(this);
		
		btnJugarx = new JButton("jugar  4x4");
		menuBar.add(btnJugarx);
		btnJugarx.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(135, 206, 235));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panel_2.setLayout(null);
		
		lblTiempo_1 = new JLabel("Tiempo:");
		lblTiempo_1.setFont(new Font("Khmer UI", Font.PLAIN, 12));
		lblTiempo_1.setBounds(10, 22, 70, 14);
		panel_2.add(lblTiempo_1);
		
		lblMovimientos_1 = new JLabel("Movimientos:");
		lblMovimientos_1.setFont(new Font("Khmer UI", Font.PLAIN, 12));
		lblMovimientos_1.setBounds(10, 68, 82, 14);
		panel_2.add(lblMovimientos_1);
		
		lblBestScore = new JLabel("Best Score");
		lblBestScore.setFont(new Font("Khmer UI", Font.PLAIN, 12));
		lblBestScore.setBounds(22, 0, 70, 14);
		panel_2.add(lblBestScore);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(107, 65, 60, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		label_1 = new JLabel("00:00:00");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(78, 22, 72, 14);
		panel_2.add(label_1);
		panel_1.setLayout(null);
		
		lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setFont(new Font("Khmer UI", Font.PLAIN, 12));
		lblTiempo.setBounds(18, 5, 63, 14);
		panel_1.add(lblTiempo);
		
		lblMovimientos = new JLabel("Movimientos:");
		lblMovimientos.setFont(new Font("Khmer UI", Font.PLAIN, 12));
		lblMovimientos.setBounds(18, 50, 96, 14);
		panel_1.add(lblMovimientos);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(104, 47, 63, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		labelcronometro = new JLabel("00:00:00");
		labelcronometro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelcronometro.setBounds(81, 6, 86, 14);
		panel_1.add(labelcronometro);
		panel.setLayout(null);
		
		
		
		button = new JButton("");
		button.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button.addActionListener(this);
		button.setBounds(0, 11, 85, 64);
		panel.add(button);
		
		button_1 = new JButton("");
		button_1.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_1.addActionListener(this);
		button_1.setBounds(85, 11, 85, 64);
		panel.add(button_1);
		
		button_2 = new JButton("");
		button_2.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_2.addActionListener(this);
		button_2.setBounds(170, 11, 85, 64);
		panel.add(button_2);
		
		button_3 = new JButton("");
		button_3.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_3.addActionListener(this);
		button_3.setBounds(0, 75, 85, 64);
		panel.add(button_3);
		
		button_4 = new JButton("");
		button_4.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_4.addActionListener(this);
		button_4.setBounds(85, 75, 85, 64);
		panel.add(button_4);
		
		button_5 = new JButton("");
		button_5.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_5.addActionListener(this);
		button_5.setBounds(170, 75, 85, 64);
		panel.add(button_5);
		
		button_6 = new JButton("");
		button_6.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_6.addActionListener(this);
		button_6.setBounds(0, 138, 85, 64);
		panel.add(button_6);
		
		button_7 = new JButton("");
		button_7.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_7.addActionListener(this);
		button_7.setBounds(85, 138, 85, 64);
		panel.add(button_7);
		
		button_8 = new JButton("");
		button_8.setFont(new Font("Ebrima", Font.ITALIC, 18));
		button_8.addActionListener(this);
		button_8.setBounds(170, 138, 85, 64);
		panel.add(button_8);
		
		contentPane.setLayout(gl_contentPane);
		
//		cronometro.start();
		
		listabotones=new ArrayList<JButton>();
		
		listabotones.add(button);
		listabotones.add(button_1);
		listabotones.add(button_2);
		listabotones.add(button_3);
		listabotones.add(button_4);
		listabotones.add(button_5);
		listabotones.add(button_6);
		listabotones.add(button_7);
		listabotones.add(button_8);
		
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
			button_8.setText("9");
			button_8.setVisible(true);
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
		
		
	
	
	
	public void contarMovimientos(){
		textField.setText(String.valueOf(contarmovimientos++));
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnJugarx) {
			try {
				actionPerformedBtnJugarx(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == btnJugar) {
			try {
				actionPerformedBtnJugar(arg0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (arg0.getSource() == button_8) {
			actionPerformedBtnNewButton(arg0);
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
	protected void actionPerformedButton(ActionEvent arg0) {
		if(button_1.isVisible()==false){
			mover(button_1, button);
			contarMovimientos();
			}
			if(button_3.isVisible()==false){
				mover(button_3,button);
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
			if(button_4.isVisible()==false){
				mover(button_4,button_1);
				contarMovimientos();
			}
			
			ganaste();
			
	}
	protected void actionPerformedButton_2(ActionEvent arg0) {
		if(button_5.isVisible()==false){
			mover(button_5, button_2);
			contarMovimientos();
			}
			if(button_1.isVisible()==false){
				mover(button_1,button_2);
				contarMovimientos();
			}
			
			ganaste();
	}
	protected void actionPerformedButton_3(ActionEvent arg0) {
		if(button.isVisible()==false){
			mover(button, button_3);
			contarMovimientos();
			}
			if(button_4.isVisible()==false){
				mover(button_4,button_3);
				contarMovimientos();
			}
			if(button_6.isVisible()==false){
				mover(button_6,button_3);
				contarMovimientos();
			}
			
			ganaste();
		
		
	}
	protected void actionPerformedButton_4(ActionEvent arg0) {
		
		if(button_5.isVisible()==false){
			mover(button_5, button_4);
			contarMovimientos();
			}
			if(button_1.isVisible()==false){
				mover(button_1,button_4);
				contarMovimientos();
			}
			if(button_7.isVisible()==false){
				mover(button_7,button_4);
				contarMovimientos();
			}
			if(button_3.isVisible()==false){
				mover(button_3,button_4);
				contarMovimientos();
			}
			
			ganaste();
			
	}
	protected void actionPerformedButton_5(ActionEvent arg0) {
		if(button_8.isVisible()==false){
		mover(button_8, button_5);
		contarMovimientos();
		}
		if(button_4.isVisible()==false){
			mover(button_4,button_5);
			contarMovimientos();
		}
		if(button_2.isVisible()==false){
			mover(button_2,button_5);
			contarMovimientos();
		}
		
		ganaste();
		
	}
	protected void actionPerformedButton_6(ActionEvent arg0) {
		if(button_7.isVisible()==false){
			mover(button_7, button_6);
			contarMovimientos();
			}
			if(button_3.isVisible()==false){
				mover(button_3,button_6);
				contarMovimientos();
			}
			
			ganaste();
			
	}
	protected void actionPerformedButton_7(ActionEvent arg0) {
		
		if(button_4.isVisible()==false){
			mover(button_4, button_7);
			contarMovimientos();
			}
			if(button_6.isVisible()==false){
				mover(button_6,button_7);
				contarMovimientos();
			}
			if(button_8.isVisible()==false){
				mover(button_8,button_7);
				contarMovimientos();
			}
			
			ganaste();
			
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		if(button_5.isVisible()==false){
			mover(button_5, button_8);
			contarMovimientos();
			}
			if(button_7.isVisible()==false){
				mover(button_7,button_8);
				contarMovimientos();
			}
			
			ganaste();
	}
	
	public static void mover(JButton a,JButton b){
		a.setText(b.getText());
		a.setVisible(true);
		b.setVisible(false);
	}
	
	protected void actionPerformedBtnJugar(java.awt.event.ActionEvent evt) throws IOException{
//		int minuto,segundo,hora;
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
	protected void actionPerformedBtnJugarx(ActionEvent arg0) throws IOException {
		
		JUEGO4x4 juego4x4 =new JUEGO4x4();
		juego4x4.setVisible(true);
		t.stop();
		minuto=0;segundo=0;hora=0;
		actualizarLabel();
		this.dispose();
		
		
	}
	
	
	public static void cargarJuego() throws IOException{
		String texto= "";
		String BfReader="";
		String resp;
		BufferedReader bf=null;
		
		String ruta=new String("./8-puzzle/matriz.txt");
		bf=getBuffered(ruta);
		
		while((BfReader=bf.readLine())!= null){
			texto+=BfReader;
		}
		
		for(int i=0;i<texto.length();i++){
			resp=""+texto.charAt(i);
			if(resp.equals("9")){
				listabotones.get(i).setVisible(false);
			}
			listabotones.get(i).setText(resp);
		}
	
	
		
		
			
		
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
