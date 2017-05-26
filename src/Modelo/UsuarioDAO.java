package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {
	private static UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private static Connection conexion = Conexion.getInstance();
	String sql;
	PreparedStatement preparedStatement;
	
	public List<Usuario> getListaUsuarios() {
		// select * from user order by login;
		List<Usuario> listaUsuarios = new ArrayList<>();
		String sql = "SELECT * FROM user ORDER BY login";
		try {
			Statement statement = conexion.createStatement();
			ResultSet resulset = statement.executeQuery(sql);
			while(resulset.next()){
				String login = resulset.getString("login");
				String password = resulset.getString("password");
				String code = resulset.getString("code");
				String gender = resulset.getString("gender");
				Usuario usuario = new Usuario(login, password, code, gender);
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("Error en la lectura de la BD");
		}
		return listaUsuarios;
	}

	@Override
	public boolean añadirUsuario(Usuario usuario) {
		boolean accion = false;
		sql = "INSERT INTO user VALUES (?, ? , ?, ?)";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getPassword());
			preparedStatement.setString(3, usuario.getCode());
			preparedStatement.setString(4, usuario.getGender());
			int filas = preparedStatement.executeUpdate();
			if (filas != 0)
				accion = true;
		} catch (SQLException e) {
			System.out.println("Error al añadir el usuario");
		}
		return accion;
	}
	public static void main(String[] args) {
		//Usuario usuario = new Usuario("ElisaSb", "777", "ID", "Female");
		//usuarioDAO.añadirUsuario(usuario);
	}
}
