package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Main {
    static Logger log;
    public static void main(String[] args) {
        log = LogManager.getLogger("prueba");
    }
}