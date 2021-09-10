package dvdrentaltests;

import databasesetup.DatabaseSetUp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompareTablesTest extends DatabaseSetUp {

    @Test
    public void compareTables() throws SQLException {

        String query = "SELECT first_name FROM public.actor INTERSECT SELECT first_name FROM public.customer";

        Connection connection = setUp();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next() ) {

            //This will get the names from actor table
            String actual = resultSet.getString("first_name");

            //This will get the names from customer table
            String expected = resultSet.getString("first_name");
            System.out.println(actual);
            System.out.println(expected);
            System.out.println("---------");
            Assert.assertEquals(actual, expected);

        }
    }
}
