package proves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BVentana extends JFrame{
	private JPanel panel;
	private JLabel eti1, eti2, eti3, saludo, saludo2, saludo3, saludo4,  etiquetapropulsor ;
	private JTextField NomCoet, NumPropulsors;
	private JButton boton1, boton2, boton3, boton4;
	JTextField[] Potenciapropulsor = new JTextField[10];
	JLabel[] etiquetadades = new JLabel[10];
	JLabel[] etiquetapropulsorr = new JLabel[10];
	public static String[][] dadestotals = new String[10][10];			//public ¿?
	public static String[][] dadesprova = new String[10][10];			//public ¿?
	int[] valors = new int[10];
	int lloc;
	
	public String[][] llamadavector() {
/*		dadesprova[0][0]="Apolo";		//carregem una valor per veure que funciona no per res mes
		dadesprova[1][0]="Buran";		//carregem una valor per veure que funciona no per res mes			
		dadesprova[2][0]="Soyuz";		//carregem una valor per veure que funciona no per res mes	
		dadesprova[0][1]="10";		//carregem una valor per veure que funciona no per res mes
		dadesprova[0][2]="30";		//carregem una valor per veure que funciona no per res mes			
		dadesprova[1][1]="70";		//carregem una valor per veure que funciona no per res mes			
		dadesprova[2][1]="125";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][2]="65";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][3]="34";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][4]="23";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][5]="89";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][6]="234";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][7]="13";		//carregem una valor per veure que funciona no per res mes
		dadesprova[2][8]="2";		//carregem una valor per veure que funciona no per res mes
*/		
//aquest bucle es bo, nomes qu esta aixi per tenir dades carregdes d'exemple i no ternir que picarles cadad cop
		for (int i=0; i<dadestotals.length; i++) {
			for (int j=0; j<10; j++) {
				dadestotals[i][j]=String.valueOf((int)(Math.random()*10));
				dadesprova[i][j] = dadestotals[i][j];
			}
		}
		return dadesprova;
	}
	
	public BVentana() {
		setBounds(50, 50, 500, 500); //posiciona i dimensiona el panel
		setTitle(" E N T R A D A    R O C K E T S ");
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	private void iniciarComponentes() {
		colocarPanel();
		colocarEtiquetas();
		colocarCajasTexto();
		colocarBotones();
	}
	
	private void colocarPanel() {
		panel = new JPanel();		//declarem l panel
		panel.setLayout(null);		// incorporm el panel a la capa, sempre null
		this.add(panel);			// afegim el panel al panel	
	}
	
	private void colocarEtiquetas() {
		eti1 = new JLabel("INTRODUCIO DADES");
		eti1.setBounds(50, 10, 240, 20);
		eti1.setFont(new Font("Comic Sans MS",1,20));
		panel.add(eti1);
		eti2 = new JLabel("Nom Coet ");
		eti2.setBounds(30, 80, 80, 20);
		eti2.setFont(new Font("Comic Sans MS",0,15));
		panel.add(eti2);
		eti3 = new JLabel("Num. Propulsors");
		eti3.setBounds(30, 120, 150, 20);
		eti3.setFont(new Font("Comic Sans MS",0,15));
		panel.add(eti3);
	}
	
	public void colocarEtiquetas2(int cantidad, int visible) {
		for (int i=0; i<cantidad; i++) {
			if (visible == 0) {
				etiquetapropulsorr[i] = new JLabel();
				etiquetapropulsorr[i].setBounds(310, (i*20+10), 200, 20);
				etiquetapropulsorr[i].setFont(new Font("Comic Sans MS",0,12));
				etiquetapropulsorr[i].setText("Potencia Propulsor: (" + (i+1) + ") " );
				panel.add(etiquetapropulsorr[i]);
				Potenciapropulsor[i] = new JTextField();
				Potenciapropulsor[i].setBounds(450, (i*20+10), 50, 20);
				Potenciapropulsor[i].setVisible(true);
				etiquetapropulsorr[i].setVisible(true);
				panel.add(Potenciapropulsor[i]);
			}else {
				etiquetapropulsorr[i].setVisible(false);
				panel.add(etiquetapropulsorr[i]);
				Potenciapropulsor[i].setVisible(false);
				panel.add(Potenciapropulsor[i]);
			}
		}
	}
	
	public void colocarEtiquetas3(int valor, int lloc) {
		etiquetadades[2] = new JLabel();
		etiquetadades[2].setBounds(10, 400, 200, 20);
		etiquetadades[2].setFont(new Font("Comic Sans MS",0,12));
		etiquetadades[2].setText("Potencia ProPUlsor: ");
		panel.add(etiquetadades[2]);
		
		etiquetadades[1] = new JLabel();
		etiquetadades[1].setBounds((lloc+110), 400, 200, 20);
		etiquetadades[1].setFont(new Font("Comic Sans MS",0,12));
		etiquetadades[1].setText(" " + valor + ", " );
		panel.add(etiquetadades[1]);
	}
	
	private void colocarCajasTexto() {
		NomCoet = new JTextField();
		NomCoet.setBounds(150, 80, 130, 20);
		panel.add(NomCoet);
		
		NumPropulsors = new JTextField();
		NumPropulsors.setBounds(150, 120, 130, 20);
		panel.add(NumPropulsors);
	}
	
	private void colocarBotones() {
		boton2 = new JButton("Sortir");
		boton2.setBounds(30, 160, 90, 20);
		boton2.setFont(new Font("Arial",0,15));
		panel.add(boton2);
		
		boton3 = new JButton("Añadir Potencias");
		boton3.setBounds(130, 160, 150, 20);
		boton3.setFont(new Font("Arial",0,15));
		panel.add(boton3);

		boton1 = new JButton("Mostrar Registros");
		boton1.setBounds(130, 190, 150, 20);
		boton1.setFont(new Font("Arial",0,15));
		panel.add(boton1);
		
		boton4 = new JButton("Guardar Potencias");
		
		saludo = new JLabel();
		saludo.setBounds(50, 350, 200, 20);
		saludo.setFont(new Font("Arial",1,20));
		panel.add(saludo);
		
		saludo2 = new JLabel();
		saludo2.setBounds(50, 380, 200, 20);
		saludo2.setFont(new Font("Arial",1,20));
		panel.add(saludo2);
		
		saludo3 = new JLabel();
		saludo3.setBounds(50, 10, 400, 20);
		saludo3.setFont(new Font("Arial",1,20));
		panel.add(saludo3);
		
		ActionListener clikboto1 = new ActionListener() {		//	boton1 = new JButton("Mostrar Registros");
			@Override
			public void actionPerformed(ActionEvent ae) {
				BDades v3 = new BDades();
				v3.setSize(600,300);
				v3.setVisible(true);
				v3.setLocation(10,220);
				int i=0;												///// Presenta els resultas guardas totals en l'array
				while (dadestotals[i][0]!=null) {
					for (int h=0; (dadestotals[i][h]!=null); h++) {
					}
					i++;
				}				
			}
		};
		
		ActionListener clikboto2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {			
				System.exit(0);
			}
		};
		
		ActionListener clikboto3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				
				saludo4 = new JLabel();
				saludo4.setBounds(310, 10, 400, 200);
				saludo4.setFont(new Font("Arial",0,15));
				panel.add(saludo4);
				
				String NumPropulsorsdades = NumPropulsors.getText();
				int valorpropulsores=Integer.parseInt(NumPropulsorsdades);
				if (valorpropulsores>=9) {
					valorpropulsores=8;
					JOptionPane.showMessageDialog(null, "El numero máximo propulsores es de 8"); //totaldades1 + "\n" + totaldades2, "Nom i Propulsors del coet:", JOptionPane.ERROR_MESSAGE);
				}
				// no esta clar perque pero s'ha de pòsar aquezt bloc perqeu si no no surten les etiquetes ni res de la potencia
				etiquetapropulsor=new JLabel();
				etiquetapropulsor.setFont(new Font("Comic Sans MS",0,12));
				saludo4.setText(" "); 
				panel.add(etiquetapropulsor);
				
				colocarEtiquetas2(valorpropulsores, 0);
				boton4.setBounds(350, (valorpropulsores*20+20), 150, 20);
				boton4.setFont(new Font("Arial",0,12));
				boton4.setVisible(true);
				panel.add(boton4);
	
			}
		};
		
		ActionListener clikboto4 = new ActionListener() {		//boto 4 guardar potencies
			@Override
			public void actionPerformed(ActionEvent ae) {
				int tonto=0;
				for (int i=0; i<Potenciapropulsor.length; i++) {		// averigua l'ultim registre valid de l'array
					if (Potenciapropulsor[i]==null) {
						tonto=i-1;
						i=Potenciapropulsor.length;
					}
				}
				
				int p=0;						// bucle que carrega les dades per presentarles despres de cop en el JOptionPane
				String presentaciodades1 = "";
				String presentaciodades2 = NomCoet.getText();
				for ( p=0; p<Integer.parseInt(NumPropulsors.getText()); p++) {
					presentaciodades1 = presentaciodades1 + ", " + Potenciapropulsor[p].getText();
				}
	
				for (int i=0; i<dadestotals.length; i++) {		// averigua l'ultim registre valid de l'array I A LA "I" INTRODUEIX EL NOM DEL COET
					if (dadestotals[i][0]==null) {
						dadestotals[i][0] = NomCoet.getText();
//						System.out.print(dadestotals[i][0] + " " );
						for (int j=0; j<Integer.parseInt(NumPropulsors.getText()); j++) {	 // AVERIGUA EL NUMERO DE PROPULSORS I CARREGA EN LA FILA DEL AARAY ELS VALORS		
							dadestotals[i][j+1] = Potenciapropulsor[j].getText();
							if (Potenciapropulsor[j]!=null) {
//								System.out.print(" "+ dadestotals[i][j+1] );
							}
						}
						i=dadestotals.length;
					}
//					System.out.println(" ");
				}
				
				for (int i=0; i<=tonto; i++) {		//netega els camps de la potencia propulsors
					Potenciapropulsor[i].setText(null);
					Potenciapropulsor[i].setText("");
				}
				JOptionPane.showMessageDialog(null, "nom coet: " + presentaciodades2 + "\nPotencia motors "+ presentaciodades1 );
				boton4.setVisible(false);
				int valorpropulsores=Integer.parseInt(NumPropulsors.getText());
				NomCoet.setText(null);
				NumPropulsors.setText(null);
				colocarEtiquetas2(valorpropulsores, 1);
				llamadavector();
			}
		};
    		boton1.addActionListener(clikboto1);
    		boton2.addActionListener(clikboto2);
    		boton3.addActionListener(clikboto3);
    		boton4.addActionListener(clikboto4);
	}
}
