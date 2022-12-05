package com.unab.adminresidencial.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.unab.adminresidencial.Entity.Propietario;


@Repository
public interface PropietarioRepository extends CrudRepository <Propietario,String> {
public Propietario findByNombre(String valor);
public List<Propietario> findByNombreContaining(String valor);

    
}
