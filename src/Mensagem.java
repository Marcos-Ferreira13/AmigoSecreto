
public abstract class Mensagem {
	private String texto;
	private String emailRemetente;
	private boolean anonimo;
	
	
	public Mensagem() {
		this("","",false);
	}


	public Mensagem(String texto, String email, boolean anonimo) {
		this.texto = texto;
		this.emailRemetente = email;
		this.anonimo = anonimo;
	}
	
	public abstract String getTextoCompleto();
	
	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public String getEmailRemetente() {
		return emailRemetente;
	}


	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}


	public boolean ehAnonima() {
		return this.anonimo;
	}


	@Override
	public String toString() {
		return "texto=" + texto + "\n emailRemetente=" + emailRemetente + "\n anonimo=" + anonimo+"\n";
	}
	
	
}
