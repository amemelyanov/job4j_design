package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException, IOException {
        Settings settings = new Settings();
        File file = new File("./app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            settings.load(io);
        }
        Class.forName("org.postgresql.Driver");
        String url = settings.getValue("url");
        String login = settings.getValue("login");
        String password = settings.getValue("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}