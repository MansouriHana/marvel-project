package com.marvel.services;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class MarvelService {

	final String PRIVATE_KEY = "6e03811164a4587b5dae0d34aa4bedd0f2c79c06";
	final String PUBLIC_KEY = "e6ac9288c6d876d4bfc62989d7d9086f";
	final String BASE_URL = "https://gateway.marvel.com:443/v1/public/";
	Long ts = Timestamp.from(Instant.now()).getTime();

	public JSONObject getCharactersList() throws NoSuchAlgorithmException, IOException, ParseException {
		String hash = getMd5fromHash();
		JSONObject data_obj;
		URL url = new URL(BASE_URL + "characters?ts=" + ts + "&apikey=" + PUBLIC_KEY + "&hash=" + hash);
		System.out.println("URL ==> " + BASE_URL + "characters?ts=" + ts + "&apikey=" + PUBLIC_KEY + "&hash=" + hash);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		System.out.println("responsecode ==> " + responsecode);
		if (responsecode != 200) {
			throw new RuntimeException("HttpResponseCode: " + responsecode);
		} else {
			String inline = "";
			Scanner scanner = new Scanner(url.openStream());
			// Write all the JSON data into a string using a scanner
			while (scanner.hasNext()) {
				inline += scanner.nextLine();
			}
			// Close the scanner
			scanner.close();
			// Using the JSON simple library parse the string into a json object
			JSONParser parse = new JSONParser();
			data_obj = (JSONObject) parse.parse(inline);
		}
		return data_obj;
	}

	public String getMd5fromHash() throws NoSuchAlgorithmException {
		String plaintext = ts + PRIVATE_KEY + PUBLIC_KEY;
		MessageDigest m;
		m = MessageDigest.getInstance("MD5");
		m.reset();
		m.update(plaintext.getBytes());
		byte[] digest = m.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashtext = bigInt.toString(16);
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		System.out.println("hashtext >> " + hashtext);
		return hashtext;

	}

}
