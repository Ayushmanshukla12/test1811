package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factoryprovider {

        public static Connection connect() {
            Connection connection;
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","root");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return connection;
        }
    }


