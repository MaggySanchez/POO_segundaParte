package org.example.clases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Cliente {
    static Logger log = LogManager.getLogger(Cliente.class);
    private Long id;
    private String nombre;

    public Cliente(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        log.info("Se ha cambiado el nombre a: "+this.nombre);
    }
}
