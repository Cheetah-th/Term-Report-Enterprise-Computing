/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static java.lang.Integer.parseInt;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

/**
 *
 * @author Cheetah
 */
public class Handle {
    
   public static String ParseJsonResponse(String status){
        try {
            String api = "";
            int s = parseInt(status);
            switch(s) {
                case 1:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=a69d43bd-be69-4989-8adc-bdcf6ca2c5ee";
                    //��ṹ����¢ͧ�š�÷��ͺ O-NET ����Ѹ���֡�һշ�� 6 �ա���֡�� 2562 ��ṡ��������Ҥ
                    break;
                case 2:
                    api = "https://opend.data.go.th/get-ckan/datastore_search?resource_id=662f2af8-2779-4bbe-af3b-ca716d6a4f54";
                    //��ṹ����¢ͧ�š�÷��ͺ O-NET ����Ѹ���֡�һշ�� 6 �ա���֡�� 2562 ��ṡ������С�����¹���
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
            //return json.getJSONObject("result").getJSONArray("records").toString(4);
            //return json.getJSONObject("result").getJSONArray("records").optJSONObject(0).toString(4);
            //return json.getJSONObject("result").getJSONArray("records").optJSONObject(0).get("REGION_NAME").toString(); 
        }
        catch (Exception e){
            return "Error: " + e;
        }
    }
   
}