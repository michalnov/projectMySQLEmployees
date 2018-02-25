package sk.akademiasovy.projectmysqlemployees.resources;

import javax.swing.text.html.HTMLDocument;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

@Path("/home")
public class Home {

    @GET
    @Path("/")
    @Produces({MediaType.TEXT_HTML})
    public String viewHome()
    {
        String output = "";
        try {
            File input = new File("employees.html");
            Scanner prepared = new Scanner(input);
            while (prepared.hasNextLine())
            {
                output += prepared.nextLine();
                output += "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return output;
    }
}
