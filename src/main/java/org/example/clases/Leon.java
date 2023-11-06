package org.example.clases;

public class Leon {
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

    public void setEdad(int edad) {
        this.edad = edad;
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
}
