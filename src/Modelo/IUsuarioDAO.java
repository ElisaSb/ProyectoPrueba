package Modelo;

import java.util.List;

import Modelo.Usuario;

public interface IUsuarioDAO {
	
	List<Usuario> getListaUsuarios();
	
	boolean aņadirUsuario(Usuario usuario);
}
