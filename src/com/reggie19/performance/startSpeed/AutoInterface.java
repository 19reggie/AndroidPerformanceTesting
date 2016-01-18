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

	public String getThisTime1(String activityName);// �״�����ʱ��

	public String getThisTime2(String activityName);// ��������ʱ��

	public String getDeviceId();

	public String getDeviceName();

	public String getPhoneModel();

	public String getSoftwareVersion1();

	public String getSoftwareVersion2();

	public String getCurrentTime(String format);//String format="yyyy-MM-dd"����"yyyy-MM-dd-hhmmss"

	public File getDirectoryPath();

	public int getArraysAvg(int[] a);// ������ƽ��ֵ

	public int[] arrayTransform_StringToInt(String[] str);// ��String[]ת����int[]

	public String[] listTransformArray(List<String> list);// Listת��Ϊ����

	public String execute1(String command, String filter);

}
