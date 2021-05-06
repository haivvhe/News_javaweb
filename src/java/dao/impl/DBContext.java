/*
*Copyright(C) 2021, Vu Van Hai .
* J3.L.P0004:
* Digital News
*
* Record of change:
* DATE            Version             AUTHOR           DESCRIPTION
* 2020-2-23       1.0                 HaiVV            control result search page
 */
package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The class contains method Connection to database
 *
 * @author Vu Van Hai
 */
public class DBContext {

    private final String serverName = "localhost";
    private final String dbname = "Digital";
    private final String portNumber = "1433";
    private final String username = "sa";
    private final String password = "221020";

    /**
     * GetConnection method connect database
     *
     * @return connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);

    }

    /**
     * CloseConnection method close connect of connection
     *
     *
     * @param con <code>Connection</code>
     * @throws SQLException
     */
    public void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * CloseConnection method close connect of PreparedStatement
     *
     *
     * @param ps <code> PreparedStatement</code>
     * @throws SQLException
     */
    public void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * CloseConnection method close connect of ResultSet
     *
     *
     * @param rs <code>ResultSet</code>
     * @throws SQLException
     */
    public void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * GetImagePath method get image
     *
     * @return image
     * @throws Exception
     */
    public String getImagePath() throws Exception {
        return "images/";
    }
}
