package com.unab.adminresidencial.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.adminresidencial.Dto.PropietarioDto;
import com.unab.adminresidencial.Entity.Message;
import com.unab.adminresidencial.Entity.Propietario;
import com.unab.adminresidencial.Service.PropietarioService;
import com.unab.adminresidencial.Utility.ConvertEntity;
import com.unab.adminresidencial.Utility.Security.Hash;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    PropietarioService propietarioService;

    @Autowired
    ConvertEntity convertEntity;
    PropietarioDto propietarioDto = new PropietarioDto();

    @PostMapping("/create")
    public ResponseEntity<Object> save(@Valid @RequestBody Propietario propietario, @RequestHeader String nombre,
            @RequestHeader String clave) {
        if (propietarioService.logIn(nombre,Hash.sha1(clave)) == 0) {
            return new ResponseEntity<>(new Message(401, "Acceso no autorizado"), HttpStatus.UNAUTHORIZED);
        }
        propietario.setClave(Hash.sha1(propietario.getClave()));
        return new ResponseEntity<>(convertEntity.convert(propietarioService.save(propietario), propietarioDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Object> findAll() {
        List<Object> propietarioDtoLista = new ArrayList<>();
        for (Propietario propietario : propietarioService.findAll())
            propietarioDtoLista.add(convertEntity.convert(propietario, propietarioDto));
        return propietarioDtoLista;
    }

    @DeleteMapping("/delete/{id}")
    public String findById(@PathVariable("id") String id, @RequestHeader String nombre,
    @RequestHeader String clave) {
        if (propietarioService.logIn(nombre, clave) == 0) {
            return "Acceso no autorizado";
        }
        return propietarioService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody Propietario propietario, @PathVariable("id") String id, @RequestHeader String nombre,
    @RequestHeader String clave) {
        if (propietarioService.logIn(nombre, clave) == 0) {
            return new ResponseEntity<>(new Message(401, "Acceso no autorizado"), HttpStatus.UNAUTHORIZED);
        }
        propietario.setIdPropietario(id);
        propietario.setClave(Hash.sha1(propietario.getClave()));
        return new ResponseEntity<>(convertEntity.convert(propietarioService.save(propietario), propietarioDto),
                HttpStatus.OK);
    }

    @GetMapping("/list/{valor}")
    public ResponseEntity<Object> findByNombre(@PathVariable("valor") String valor) {
        if (propietarioService.findByNombre(valor) == null) {
            Message message = new Message();
            message.setStatus(401);
            message.setMessage("Propietario ["+valor+"] no encontrado");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(propietarioService.findByNombre(valor), HttpStatus.OK);
    }

    @GetMapping("/list/cont/{valor}")
    public ResponseEntity<List<Propietario>> findByNombreContaining(@PathVariable("valor") String valor) {
        if (propietarioService.findByNombre(valor) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(propietarioService.findByNombreContaining(valor), HttpStatus.OK);
    }

}
