package com.qa.todo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Utils {
	public static String sha256(String text) {
		String hex = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("sha-256");
			md.update(text.getBytes("UTF-8"));
			byte[] digest = md.digest();
			hex = DatatypeConverter.printHexBinary(digest);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hex;
	}
}
