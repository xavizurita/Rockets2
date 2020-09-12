package proves;

import java.util.Scanner;
import javax.swing.JOptionPane;
public class BPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			BVentana v1 = new BVentana();		// obrim  fienstra 1
			v1.setSize(600,400);
			v1.setVisible(true);
			v1.setLocation(10, 30);
			
			

/*
			// aqui s'ha de carregar les dades de l'array que ve de BVentana i carregarr la finestra de les potencies del motor
		Scanner entrada=new Scanner(System.in);
		System.out.println("vols veure les dades");
		String siono=entrada.nextLine();
/*			BVentana obj = new BVentana();
			String[][] vector = obj.llamadavector();
			vector[0][0]="Apolo";		//carregem una valor per veure que funciona no per res mes
			vector[1][0]="Buran";		//carregem una valor per veure que funciona no per res mes			
			vector[2][0]="Soyuz";		//carregem una valor per veure que funciona no per res mes	
			for (int i=0; i<vector.length; i++) {
				if (vector[i][0]!=null) {
					for (int j=0; j<10; j++) {
						System.out.print(i +""+ j + " " + vector[i][j]);	// pendent de IF per controlar NULL de segon bucle
						System.out.print(" - " );		
					}
					System.out.println("");	
				}

			}
			
			BPropulsores v2 = new BPropulsores();
			v2.setSize(425,400);
			v2.setVisible(true);
			v2.setLocation(620, 30);
*/			
/*			for (int i=0; i<dadestotals.length; i++) {		// averigua l'ultim registre valid de l'array I A LA "I" INTRODUEIX EL NOM DEL COET
				if (dadestotals[i][0]==null) {
					dadestotals[i][0] = NomCoet.getText();
					System.out.print(dadestotals.length + " " + i + " " + dadestotals[i][0] + " " + Potenciapropulsor.length); 
					for (int j=0; j<Integer.parseInt(NumPropulsors.getText()); j++) {	 // AVERIGUA EL NUMERO DE PROPULSORS I CARREGA EN LA FILA DEL AARAY ELS VALORS		
						dadestotals[i][j+1] = Potenciapropulsor[j].getText();
						if (Potenciapropulsor[j]!=null) {
							System.out.print(" " + i + (j+1) + " "+ dadestotals[i][j+1] );
						}
					}
					i=dadestotals.length;
				}
				System.out.println(" ");
			}
*/			
/*		BVentana.cosa();
		BVentana sorpresa = new BVentana();
		String[][] dadestotals = new String[10][10];
		for (int i=0; i<5; i++) {
			System.out.println(dadestotals[i][0]);
		}
		System.out.println(sorpresa.getValors() + " ww");			//.get[1][1]);

//		BVentana v2 = new BVentana();
//		v2.setSize(800,600);
//		v2.setVisible(true);
		
*/		
	}

}
