package com.myapp.pointapp.dao;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDAO {

//POOL DE CONEXION A BD, SE SUSTITUIRA CON FRM SPRING DATA EN LA SIGUIENTE VERSION

    private final String DB="market";
    private final String URL= "jdbc:mysql://localhost:3306/"+DB+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String USER="root";
    private final String PASS="root";
    //conexion estatica
    private static ConnectionDAO dataSource;
    private BasicDataSource basicDataSource;

    private ConnectionDAO()
    {
        basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);
        basicDataSource.setUrl(URL);

        //Restricciones de la conexion
        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxTotal(50);
        basicDataSource.setMaxWaitMillis(-1);

    }

    public static ConnectionDAO getInstance() {
        if (dataSource == null) {
            dataSource = new ConnectionDAO();
        }
        return dataSource;
    }

    public Connection getConnection() throws SQLException{
        return this.basicDataSource.getConnection();
    }
    public void closeConnection(Connection connection) throws SQLException{
        connection.close();
    }





}
