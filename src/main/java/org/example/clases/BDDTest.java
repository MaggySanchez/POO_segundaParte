package org.example.clases;




import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class BDDTest {


    /*
     * un `PreparedStatement` es una subclase de `Statement`. Utiliza consultas parametrizadas,
     * lo que significa que se pueden definir marcadores de posición para los parámetros en la consulta.
     * Esto ayuda a prevenir la inyección SQL, ya que la consulta y los datos enviados se separan claramente.
     *  Los valores de los parámetros se asignan a estos marcadores de posición antes de que se ejecute la consulta,
     *  lo que hace que sea mucho más seguro en términos de seguridad.


     **/




    public static void main(String[] args) throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {




        Class.forName("org.h2.Driver").newInstance();


        Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        // Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear

        String createSql = "DROP TABLE IF EXISTS TEST_CLIENTE1; " +
                "CREATE TABLE TEST_CLIENTE1(ID INT PRIMARY KEY, NAME VARCHAR(255));";



        // utilizamos un objeto `PreparedStatement` para ejecutar la creación de la tabla
        PreparedStatement createStatement = con.prepareStatement(createSql);
        createStatement.execute();


     /*  String createSql = "DROP TABLE IF EXISTS TEST_CLIENTE; " +
                           "CREATE TABLE TEST_CLIENTE(ID INT PRIMARY KEY, NAME VARCHAR(255));";


     /*  utilizamos el objeto statement para crear una tabla- execute ejecuta la instruccion SQL
                   stmt.execute(createSql);
                   String insertarRegistros="INSERT INTO TEST_CLIENTE VALUES(1, 'Juan');\n" +
                           "INSERT INTO TEST_CLIENTE VALUES(2, 'Florencia');\n";
                   stmt.execute(insertarRegistros); */


        // Código para insertar

        String insertarRegistros = "INSERT INTO TEST_CLIENTE1 VALUES(?, ?);";
        // Utilizamos PreparedStatement para evitar la inyección de SQL y mejorar la seguridad
        PreparedStatement insertStatement = con.prepareStatement(insertarRegistros);

        //crea el primer cliente
        insertStatement.setInt(1, 1);
        insertStatement.setString(2, "Juan");
        insertStatement.execute();
        //crea el segundo
        insertStatement.setInt(1, 2);
        insertStatement.setString(2, "Florencia");
        insertStatement.execute();




        // Código para consultar (query) todos los registros de la tabla TEST_CLIENTE
        String sql = "SELECT * FROM TEST_CLIENTE1";
        PreparedStatement queryStatement = con.prepareStatement(sql);
        ResultSet res = queryStatement.executeQuery();


        // Código para recorrer el resultado de la consulta
        while (res.next()) {
            System.out.println(res.getInt(1) + " " + res.getString(2));
        }




    }
}
