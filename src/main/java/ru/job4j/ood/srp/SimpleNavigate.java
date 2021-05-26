package ru.job4j.ood.srp;

import java.sql.*;
import java.util.Map;
import java.util.Properties;

public class SimpleNavigate implements Navigate {
    private Map<Integer, String> data;
    private final Connection cn;

    public SimpleNavigate(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void load(String sql) {
        try (PreparedStatement ps = cn.prepareStatement(sql)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    data.put(
                            resultSet.getInt("id"),
                            resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
     }

    @Override
    public void print() {
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            System.out.println(String.format("%n = $s%n", entry.getKey(), entry.getValue()));
        }
    }
}
