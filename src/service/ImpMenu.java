package service;

public class ImpMenu implements IntMenu {

	@Override
	public void MostrarMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. Leer el fichero que tu digas(indicando la ruta)");
		System.out.println("2. Leer fichero por defecto");
		System.out.println("3. Salir");
	}

	@Override
	public void MostrarMenuRepetir() {
		// TODO Auto-generated method stub
		System.out.println("1. Leer otro fichero");
		System.out.println("2. Mostrar");
	}

}
