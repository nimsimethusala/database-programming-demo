package lk.Ijse.statement;

import java.sql.*;

public class createStatement {
    private static void saveCustomer() throws ClassNotFoundException, SQLException {
        /* since JDBC4.x not compulsory to load the Driver *//*
        Class.forName("com.mysql.cj.jdbc.Driver");*/

        String sql = "INSERT INTO customers VALUES('C004', 'Danushi', 'Galle', '0765481254')";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        );
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate(sql);

        if (affectedRows > 0)
            System.out.println("Customer saved!");
        else
            throw new RuntimeException("Customer not saved!");

        connection.close();

    }

    private static void getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM customers";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);    //customer table -> customer ResultSet

        while (resultSet.next()) {
//            String id = resultSet.getString(1);
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String tel = resultSet.getString("tel");

            System.out.println(id + " " + name + " " + address + " " + tel);
        }

        connection.close();
    }

    private static void searchCustomerById() throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = 'C001'";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@123"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);    //return type -> int OR ResultSet

            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(4);

                System.out.println(id + " " + name + " " + address + " " + tel);
            } else {
                System.out.println("OOPs! customer not found!");
            }
        }
//        connection.close();   // No need
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        saveCustomer();

//        getAllCustomer();

//        searchCustomerById();

        deleteCustomer();

//        updateCustomer();

    }

    private static void deleteCustomer() throws SQLException {
        String sql = "delete from customers where id = 'C004'";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/3306:kade",
                "root",
                "Ijse@123"
        )){
            Statement statement = connection.createStatement();
            int affectedRow = statement.executeUpdate(sql);

            if (affectedRow > 0)
                System.out.println("customer delete successfully");
            else
                System.out.println("customer delete not successfully");

        }
    }
}
