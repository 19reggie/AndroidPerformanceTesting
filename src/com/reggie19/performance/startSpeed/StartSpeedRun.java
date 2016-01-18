package com.reggie19.performance.startSpeed;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2015/12/18
 * 
 * @author Reggie
 *
 */
public class StartSpeedRun {
	static StartSpeedUtils ssu = new StartSpeedUtils();//ʵ����
	static StartSpeedData ssd=new StartSpeedData();

	public static void test01() throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		@SuppressWarnings("resource")
		PrintStream printStream = new PrintStream(
				new FileOutputStream(ssu.getDirectoryPath() + "\\testResult_" + ssu.getCurrentTime("yyyy-MM-dd-hhmmss") + ".html"));
		sb.append(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"> ");
		sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\"> ");
		sb.append("<head>");
		sb.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" /> ");
		sb.append("<title>Test Report for " + ssu.getDeviceName() + " -" + ssu.getDeviceId() + "</title>");
		sb.append("<style>");
		sb.append("*{font-family:Arial, Helvetica, sans-serif;font-size:14px;border:none;}");
		sb.append("body{text-align:center;} ");
		sb.append("table{margin:100px auto;} ");
		sb.append("td{width:100px;height:24px;text-align:center;line-height:24px;border:1px solid silver;}");
		sb.append(".red{color:red;}");
		sb.append(".top{background:#CCCCCC;cursor:pointer;}");
		sb.append(".up{background:#FFFFCC url(/upload/20090211095733175.gif) no-repeat right 5px;} ");
		sb.append(".down{background:#FFFFCC url(/upload/20090211095734843.gif) no-repeat right 5px;}");
		sb.append(".hov{background:#F0EFE5;} ");
		sb.append("</style>");
		sb.append("</head>");
		sb.append("<body> ");
		sb.append("<table cellpadding=\"0\" id=\"table\">");
		sb.append("<tr> ");
		sb.append("<td colspan=\"4\" bgcolor=\"#6495ED\"><span>Test Summary</span></td>");
		sb.append("</tr>");
		sb.append("<tr> ");
		sb.append("<td bgcolor=\"#6495ED\"><span>���ͼ��豸ID</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getDeviceName() + "</td>");
		sb.append("</tr>");
		sb.append("<tr> ");
		sb.append("	<td bgcolor=\"#6495ED\"><span>����汾��</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getSoftwareVersion1() + "</td>");
		sb.append("<tr>");
		sb.append("<td bgcolor=\"#6495ED\"><span>��������</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getCurrentTime("yyyy-MM-dd") + "</td>");
		sb.append("<tr> ");
		sb.append("<td rowspan=\"2\" bgcolor=\"#6495ED\"><span id=\"package_name\">����app����</span></td>");
		sb.append("<td colspan=\"3\" bgcolor=\"#6495ED\">�״�������ʱ(��λ��ms)</td> ");
		sb.append("</tr> ");
		sb.append("<tr>");
		sb.append("	<td bgcolor=\"#6495ED\">��������</td>  ");
		sb.append("<td class=\"red\" bgcolor=\"#6495ED\">ƽ��ֵ(ms)</td>");
		sb.append("<td class=\"red\" bgcolor=\"#6495ED\">���ֵ(ms)</td>");
		sb.append("</tr> ");
		// ����ѭ�����Ʊ��
		Iterator<String> iterator = ssd.testData().keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			String sPackageName = (String) key;
			System.out.println("����app����:" + sPackageName);
			sb.append("<tr><td bgcolor=\"#6495ED\"><span>" + sPackageName + "</span></td> ");
			sb.append("<td>" + ssd.cycleIndex() + "</td>");
			// ����һ��List����appÿ�������ٶ�
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < ssd.cycleIndex(); j++) {
				String sActivityName = ssd.testData().get(key);
				String sThisTime = ssu.getThisTime1(sActivityName);
				System.out.println("��" + (j + 1) + "�������ٶ�:" + sThisTime);
				list.add(sThisTime);// ��ÿ�������ٶ���ӵ�List��
				// sb.append("<td>"+sThisTime+"</td>");
			}

			System.out.println("list:" + list);
			// ��Listת��ΪString���͵�����
			String[] all = ssu.listTransformArray(list);
			System.out.println("all:" + Arrays.toString(all));

			// String��������ת��Ϊint����
			int[] iAll = ssu.arrayTransform_StringToInt(all);
			System.out.println("iAll:" + Arrays.toString(iAll));
			// int����������ƽ��ֵ
			int avg = ssu.getArraysAvg(iAll);
			// �����С��������
			Arrays.sort(iAll);
			System.out.println("iAll:" + Arrays.toString(iAll));
			int max = iAll[iAll.length - 1];// ���������һ��Ԫ�ؼ�Ϊ���ֵ
			String mAvg = String.valueOf(avg);// intת��ΪString
			String mMax = String.valueOf(max);
			System.out.println("ƽ��ֵ:" + mAvg);
			System.out.println("���ֵ:" + mMax);
			sb.append("<td>" + mAvg + "</td>");
			sb.append("<td>" + mMax + "</td>");
			sb.append("</tr>");
		}
		sb.append("</table> ");
		sb.append("</body>");
		sb.append("</html> ");
		printStream.println(sb.toString());
	}

	public static void main(String[] args) throws FileNotFoundException {
		test01();
	}

}
