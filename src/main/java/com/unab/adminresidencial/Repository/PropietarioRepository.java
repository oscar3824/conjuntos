package com.unab.adminresidencial.Repository;

import java.util.List;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.unab.adminresidencial.Entity.Propietario;

public interface PropietarioRepository extends CrudRepository <Propietario,String> {
public Propietario findByNombre(String valor);
public List<Propietario> findByNombreContaining(String valor);

@Transactional(readOnly=true)
@Query(value = "select count(*) from propietario where nombre=:nombre and clave=:clave",nativeQuery = true)
public Integer logIn(@Param("nombre")String nombre, @Param("clave")String clave);

}
