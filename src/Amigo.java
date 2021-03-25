
public class Amigo {
	private String nome;
	private String email;
	private String emailSorteado;
	
	
	
	public Amigo(String amigo,String emailAmigo) {
		this.nome = amigo;
		this.email = emailAmigo;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEmailSorteado() {
		return emailSorteado;
	}



	public void setEmailSorteado(String emailSorteado) {
		this.emailSorteado = emailSorteado;
	}



	@Override
	public String toString() {
		return "nome=" + nome + "\nemail=" + email + "\nemailSorteado=" + emailSorteado;
	}
	
	
}
