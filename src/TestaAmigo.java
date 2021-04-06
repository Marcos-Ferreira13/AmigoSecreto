import java.util.ArrayList;
import java.util.List;

public class TestaAmigo {
	public static void main(String[] args) {
		//Instancia
		SistemaAmigo sistema = new SistemaAmigo();
		Mensagem msg = new MensagemParaTodos();
		
		//cadastrando
		sistema.cadastraAmigo("Jos�", "Jose@gmail.com");
		sistema.cadastraAmigo("Maria", "Maria@gmail.com");
		
		//excessoes
		try {
			sistema.configuraAmigoSecretoDe("Jose@gmail.com", "Maria@gmail.com");
			sistema.configuraAmigoSecretoDe("Maria@gmail.com", "Jose@gmail.com");
			System.out.println("Configurado com sucesso.");
		}catch(AmigoInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			sistema.configuraAmigoSecretoDe("Maria@gmail.com","Jose@gmail.com");
			System.out.println("Configurado com sucesso.");
			
		}catch(AmigoInexistenteException e) {
			System.out.println(e.getMessage());
			
		}
		
		
		//enviando msg anonima
		
		sistema.enviarMensagemParaAlguem("bom dia","Maria@gmail.com","Jose@gmail.com",true);
		sistema.enviarMensagemParaTodos("bom dia amigos", "Maria@gmail.com", true);
		
		List<Mensagem> msgs = sistema.pesquisaMensagensAnonimas();
		
		for(Mensagem msgA : msgs) {
			System.out.println(msgA.getTextoCompleto());
		}
		
		
		try {
			sistema.pesquisaAmigoSecretoDe("Jose@gmail.com");
			System.out.println("OK!");
			
		}catch(AmigoNaoSorteadoException e) {
			System.out.println(e.getMessage());
		}catch(AmigoInexistenteException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
