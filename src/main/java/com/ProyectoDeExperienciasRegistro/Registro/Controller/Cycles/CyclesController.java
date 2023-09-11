package com.ProyectoDeExperienciasRegistro.Registro.Controller.Cycles;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Cycles;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Cycles.CyclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/cycles")
public class CyclesController {
    @Autowired
    private CyclesService cyclesService;

    @PostMapping
    public ResponseEntity<Cycles> create(@RequestBody Cycles cycles){
        return ResponseEntity.status(HttpStatus.CREATED).body(cyclesService.save(cycles));
    }

    @GetMapping
    public List<Cycles> readAll(){
        List<Cycles> cycles= StreamSupport
                .stream(cyclesService.findAll().spliterator(),false).collect(Collectors.toList());
        return cycles;
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Cycles> update(@RequestBody Cycles cyclesDetalle,@PathVariable Long id){
        Optional<Cycles> cycles=cyclesService.findById(id);
        if(!cycles.isPresent()){
            return ResponseEntity.notFound().build();
        }
        cycles.get().setNumberCycles(cyclesDetalle.getNumberCycles());

        return ResponseEntity.status(HttpStatus.CREATED).body(cyclesService.save(cycles.get()));
    }

    @DeleteMapping(path = "{id}")
    public  ResponseEntity<String> delete(@PathVariable Long id){
        if (!cyclesService.findById(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        cyclesService.deleteById(id);
        return ResponseEntity.ok("Se elimo correctamente el ciclo");
    }


}
