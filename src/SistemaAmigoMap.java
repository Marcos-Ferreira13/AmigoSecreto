import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
	List<Mensagem>mensagens;
	Map<String,Amigo> amigos;
	private int quantMensagensEnviadas = 0;
	
	
	
	public SistemaAmigoMap() {
		this.mensagens = new ArrayList<>();
		this.amigos =new HashMap<>();
	}
	
	public void cadastraAmigo(String nomeAmigo,String emailAmigo) throws AmigoJaExisteException {
		Amigo novoAmigo = new Amigo(nomeAmigo,emailAmigo);
		if(this.amigos.containsKey(emailAmigo)) {
			throw new AmigoJaExisteException("Já cadastrado no sistema");
		}else {
			this.amigos.put(emailAmigo, novoAmigo);
		}
		
		
		
	}
	
	public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
		Amigo amigoAchado = this.amigos.get(emailAmigo);
		if(amigoAchado == null) {
			throw new AmigoInexistenteException("Amigo não encontrado no sistema.");
		}else {
			
			return amigoAchado;
		}
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
		Amigo amigoSecreto = this.amigos.get(emailDaPessoa);
		
		if(amigoSecreto.getEmailSorteado() == null) {
			throw new AmigoNaoSorteadoException("O amigo pesquisado não tem um amigo secreto");
		}
		
		return amigoSecreto.getEmailSorteado();
	}
	
	public void configuraAmigoSecretoDe(String emailDaPessoa,String emailAmigoSorteado) throws AmigoInexistenteException{
		Amigo amigoAchado = this.pesquisaAmigo(emailDaPessoa);
		if(amigoAchado == null) {
			throw new AmigoInexistenteException ("Amigo Inexistente no sistema.");
		}else {
			amigoAchado.setEmailSorteado(emailAmigoSorteado);
		}
		
	}
	
}

