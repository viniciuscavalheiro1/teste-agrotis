package br.com.agrotis.testeagrotis.controller;

import br.com.agrotis.testeagrotis.controller.dto.InfoPropriedadeRq;
import br.com.agrotis.testeagrotis.controller.dto.InfoPropriedadeRs;
import br.com.agrotis.testeagrotis.model.InfoPropriedade;
import br.com.agrotis.testeagrotis.repository.InfoPropriedadeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/infopropriedade")
public class InfoPropriedadeController {

    private final InfoPropriedadeRepository infoPropriedadeRepository;

    public InfoPropriedadeController(InfoPropriedadeRepository infoPropriedadeRepository) {
        this.infoPropriedadeRepository = infoPropriedadeRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<InfoPropriedadeRs>> findAll() {
        var infoPropriedades = infoPropriedadeRepository.findAll();
        if(infoPropriedades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(infoPropriedades
                .stream()
                .map(InfoPropriedadeRs::converter)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfoPropriedadeRs> findById(@PathVariable("id") Long id) {
        var pessoa = infoPropriedadeRepository.getReferenceById(id);

        return ResponseEntity.ok(InfoPropriedadeRs.converter(pessoa));
    }

    @PostMapping("/")
    public ResponseEntity<InfoPropriedade> saveInfoPropriedade(@RequestBody InfoPropriedadeRq infoProp) {
        var i = new InfoPropriedade();
        i.setId(infoProp.getId());
        i.setNome(infoProp.getNome());

        infoPropriedadeRepository.save(i);
        return new ResponseEntity<>(i, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InfoPropriedade> updateInforPropriedade(@PathVariable("id") Long id, @RequestBody InfoPropriedadeRq infoProp) throws Exception {
        var i = infoPropriedadeRepository.findById(id);

        if(i.isPresent()) {
            var pessoaSave = i.get();
            pessoaSave.setId(infoProp.getId());
            pessoaSave.setNome(infoProp.getNome());
            return ResponseEntity.ok(infoPropriedadeRepository.save(pessoaSave));
        }
        return ResponseEntity.of(i);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<InfoPropriedade> DeleteInfoPropriedade(@PathVariable("id") Long id) {
        var p = infoPropriedadeRepository.findById(id);
        if(p.isPresent()) {
            infoPropriedadeRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.of(p);
    }
}
