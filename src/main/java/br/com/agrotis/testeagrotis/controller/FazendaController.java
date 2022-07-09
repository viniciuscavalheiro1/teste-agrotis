package br.com.agrotis.testeagrotis.controller;

import br.com.agrotis.testeagrotis.controller.dto.FazendaRq;
import br.com.agrotis.testeagrotis.controller.dto.FazendaRs;
import br.com.agrotis.testeagrotis.model.Fazenda;
import br.com.agrotis.testeagrotis.repository.FazendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/fazenda")
public class FazendaController {
    private final FazendaRepository fazendaRepository;

    public FazendaController(FazendaRepository fazendaRepository) {
        this.fazendaRepository = fazendaRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<FazendaRs>> findAll() {
        var fazendas = fazendaRepository.findAll();
        if(fazendas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fazendas
                .stream()
                .map(FazendaRs::converter)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FazendaRs> findById(@PathVariable("id") Long id) {
        var pessoa = fazendaRepository.getReferenceById(id);

        return ResponseEntity.ok(FazendaRs.converter(pessoa));
    }

    @PostMapping("/")
    public ResponseEntity<Fazenda> saveFazenda(@RequestBody FazendaRq fazenda) {
        var f = new Fazenda();
        f.setData_inicial(fazenda.getData_inicial());
        f.setData_final(fazenda.getData_final());
        f.setId_propriedade_fazenda(fazenda.getId_propriedade_fazenda());
        f.setCnpj(fazenda.getCnpj());
        f.setId_laboratorio(fazenda.getId_laboratorio());
        f.setObservacoes(fazenda.getObservacoes());
        fazendaRepository.save(f);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fazenda> updateFazenda(@PathVariable("id") Long id, @RequestBody FazendaRq fazenda) throws Exception {
        var f = fazendaRepository.findById(id);

        if(f.isPresent()) {
            var fazendaSave = f.get();
            fazendaSave.setData_inicial(fazenda.getData_inicial());
            fazendaSave.setData_final(fazenda.getData_final());
            fazendaSave.setId_propriedade_fazenda(fazenda.getId_propriedade_fazenda());
            fazendaSave.setCnpj(fazenda.getCnpj());
            fazendaSave.setId_laboratorio(fazenda.getId_laboratorio());
            fazendaSave.setObservacoes(fazenda.getObservacoes());

            return ResponseEntity.ok(fazendaRepository.save(fazendaSave));
        }
        return ResponseEntity.of(f);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fazenda> deleteFazenda(@PathVariable("id") Long id, @RequestBody FazendaRq fazenda) throws Exception {
        var f = fazendaRepository.findById(id);

        if(f.isPresent()) {
            fazendaRepository.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.of(f);
    }
}
