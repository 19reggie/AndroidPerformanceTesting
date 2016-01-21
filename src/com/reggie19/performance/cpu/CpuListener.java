package com.reggie19.performance.cpu;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class CpuListener implements Runnable {
	
	final String packageName = "com.aurora.puremanager";// 被测应用进程名
	final int count = 10;// 循环次数
	public static void main(String[] args) {
		new CpuListener().run();
	}

	@Override
	public void run() {
		int n = 1;
		System.out.println("被测应用" + packageName + "的CPU趋势如下：");
		Cpuinfo cpu = new Cpuinfo();
		for (int i = 0; i < count; i++) {
			System.out.println("第" + n + "次取值为" + cpu.getTopCpu(packageName) + "%");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
		
	}

}
