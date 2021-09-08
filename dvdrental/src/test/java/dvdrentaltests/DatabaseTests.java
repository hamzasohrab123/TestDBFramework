package dvdrentaltests;

import databasesetup.DatabaseSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTests extends DatabaseSetUp {

    @Test
    public void dbTest() throws SQLException {

        String query = "SELECT first_name FROM public.actor WHERE actor_id = 1";

        Connection connect = setUp();

        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actual = resultSet.getString(1);
            Assert.assertEquals(actual, "Penelope");
            break;

        }

    }
}
