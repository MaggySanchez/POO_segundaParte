package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.clases.Leon;

public class Main {
    static Logger log;
    public static void main(String[] args) {
        Leon leon = new Leon("Mufasa", 15, true);
        leon.esAlfaMayor();
        try {
            leon.setEdad(-2);
        } catch (IllegalArgumentException e) {
            System.err.println("Ingreso una edad invalida.");
        } finally {
            System.out.println("Finalizo el proceso.");
        }
    }
}