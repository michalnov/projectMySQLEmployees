package sk.akademiasovy.projectmysqlemployees.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Path("/resources")
public class Resources {

    @GET
    @Path("/{path}/{file}")
    @Produces({MediaType.TEXT_PLAIN})
    public String getResour(@PathParam("path") String source, @PathParam("file") String file)
    {
        String output = "";
        String inFile = "src/main/java/sk/akademiasovy/projectmysqlemployees/resources/source/"+source+"/"+file;
        try {
            File input = new File(inFile);
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
