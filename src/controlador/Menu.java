package controlador;

import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;


import entidad.Usuario;
import service.ImpFichero;
import service.ImpMenu;
import service.IntFichero;
import service.IntMenu;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String menu="";
		int opcion;	
		
		IntMenu iM =new ImpMenu();
		IntFichero iMF= new ImpFichero();
		
		Scanner entOpcion =new Scanner(System.in);
		
		Boolean cerrarMenu = false;
		
		List<Usuario> bd=new ArrayList<Usuario>();
		
		while(!cerrarMenu) {	
			//Mostramos el menú
			iM.MostrarMenu();
			System.out.println("Introduza la opción deseada: ");
			opcion = entOpcion.nextInt();
			System.out.println("[INFO] - Has seleccionado la opcion " + opcion);
			switch (opcion) {			
				case 1: //Pide una ruta para leer un fichero
					 menu=entOpcion.next();				
					break;
				case 2: //Ruta por defecto(Cambia la  ruta a la que desees)
					 menu="C:\\Users\\pablo\\OneDrive\\Escritorio\\Fichero.txt";		
					break;
				case 3: //Cerrar menu
					cerrarMenu = true;
					break;
				
				default:

			}
			if(opcion==1||opcion==2)
			{
				boolean error;
				do {
					error=false;
					//Menu para saber si el usuario quiere leer otro fichero o mostrar
					iM.MostrarMenuRepetir();
					System.out.println("Introduza la opción deseada: ");
					int repetir=entOpcion.nextInt();
					File archivo = new File (menu);
					iMF.AbrirFichero(archivo, bd);
					 //Controla si le das al 1 o al dos 
					if(repetir==2)
					{
						System.out.println("------------------------Los usuarios son----------------");
						for(Usuario cadaUsuario:bd)
						System.out.println(cadaUsuario.toString());
						System.out.println("-------------------------------------------------------");
					}
					else if(repetir!=2&&repetir!=1)
					{
						System.out.println("Error introduce 1 o 2");
						error=true;
					}
						
				}while(error);
				
				 				
			}
		}
	}
}

