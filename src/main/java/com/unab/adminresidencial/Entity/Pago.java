package com.unab.adminresidencial.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="pago")

public class Pago {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 50)
    private String idPago;
    @Column(length = 50)
    private String valorPago;
    @Column(length = 50)
    private Date fecha;
    @ManyToOne
    @JoinColumn(name="idPropietario")
    private Propietario propietario;
    @Override
    public String toString() {
        return "Pago [idPago=" + idPago + ", valorPago=" + valorPago + ", fecha=" + fecha + ", propietario="
                + propietario + "]";
    }
    
    

    


    
}
