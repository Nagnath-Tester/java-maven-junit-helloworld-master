package com.example.javamavenjunithelloworld;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.commons.lang3.RandomStringUtils;

public class DataCreation {

	public static String printPages() {

		// To Print Header

		String empty = "";
		for (int i = 0; i < 80; i++) {
			empty = empty.concat("=");
		}
		empty = empty.concat("\r");
		String header = "Sample Company";
		for (int i = 80; i > header.length(); i--) {
			empty = empty.concat("\s");
		}
		empty = empty + header + "\r";

		// To Print Lines

		for (int j = 0; j < 49; j++) {
			String random = "";
			int count = 0;

			// To Print Random data in Line

			for (int i = 0; i < 80; i++) {
				int minLength = 1;
				int maxLength = 10;
				String randomString = RandomStringUtils.randomAlphabetic(minLength, maxLength);
				randomString = randomString.concat("\s");
				count = randomString.length() + count;
				i = count;
				random = random + randomString;
			}
			empty = empty + random.substring(0, 79) + "\r";

		}

		// To Print Testing Once

		String random = "";
		int count = 0;
		for (int i = 0; i < 73; i++) {
			int minLength = 1;
			int maxLength = 10;
			String randomString = RandomStringUtils.randomAlphabetic(minLength, maxLength);
			randomString = randomString.concat("\s");
			count = randomString.length() + count;
			i = count;
			random = random + randomString;
		}

		// To Print Testing Word

		empty = empty +"testing"+ "\s"+ random.substring(0, 72) + "\r";

		// To Print Footer

		for (int i = 0; i < 65; i++) {
			empty = empty.concat("-");
		}
		empty = empty + "\r";
		for (int i = 0; i < 32; i++) {
			empty = empty.concat("\s");
		}

		return empty;
	}

	public static void main(String[] args) {

		try {
			File myObj = new File("./src/main/java/Test File Finance.txt");
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		String pageContent = "";
		for (int i = 1; i <= 11; i++) {
			if (i == 11) {
				String printFinance = printPages();
				printFinance = printFinance.replace("testing", "testing Finance finance finance ");
				printFinance = printFinance.substring(0, 4160);
				printFinance = printFinance + "\r";
				for (int j = 0; j < 65; j++) {
					printFinance = printFinance.concat("-");
				}
				printFinance = printFinance + "\r";
				for (int k = 0; k < 32; k++) {
					printFinance = printFinance.concat("\s");
				}

				pageContent = pageContent + printFinance;

			} else {
				pageContent = pageContent + printPages();
			}

			pageContent = pageContent + i + "\r";
			pageContent = pageContent + "Sample Company" + "\r";
		}

		try {
			FileOutputStream fos = new FileOutputStream("./src/main/java/Test File Finance.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
			bufferedWriter.write(pageContent);
			System.out.println("Written Successfull");
			bufferedWriter.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
