
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
//		hashMap.put("相册", "com.android.gallery3d/com.android.gallery3d.app.Gallery");
//		hashMap.put("音乐", "com.android.music/com.android.auroramusic.ui.AuroraMediaPlayHome");
//		hashMap.put("备忘录", "com.aurora.note/com.aurora.note.NoteMainActivity");
//		hashMap.put("日历", "com.android.calendar/com.android.calendar.AllInOneActivity");
//		hashMap.put("时钟", "com.android.deskclock/com.android.deskclock.AlarmClock");
//		hashMap.put("设置", "com.android.settings/com.android.settings.Settings");
//		hashMap.put("应用商店", "com.aurora.market/com.aurora.market.MarketMainActivity");
//		hashMap.put("文件管理", "com.aurora.filemanager/com.aurora.filemanager.FileExplorerTabActivity");
//		hashMap.put("邮件", "com.aurora.email/com.android.email.activity.setup.AccountSetupBasics");
//		hashMap.put("天气", "com.aurora.weatherforecast/com.aurora.weatherforecast.AuroraWeatherMain");
//		hashMap.put("应用管理", "com.aurora.secure/com.secure.activity.MainActivity");
//		hashMap.put("流量统计", "com.aurora.netmanage/com.netmanage.activity.NetMainActivity");
//		hashMap.put("骚扰拦截", "com.aurora.reject/com.aurora.reject.AuroraRejectActivity");
//		hashMap.put("系统升级", "gn.com.android.update/gn.com.android.update.ui.UpdateUiActivity");
//		hashMap.put("隐私", "com.aurora.privacymanage/com.privacymanage.activity.PageWelcome");
//		hashMap.put("计算器", "com.android.calculator2/com.android.calculator2.Calculator");
		return hashMap;
	}
	
	public HashMap<String, String> testData2(){
		HashMap<String, String> hashMap=new HashMap<String, String>();
		hashMap.put("微信", "com.tencent.mm/com.tencent.mm.ui.LauncherUI");
		hashMap.put("空间", "com.qzone/com.qzonex.app.tab.QZoneTabActivity");
		hashMap.put("微博", "	com.sina.weibo/com.sina.weibo.MainTabActivity");
		hashMap.put("哔哩哔哩动画", "	tv.danmaku.bili/tv.danmaku.bili.MainActivity");
		return hashMap;
	}

}
