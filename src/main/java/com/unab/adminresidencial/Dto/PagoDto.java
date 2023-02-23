package com.unab.adminresidencial.Dto;


import java.util.Date;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter

public class PagoDto {
    private String idPago;
    private String valorPago;
    private Date fecha;
    private String idPropietario;
}
