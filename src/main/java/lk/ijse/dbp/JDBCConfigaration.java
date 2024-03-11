package lk.ijse.dbp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConfigaration {
    private static Connection connection;
    private static Statement statement;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        loadAndRegisterDriver();
        createTheConnection();
        createTheStatemnt();
        executeTheQuery();
        closeTheConnection();
    }

    private static void closeTheConnection() throws SQLException {
        connection.close();
    }

    private static void executeTheQuery() throws SQLException {
        String sql = "INSERT INTO customers(id, name, address, tel) VALUES('C003', 'Kithmi', 'Jaffna', '0714567685')";

        int affectedRows = statement.executeUpdate(sql);
        System.out.println("affected rows: " + affectedRows);
    }

    private static void createTheStatemnt() throws SQLException {
        statement = connection.createStatement();
    }

    private static void createTheConnection() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123");

        System.out.println("connection: " + connection);
    }

    private static void loadAndRegisterDriver() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
