package com.reggie19.logFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created on 2015/12/16
 * 
 * @author Reggie
 *
 */

public class LogcatTest implements Runnable {
	static LogcatTest lt = new LogcatTest();

	public static void main(String[] args) {
		lt.run();
	}

	@Override
	public void run() {
		String command = "adb logcat";
		StringBuffer sb = new StringBuffer();
		String line = null;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");
			errorGobbler.start();
			StreamGobbler outGobbler = new StreamGobbler(proc.getInputStream(), "STDOUT");
			outGobbler.start();
//			proc.waitFor();
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			while ((line = br.readLine()) != null) {
				if (line.contains("Displayed")) {
					System.out.println(line);
					String[] str0 = line.split(" ");
					System.out.println(str0[str0.length - 1]);
					sb.append(line + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
