import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstExample {
    public static void main(String[] args) throws SQLException {
        String username = "root";
        String password = "Sherlock@22";
        String url = "jdbc:mysql://localhost:3306/sanskar_sit_java";
        String sql = "select country_name from countries";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                System.out.println(resultSet.getString("country_name"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
