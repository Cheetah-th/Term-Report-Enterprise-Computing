package opendataapi;

import org.json.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenDataAPI {
    public static void main(String args[]){
        int selected_api = 1;
        System.out.println("HTTP Request Example ");
        ParseJsonResponse(selected_api);
    }
    
   public static void ParseJsonResponse(int s){
        try {
            String api = "";
            switch(s) {
                case 1:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=a69d43bd-be69-4989-8adc-bdcf6ca2c5ee";
                    //คะแนนเฉลี่ยของผลการทดสอบ O-NET ชั้นมัธยมศึกษาปีที่ 6 ปีการศึกษา 2562 จำแนกตามภูมิภาค
                    break;
                case 2:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=662f2af8-2779-4bbe-af3b-ca716d6a4f54";
                    //คะแนนเฉลี่ยของผลการทดสอบ O-NET ชั้นมัธยมศึกษาปีที่ 6 ปีการศึกษา 2562 จำแนกตามสาระการเรียนรู้
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
            //System.out.println("Response : " + response.toString());
            JSONObject json = new JSONObject(response.toString());
            System.out.println(json.toString(4)); 
            //System.out.println(json.getJSONObject("result").getJSONArray("records").toString(4));
            //System.out.println(json.getJSONObject("result").getJSONArray("records").optJSONObject(0).toString(4)); 
            //System.out.println(json.getJSONObject("result").getJSONArray("records").optJSONObject(0).get("REGION_NAME")); 

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}