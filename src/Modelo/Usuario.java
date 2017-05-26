package Modelo;

public class Usuario {
	//atributos
	private String login;
	private String password;
	private String code;
	private String gender;
	//constructor
	public Usuario(String login, String password, String code, String gender) {
		super();
		this.login = login;
		this.password = password;
		this.code = code;
		this.gender = gender;
	}
	//getters y setters
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLogin() {
		return login;
	}
	//toString
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", password=" + password + ", code=" + code + ", gender=" + gender + "]";
	}
	
	
	
	

}
