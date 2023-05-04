package service;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import entidad.Usuario;

public interface IntFichero {
	
	public void AbrirFichero(File archivo,List<Usuario>bd);
	
	public void LeerFiechero(FileReader fr,List<Usuario>bd);
	
	public void CerrarFichero(FileReader fr);
	
}
