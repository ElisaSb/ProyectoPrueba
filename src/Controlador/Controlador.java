package Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.Vista;;

public class Controlador implements ActionListener {
	
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();

	private Vista vista;
	private List<Usuario> listaUsuarios;
	
	public Controlador(Vista vista, UsuarioDAO userdao) {
		this.vista = vista;
		actionListener(this);
		mostrarUsuario(0);
	}
	
	public static List<Usuario> obtenerDatosCSV() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		try {
			Scanner in = new Scanner(new File("BD/Datos/user.csv"));
			String cabecera = in.nextLine();
			while (in.hasNextLine()){
				String[] datos = in.nextLine().split(",");
				Usuario usuario = new Usuario(datos[0].trim(), datos[1].trim(), datos[2].trim(), datos[3].trim());
				listaUsuarios.add(usuario);
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado");
		}
		salvarDatos(listaUsuarios);
		return listaUsuarios;
	}
	
	private static void salvarDatos(List<Usuario> listaUsuario) {
		for (Usuario usuario : listaUsuario) {
			usuarioDAO.añadirUsuario(usuario);
		}
	}
	
	private void mostrarUsuario(int indice) {
		vista.getTextFieldLogin().setText(listaUsuarios.get(indice).getLogin());
		vista.getTextFieldPassword().setText(listaUsuarios.get(indice).getPassword());
		vista.getTextFieldCode().setText(listaUsuarios.get(indice).getCode());
		vista.getTextFieldGender().setText(listaUsuarios.get(indice).getGender());
	}
	
	private void actionListener(ActionListener escuchador) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		System.out.println(obtenerDatosCSV());
	}
}
