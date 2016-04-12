package org.mayo.edu.tcga.rest;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.mayo.edu.tcga.helper.Config;
import org.mayo.edu.tcga.helper.SparqlStmt;
import org.mayo.edu.tcga.helper.Store;
import org.mayo.edu.tcga.helper.Store.OutputFormat;

/**
 * 
 * Service class that handles REST requests
 *
 */
@Path("/dataelement")
public class DataElementRestService {

    @Context
    UriInfo uriInfo;

    public DataElementRestService()  {
        
    }
    
	   
	/**
	 * Returns metadata associated with all tcga data elements.
	 * @return JSON Response
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getDataElements() {
	    String response = queryRepository(SparqlStmt.DE_ALL, Store.OutputFormat.JSON);
	    return returnResponse(response);
	}
		
    /**
     * Returns metadata associated with a specific tcga data element.
     * @param pid is the id of the data element
     * @return JSON Response
     */
	@GET 
	@Path("/{pid}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response  findDataElementById(@PathParam("pid") String pid)  {		
	    String response = queryRepository(SparqlStmt.getDataElementBasedOnId(pid), Store.OutputFormat.JSON);
	    return returnResponse(response);
	}

    /**
     * Returns permissible values associated with a specific tcga data element.
     * @param pid is the id of the data element
     * @return JSON Response
     */
    @GET 
    @Path("/{pid}/permissiblevalues")
    @Produces({MediaType.APPLICATION_JSON})
    public Response  findPermissibleValuesById(@PathParam("pid") String pid)  {      
        String value  = "";
        String response = "";

        String domainJsonn =  queryRepository(SparqlStmt.getValueDomainId(pid), Store.OutputFormat.JSON);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(domainJsonn);
    
            JsonNode valueNode = rootNode.findValue("value");
            value = valueNode.getTextValue();
    
            int index = value.indexOf("#");
            value = value.substring(index+1);
    
            response = queryRepository(SparqlStmt.getPermissibleValues(value), Store.OutputFormat.JSON);
        }
        catch(Exception e)  {
            
        }
        return returnResponse(response);   
    }

    

    private String queryRepository(String sparql, OutputFormat format)  {
        String response = "test";
       
       Config config;
       config = new Config();
       config.setConfig();

       //System.out.println(sparql);
       try {
           Store store = new Store(config.getRepositoryUrl());
           response = store.query(sparql,format, 100000);

       } catch (MalformedURLException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       return response;
   }
      
   private Response returnResponse(String response)   {
       if(response.equals("test"))  {
           return Response.status(Response.Status.NOT_FOUND).entity("Data was not retrieved").build();
       }
       return Response.status(200).entity(response).build();
   }
       
}
