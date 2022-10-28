package com.portfolio.Portfolio.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String anioE;
    

    //Constructores
    public DtoExperiencia() {
    }

    public DtoExperiencia(String nombreE, String descripcionE, String anioE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.anioE = anioE;
    }
    //Getters & Setters

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
