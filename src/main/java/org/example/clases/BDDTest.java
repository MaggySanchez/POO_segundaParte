package org.example.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDDTest {
    public static void main(String[] args) throws Exception {
        // indicamos el driver correspondiente a la bd en memoria
        // carga dinámicamente la clase del controlador en memoria, y newInstance() crea una instancia de esa clase.
        Class.forName("org.h2.Driver").newInstance();


        // con el metodo hetCoonnection de DriverManager
        // creamos un obj conexion con las configuraciones correspondientes a nuestra bd: url,usuario y pass
        Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");


        //Obj para realizar consultas, instruccines SQL
        Statement stmt = con.createStatement();
        //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        //elimnarla antes de comenzar es una buena práctica en las bd en memoria se supone que no debe existir al levantarla
        String createSql = "DROP TABLE IF EXISTS TEST_CLIENTE; " +
                "CREATE TABLE TEST_CLIENTE(ID INT PRIMARY KEY, NAME VARCHAR(255));";


        //utilizamos el objeto statement para crear una tabla- execute ejecuta la instruccion SQL
        stmt.execute(createSql);
        String insertarRegistros="INSERT INTO TEST_CLIENTE VALUES(1, 'Juan');\n" +
                "INSERT INTO TEST_CLIENTE VALUES(2, 'Florencia');\n";
        stmt.execute(insertarRegistros);
        //Codigo para consultar (query) todos los registros de la tabla TEST_CLIENTE
        String sql = "select * from TEST_CLIENTE";
        ResultSet res= stmt.executeQuery(sql); // como es una query va este método...


        // retorna un objeto de tipo ResultSet
        //Código para recorrer el resultado de la consulta
        while(res.next()) {
            System.out.println(res.getInt(1) + res.getString(2));
        }




        con.close();
    }

}
