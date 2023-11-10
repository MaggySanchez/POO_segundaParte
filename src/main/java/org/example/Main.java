package org.example;

import org.apache.logging.log4j.Logger;
import org.example.clases.Cliente;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1234L,"Marcos");
        cliente1.setNombre("Lucas");
    }
}