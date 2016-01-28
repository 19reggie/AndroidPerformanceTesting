package com.reggie19.performance.memory;

/**
 * Created on 2016/01/21
 * 
 * @author Reggie
 *
 */

public class MemListener implements Runnable {

	final String packageName = "com.aurora.puremanager";// ����Ӧ�ý�����
	final int count = 1000;// ѭ������

	public static void main(String[] args) {
		new MemListener().run();
	}

	@Override
	public void run() {
		int n = 1;
		System.out.println("����Ӧ��" + packageName + "���ڴ��������£�");
		Meminfo mem = new Meminfo();
		for (int i = 0; i < count; i++) {
			System.out.println("��" + n + "��ȡֵΪ" + mem.getMeminfo(packageName) + "MB");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			n++;
		}
	}
}
