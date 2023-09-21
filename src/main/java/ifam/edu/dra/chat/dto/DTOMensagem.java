package ifam.edu.dra.chat.dto;

import java.sql.Date;
import java.util.Calendar;

import ifam.edu.dra.chat.model.Contato;
import ifam.edu.dra.chat.model.Mensagem;

public class DTOMensagem {
	private String conteudo;
	private Calendar data;
	private Long idEmissor;
	private Long idReceptor;
	
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar calendar) {
		this.data = calendar;
	}
	public Long getIdEmissor() {
		return idEmissor;
	}
	public void setIdEmissor(Long idEmissor) {
		this.idEmissor = idEmissor;
	}
	public Long getIdReceptor() {
		return idReceptor;
	}
	public void setIdReceptor(Long idReceptor) {
		this.idReceptor = idReceptor;
	}
	
	public DTOMensagem DTOMensagem(Mensagem mensagem) {
		DTOMensagem dtoMensagem = new DTOMensagem();
		dtoMensagem.setConteudo(mensagem.getConteudo());;
		dtoMensagem.setData(mensagem.getDataHora());			
		dtoMensagem.setIdEmissor(mensagem.getEmissor().getId());
		dtoMensagem.setIdReceptor(mensagem.getReceptor().getId());

		return dtoMensagem;
	}
	
	public Mensagem getMensagem() {
		Mensagem mensagem = new Mensagem();
		mensagem.setDataHora(this.data);
		mensagem.setConteudo(this.conteudo);
			
		Contato emissor = new Contato();
		emissor.setId(this.idEmissor);
		mensagem.setEmissor(emissor);
		

		Contato receptor = new Contato();
		receptor.setId(this.idReceptor);
		mensagem.setReceptor(receptor);

		return mensagem;
	}
}
