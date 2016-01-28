package com.reggie19.performance.memory;

/**
 * Created on 2016/01/21
 * 
 * @author Reggie
 *
 */

public class MemListener implements Runnable {

	final String packageName = "com.aurora.puremanager";// 被测应用进程名
	final int count = 1000;// 循环次数

	public static void main(String[] args) {
		new MemListener().run();
	}

	@Override
	public void run() {
		int n = 1;
		System.out.println("被测应用" + packageName + "的内存趋势如下：");
		Meminfo mem = new Meminfo();
		for (int i = 0; i < count; i++) {
			System.out.println("第" + n + "次取值为" + mem.getMeminfo(packageName) + "MB");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
}
