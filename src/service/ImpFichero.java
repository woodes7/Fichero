package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import entidad.Usuario;

public class ImpFichero implements IntFichero {

	@Override
	public void AbrirFichero(File archivo, List<Usuario> bd) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		try  {
			fr= new FileReader(archivo);			
		}catch (FileNotFoundException  e) {
		
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
		LeerFiechero(fr,bd);
		
	}
	
	

	@Override
	public void LeerFiechero(FileReader fr, List<Usuario> bd) {
		// TODO Auto-generated method stub
		
		try {

		    BufferedReader br = new BufferedReader(fr);
		    
		    // Leer la primera línea y no hacer nada con ella
		    br.readLine();

		    String linea;
		    while ((linea = br.readLine()) != null) {
		    	GuardarUsuario(linea, bd);
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    //Como si o si pasa por aqui con el finally pues llamo al metodo cerrar
		    try {                    
		        CerrarFichero(fr);
		    } catch (Exception e2) { 
		        e2.printStackTrace();
		    }
		}
	}

	private void GuardarUsuario(String linea, List<Usuario> bd) {
		// TODO Auto-generated method stub
		//dentro le haces un split para guadarlo en un vector separando por ;
		
		String [] divi=null;
		Usuario nue =new Usuario();
		
		divi=linea.split(";");
   	 	nue.setNombre(divi[0]);
   	 	nue.setApellido(divi[1]);
   	 	nue.setEdad(Integer.parseInt(divi[2]));
   	 	nue.setFechaNacimiento(divi[3]);
   	 	bd.add(nue);
	}

	@Override
	public void CerrarFichero(FileReader fr) {
		// TODO Auto-generated method stub

		//en metodo cerrar con el try controlo si se cierra o no y con el if veo si fr se ha podido abrir
		
		try {
			if(null !=fr)
				fr.close();
			}catch (IOException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
