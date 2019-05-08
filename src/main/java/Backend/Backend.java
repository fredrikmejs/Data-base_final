package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Backend {

    private static Connection con;

    public void createConnection() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/chbu?"
                + "user=s185140&password=YKl6EOAgNqhvE0fjJ0uJX");
    }


}
