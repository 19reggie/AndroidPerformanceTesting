package com.reggie19.performance.cpu;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class CpuListener implements Runnable {
	
	final String packageName = "com.aurora.puremanager";// ����Ӧ�ý�����
	final int count = 10;// ѭ������
	public static void main(String[] args) {
		new CpuListener().run();
	}

	@Override
	public void run() {
		int n = 1;
		System.out.println("����Ӧ��" + packageName + "��CPU�������£�");
		Cpuinfo cpu = new Cpuinfo();
		for (int i = 0; i < count; i++) {
			System.out.println("��" + n + "��ȡֵΪ" + cpu.getTopCpu(packageName) + "%");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
		
	}

}
