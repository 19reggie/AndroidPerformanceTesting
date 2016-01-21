package com.reggie19.performance.memory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created on 2016/01/21
 * 
 * @author Reggie
 *
 */

public class Meminfo {
	/*
	 * Pss对应的TOTAL值
	 */

	public String getMeminfo(String packageName) {
		String command = "adb shell dumpsys meminfo " + packageName;
		String commandResult = null;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				if (line.contains("No process found for")) {
					stringBuffer.append(line);
					System.out.println(stringBuffer.toString());
				} else if (line.contains("TOTAL")) {
					stringBuffer.append(line);
//					System.out.println(stringBuffer.toString());
					String result0 = stringBuffer.toString().trim().split("    ")[1].trim();
//					System.out.println(result0+"KB");
					double result1 = Double.parseDouble(result0) / 1024;
					commandResult = new DecimalFormat("0.00").format(result1);
//					System.out.println(commandResult + "MB");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return commandResult;
	}

}
