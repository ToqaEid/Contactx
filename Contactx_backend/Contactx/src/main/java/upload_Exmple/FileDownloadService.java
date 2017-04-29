package upload_Exmple;  
import java.io.File;  
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;  
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/file")  
public class FileDownloadService {  
    
    private static final String FILE_PATH = "/Users/michael/img_fjords.jpg";  
    @GET  
    @Path("/image")  
    @Produces("image/jpg")  
    public Response getFile() {  
        File file = new File(FILE_PATH);  
        ResponseBuilder response = Response.ok((Object) file);  
        response.header("Content-Disposition","attachment; filename=\"javatpoint_image.png\"");  
        return response.build();  
   
    } 
    
    
 }