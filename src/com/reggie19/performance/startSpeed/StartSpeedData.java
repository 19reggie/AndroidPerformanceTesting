
package com.reggie19.performance.startSpeed;

import java.util.HashMap;

/**
 * Created on 2016/01/18
 * 
 * @author Reggie
 *
 */

public class StartSpeedData {
	
	//打开应用次数
	public int cycleIndex(){
		return 10;
	}
	/**
	 * 使用HashMap来存储待测应用数据：PackageName和Activity以键值对的形式进行存储
	 * @return
	 */
	public HashMap<String, String> testData(){
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("拨号", "com.android.contacts/com.android.contacts.activities.AuroraDialActivity");
		hashMap.put("联系人", "com.android.contacts/com.android.contacts.activities.AuroraPeopleActivity");
		hashMap.put("信息", "com.android.mms/com.aurora.mms.ui.AuroraConvListActivity");
		hashMap.put("浏览器", "com.android.browser/com.android.browser.BrowserActivity");
		hashMap.put("相机", "com.android.camera/com.android.camera.CameraLauncher");
		hashMap.put("相册", "com.android.gallery3d/com.android.gallery3d.app.Gallery");
		hashMap.put("日历", "com.android.calendar/com.android.calendar.AllInOneActivity");
		hashMap.put("时钟", "com.android.deskclock/com.android.deskclock.AlarmClock");
		hashMap.put("设置", "com.android.settings/com.android.settings.Settings");
		hashMap.put("计算器", "com.android.calculator2/com.android.calculator2.Calculator");
		return hashMap;
	}

}
