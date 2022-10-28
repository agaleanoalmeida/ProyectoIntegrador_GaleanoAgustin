
package com.portfolio.Portfolio.Security.Dto;

import javax.validation.constraints.NotBlank;


public class DtoEducacion {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    
    @NotBlank
    private String anioE;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreE, String descripcionE, String anioE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.anioE = anioE;
    }

    public String getAnioE(){
        return anioE;
    }
    
    public void setAnioE(String anioE){
        this.anioE = anioE;
    }
    
    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    
}
