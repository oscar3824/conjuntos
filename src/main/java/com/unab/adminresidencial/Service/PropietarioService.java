package com.unab.adminresidencial.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unab.adminresidencial.Entity.Propietario;
import com.unab.adminresidencial.Repository.PropietarioRepository;

@Service
public class PropietarioService {
    @Autowired
    PropietarioRepository   propietarioRepository;

    public Propietario save(Propietario propietario){
        return propietarioRepository.save(propietario);
    }
    public List<Propietario> findAll(){
        return (List<Propietario>) propietarioRepository.findAll();

    }
    public String deleteById(String id){
        propietarioRepository.deleteById(id);
        return "registro eliminado";

    }
    public Propietario findByNombre(String valor){
        return propietarioRepository.findByNombre(valor);
    }

    public List<Propietario> findByNombreContaining(String valor){
        return propietarioRepository.findByNombreContaining(valor);
}
    public Integer logIn(String nombre, String clave){
    return propietarioRepository.logIn(nombre, clave);
    }
}

