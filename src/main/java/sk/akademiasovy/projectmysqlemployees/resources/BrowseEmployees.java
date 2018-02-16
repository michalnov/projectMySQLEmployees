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
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public HTMLDocument home()
    {
        HTMLDocument result = new HTMLDocument();
        return result;
    }

    @GET
    @Path("/emploiees")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees()
    {
        String result = "";

        try {
            List<String> res = new ArrayList<>();
            MysqlEmployees mySQL = new MysqlEmployees();
            res = mySQL.getEmployees();

            int i = 0;
            for (String swap: res) {
                if (i==0)
                {
                    result = "resultEmployees({\"emp\"[";
                    result += "\""+ swap +"\"";
                }
                else
                {
                    result += ",\""+ swap +"\"";
                }
            }
            result += "]})";

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

            int i = 0;
            for (String swap: res) {
                if (i==0)
                {
                    result = "resultSalary({\"sal\"[";
                    result += "\""+ swap +"\"";
                }
                else
                {
                    result += ",\""+ swap +"\"";
                }
            }
            result += "]})";

        }
        catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
        return result;
    }
}
