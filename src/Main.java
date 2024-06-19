import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sakila?autoReconnect=true&useSSL=false";
        String user = "blackjack13";
        String password = "Sarpoma..";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}