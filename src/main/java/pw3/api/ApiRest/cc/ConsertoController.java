package pw3.api.ApiRest.cc;


import pw3.api.ApiRest.conserto.*;
import jakarta.transaction.Transactional;
import java.util.List;
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
    public void cadastrar(@RequestBody @Valid DadosConserto dados){
        repository.save( new Conserto(dados) );
    }

    @GetMapping
    public Page<Conserto> listar(Pageable paginacao) {

        return repository.findAll(paginacao);
    }

    @GetMapping
    @RequestMapping("ordemservico")
    public Page<DadosListagemConserto> listarAlgunsDados(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemConserto::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
        if (consertoOptional.isPresent()) {
            Conserto conserto = consertoOptional.get();
            return ResponseEntity.ok(conserto);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);

        conserto.excluir();

    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);
    }
}