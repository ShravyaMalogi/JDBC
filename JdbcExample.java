import java.sql.*;

public class JdbcExample {

    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "root";
        String password = "password";

        // SQL query to select only the id
        String query = "SELECT id FROM users";

        try {
            // Establishing the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // Creating a statement object to execute the query
            Statement smt = con.createStatement();

            // Executing the query and storing the result set
            ResultSet rs = smt.executeQuery(query);

            // Iterating through the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("ID: " + id);
            }

            // Closing the result set, statement, and connection
            rs.close();
            smt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
