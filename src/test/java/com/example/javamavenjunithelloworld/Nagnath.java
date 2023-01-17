
package com.example.javamavenjunithelloworld;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.*;
import org.json.simple.parser.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class Nagnath {

	static String name;
	static String lastName;
	static String email;

	public void fetchFromJsonFile() {

		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("C:/Users/nagnath.bandgul/Desktop/response.json.txt"));
			JSONObject jsonObject = (JSONObject) obj;
			name = (String) jsonObject.get("firstName");
			lastName = (String) jsonObject.get("lastName");
			email = (String) jsonObject.get("email");
			// JSONArray subjects = (JSONArray) jsonObject.get("Subjects");
			System.out.println("Name: " + name);
			System.out.println("lastName: " + lastName);
			System.out.println("email: " + email);
			// System.out.println("Subjects:");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Order(1)
	public void textAssertion() {
		fetchFromJsonFile();
		String firstName = "shubham";
		String lastName1 = "parab";
		String email1 = "asmith@thinkingtester.com";
		assertEquals(firstName, name);
		assertEquals(lastName1, lastName);
		assertEquals(email1, email);
		System.out.println("Text Assertion Passed");
	}

	@Test
	@Order(2)
	public void patternAssertion() {
		fetchFromJsonFile();
		Pattern pattern = Pattern.compile(".com", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		boolean matchFound = matcher.find();
		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}
	}

	@Test
	@Order(3)
	public void spaceAssertion() {
		String value = "S a m p l e    C o m p a n y";
		String actual = "Sample Company";
		assertEquals(value.replaceAll("\\s+", ""),actual.replaceAll("\\s+", ""));
		//System.out.println(value.replaceAll("\\s+", ""));
	}

}
