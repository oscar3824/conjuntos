package com.unab.adminresidencial.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.adminresidencial.Entity.Pago;
@Repository

public interface PagoRepository extends CrudRepository <Pago, String>{
    
}
