
package com.reggie19.performance.startSpeed;

import java.util.HashMap;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class StartSpeedData {
	
	//��Ӧ�ô���
	public int cycleIndex(){
		return 10;
	}
	/**
	 * ʹ��HashMap���洢����Ӧ�����ݣ�PackageName��Activity�Լ�ֵ�Ե���ʽ���д洢
	 * @return
	 */
	public HashMap<String, String> testData(){
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("����", "com.android.contacts/com.android.contacts.activities.AuroraDialActivity");
		hashMap.put("��ϵ��", "com.android.contacts/com.android.contacts.activities.AuroraPeopleActivity");
		hashMap.put("��Ϣ", "com.android.mms/com.aurora.mms.ui.AuroraConvListActivity");
		hashMap.put("�����", "com.android.browser/com.android.browser.BrowserActivity");
		hashMap.put("���", "com.android.camera/com.android.camera.CameraLauncher");
		hashMap.put("���", "com.android.gallery3d/com.android.gallery3d.app.Gallery");
		hashMap.put("����", "com.android.calendar/com.android.calendar.AllInOneActivity");
		hashMap.put("ʱ��", "com.android.deskclock/com.android.deskclock.AlarmClock");
		hashMap.put("����", "com.android.settings/com.android.settings.Settings");
		hashMap.put("������", "com.android.calculator2/com.android.calculator2.Calculator");
		return hashMap;
	}

}
