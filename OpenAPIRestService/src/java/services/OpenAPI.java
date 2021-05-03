/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXB;
import org.json.*;

/**
 * REST Web Service
 *
 * @author Cheetah
 */
@Path("openapi")
public class OpenAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OpenAPI
     */
    public OpenAPI() {
    }

    /**
     * Retrieves representation of an instance of services.OpenAPI
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{selected_api}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml(@PathParam("selected_api") int s) {
        try {
            String api = "";
            switch(s) {
                case 1:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=7c8f759f-d7cb-4813-b514-5736c7a85994";
                    //อัตราการเข้าถึงของบริการอินเทอร์เน็ตความเร็วสูงต่อจำนวนครัวเรือน
                    break;
                case 2:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=d3b73175-472b-4bea-af36-7a257417186f";
                    //จำนวนผู้ลงทะเบียนใช้บริการอินเทอร์เน็ตความเร็วสูง
                    break;
            }
            URL url = new URL(api);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            //adding header
            httpURLConnection.setRequestProperty("api-key", "7WdWmMdO9m4gqUppmSUqCos02vmOrYCP");

            String line = "";
            InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder response = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null){
                response.append(line);
            }
            bufferedReader.close();
            JSONObject json = new JSONObject(response.toString());
            return json.toString(4);
        }
        catch (Exception e){
            return "Error: " + e;
        }
        
    }

    /**
     * PUT method for updating or creating an instance of OpenAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}