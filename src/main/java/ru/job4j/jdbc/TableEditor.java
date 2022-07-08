package ru.job4j.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    final private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = properties.getProperty("url");
            String login = properties.getProperty("login");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) {
            String sql = String.format(
                    "create table if not exists %s();",
                    tableName
            );
            execQuery(sql);
    }

    public void dropTable(String tableName) {
            String sql = String.format(
                    "drop table %s;",
                    tableName
            );
            execQuery(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
            String sql = String.format(
                    "alter table %s ADD column %s %s;",
                    tableName, columnName, type
            );
            execQuery(sql);
    }

    public void dropColumn(String tableName, String columnName) {
            String sql = String.format(
                    "alter table %s drop column %s cascade;",
                    tableName, columnName
            );
            execQuery(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                    "alter table %s rename column %s to %s;",
                    tableName, columnName, newColumnName
            );
        execQuery(sql);
    }

    public void execQuery(String sql) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        File file = new File("./app.properties");
        try (FileInputStream io = new FileInputStream(file)) {
            properties.load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable("students");
        System.out.println("-----------------------------------------");
        System.out.println(tableEditor.getScheme("students"));
        tableEditor.addColumn("students", "id", "serial");
        tableEditor.addColumn("students", "name", "varchar(30)");
        System.out.println("-----------------------------------------");
        System.out.println(tableEditor.getScheme("students"));
        tableEditor.renameColumn("students", "name", "student_name");
        tableEditor.addColumn("students", "score", "int");
        System.out.println("-----------------------------------------");
        System.out.println(tableEditor.getScheme("students"));
        tableEditor.dropColumn("students", "score");
        tableEditor.dropColumn("students", "student_name");
        tableEditor.dropColumn("students", "id");
        System.out.println("-----------------------------------------");
        System.out.println(tableEditor.getScheme("students"));
        tableEditor.dropTable("students");
        tableEditor.close();
    }
}