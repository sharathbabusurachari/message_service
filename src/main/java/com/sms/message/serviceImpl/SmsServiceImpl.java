package com.sms.message.serviceImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.sms.message.module.SmsModule;
import com.sms.message.service.SmsService;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public String getTelspielSms(SmsModule smsModule) {

		try {
			String baseURL = "https://api.telsp.in/pushapi/sendbulkmsg";

			String username = "SwatApi";
			String dest = smsModule.getDest();
			String apikey = "uhEqWZKRPDOVmUB91K1VgegFg6pgTuqW";
			String signature = "SASWTF";
			String msgtype = "PM";
			String entityid = "1101415480000073106";
			String templateid = "1107170781932088080";
			int smsotp = smsModule.getOtp();
			String msgtxt = "Greetings%20from%20Saswat%20Finance%2C%20your%20otp%20is%20"+smsotp+"%20for%20the%20verification.%20-%20Saswat%20Finance.%20-SASWAT%20Financial%20Services%20Pvt%20LTD";

			// Build the full URL
	        String fullURL = String.format("%s?username=%s&dest=%s&apikey=%s&signature=%s&msgtype=%s&msgtxt=%s&entityid=%s&templateid=%s",
	                baseURL, username, dest, apikey, signature, msgtype, msgtxt, entityid, templateid);

			URL url = new URL(fullURL);

			// Open connection
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set request method
			connection.setRequestMethod("POST");

			// Get response code
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// Read response
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			String smsResponse = response.toString();

			// Print response
			System.out.println("Response: " + smsResponse );

			// Close connection
			connection.disconnect();
			
	

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
