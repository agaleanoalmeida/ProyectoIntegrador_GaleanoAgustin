package com.portfolio.Portfolio.Controller;

import com.portfolio.Portfolio.Dto.dtoPersona;
import com.portfolio.Portfolio.Entity.Persona;
import com.portfolio.Portfolio.Security.Controller.Mensaje;
import com.portfolio.Portfolio.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
@CrossOrigin(origins = {"https://frontendgaleano.web.app","http://localhost:4200"})
public class PersonaController {
  @Autowired
    ImpPersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
        @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
      
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopers){
        //Validamos si existe el ID
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(personaService.existsByNombre(dtopers.getNombre()) && personaService.getByNombre(dtopers.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopers.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(dtopers.getNombre());
        persona.setApellido(dtopers.getApellido());
        persona.setDescripcion((dtopers.getDescripcion()));
        persona.setImg((dtopers.getImg()));
        
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
             
    }
    
    
//    POR EL MOMENTO NO ES NECESARIO ---- CREAR
//   
//    @PostMapping("/create")
//    public ResponseEntity<?> create(@RequestBody dtoPersona dtopers){      
//        if(StringUtils.isBlank(dtopers.getNombre()))
//            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
//        if(personaService.existsByNombre(dtopers.getNombre()))
//            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
//        
//        Persona persona = new Persona(dtopers.getNombre(), dtopers.getDescripcion());
//        personaService.save(persona);
//        
//        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
//    }
    
//    POR EL MOMENTO NO ES NECESARIO ------ BORRAR
    
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable("id") int id) {
//        if (!personaService.existsById(id)) {
//            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
//        }
//        personaService.delete(id);
//        return new ResponseEntity(new Mensaje("persona eliminada"), HttpStatus.OK);
//    }
}

