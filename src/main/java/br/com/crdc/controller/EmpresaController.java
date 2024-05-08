package br.com.crdc.controller;

import br.com.crdc.controller.dto.EmpresaDto;
import br.com.crdc.controller.form.AtualizacaoEmpresaForm;
import br.com.crdc.controller.form.EmpresaForm;
import br.com.crdc.modelo.Empresa;
import br.com.crdc.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Empresas")
public class

EmpresaController {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping
	public List<EmpresaDto> lista() {
			List<Empresa> empresa = empresaRepository.findAll();

			return EmpresaDto.converter(empresa);
	}

	@GetMapping("/Max")
	public Long maximo() {
		return empresaRepository.findMaxValue();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> cadastrar(@RequestBody @Valid EmpresaForm form) {
		System.out.println("metodo cadastrar<==============");
		Empresa empresa = form.converter();
		empresaRepository.save(empresa);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmpresaDto>
	       atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoEmpresaForm form) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		Optional<Empresa> optional = empresaRepository.findById(id);
		if (optional.isPresent()) {
			Empresa empresa = form.atualizar(id, empresaRepository);
			empresaRepository.save(empresa);
			return ResponseEntity.ok(new EmpresaDto(empresa));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Empresa> optional = empresaRepository.findById(id);
		if (optional.isPresent()) {
			empresaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
