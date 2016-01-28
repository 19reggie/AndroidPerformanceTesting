package com.reggie19.performance.memory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created on 2016/01/22
 * 
 * @author Reggie
 *
 */

public class MemListener2 implements Runnable {

	final String packageName = "com.aurora.puremanager";// 被测应用进程名
	final int count = 10000;// 循环次数

	public static void main(String[] args) {
		 new MemListener2().run();
	}

	@Override
	public void run() {
		File mmFile = createFile();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(mmFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		int n = 1;
		System.out.println("被测应用" + packageName + "的内存趋势如下：");
		Meminfo mem = new Meminfo();
		for (int i = 0; i < count; i++) {
			String mMem = mem.getMeminfo(packageName);
			System.out.println("第" + n + "次取值为" + mMem + "MB");
			byte[] b1 = (mMem + "\n").getBytes();
			try {
				fos.write(b1);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File createFile() {
		String directoryPath = System.getProperty("user.dir") + "\\repository\\results";
		String file = directoryPath + "\\mem-" + getCurrentTime("yyyy-MM-dd-hhmmss") + ".xls";
		File mDirectoryPath = new File(directoryPath);
		File mFile = new File(file);
		if (!mDirectoryPath.exists() && !mFile.exists()) {
			mDirectoryPath.mkdirs();
			try {
				mFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mFile;
	}

	public String getCurrentTime(String format) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
