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
	static StartSpeedUtils ssu = new StartSpeedUtils();//实例化
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
		sb.append("<td bgcolor=\"#6495ED\"><span>机型及设备ID</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getDeviceName() + "</td>");
		sb.append("</tr>");
		sb.append("<tr> ");
		sb.append("	<td bgcolor=\"#6495ED\"><span>软件版本号</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getSoftwareVersion1() + "</td>");
		sb.append("<tr>");
		sb.append("<td bgcolor=\"#6495ED\"><span>测试日期</span></td>");
		sb.append("<td colspan=\"3\">" + ssu.getCurrentTime("yyyy-MM-dd") + "</td>");
		sb.append("<tr> ");
		sb.append("<td rowspan=\"2\" bgcolor=\"#6495ED\"><span id=\"package_name\">被测app包名</span></td>");
		sb.append("<td colspan=\"3\" bgcolor=\"#6495ED\">首次启动耗时(单位：ms)</td> ");
		sb.append("</tr> ");
		sb.append("<tr>");
		sb.append("	<td bgcolor=\"#6495ED\">启动次数</td>  ");
		sb.append("<td class=\"red\" bgcolor=\"#6495ED\">平均值(ms)</td>");
		sb.append("<td class=\"red\" bgcolor=\"#6495ED\">最大值(ms)</td>");
		sb.append("</tr> ");
		// 创建循环绘制表格
		Iterator<String> iterator = ssd.testData().keySet().iterator();
		while (iterator.hasNext()) {
			Object key = iterator.next();
			String sPackageName = (String) key;
			System.out.println("被测app包名:" + sPackageName);
			sb.append("<tr><td bgcolor=\"#6495ED\"><span>" + sPackageName + "</span></td> ");
			sb.append("<td>" + ssd.cycleIndex() + "</td>");
			// 创建一个List单个app每次启动速度
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < ssd.cycleIndex(); j++) {
				String sActivityName = ssd.testData().get(key);
				String sThisTime = ssu.getThisTime1(sActivityName);
				System.out.println("第" + (j + 1) + "次启动速度:" + sThisTime);
				list.add(sThisTime);// 将每次启动速度添加到List中
				// sb.append("<td>"+sThisTime+"</td>");
			}

			System.out.println("list:" + list);
			// 将List转换为String类型的数组
			String[] all = ssu.listTransformArray(list);
			System.out.println("all:" + Arrays.toString(all));

			// String类型数组转换为int类型
			int[] iAll = ssu.arrayTransform_StringToInt(all);
			System.out.println("iAll:" + Arrays.toString(iAll));
			// int类型数组求平均值
			int avg = ssu.getArraysAvg(iAll);
			// 数组从小到大排序
			Arrays.sort(iAll);
			System.out.println("iAll:" + Arrays.toString(iAll));
			int max = iAll[iAll.length - 1];// 数组中最后一个元素即为最大值
			String mAvg = String.valueOf(avg);// int转换为String
			String mMax = String.valueOf(max);
			System.out.println("平均值:" + mAvg);
			System.out.println("最大值:" + mMax);
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
