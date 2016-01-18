package com.reggie19.performance.startSpeed;

import java.io.File;
import java.util.List;

/**
 * Created on 2015/12/18
 * 
 * @author Reggie
 *
 */

public interface AutoInterface {

	public String getThisTime1(String activityName);// 首次启动时间

	public String getThisTime2(String activityName);// 二次启动时间

	public String getDeviceId();

	public String getDeviceName();

	public String getPhoneModel();

	public String getSoftwareVersion1();

	public String getSoftwareVersion2();

	public String getCurrentTime(String format);//String format="yyyy-MM-dd"或者"yyyy-MM-dd-hhmmss"

	public File getDirectoryPath();

	public int getArraysAvg(int[] a);// 数组求平均值

	public int[] arrayTransform_StringToInt(String[] str);// 将String[]转换成int[]

	public String[] listTransformArray(List<String> list);// List转换为数组

	public String execute1(String command, String filter);

}
