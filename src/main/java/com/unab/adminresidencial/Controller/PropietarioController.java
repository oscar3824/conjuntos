package com.unab.adminresidencial.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.adminresidencial.Dto.PropietarioDto;
import com.unab.adminresidencial.Entity.Propietario;
import com.unab.adminresidencial.Service.PropietarioService;
import com.unab.adminresidencial.Utility.ConvertEntity;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/propietario")
public class PropietarioController {

    @Autowired
    PropietarioService propietarioService;

    @Autowired
    ConvertEntity convertEntity;
    PropietarioDto propietarioDto= new PropietarioDto();

    @PostMapping("/create")
    public Object save(@RequestBody Propietario propietario){
        return convertEntity.convert(propietarioService.save(propietario), propietarioDto);
    
    }
    @GetMapping("/list")
    public List<Object> findAll(){
        List<Object> propietarioDtoLista =new ArrayList<>();
        for (Propietario propietario: propietarioService.findAll())
             propietarioDtoLista.add(convertEntity.convert(propietario, propietarioDto));
        return propietarioDtoLista;
    }
    @DeleteMapping("/delete/{id}")
    public String findById(@PathVariable("id") String id){
        return propietarioService.deleteById(id);
    }
    
    @PutMapping("/update/{id}")
    public Object update(@RequestBody  Propietario propietario, @PathVariable("id") String id){
        propietario.setIdPropietario(id);
        return convertEntity.convert(propietarioService.save(propietario),propietarioDto);
    }
    @GetMapping("/list/{valor}")
    public Propietario findByNombre(@PathVariable("valor") String valor){
        return propietarioService.findByNombre(valor);
    }
    @GetMapping("/list/cont/{valor}")
    public List<Propietario> findByNombreContaining(@PathVariable("valor") String valor){
        return propietarioService.findByNombreContaining(valor);
    }

}
