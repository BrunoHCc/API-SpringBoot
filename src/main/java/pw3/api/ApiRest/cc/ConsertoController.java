package pw3.api.ApiRest.cc;

import pw3.api.ApiRest.conserto.Conserto;
import pw3.api.ApiRest.conserto.ConsertoRepository;
import pw3.api.ApiRest.conserto.DadosConserto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados){
        repository.save( new Conserto(dados) );
    }

}