package com.smartentities.plugins.blake2b.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import com.smartentities.plugins.blake2b.Blake2b;
import com.smartentities.plugins.blake2b.ByteUtils;
import com.smartentities.plugins.blake2b.security.Blake2bProvider;

public class PluginTest {

	public static void main(String[] args) {
		
		Security.addProvider(new Blake2bProvider());
		
		final String input = "hello";

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(Blake2b.BLAKE2_B_256);
			digest.update(input.getBytes());

			//String hash = new String(digest.digest());
			String hash = ByteUtils.bytesToHex(digest.digest()); 
			System.out.println("Hash output: "+hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
