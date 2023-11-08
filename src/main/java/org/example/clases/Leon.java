package org.example.clases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Leon {
    static Logger log = LogManager.getLogger("prueba");
    private String nombre;
    private int edad;
    private Boolean esAlfa;

    public Leon(String nombre, int edad, Boolean esAlfa) {
        this.nombre = nombre;
        this.edad = edad;
        this.esAlfa = esAlfa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Boolean getEsAlfa() {
        return esAlfa;
    }

    public void setEsAlfa(Boolean esAlfa) {
        this.esAlfa = esAlfa;
    }

    @Override
    public String toString() {
        return "Leon{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", esAlfa=" + esAlfa +
                '}';
    }

    public Boolean esAlfaMayor() {
        Boolean esAM = esAlfa && edad > 10;
        if (esAM) {
            log.info("el Leon es mayor y alfa " + this.esAlfa + " " + this.edad);
        }
        return esAM;
    }

    public void setEdad(Integer edad) {

        if (edad >= 0) {
            this.edad = edad;
        } else {
            log.error("ingresó un edad inválida valor:" + edad);
            throw new IllegalArgumentException("Ingrese una edad válida");

        }
    }
}
