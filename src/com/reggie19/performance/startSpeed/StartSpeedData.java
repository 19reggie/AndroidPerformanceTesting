
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
//		hashMap.put("���", "com.android.gallery3d/com.android.gallery3d.app.Gallery");
//		hashMap.put("����", "com.android.music/com.android.auroramusic.ui.AuroraMediaPlayHome");
//		hashMap.put("����¼", "com.aurora.note/com.aurora.note.NoteMainActivity");
//		hashMap.put("����", "com.android.calendar/com.android.calendar.AllInOneActivity");
//		hashMap.put("ʱ��", "com.android.deskclock/com.android.deskclock.AlarmClock");
//		hashMap.put("����", "com.android.settings/com.android.settings.Settings");
//		hashMap.put("Ӧ���̵�", "com.aurora.market/com.aurora.market.MarketMainActivity");
//		hashMap.put("�ļ�����", "com.aurora.filemanager/com.aurora.filemanager.FileExplorerTabActivity");
//		hashMap.put("�ʼ�", "com.aurora.email/com.android.email.activity.setup.AccountSetupBasics");
//		hashMap.put("����", "com.aurora.weatherforecast/com.aurora.weatherforecast.AuroraWeatherMain");
//		hashMap.put("Ӧ�ù���", "com.aurora.secure/com.secure.activity.MainActivity");
//		hashMap.put("����ͳ��", "com.aurora.netmanage/com.netmanage.activity.NetMainActivity");
//		hashMap.put("ɧ������", "com.aurora.reject/com.aurora.reject.AuroraRejectActivity");
//		hashMap.put("ϵͳ����", "gn.com.android.update/gn.com.android.update.ui.UpdateUiActivity");
//		hashMap.put("��˽", "com.aurora.privacymanage/com.privacymanage.activity.PageWelcome");
//		hashMap.put("������", "com.android.calculator2/com.android.calculator2.Calculator");
		return hashMap;
	}
	
	public HashMap<String, String> testData2(){
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("΢��", "com.tencent.mm/com.tencent.mm.ui.LauncherUI");
		hashMap.put("�ռ�", "com.qzone/com.qzonex.app.tab.QZoneTabActivity");
		hashMap.put("΢��", "	com.sina.weibo/com.sina.weibo.MainTabActivity");
		hashMap.put("������������", "	tv.danmaku.bili/tv.danmaku.bili.MainActivity");
		return hashMap;
	}

}
