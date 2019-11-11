/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Conor
 */
public final class SqlConnect {

    private Connection connection;

    // constants 
    private static final Logger logger = Logger.getLogger("Test App Logger");
    
    //constructor
    public SqlConnect(final Connection connection) {
        this.connection = connection;
    }
    //public methods
    public void connect() throws ClassNotFoundException {
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            final Security buildSecure = buildSqlLogon();
            connection = DriverManager.getConnection(buildSecure.getUrl(), buildSecure.getUsermame(), buildSecure.getPword());
        
           PreparedStatement pre = connection.prepareStatement("Insert into test (name) values('test')");
           pre.executeUpdate();
           logger.info("Connection Established for connector");

        } catch (SQLException ex) {
            ex.getMessage();
            logger.warning("Connection refused");
        }
    }

    //private methods 
    private Security buildSqlLogon() {
        Security secure = new Security();
        secure.setUrl("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false");
        secure.setPword("syst3m");
        secure.setUsermame("root");
        return secure;
    }
}
