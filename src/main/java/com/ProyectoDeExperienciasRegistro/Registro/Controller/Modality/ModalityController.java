package com.ProyectoDeExperienciasRegistro.Registro.Controller.Modality;

import com.ProyectoDeExperienciasRegistro.Registro.Entity.Courses;
import com.ProyectoDeExperienciasRegistro.Registro.Entity.Modality;
import com.ProyectoDeExperienciasRegistro.Registro.Service.Modality.ModalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("api/modality")
@CrossOrigin(origins = "http://localhost:3000")
public class ModalityController {
    @Autowired
    private ModalityService modalityService;

    @GetMapping
    public List<Modality> readAll(){
        List<Modality> modality= StreamSupport
                .stream(modalityService.findAll().spliterator(), false).collect(Collectors.toList());
        return modality ;
    }
    @PostMapping
    public ResponseEntity<Modality> create(@RequestBody Modality modalitys){
        return ResponseEntity.status(HttpStatus.CREATED).body(modalityService.save(modalitys));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Modality> update(@RequestBody Modality modalityDetalle, @PathVariable Long id){
        Optional<Modality> modality= modalityService.findById(id);
        if (!modality.isPresent()){
            return ResponseEntity.notFound().build();
        }
        modality.get().setType(modalityDetalle.getType());


        return ResponseEntity.status(HttpStatus.CREATED).body(modalityService.save(modality.get()));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(!modalityService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        modalityService.deleteById(id);
        return ResponseEntity.ok("Se elimino correctamente la modalidad");
    }

}
