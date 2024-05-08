package br.com.crdc.controller;

import br.com.crdc.controller.dto.TransacaoDto;
import br.com.crdc.controller.form.AtualizacaoTransacaoForm;
import br.com.crdc.controller.form.TransacaoForm;
import br.com.crdc.modelo.Empresa;
import br.com.crdc.modelo.Transacao;
import br.com.crdc.repository.EmpresaRepository;
import br.com.crdc.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Transacoes")
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public List<TransacaoDto> lista() {
			List<Transacao> transacao = transacaoRepository.findAll();
			System.out.println("---size-> " + transacao.size());
		    List<TransacaoDto> ltdto = TransacaoDto.converter(transacao);
		    System.out.println("---size-ltdto-> " + ltdto.size());
			String teste1 = "madam";
			String teste2 = "madam";
		    System.out.println(">>test1=test2?"+teste1.equals(teste2));
			return ltdto;
			//return TransacaoDto.converter(transacao);
	}




	@PostMapping("/Cadastrar/{id}")
	@Transactional
	public ResponseEntity<?> cadastrar(@PathVariable Long id, @RequestBody @Valid TransacaoForm form) {
		System.out.println("-------------> entrou cadastrar id= "+ id);
		Optional<Empresa> optional = empresaRepository.findById(id);
		System.out.println("===>transacaoController");
		if (optional.isPresent()) {
			System.out.println("==>Empresa esta presente");
			Transacao transacao = form.converter(optional.get().getId(), empresaRepository);
			transacaoRepository.save(transacao);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TransacaoDto>
	       atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTransacaoForm form) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		Optional<Transacao> optional = transacaoRepository.findById(id);
		if (optional.isPresent()) {
			Transacao transacao = form.atualizar(id, transacaoRepository);
			transacaoRepository.save(transacao);
			return ResponseEntity.ok(new TransacaoDto(transacao));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Transacao> optional = transacaoRepository.findById(id);
		if (optional.isPresent()) {
			transacaoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
