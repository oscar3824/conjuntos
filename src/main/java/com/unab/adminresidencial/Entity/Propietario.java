package com.unab.adminresidencial.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="propietario")

public class Propietario {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name="idPropietario",length = 50)
    private String idPropietario;
   
    @Column(length = 30, unique = true)
    @Size(min= 5, message= "El campo nombre debe tener minimo 5 caracteres")
    private String nombre;
    
    @Column(length = 50)
    @NotEmpty(message = "El campo clave es requerido")
    private String clave;
    /* 
    public Propietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }
    */
    @Override
    public String toString() {
        return "Propietario [idPropietario=" + idPropietario + ", nombre=" + nombre + ", clave=" + clave + "]";
    }
    

    
    
    //@Column(length = 30)
    //private String apellido;
   
    //@Column(length = 30)
    //@NotEmpty(message = "El campo documento es requerido")
    //private String documento;
    
    //@Column(length = 20)
    //private String email;
   
    //@Column(length = 15)
    //private Long telefono;
    }
