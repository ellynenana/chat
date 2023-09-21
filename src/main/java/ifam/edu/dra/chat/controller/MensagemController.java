package ifam.edu.dra.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifam.edu.dra.chat.dto.DTOMensagem;
import ifam.edu.dra.chat.model.Mensagem;
import ifam.edu.dra.chat.service.MensagemService;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

	@Autowired
	MensagemService mensagemService;

	@GetMapping
	ResponseEntity<List<Mensagem>> getMensagens() {
		List<Mensagem> mensagem = mensagemService.getMensagens();
		if (mensagem.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
		return ResponseEntity.ok(mensagem);
	}

	@GetMapping("/{id}")
	ResponseEntity<Mensagem> getMensagem(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(mensagemService.getMensagem(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Mensagem());
		}
	}

	@GetMapping("/receptor/{receptorId}")
	ResponseEntity<List<Mensagem>> getMensagensByReceptor(@PathVariable Long receptorId) {
		List<Mensagem> mensagens = mensagemService.getMensagensByReceptor(receptorId);
		if (mensagens.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagens);
		return ResponseEntity.ok(mensagens);
	}

	@PostMapping
	ResponseEntity<DTOMensagem> setMensagem(@RequestBody DTOMensagem dtomensagem) {
		DTOMensagem DTOMensagemNova = mensagemService.setMensagem(dtomensagem);
		return ResponseEntity.status(HttpStatus.CREATED).body(DTOMensagemNova);
	}
}
