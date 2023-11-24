package Tools;

import java.sql.*;

import static java.lang.Class.*;
import static java.sql.DriverManager.*;

public class DBConnetion {

    String dbURL = "jdbc:postgresql://localhost:5432/projetofrota"; // Replace with your database URL
    String username = "pedro";
    String password = "123";
    public Connection connection;

    public DBConnetion() {
        connectToDatabase();
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() {
        try {
            Class.forName("org.postgresql.Driver"); // Load the PostgreSQL JDBC driver
            connection = DriverManager.getConnection(dbURL, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver"); // Load the PostgreSQL JDBC driver

            this.connection = DriverManager.getConnection(dbURL, username, password);

            if (connection != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public boolean checkLogin(String login, String senha) {
        if (connection == null) {
            return false;
        }
        try {
            String sql = "SELECT * FROM logins WHERE login = ? AND senha = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean loginExists = resultSet.next();

            resultSet.close();
            preparedStatement.close();
            return loginExists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean inserirLogin(String login, String senha){
        if (connection == null || checkLogin(login, senha)) {
            return false;
        }
        try {
            String sql = "INSERT INTO logins VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean loginExists = resultSet.next();

            resultSet.close();
            preparedStatement.close();
            return loginExists;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
