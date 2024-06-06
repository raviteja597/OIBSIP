package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeBO {

    static final String url = "jdbc:mysql://localhost:3306/jdbcclasses2";
    static final String username = "root";
    static final String password = "tejaA#12";
    static final String INSERT_QUERY = "INSERT INTO employee "
            + "(id, name, email, department, salary) "
            + "VALUES (?, ?, ?, ?, ?)";

    private Connection connection;
    private PreparedStatement statement;

    public EmployeeBO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public int save(Employee e) {
        try {
            statement = connection.prepareStatement(INSERT_QUERY);

            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setString(3, e.getEmail());
            statement.setString(4, e.getDepartment()); 
            statement.setInt(5, e.getSalary());

            int i = statement.executeUpdate();

            return i;
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return 0;
    }
}
