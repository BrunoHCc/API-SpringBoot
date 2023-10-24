package pw3.api.ApiRest.cc;


import org.springframework.web.util.UriComponentsBuilder;
import pw3.api.ApiRest.conserto.*;
import jakarta.transaction.Transactional;

import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados, UriComponentsBuilder uriBuilder) {
        var conserto = new Conserto(dados);
        repository.save(conserto);

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalheConserto(conserto));
    }

    @GetMapping
    public Page<Conserto> listar(Pageable pageable) {

        return repository.findAll(pageable);
    }

    @GetMapping
    @RequestMapping("algunsdados")
    public Page<AlgunsDadosConserto> listarAlgunsDados(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(AlgunsDadosConserto::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(new DadosDetalheConserto(conserto));
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById(dados.id());
        conserto.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalheConserto(conserto));
    }
}