import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {
	public static void main(String[] args) {
		int maxMensagens = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de mensagens permitidas:"));
		SistemaAmigo sistema = new SistemaAmigo(maxMensagens);
		
		int participantes = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o número de participantes:"));
		
		for(int i=0; i< participantes; i++) {
			String nomeAmigo = JOptionPane.showInputDialog("Digite o nome do amigo: " +i);
			String emailAmigo = JOptionPane.showInputDialog("Digite o email do amigo: "+i);
			sistema.cadastraAmigo(nomeAmigo, emailAmigo);
		}
		
		for(int i=0; i< participantes; i++) {
			String emailDaPessoa = JOptionPane.showInputDialog("Digite o email do amigo número"+ i);
			String emailAmigoSorteado = JOptionPane.showInputDialog("Digite o email do par do amigo "+ emailDaPessoa);
			try {
				sistema.configuraAmigoSecretoDe(emailDaPessoa, emailAmigoSorteado);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
			}catch(AmigoInexistenteException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			
		}
		
	}
		
	String texto = JOptionPane.showInputDialog("Digite o texto da mensagem:");
	String emailRemetente = JOptionPane.showInputDialog("Digite o seu email:");
	boolean ehAnonima = Boolean.parseBoolean(JOptionPane.showInputDialog("true ou false"));
	sistema.enviarMensagemParaTodos(texto, emailRemetente, ehAnonima);
		
	}
}
