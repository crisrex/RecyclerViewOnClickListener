package com.cescristorey.recyclerview.ejemplorecyclerview;

/**
 * Created by Luis on 23/10/2017.
 */

public class Coche {

    private String modelo;
    private String matricula;

    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
