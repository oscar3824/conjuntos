package com.unab.adminresidencial.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unab.adminresidencial.Entity.Pago;
import com.unab.adminresidencial.Repository.PagoRepository;

@Service

public class PagoService {
    @Autowired
    PagoRepository pagoRepository;

    public Pago save(Pago pago){
        return pagoRepository.save(pago);
    }
    public List<Pago> findAll(){
        return (List<Pago>) pagoRepository.findAll();
    }
    public String deleteById(String id){
        pagoRepository.deleteById(id);
        return"registro de pago eliminado";

    }
}
