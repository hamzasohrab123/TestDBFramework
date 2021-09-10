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

        String query = "SELECT * FROM public.actor limit 5";

        Connection connect = setUp();

        Statement statement = connect.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actorId = resultSet.getString("actor_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String lastUpdate = resultSet.getString("last_update");

            //This will print all the data of 5 actors in the dvdrental
            System.out.println(actorId + " " + firstName + " " + lastName + " " + lastUpdate);

            //This actual first_name would be same first_name which is in dvdrental for all 5 actors
            String actual = resultSet.getString("first_name");
            Assert.assertEquals(actual, firstName);

        }

    }
}
