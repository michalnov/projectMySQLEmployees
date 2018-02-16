package sk.akademiasovy.projectmysqlemployees.resources;

import sk.akademiasovy.projectmysqlemployees.db.MysqlEmployees;

import javax.swing.text.html.HTMLDocument;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.*;
import java.util.List;

@Path("/read")
public class BrowseEmployees {

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees()
    {
        String result = "";

        try {
            List<String> res = new ArrayList<>();
            MysqlEmployees mySQL = new MysqlEmployees();
            res = mySQL.getEmployees();

            boolean i = false;
            for (String swap: res) {
                if (i == false)
                {
                    result = "resultEmployees({\"emp\":[";
                    result = result +swap;
                    i = true;
                }
                else
                {
                    result = result + ","+ swap;
                }
            }
            result = result + "]})";

        }
        catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return result;
    }

    @GET
    @Path("salary/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSalary(@PathParam("id") String id)
    {
        String result = "";

        try {
            List<String> res = new ArrayList<>();
            MysqlEmployees mySQL = new MysqlEmployees();
            res = mySQL.getSalary(id);

            boolean i = false;
            for (String swap: res) {
                if (i == false)
                {
                    result = "resultSalary(";
                    result +=  swap;
                    i = true;
                }
                else
                {
                    result += ","+ swap;
                }
            }
            result += ")";

        }
        catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return result;
    }
}
