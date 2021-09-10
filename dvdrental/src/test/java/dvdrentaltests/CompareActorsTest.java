package dvdrentaltests;

import databasesetup.DatabaseSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CompareActorsTest extends DatabaseSetUp {

    @Test
    public void compareActors() throws SQLException {

        String query = "SELECT first_name FROM public.actor limit 5";

        Connection connection = setUp();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        ArrayList<String> actors = new ArrayList<>();

        actors.add("Penelope");
        actors.add("Nick");
        actors.add("Ed");
        actors.add("Jennifer");
        actors.add("Johnny");

        for (int i = 0; i < actors.size(); i++) {
            while (resultSet.next()) {

                String actual = resultSet.getString("first_name");
                String expected = actors.get(i);
                System.out.println(actual);
                System.out.println(expected);
                System.out.println("---------");
                Assert.assertEquals(actual, expected);
                break;

            }
        }
    }
}
