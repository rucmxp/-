package lizi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class My_JosephCircle {
	
	public static void main(String[] args) {
		List alist = new ArrayList();
		
		System.out.println("请输入约瑟夫环  中 总个数数：");
		Scanner sca = new Scanner(System.in);
		int N = sca.nextInt();
		// 提示输入要出圈的数值
		System.out.println("请输入要出圈的数值：");
		int X = sca.nextInt();
		System.out.println("按出圈的次序输出序号：");
		
		for(int i=0 ;i<N;i++){
			alist.add(i+1);
		}
		
		int i=-1;
		int countX=0;
		while(alist.size()!=0){
			++i;
			if(i== alist.size()){
				i=0;
			}
			++countX;
			if(countX==X){//输出
				System.out.print(alist.get(i)+ " ");
				alist.remove(i);
				countX=0;
				i--;//修正
			}
		}
		
	}
}
