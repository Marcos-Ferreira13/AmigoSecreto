import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
	List<Mensagem>mensagens;
	List<Amigo> amigos;
	private int quantMensagensEnviadas = 0;
	
	
	
	public SistemaAmigo() {
		this.mensagens = new ArrayList<>();
		this.amigos =new ArrayList<>();
	}
	
	public void cadastraAmigo(String nomeAmigo,String emailAmigo) {
		Amigo novoAmigo = new Amigo (nomeAmigo,emailAmigo);
		this.amigos.add(novoAmigo);
		
		
		
	}
	
	public Amigo pesquisaAmigo(String nomeAmigo) {
		Amigo amigoAchado = null;
		for(Amigo amigos :amigos) {
			if(amigos.getNome().equalsIgnoreCase(nomeAmigo)){
				amigoAchado = amigos;
			}
		}
		return amigoAchado;
	}

	
	public void enviarMensagemParaTodos(String texto,String emailRemetente,boolean ehAnonima) {
		MensagemParaTodos novaMensagem = new MensagemParaTodos(texto,emailRemetente,ehAnonima);
		this.mensagens.add(novaMensagem);
	}
	
	public void enviarMensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario,boolean ehAnonima) {
		MensagemParaAlguem novaMensagem = new MensagemParaAlguem(texto,emailRemetente,ehAnonima);
		this.mensagens.add(novaMensagem);
	}
	
	
	
	
	public List<Mensagem> pesquisaMensagensAnonimas(){
		ArrayList<Mensagem> mensagensAnonimas = new ArrayList<>();
		for(Mensagem msg :mensagens) {
			if(msg.ehAnonima()) {
				mensagensAnonimas.add(msg);
			}
		}
		return mensagensAnonimas;
	}
	
	public List<Mensagem> pesquisaTodasAsMensagens(){
		List<Mensagem> msgs = new ArrayList<>();
		
		for(Mensagem msg :mensagens) {
			msgs.add(msg);
		}
		
		return msgs;
	}
	public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException,AmigoNaoSorteadoException {
		boolean amigoAchado = false;
		for(Amigo amigo : amigos) {
			if(amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
				amigoAchado = true;
				
				if(amigo.getEmailSorteado() == null) {
					throw new AmigoNaoSorteadoException("Amigo n�o sorteado");
				}
				
				return amigo.getEmailSorteado();
			}
		}
		
		if(!amigoAchado){
			throw new AmigoInexistenteException("Amigo inexistente.");
		}
		
		
		
		return null;
	}
	
	public void configuraAmigoSecretoDe(String emailDaPessoa,String emailAmigoSorteado) throws AmigoInexistenteException{
		boolean amigoAchado = false;
		for(Amigo amigo : amigos) {
			if(amigo.getEmail().equalsIgnoreCase(emailDaPessoa)) {
				amigo.setEmailSorteado(emailAmigoSorteado);
				amigoAchado = true;
			}
		}
		
		if(!amigoAchado) {
			throw new AmigoInexistenteException ("Amigo Inexistente no sistema.");
		}
		
	}
	
}

