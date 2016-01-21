package com.reggie19.performance.startSpeed;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class StartSpeedUtils implements AutoInterface {

	static StartSpeedUtils ssu = new StartSpeedUtils();
	final static String pressHome = "adb shell input keyevent KEYCODE_HOME";

	@Override
	public String getDeviceId() {
		String command = "adb devices";
		String[] result = ssu.execute1(command, "").split("\t");
		String[] mResult = result[0].split(" ");
		return mResult[mResult.length - 1].trim();
	}

	@Override
	public String getDeviceName() {
		String command = "adb shell getprop ro.product.device";
		String result = ssu.execute1(command, "");
		return result.trim();
	}

	@Override
	public String getPhoneModel() {
		String command = "adb shell getprop ro.product.model";
		String result = ssu.execute1(command, "");
		System.out.println(result);
		return result.trim();
	}

	@Override
	public String getSoftwareVersion1() {
		String command = "adb shell getprop ro.gn.iuniznvernumber";
		String result = ssu.execute1(command, "");
		System.out.println("软件版本号:" + result);
		return result.trim();
	}

	@Override
	public String getSoftwareVersion2() {
		String command = "adb shell getprop ro.gn.gnznvernumber";
		String result = ssu.execute1(command, "");
		System.out.println("软件版本号:" + result);
		return result.trim();
	}

	@Override
	public String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	@Override
	public File getDirectoryPath() {
		String directoryPath = System.getProperty("user.dir") + "\\repository\\results";
		File mDirectoryPath = new File(directoryPath);
		if (!mDirectoryPath.exists()) {
			mDirectoryPath.mkdirs();
		}
		return mDirectoryPath;
	}

	@Override
	public int getArraysAvg(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		int average = sum / a.length;
		return average;
	}

	@Override
	public int[] arrayTransform_StringToInt(String[] str) {
		int[] arr = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		return arr;
	}

	@Override
	public String[] listTransformArray(List<String> list) {
		int size = list.size();
		String[] all = list.toArray(new String[size]);
		return all;
	}

	@Override
	public String execute1(String command, String filter) {
		String commandResult = null;
		BufferedReader in = null;
		StringBuffer stringBuffer = new StringBuffer();
		try {
			Process proc = Runtime.getRuntime().exec(command);
			proc.waitFor();
			in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				if (line.contains(filter)) {
					// stringBuffer.append(line + "\n");
					stringBuffer.append(line);
				}
			}
			commandResult = stringBuffer.toString();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return commandResult;
	}

	@Override
	public String getThisTime1(String activityName) {
		String command = "adb shell am start -S -W -n " + activityName;
		String result = ssu.execute1(command, "ThisTime");
		ssu.execute1(pressHome, "");
		String[] result1 = result.split(":");
		return result1[1].trim();
	}

	@Override
	public String getThisTime2(String activityName) {
		String command = "adb shell am start -W -n " + activityName;
		String result = ssu.execute1(command, "ThisTime");
		ssu.execute1(pressHome, "");
		System.out.println(result);
		String[] result1 = result.split(":");
		return result1[1].trim();
	}

}
