package org.example.demobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class DemobackendApplication {

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433";
    private static final String USER = "sa";
    private static final String PASS = "password";
    private static final String DB_NAME = "Retailer";

    public static void main(String[] args) {
        initializeDatabase();
        SpringApplication.run(DemobackendApplication.class, args);
    }

    private static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            String sql = "IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = '" + DB_NAME + "') " +
                    "CREATE DATABASE " + DB_NAME;
            stmt.execute(sql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}