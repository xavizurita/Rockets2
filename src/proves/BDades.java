package proves;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BDades extends JFrame{
	private JPanel panel10;
	private JLabel etik1, etik2, etik3, etiinfo;
	private JButton boton1;
	int indicei, indicej;
	JTextField nomaveure = new JTextField();
	public static String[][] dadeseti = new String[10][10];
	public static String[] acumuladades = new String[10];
	JLabel[] etiquetapres = new JLabel[10];
	
	BVentana obj = new BVentana();
	String[][] vector = obj.llamadavector();
	
	public   void cargadatos() {			//////////FET
		int i=0;
		while (vector[i][0]!=null) {
			acumuladades[i]="";
			for (int h=0; (vector[i][h]!=null); h++) {
				acumuladades[i]=acumuladades[i] + vector[i][h] + " ";
			}
			i++;
		}
	}

	public BDades() {
		setBounds(30, 30, 500, 500); //posiciona i dimensiona el panel
		setTitle("DADES DE COETS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		iniciarComponentes();
	}
	
	private void iniciarComponentes() {
		cargadatos();
		colocarPanel();
		colocarEtiquetas();
		colocarText();
		colocarBoto();
	}
	
	private void colocarPanel() {
		panel10 = new JPanel();		//declarem l panel
		panel10.setLayout(null);		// incorporm el panel a la capa, sempre null
		this.add(panel10);			// afegim el panel al panel	
	}
	
	private void colocarEtiquetas() {
		for (int i=0; i<acumuladades.length; i++) {
			if (acumuladades[i]!=null) {
				etiquetapres[i] = new JLabel();	//(acumuladades[i]);
				etiquetapres[i].setBounds(10, (i*20+20), 250, 20);
				etiquetapres[i].setFont(new Font("Comic Sans MS",0,14));
				etiquetapres[i].setText(acumuladades[i]);
				panel10.add(etiquetapres[i]);
			}
		}
	}
	
	private void colocarText() {
	
	}
	
	private void colocarBoto() {
		boton1 = new JButton("Arranca motores");
		boton1.setBounds(75, 220, 150, 20);
		boton1.setFont(new Font("Arial",1,14));
		panel10.add(boton1);
		
		ActionListener clikboto1 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				BPropulsores v2 = new BPropulsores(); 				// arrencar tota la finestra BPropulsores
				v2.setSize(425,400);
				v2.setVisible(true);
				v2.setLocation(620, 30);
			}
		};
		boton1.addActionListener(clikboto1);
	}
}
