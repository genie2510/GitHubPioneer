package com.lambda.tutorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.UnsupportedCharsetException;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SneakyException {

	public String resourceAsString() {
	    try 
	    {
	    	InputStream is = this.getClass().getResourceAsStream("/check.txt"); 
	        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        return br.lines().collect(Collectors.joining("\n"));
	    } catch (IOException | UnsupportedCharsetException ex) {
	        // If this ever happens, then its a bug.
	        throw new RuntimeException(ex);
	    }
	}
	
	public static void main(String[] args) {
		String str = new SneakyException().resourceAsString();
		System.out.println(str);
		//log.info("11111111111111111");
	}
}
