package com.j4jas.library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Samuel.Iheadindu on 31/08/2017.
 * This class helps java applications connect to jasmin smpp sms gateway and send sms
 */
public class Messager {

    private static String user = "username";
    private static String pwd = "password";
    private static String from = "sender's name";
    private static String sendEndPoint = "http://domain-name/send";
    private static String checkBalanceEndPoint = "http://domain-name/balance";

    public static void sendSms(String recipient, String txt){
        try{
            String formedUrl = sendEndPoint+"?username="+user+"&password="+pwd+"&to="+recipient+"&from="+from+"&content="+ URLEncoder.encode(txt, "UTF-8");
            URL url = new URL(formedUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //log response
            //log response.toString();
        }catch(Exception e){
            //
        }
    }

    public static Integer checkBalance(){
        try{
            String formedUrl = checkBalanceEndPoint+"?username="+user+"&password="+pwd;
            URL url = new URL(formedUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            //convert to json
            //index zero is balance
            //index 1 is sms_count
        }catch(Exception e){
            //
        }
        return 0;
    }

    public static Integer checkRate(){
        return 0;
    }

    //end of class
}
