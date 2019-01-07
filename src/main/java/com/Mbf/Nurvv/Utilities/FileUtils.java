package com.Mbf.Nurvv.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileUtils {

	public static String readFile(String path) {
		
		String text = "";
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			
			StringBuilder builder = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
			fis.close();
			reader.close();
			text = builder.toString();
		} catch(Exception e) {
			
		}
		return text;
	}
}
