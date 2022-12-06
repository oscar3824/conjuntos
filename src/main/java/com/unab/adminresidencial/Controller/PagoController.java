package com.unab.adminresidencial.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unab.adminresidencial.Dto.PagoDto;
import com.unab.adminresidencial.Entity.Pago;
import com.unab.adminresidencial.Service.PagoService;
import com.unab.adminresidencial.Utility.ConvertEntity;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/pago")
public class PagoController {
    
@Autowired
PagoService pagoService;

@Autowired
ConvertEntity convertEntity;
PagoDto pagoDto = new PagoDto();

@PostMapping("/create")
public Object save(@RequestBody Pago pago){
    return convertEntity.convert(pagoService.save(pago), pagoDto);
}
@GetMapping("/listar")
public List<Object> findAll(){
    List<Object> pagoDtoLista =new ArrayList<>();
        for (Pago pago: pagoService.findAll())
             pagoDtoLista.add(convertEntity.convert(pago, pagoDto));
        return pagoDtoLista;  
}
@DeleteMapping("delete/{id}")
public String findById(@PathVariable("id")String id){
    return pagoService.deleteById(id);
}


}
