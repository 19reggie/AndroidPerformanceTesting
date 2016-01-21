package com.reggie19.performance.cpu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class Cpuinfo {
	
	public String getTopCpu(String packageName) {
		String command = "adb shell top -n 1 | grep " + packageName;
		String commandResult = null;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				stringBuffer.append(line);
			}
			// System.out.println(stringBuffer.toString());
			String result0 = stringBuffer.toString().split("%")[0].trim();
			// System.out.println(result0);
			String[] result1 = result0.split(" ");
			commandResult = result1[result1.length - 1].trim();
			// System.out.println(commandResult+"%");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return commandResult;
	}

}
