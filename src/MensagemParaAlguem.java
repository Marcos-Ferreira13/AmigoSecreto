
public class MensagemParaAlguem extends Mensagem {
	private String emailDestinatario;
	
	public MensagemParaAlguem(String texto,String email, boolean ehAnonimo) {
		super(texto,email,ehAnonimo);
		this.emailDestinatario = email;
	}
	
	public String getDestinatario() {
		return this.emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}
	
	
	public String getTextoCompleto(){
		return "Mensagem para: "+this.emailDestinatario+ "\nTexto da mensagem:"+getTexto();
	}
}
