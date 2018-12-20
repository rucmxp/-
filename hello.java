package lizi;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class hello {
		public void Test(int n){
			System.out.println("你输入的三角形如图");
			for (int i = 0; i < n; i++) {
			for (int j = 0; j <= n-1-i; j++) {
					System.out.print(" ");
					}
			for (int k = 0; k <= i; k++) {
			System.out.print("* ");
			}
			//每遍历一次换一行
			System.out.println("  ");
			}		
			}
			
		
//		2.写一个类实现验证邮箱账号的功能
//		要求：1.邮箱后缀名必须为@126.com或者@163.com或者@163
//		          2.邮箱账号可以由数字、大小写的字母组成，不能包含空格及其他特殊符号
//			  3.邮箱账号首位必须为字母，不能为纯数字或者纯字母		
	public void test() {
		boolean star = true;
		while(star) {
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
			//判断用户有没有输入
		if(s != null && !s.equals("")){
			char[] cha = s.toCharArray();
			char shou = cha[0];
			if (shou >= 97 && shou <= 122 || (shou >= 65 && shou <= 90)) {
				if (s.endsWith("@126.com") || s.endsWith("@163.com")) {
					// 截取用户输入的字符串@符号前面的内容 进行判断用户输入的是否纯字母或者纯数字
					String ne = s.substring(0, s.indexOf("@"));
								char chars[] = ne.toCharArray();
			if (ne.length() >= 6 && ne.length() <= 16) {
						boolean flag = false;
					for (int i = 0; i < chars.length; i++) {
					// 判断字符串不能包含特殊符号
		if ((chars[i] >= 48 && chars[i] <= 57)|| (chars[i] >= 65 && chars[i] <= 90)	|| (chars[i] >= 97 && chars[i] <= 122)) {
						flag = true;
					} else {
				System.out.println("你输入的格式有误！不能包含空格及其他特殊符号");
					flag = false;
					break;
										}
									}
				if (flag) {
					for (int i = 0; i < chars.length; i++) {
					// 判断输入的字符串不能为纯数字
			if ((chars[i] >= 65 && chars[i] <= 90)|| (chars[i] >= 97 && chars[i] <= 122)) {
		flag = false;
		} else {
					flag = true;
						break;
							}
									}
					if (flag) {
					System.out.println("你的邮箱为" + s + "已经录入成功");
										star = false;
									} else {
		System.out.println("你输入的格式有误！不能输入纯数字或者纯字母");
										}
									}
								} else {
			System.out.println("你输入的格式有误！长度必须大于6小于16！");
								}

							} else {
			System.out.println("你输入的格式有误！邮箱的后缀名必须为@126.com或者@163.com或者@163！请重新输入！");
							}
						} else {
							System.out.println("你输入的格式有误！首字必须为字母！请重新输入！");
						}

					} else {
						System.out.println("你的输入内容不得为空");
					}
				}
			}
				
//	1.写一个打印日历表的方法，格式参考电脑上面的系统时间
//	要求：可以查询任意年月日的月日历；
//	用*标记当前天
	
//	public void t1() {
	/*class CalendarTest {
		public static void main(String[] args) {

		boolean flag= true;
		while (flag) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("请输入你要查询的日期!只允许输入格式为2017-1-1");
		String aa=scanner.nextLine();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		try {
		Calendar calendar= Calendar.getInstance();
		Datedate=dateFormat.parse(aa);
		System.out.println(dateFormat.format(date.getTime()));
		calendar.set(Calendar.YEAR,date.getYear()+1900);
		calendar.set(Calendar.MONTH, date.getMonth());
		calendar.set(Calendar.DATE, date.getDate());
		System.out.println(" Sun Mon Thu Wed Thu Fri Sat");
		int today = calendar.get(Calendar.DAY_OF_MONTH);//当天
		int month = calendar.get(Calendar.MONTH);//当月
		int firstDayOfWeek =calendar.getFirstDayOfWeek();//每周从周几开始
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		int firstday = calendar.get(Calendar.DAY_OF_WEEK);
		do {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if(day == 1){
		System.out.print(" ");
		for(int i =0;i<firstday-1;i++){< span=""></firstday-1;i++){<>
		System.out.print(" ");
		}
		}
		System.out.printf("%3d", day);
		if (day == today) {
		System.out.print("*");
		} else {
		System.out.print(" ");
		}
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		if (calendar.get(Calendar.DAY_OF_WEEK) == firstDayOfWeek) {
		System.out.println();
		System.out.print(" ");
		}
		} while (calendar.get(Calendar.MONTH) == month);
		flag=false;}
		catch (ParseException e) {
		System.out.println("你输入的格式有误请重新输入");
		flag=true;
		}
		}
		*/	
//	}
	
	
	//传递数组，调用方法
	public static void fun(int...args) {
	
//		foreach 循环  for(数据类型  变量名称：数组名称)
		
		for(int x:args) {
			System.out.print(x+"\t");
		}
	}
	
/*	1.一球从100米高度自由落下，每次落地后反跳回原高度的一半；
	 再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
	 (考察知识点：循环语句) */	
	void ball() {
		int height = 100;
		int sum =100;
		for(int i=0;i<10;i++) {
			height =height/2;
			sum +=height;
		}
		System.out.println(height);
		System.out.println(sum);
	}
	/* 2.编写一个截取字符串的函数，任意输入一个字符串和字节数，返回该字符串的指定字节数，
	但是要保证汉字不被截取半个,
	例如：输入"哈123"  4 返回"哈12"
	   输入"哈123哈456" 6 返回"哈123哈"  而不是"哈123"+半个哈（乱码格式）
	考察知识点：String类的使用  带参数有返回值的方法  字符与字节的关系  汉字的 字节处理  循环语句  判断语句  */
	
	void st(String s,int length) {
		char st1[] = s.toCharArray();
		int st[] = new int[st1.length];
		if(s.length()< length) {
			length = s.length();
		}
		StringBuilder builder = new StringBuilder();
		int max =0;
		for(int i=0;i<st1.length;i++) {
			if(st1[i]>255) {
				st[i]=2;
			}else {
				st[i]=1;
			}
			builder.append(st1[i]);
			max+=st[i];
			if(max>=length) {
				break;
			}
		}System.out.println(builder);
		
		}
	
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("请输入：");
		String s1= reader.nextLine();
		 System.out.println("请输入一个你要截取的字符串字节数");
	       int b = reader.nextInt();
	       hello h2 = new hello();
	       hello.st(s1,b);
		
//		hello h1 = new hello();
//		h1.ball();
//
//	System.out.println();
//	fun();   
//	System.out.println();
//	fun(1);
//	System.out.println();
//		fun(1,2,3,4,5);}
	
		
String str1 ="hello world";
String s[] = str1.split(" ");
//for(int i =0;i<s.length;i++) {
//	System.out.println(s[i]);
//}



	
	}
	
	
	}
	
	
			
			
	
	

//		hello n= new hello();
//		n.Test(7);	
		
		
//		System.out.println("请输入你的邮箱");
//		hello st = new hello();
//		st.test();
