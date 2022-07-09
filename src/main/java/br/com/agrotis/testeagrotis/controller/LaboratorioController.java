package br.com.agrotis.testeagrotis.controller;

import br.com.agrotis.testeagrotis.controller.dto.InfoPropriedadeRq;
import br.com.agrotis.testeagrotis.controller.dto.InfoPropriedadeRs;
import br.com.agrotis.testeagrotis.controller.dto.LaboratorioRq;
import br.com.agrotis.testeagrotis.controller.dto.LaboratorioRs;
import br.com.agrotis.testeagrotis.model.InfoPropriedade;
import br.com.agrotis.testeagrotis.model.Laboratorio;
import br.com.agrotis.testeagrotis.repository.LaboratorioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

    private final LaboratorioRepository laboratorioRepository;

    public LaboratorioController(LaboratorioRepository laboratorioRepository) {
        this.laboratorioRepository = laboratorioRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<LaboratorioRs>> findAll() {
        var laboratorios = laboratorioRepository.findAll();
        if(laboratorios.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(laboratorios
                .stream()
                .map(LaboratorioRs::converter)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaboratorioRs> findById(@PathVariable("id") Long id) {
        var laboratorio = laboratorioRepository.getReferenceById(id);

        return ResponseEntity.ok(LaboratorioRs.converter(laboratorio));
    }

    @PostMapping("/")
    public ResponseEntity<Laboratorio> saveLaboratorio(@RequestBody LaboratorioRq laboratorio) {
        var l = new Laboratorio();
        l.setId(laboratorio.getId());
        l.setNome(laboratorio.getNome());

        laboratorioRepository.save(l);
        return new ResponseEntity<>(l, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> updateLaboratorio(@PathVariable("id") Long id, @RequestBody LaboratorioRq laboratorio) throws Exception {
        var i = laboratorioRepository.findById(id);

        if(i.isPresent()) {
            var laboratorioSave = i.get();
            laboratorioSave.setId(laboratorio.getId());
            laboratorioSave.setNome(laboratorio.getNome());
            return ResponseEntity.ok(laboratorioRepository.save(laboratorioSave));
        }
        return ResponseEntity.of(i);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Laboratorio> DeleteLaboratorio(@PathVariable("id") Long id) {
        var lab = laboratorioRepository.findById(id);
        if(lab.isPresent()) {
            laboratorioRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.of(lab);
    }

}
