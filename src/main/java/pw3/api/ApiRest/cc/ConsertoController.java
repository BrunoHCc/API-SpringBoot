package pw3.api.ApiRest.cc;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pw3.api.ApiRest.conserto.Conserto;
import pw3.api.ApiRest.conserto.ConsertoRepository;
import pw3.api.ApiRest.conserto.DadosConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import pw3.api.ApiRest.conserto.DadosListagemConserto;

import java.util.List;

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
    public Page<Conserto> listar(Pageable paginacao){
        return repository.findAll(paginacao);
    }

    @GetMapping
    @RequestMapping("algunsdados")
    public Page<DadosListagemConserto> ListarAlgunsDados(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemConserto::new);
    }


}

