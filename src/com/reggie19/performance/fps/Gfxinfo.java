package com.reggie19.performance.fps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class Gfxinfo {

	public static String getFPS() {
		String command = "adb shell dumpsys gfxinfo " + getPackageName();
		String commandResult = null;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			boolean tag = false;
			int n = 0;
			while ((line = in.readLine()) != null) {
				if (line.contains("Process	Execute")) {
					if (n > 0 && stringBuffer.length() < 1000) {
						stringBuffer.delete(0, stringBuffer.length());
					}
					tag = true;
					n += 1;
				}
				if (line.contains("hierarchy")) {
					tag = false;
				}
				if (tag) {
					stringBuffer.append(line + "/n");
				}
			}
			System.out.println(stringBuffer);

			String commandResult2 = stringBuffer.substring(stringBuffer.indexOf("Execute"),
					stringBuffer.indexOf("/n/n/n/n"));
			System.out.println(commandResult2);
			String[] commandResult3 = commandResult2.split("/n/n");
			System.out.println(Arrays.toString(commandResult3));
			int framesDropped = 0;
			float sumTime_FPS = 0;
			for (int i = 1; i < commandResult3.length; i++) {
				String a = commandResult3[i].trim();
				String[] b = a.split("	");
				System.out.println(Arrays.toString(b));
				float eachTime_FPS = 0;// 单帧耗时ms
				for (int j = 0; j < b.length; j++) {
					eachTime_FPS += Float.parseFloat(b[j].trim());
				}
				if (eachTime_FPS > 16) {// 每帧的处理时间不超过16ms
					framesDropped++;
				}
				// System.out.println(each_FPS);
				sumTime_FPS += eachTime_FPS;
			}
			int allNumber_FPS = commandResult3.length - 1;// 滑动一次出现的帧数
			System.out.println("总帧数=" + new DecimalFormat("0.00").format(allNumber_FPS));
			float avg_FPS = sumTime_FPS / allNumber_FPS;// 平均每帧耗时ms
			System.out.println("平均每帧耗时=" + new DecimalFormat("0.00").format(avg_FPS) + "ms");
			float FPS = 1000 / avg_FPS;// 帧率(帧)
			System.out.println("帧率=" + new DecimalFormat("0.00").format(FPS));
			System.out.println("掉帧数=" + framesDropped);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(commandResult);
		return null;
	}

	/**
	 * 
	 * @return 进程名
	 */

	public static String getPackageName() {
		String command = "adb shell dumpsys activity top | grep ACTIVITY";
		String commandResult = null;
		String mPackageName = null;
		String mPid = null;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while ((line = in.readLine()) != null) {
				stringBuffer.append(line);
			}
			commandResult = stringBuffer.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] commandResult1 = commandResult.split(" ");
		// System.out.println(Arrays.toString(commandResult1));
		mPackageName = commandResult1[1].trim().split("/")[0].trim();
		mPid = commandResult1[commandResult1.length - 1].trim().split("=")[1].trim();
		System.out.println(
				"commandResult=" + commandResult + "\n" + "mPackageName=" + mPackageName + "\n" + "mPid=" + mPid);
		return mPackageName;
	}

	public static void main(String[] args) {
		// getPackageName();
		getFPS();
	}

}
