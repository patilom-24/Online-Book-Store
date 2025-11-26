package com.om.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.om.constant.ResponseCode;
import com.om.model.StoreException;

public class DBUtil {

    private static Connection connection;

    static {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore","root", "2596");
        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }

    }// End of static block

    public static Connection getConnection() throws StoreException {

        if (connection == null) {
            throw new StoreException(ResponseCode.DATABASE_CONNECTION_FAILURE);
        }

        return connection;
    }

}
