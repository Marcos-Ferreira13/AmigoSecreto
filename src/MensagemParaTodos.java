
public class MensagemParaTodos extends Mensagem {
	
	
	public MensagemParaTodos() {
		this("","",false);
	}
	public MensagemParaTodos(String texto,String emailRemetente,boolean ehAnonima) {
		super(texto,emailRemetente,ehAnonima);
	}
	
	public String getTextoCompleto() {
		if(super.ehAnonima()) {
			return "Mensagem para todos\nTexto: "+ super.getTexto();
		}else {
			return "Mensagem de " + super.getEmailRemetente() + " Para todos\n" +"Texto:" + super.getTexto();
		}
		
		
	}
	
	
}
