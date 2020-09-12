package proves;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

//import nous.Ehilo1;

import java.awt.*;
// import javax.swing.JFrame;

public class BPropulsores extends JFrame {
	public JPanel panel;
	private JLabel eti1;			
	private JButton boton2;
	int[] valors = new int[10];
	int[] potenciaactualaleatoria = new int[10];
	int lloc;
	int indice=0;
	int indicei=0;
	int indicej=0;
	JLabel[] presentacion= new JLabel[10]; 
	JLabel[] Pactual= new JLabel[10];
	JLabel[] Pfinal= new JLabel[10];
	JButton[] BtAcelera = new JButton[10];
	JButton[] Btfrena = new JButton[10];
	
	String entrada2 = JOptionPane.showInputDialog("Nombre coete que quieres ver");
	BVentana obj = new BVentana();
	String[][] vector = obj.llamadavector();
	
	public  void cargadatos() {			//he tret STATIC		//////////FET
		for (int i=0; i<vector.length; i++) {
			if (vector[i][0]!=null) {				//accedeix al bucle menomes mentres hi ha deades a lleguir
				for (int j=0; j<10; j++) {
					if (vector[i][j]!=null) {
						if (vector[i][0].equals(entrada2)) {
							indicei=i;			// es el indice on esta el mateix valor que hem entrat en el JOptionpane de dalt dintre del array
							indicej=j;			// determina el numero total de propulsors qeu te el coet que hem guardat a l' array
						}
					}
				}
			}
		}
	}
	
	public BPropulsores() {
		setBounds(50, 50, 500, 500); //posiciona i dimensiona el panel
		setTitle(" P O T E N C I A    M O T O R E S    R O C K E T S ");
		iniciarComponentes();
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	private void iniciarComponentes() {
		cargadatos();			//////////FET		
		colocarPanel();			//////////FET
		colocarEtiquetas();		//////////FET
		colocarBotones();		//////////FET
	}
	
	private void colocarPanel() {		//////////FET
		panel = new JPanel();		//declarem l panel
		panel.setLayout(null);		// incorporm el panel a la capa, sempre null
		this.add(panel);			// afegim el panel al panel	
	}
	
	private void colocarEtiquetas() {		//////////FET // etiquetas que indica el valor de la potencia del coet concret i el lloc on s'ha de situar l etiqeuta tot pasa per parametre
		eti1 = new JLabel("Propulsors del coet " + entrada2);					
		eti1.setBounds(50, 10, 240, 25);
		eti1.setFont(new Font("Comic Sans MS",1,16));
		panel.add(eti1);
		for (int i=0; i<indicej; i++) {
			int dddd = Integer.parseInt(vector[indicei][(i+1)]);
			potenciaactualaleatoria[i] = (int)(Math.random()*dddd);			//triem de forma aleatoria la potencia actual qeu no pot superar la potencia maxima
			presentacion[i] = new JLabel("P. Maxima: " + vector[indicei][(i+1)]);
			presentacion[i].setBounds(30, (i*20+80), 115, 20);
			presentacion[i].setFont(new Font("Comic Sans MS",0,15));
			panel.add(presentacion[i]);
			Pactual[i] = new JLabel("P. Actual: " + potenciaactualaleatoria[i]);
			Pactual[i].setBounds(150, (i*20+80), 115, 20);
			Pactual[i].setFont(new Font("Comic Sans MS",0,15));
			panel.add(Pactual[i]);
		}
	}
	
	private void colocarBotones() {
		for (int i=0; i<indicej; i++) {				// Botons accelerar i frenar el numero es posa en funcio dels propulsors del coet 
			BtAcelera[i] = new JButton("A");
			BtAcelera[i].setBounds(250, (i*20+80), 45, 20);
			BtAcelera[i].setFont(new Font("Arial",0,15));
			BtAcelera[i].setVisible(true);
			panel.add(BtAcelera[i]);
		}
		
		for (int i=0; i<indicej; i++) {	
			Btfrena[i] = new JButton("F");
			Btfrena[i].setBounds(300, (i*20+80), 45, 20);
			Btfrena[i].setFont(new Font("Arial",0,15));
			Btfrena[i].setVisible(true);
			panel.add(Btfrena[i]);
		}
		
		boton2 = new JButton("Sortir");						
		boton2.setBounds(30, 250, 90, 20);
		boton2.setFont(new Font("Arial",0,15));
		panel.add(boton2);

		ActionListener clikboto1 = new ActionListener() {   
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil1 = new aceleramos(Integer.parseInt(vector[indicei][1]),  potenciaactualaleatoria[0]);
				fil1.start();
				try {
					fil1.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil2 = new frenamos(Integer.parseInt(vector[indicei][1]),  potenciaactualaleatoria[0]);
				fil2.start();
				try {
					fil2.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto3 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil3 = new aceleramos(Integer.parseInt(vector[indicei][2]),  potenciaactualaleatoria[1]);
				fil3.start();
				try {
					fil3.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto4 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil4 = new frenamos(Integer.parseInt(vector[indicei][2]),  potenciaactualaleatoria[1]);
				fil4.start();
				try {
					fil4.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto5 = new ActionListener() {   /// la dada a pasar huria de ser p maxima i poencia actual
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil5 = new aceleramos(Integer.parseInt(vector[indicei][3]),  potenciaactualaleatoria[2]);
				fil5.start();
				try {
					fil5.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto6 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//				AceleraFrena.Frena(Integer.parseInt(vector[indicei][3]),  potenciaactualaleatoria[2]);
				frenamos fil6 = new frenamos(Integer.parseInt(vector[indicei][3]),  potenciaactualaleatoria[2]);
				fil6.start();
				try {
					fil6.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto7 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil7 = new aceleramos(Integer.parseInt(vector[indicei][4]),  potenciaactualaleatoria[3]);
				fil7.start();
				try {
					fil7.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
				
			}
		};
		
		ActionListener clikboto8 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil8 = new frenamos(Integer.parseInt(vector[indicei][4]),  potenciaactualaleatoria[3]);
				fil8.start();
				try {
					fil8.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto9 = new ActionListener() {   /// la dada a pasar huria de ser p maxima i poencia actual
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil9 = new aceleramos(Integer.parseInt(vector[indicei][5]),  potenciaactualaleatoria[4]);
				fil9.start();
				try {
					fil9.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto10 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil10 = new frenamos(Integer.parseInt(vector[indicei][5]),  potenciaactualaleatoria[4]);
				fil10.start();
				try {
					fil10.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto11 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil11 = new aceleramos(Integer.parseInt(vector[indicei][6]),  potenciaactualaleatoria[5]);
				fil11.start();
				try {
					fil11.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}			
			}
		};
		
		ActionListener clikboto12 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil12 = new frenamos(Integer.parseInt(vector[indicei][6]),  potenciaactualaleatoria[5]);
				fil12.start();
				try {
					fil12.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto13 = new ActionListener() {   /// la dada a pasar huria de ser p maxima i poencia actual
			@Override
			public void actionPerformed(ActionEvent ae) {
				aceleramos fil13 = new aceleramos(Integer.parseInt(vector[indicei][7]),  potenciaactualaleatoria[6]);
				fil13.start();
				try {
					fil13.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto14 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frenamos fil14 = new frenamos(Integer.parseInt(vector[indicei][7]),  potenciaactualaleatoria[6]);
				fil14.start();
				try {
					fil14.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto15 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//				AceleraFrena.Acelera(Integer.parseInt(vector[indicei][8]),  potenciaactualaleatoria[7]);
				aceleramos fil15 = new aceleramos(Integer.parseInt(vector[indicei][8]),  potenciaactualaleatoria[7]);
				fil15.start();
				try {
					fil15.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto16 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
//				AceleraFrena.Frena(Integer.parseInt(vector[indicei][8]),  potenciaactualaleatoria[7]);
				frenamos fil16 = new frenamos(Integer.parseInt(vector[indicei][8]),  potenciaactualaleatoria[7]);
				fil16.start();
				try {
					fil16.join();
				} catch (InterruptedException e) {
					System.out.println("Error " + e);
				}
			}
		};
		
		ActionListener clikboto22 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {			
				System.exit(0);
			}
		};
		

		if (indicej >= 1) {
			BtAcelera[0].addActionListener(clikboto1);
			Btfrena[0].addActionListener(clikboto2);	
		}

		if (indicej >= 2) {
			BtAcelera[1].addActionListener(clikboto3);
			Btfrena[1].addActionListener(clikboto4);
		}

		if (indicej >= 3) {
			BtAcelera[2].addActionListener(clikboto5);
			Btfrena[2].addActionListener(clikboto6);
		}

		if (indicej >= 4) {
			BtAcelera[3].addActionListener(clikboto7);
			Btfrena[3].addActionListener(clikboto8);
		}
		
		if (indicej >= 5) {
			BtAcelera[4].addActionListener(clikboto9);
			Btfrena[4].addActionListener(clikboto10);
		}
		
		if (indicej >= 6) {
			BtAcelera[5].addActionListener(clikboto11);
			Btfrena[5].addActionListener(clikboto12);
		}
		
		if (indicej >= 7) {
			BtAcelera[6].addActionListener(clikboto13);
			Btfrena[6].addActionListener(clikboto14);
		}

		if (indicej >= 8) {
			BtAcelera[7].addActionListener(clikboto15);
			Btfrena[7].addActionListener(clikboto16);
		}
		
		boton2.addActionListener(clikboto22);
	}
}


class AceleraFrena extends Thread{
	public int potmaxima;
	public int potactual;
	public int diferencia;
}

class frenamos extends Thread{
	public int potmaxima;
	public int potactual;
	public int diferencia;
	
	public frenamos(int potmaxima, int potactual) {
		this.potmaxima=potmaxima;
		this.potactual=potactual;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		diferencia=potmaxima-potactual;
		System.out.println(" ");
		System.out.print("P. Actual=> " + potactual + " " );
		for (int i = potactual; i >= 0; i--) {
			System.out.print("<" );			//+ i+ " ");
			try {
				frenamos.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Error " + e);
			}
		}
		System.out.print("P. Final: 0" );
	}
}

class aceleramos extends Thread{
	public int potmaxima;
	public int potactual;
	public int diferencia;
	
	public aceleramos(int potmaxima, int potactual) {
		this.potmaxima=potmaxima;
		this.potactual=potactual;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		diferencia=potmaxima-potactual;
		System.out.println("");
		System.out.print("P. Actual=> " + potactual + " -- " );
		for (int i = 0; i <= diferencia; i++) {
			System.out.print(">");					//+ i + " > ");
			try {
				aceleramos.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Error " + e);
			}
		}
		System.out.print("P. Final: "+ potmaxima  );
	}
}

